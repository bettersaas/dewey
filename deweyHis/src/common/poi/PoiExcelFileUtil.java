package common.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * @author caihua
 */
public class PoiExcelFileUtil {

	// ����cell���������ĸ�λ�ֽڽض�
	//private static short XLS_ENCODING = HSSFCell.ENCODING_UTF_16;

	// ���Ƹ�������ʽ
	private static String NUMBER_FORMAT = "#,##0.00";

	// �������ڸ�ʽ
	private static String DATE_FORMAT = "m/d/yy"; // "m/d/yy h:mm"

	private HSSFWorkbook wb = null;// book [includes sheet]

	private HSSFSheet sheet = null;

	private HSSFRow row = null;

	private int sheetNum = 0; // ��sheetnum��������

	private int rowNum = 0;

	private FileInputStream fis = null;

	private File file = null;

	private OutputStream out = null;

	private HSSFWorkbook workbook = null;

	public PoiExcelFileUtil() {
	}

	/*
	 * ��ʼ�� read
	 */
	public void initRead(File file) {
		this.file = file;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public void setSheetNum(int sheetNum) {
		this.sheetNum = sheetNum;
	}

	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * ��ȡexcel�ļ����HSSFWorkbook����
	 */
	public void open() throws IOException {
		fis = new FileInputStream(file);
		wb = new HSSFWorkbook(new POIFSFileSystem(fis));
		fis.close();
	}

	/**
	 * ����sheet����Ŀ
	 * 
	 * @return int
	 */
	public int getSheetCount() {
		int sheetCount = -1;
		sheetCount = wb.getNumberOfSheets();
		return sheetCount;
	}

	/**
	 * sheetNum�µļ�¼����
	 * 
	 * @return int
	 */
	public int getRowCount() {
		if (wb == null)
			System.out.println("=============>WorkBookΪ��");
		HSSFSheet sheet = wb.getSheetAt(this.sheetNum);
		int rowCount = -1;
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	/**
	 * ��ȡָ��sheetNum��rowCount
	 * 
	 * @param sheetNum
	 * @return int
	 */
	public int getRowCount(int sheetNum) {
		HSSFSheet sheet = wb.getSheetAt(sheetNum);
		int rowCount = -1;
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	/**
	 * �õ�ָ���е�����
	 * 
	 * @param lineNum
	 * @return String[]
	 */
	public String[] readExcelLine(int lineNum) {
		return readExcelLine(this.sheetNum, lineNum);
	}

	/**
	 * ָ�������������������
	 * 
	 * @param sheetNum
	 * @param lineNum
	 * @return String[]
	 */
	public String[] readExcelLine(int sheetNum, int lineNum) {
		if (sheetNum < 0 || lineNum < 0)
			return null;
		String[] strExcelLine = null;
		try {
			sheet = wb.getSheetAt(sheetNum);
			row = sheet.getRow(lineNum);
			int cellCount = row.getLastCellNum();
			strExcelLine = new String[cellCount + 1];
			for (int i = 0; i <= cellCount; i++) {
				strExcelLine[i] = readStringExcelCell(lineNum, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strExcelLine;
	}

	/**
	 * ��ȡָ���е�����
	 * 
	 * @param cellNum
	 * @return String
	 */
	public String readStringExcelCell(int cellNum) {
		return readStringExcelCell(this.rowNum, cellNum);
	}

	/**
	 * ָ���к��б�ŵ�����
	 * 
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 */
	public String readStringExcelCell(int rowNum, int cellNum) {
		return readStringExcelCell(this.sheetNum, rowNum, cellNum);
	}

	/**
	 * ָ���������С����µ�����
	 * @param sheetNum
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 */
	public String readStringExcelCell(int sheetNum, int rowNum, int cellNum) {
		if (sheetNum < 0 || rowNum < 0)
			return "";
		String strExcelCell = "";
		try {
			sheet = wb.getSheetAt(sheetNum);
			row = sheet.getRow(rowNum);
			if (row.getCell(cellNum) != null) { // add this condition
				// judge
				switch (row.getCell(cellNum).getCellType()) {
				case HSSFCell.CELL_TYPE_FORMULA:
					strExcelCell = "FORMULA ";
					break;
				case HSSFCell.CELL_TYPE_NUMERIC: {
					strExcelCell = String.valueOf(row.getCell(cellNum).getNumericCellValue());
				}
					break;
				case HSSFCell.CELL_TYPE_STRING:
					strExcelCell = row.getCell(cellNum).getStringCellValue();
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					strExcelCell = "";
					break;
				default:
					strExcelCell = "";
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strExcelCell;
	}
	
	/**
	 * ��ʼ��write
	 */
	public void initWorkBook(OutputStream out) {
		this.out = out;
		this.workbook = new HSSFWorkbook();
	}
	 
	/**
	 * ����һ��sheet
	 */
	public void createSheet(int sheetNo,String sheetName) {
		this.sheet = workbook.createSheet();
		this.workbook.setSheetName(sheetNo, sheetName);  // , (short)1
	}

	/**
	 * ����Excel�ļ�
	 * @throws Exception
	 */
	public void export() throws Exception {
		try {
			workbook.write(out);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			throw new Exception(" ���ɵ���Excel�ļ�����! ", e);
		} catch (IOException e) {
			throw new Exception(" д��Excel�ļ�����! ", e);
		}
	}

	/**
	 * ����һ��
	 * @param index   �к�
	 */
	public HSSFRow createRow(int index, float height) {
		this.row = this.sheet.createRow(index);
		this.row.setHeightInPoints(height);
		return this.row;
	}

	/**
	 * ��ȡ��Ԫ���ֵ
	 * @param index
	 *            �к�
	 */
	public String getCell(int index) {
		HSSFCell cell = this.row.getCell(index);
		String strExcelCell = "";
		if (cell != null) { // add this condition
			// judge
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_FORMULA:
				strExcelCell = "FORMULA ";
				break;
			case HSSFCell.CELL_TYPE_NUMERIC: {
				strExcelCell = String.valueOf(cell.getNumericCellValue());
			}
				break;
			case HSSFCell.CELL_TYPE_STRING:
				strExcelCell = cell.getStringCellValue();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				strExcelCell = "";
				break;
			default:
				strExcelCell = "";
				break;
			}
		}
		return strExcelCell;
	}

	/**
	 * ���õ�Ԫ��
	 * @param index
	 *            �к�
	 * @param value
	 *            ��Ԫ�����ֵ
	 */
	public void setCell(int index, int value) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
	}

	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index
	 *            �к�
	 * @param value
	 *            ��Ԫ�����ֵ
	 */
	public void setCell(int index, double value) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
		HSSFCellStyle cellStyle = workbook.createCellStyle(); // �����µ�cell��ʽ
		HSSFDataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT)); // ����cell��ʽΪ���Ƶĸ�������ʽ
		cell.setCellStyle(cellStyle); // ���ø�cell����������ʾ��ʽ
	}

	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index
	 *            �к�
	 * @param value
	 *            ��Ԫ�����ֵ
	 */
	public void setCell(int index, String value) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		//cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value);
	}

	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index
	 *            �к�
	 * @param value
	 *            ��Ԫ�����ֵ
	 */
	public void setCell(int index, Calendar value) {
		HSSFCell cell = this.row.createCell(index);
		//cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value.getTime());
		HSSFCellStyle cellStyle = workbook.createCellStyle(); // �����µ�cell��ʽ
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // ����cell��ʽΪ���Ƶ����ڸ�ʽ
		cell.setCellStyle(cellStyle); // ���ø�cell���ڵ���ʾ��ʽ
	}
	
	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index   �к�
	 * @param value   ��Ԫ�����ֵ
	 */
	public void setCell(int index, Date value) {
		HSSFCell cell = this.row.createCell(index);
		//cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value);
		HSSFCellStyle cellStyle = workbook.createCellStyle(); // �����µ�cell��ʽ
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // ����cell��ʽΪ���Ƶ����ڸ�ʽ
		cell.setCellStyle(cellStyle); // ���ø�cell���ڵ���ʾ��ʽ
	}

	public static void main(String[] args) {
		System.out.println(" ��ʼ����Excel�ļ� ");

		File f = new File("E://qt.xls");
		PoiExcelFileUtil ps = new PoiExcelFileUtil();
		try {
			ps.initWorkBook(new FileOutputStream(f));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ps.createSheet(0, "Э���б�1");		
		ps.createRow(0,20);
		ps.setCell(0, "������� ");
		ps.setCell(1, "����");
		ps.setCell(2, "��ֵ");
		ps.setCell(3, "�Ѷ�");
		ps.setCell(4, "����");
		ps.setCell(5, "֪ʶ��");
		ps.setCell(6, "ʱ��");
		ps.createRow(1,15);
		ps.setCell(0, "t1");
		ps.setCell(1, 1);
		ps.setCell(2, 3.0);
		ps.setCell(3, 1);
		ps.setCell(4, "��Ҫ");
		ps.setCell(5, "רҵ");
		ps.setCell(6, new Date());
		ps.createSheet(1, "Э���б�2");		
		ps.createRow(0,20);
		ps.setCell(0, "������� ");
		ps.setCell(1, "����");
		ps.setCell(2, "��ֵ");
		ps.setCell(3, "�Ѷ�");
		ps.setCell(4, "����");
		ps.setCell(5, "֪ʶ��");
		ps.setCell(6, "ʱ��");
		ps.createRow(1,15);
		ps.setCell(0, "t1");
		ps.setCell(1, 1);
		ps.setCell(2, 3.0);
		ps.setCell(3, 1);
		ps.setCell(4, "��Ҫ");
		ps.setCell(5, "רҵ");
		ps.setCell(6, new Date());

		try {
			ps.export();
			System.out.println(" ����Excel�ļ�[�ɹ�] ");
		} catch (Exception ex) {
			System.out.println(" ����Excel�ļ�[ʧ��] ");
			ex.printStackTrace();
		}

//		File file = new File("C://qt.xls");
//		PoiExcelUtil readExcel = new PoiExcelUtil();
//		try {
//			readExcel.initRead(file);
//			readExcel.open();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
//		readExcel.setSheetNum(1); // ���ö�ȡ����Ϊ0�Ĺ�����
//		// ������
//		int count = readExcel.getRowCount();
//		for (int i = 0; i <= count; i++) {
//			String[] rows = readExcel.readExcelLine(i);
//			for (int j = 0; j < rows.length; j++) {
//				System.out.print(rows[j] + " ");
//			}
//			System.out.print("/n");
//		}
	}
}
