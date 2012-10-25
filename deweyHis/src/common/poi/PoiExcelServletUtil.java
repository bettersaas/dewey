package common.poi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

/**
 * @author caihua
 */
public class PoiExcelServletUtil {
	
	//private String excelFileFileName;    // ����ԭʼ�ļ���  

	// ����cell���������ĸ�λ�ֽڽض�
	// private static short XLS_ENCODING = HSSFCell.ENCODING_UTF_16;

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

	private File excelFile = null;
	
	private OutputStream out = null;
	
	// private InputStream is = null;
	
	private HSSFWorkbook workbook = null;   // Workbook  HSSFWorkbook
	
	private HSSFFont font = null;
	
	private HSSFCellStyle style = null;
	
	public PoiExcelServletUtil() {
	}

	/**
	 * ��ʼ�� read
	 */
	public void initRead(File file) {
		this.excelFile = file;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public void setSheetNum(int sheetNum) {
		this.sheetNum = sheetNum;
	}

	public void setFile(File file) {
		this.excelFile = file;
	}

	/**
	 * ��ȡexcel�ļ����HSSFWorkbook����
	 */
	public void open() throws IOException {
		fis = new FileInputStream(excelFile);
		wb = new HSSFWorkbook(new POIFSFileSystem(fis));
		fis.close();
	}

	@SuppressWarnings("unchecked")
	public List<?> parseExcelFile(InputStream inputStream) throws IOException {
		// ����ͨ�ö����б�
		List<?> dataList = new ArrayList();
		List<String> valueList = null;
		// ���ļ�������workbook
		HSSFWorkbook workbook = null;
		workbook = new HSSFWorkbook(inputStream);
		//int sheetNum = workbook.getNumberOfSheets();
		// �õ���һ��sheet����
		HSSFSheet templateSheet = workbook.getSheetAt(1);
		HSSFRow templateRow = templateSheet.getRow(0);
		// �õ�������
		int rowNum = templateSheet.getPhysicalNumberOfRows();
		// �õ�������
		int columnNum = templateSheet.getRow(0).getPhysicalNumberOfCells();
		// ѭ��ÿһ��
		for (int rowId = 0; rowId < rowNum; rowId++) {
			// �õ���rowId�ж���
			HSSFRow hsrow = templateSheet.getRow(rowId);
			// ����һ��ֵ�б���� �ֱ���ÿһ���ֶζ�Ӧ��ֵ
			valueList = new ArrayList<String>();
			// ѭ��ÿһ��
			for (int columnId = 0; columnId < columnNum; columnId++) {
				String value = null;
				// �õ�һ����Ԫ��
				if (hsrow == null)
					return dataList;
				HSSFCell cell = hsrow.getCell(columnId);
				// ȡģ���һ����Ԫ��
				HSSFCell templateCell = templateRow.getCell(columnId);
				// ȡ��������
				String columnName = templateCell.getStringCellValue().trim();
				// ֻ�е�Ԫ������ֵʱ���������ж�
				if (cell != null) {
					// �õ�����
					int cellType = cell.getCellType();
					switch (cellType) {
					// ����ǿմ�
					case HSSFCell.CELL_TYPE_BLANK:
						value = " ";
						break;
					// ����ǲ�����
					case HSSFCell.CELL_TYPE_BOOLEAN:
						value = cell.getBooleanCellValue() ? "TRUE " : "FALSE ";
						break;
					// ����Ǵ�����
					case HSSFCell.CELL_TYPE_ERROR:
						value = "#ERR " + cell.getErrorCellValue();
						break;
					// ����ǹ�ʽ��
					case HSSFCell.CELL_TYPE_FORMULA:
						value = cell.getCellFormula();
						break;
					// �����������
					case HSSFCell.CELL_TYPE_NUMERIC:
						// �ж�һ���Ƿ�����������
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							// תΪyyyy-MM-dd��ʽ
							DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
							value = sdf.format(cell.getDateCellValue());
						} else { // ����������
							if ("��� ".equals(columnName) || "ʱ�� ".equals(columnName)) {
								// תΪ�������ַ���
								value = " " + (long) cell.getNumericCellValue();
							} else { // ����ȫ��תΪС�����ַ���
								value = cell.getNumericCellValue() + " ";
							}
						}
						break;
					// �ַ�����
					case HSSFCell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						break;
					// ����
					default:
						value = "Unknown   Cell   Type:   " + cell.getCellType();
					}
				}
				// ��ת�����ֵ����List ����list�п��ܷ���null ����û��ֵ
				valueList.add(value);
			}
		}
		// ����ͨ���б�ȫ��ΪString ���� �� Null
		return dataList;
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
	 * 
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
	 * ��ȡ��Ԫ���ֵ
	 * 
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
	 * ��ʼ��write
	 */
	public void initWorkBook() {
		this.workbook = new HSSFWorkbook();
		// �����������ʽ
		this.font = this.workbook.createFont();
		font.setFontHeightInPoints((short) 12);
		font.setFontName("Courier New");
		this.style = this.workbook.createCellStyle();
		style.setFont(font);
		style.setWrapText(true);
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	}
	
	/**
	 * ����ģ���ļ��ĺ����ͷ��Ԫ�����ʽ
	 * @param wb
	 * @return
	 */
	public HSSFCellStyle getTitleStyle() {
		HSSFCellStyle style = this.workbook.createCellStyle();
		// ���뷽ʽ����
		style.setAlignment(CellStyle.ALIGN_CENTER);
		// �߿���ɫ�Ϳ������
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		// ���ñ�����ɫ
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// ����������
		Font font = this.workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}
	
	/**
	 * ����ģ���ļ��ĺ����ͷ��Ԫ�����ʽ
	 * @param wb
	 * @return
	 */
	public HSSFCellStyle getContentStyle() {
		HSSFCellStyle style = this.workbook.createCellStyle();
		// ���뷽ʽ����
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		// �߿���ɫ�Ϳ������
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		return style;
	}

	/**
	 * ��ʼ��write
	 */
	public void initWorkBook(OutputStream out) {
		this.out = out;
		this.initWorkBook();
	}

	/**
	 * ����һ��sheet
	 */
	public void createSheet(int sheetNo, String sheetName) {
		this.sheet = workbook.createSheet();
		// this.sheet.setColumnWidth(i, (short) (5000)); // ����sheet���п��
		this.workbook.setSheetName(sheetNo, sheetName);  //, (short) 1
	}

	/**
	 * ����һ��
	 * 
	 * @param index
	 *            �к�
	 */
	public HSSFRow createRow(int index, float height) {
		this.row = this.sheet.createRow(index);
		this.row.setHeightInPoints(height);
		return this.row;
	}

	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index
	 *            �к�
	 * @param value
	 *            ��Ԫ�����ֵ ����
	 */
	public HSSFCell setCell(int index, int value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC); // ����
		cell.setCellValue(value);
		// �����µĵ�Ԫ����ʽ
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index
	 *            �к�
	 * @param value
	 *            ��Ԫ�����ֵ ������
	 */
	public HSSFCell setCell(int index, double value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
		// �����µĵ�Ԫ����ʽ
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		HSSFDataFormat format = workbook.createDataFormat();
		// ������ʽ
		// cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		// ����cell��ʽΪ���Ƶĸ�������ʽ
		cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT));
		// ���ø�cell����������ʾ��ʽ
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index    �к�
	 * @param value    ��Ԫ�����ֵ
	 */
	public HSSFCell setCell(int index, String value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		// ��������
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		if (value != null) {
			cell.setCellValue(value);
		}
		// �����µĵ�Ԫ����ʽ
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index    �к�
	 * @param value    ��Ԫ�����ֵ
	 */
	public HSSFCell setCell(int index, Calendar value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		if (value != null) {
			cell.setCellValue(value.getTime());
		}
		// �����µ�cell��ʽ
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		// ����cell��ʽΪ���Ƶ����ڸ�ʽ
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT));
		// ���ø�cell���ڵ���ʾ��ʽ
		cell.setCellStyle(cellStyle);
		return cell;
	}
	
	/**
	 * ���õ�Ԫ��
	 * 
	 * @param index   �к�
	 * @param value   ��Ԫ�����ֵ
	 */
	public HSSFCell setCell(int index, Date value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		if (value != null) {
			cell.setCellValue(value);
		}
		// �����µ�cell��ʽ
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		// ����cell��ʽΪ���Ƶ����ڸ�ʽ
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT));
		// ���ø�cell���ڵ���ʾ��ʽ
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * ����Excel�ļ�
	 * 
	 * @throws Exception
	 */
	public InputStream exportServletInputStream() throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			workbook.write(os);
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			// ���л��ֽ���
			// InputStreamSerializable iss = new InputStreamSerializable(is);
			// return new ModelAndView("downPoolReportFile","contentStream",iss.getInStream());
			return is;
		} catch (FileNotFoundException e) {
			throw new Exception(" ���ɵ���Excel�ļ�����! ", e);
		} catch (IOException e) {
			throw new Exception(" д��Excel�ļ�����! ", e);
		}
	}

	/**
	 * ����Excel�ļ�
	 * 
	 * @throws Exception
	 */
	public void exportFile() throws Exception {
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

//	/**
//	 * ������ģ���ļ���excel 
//	 */
//	public void exportStyleFile(String inputFile, String outputFile, List<?> dataList) {
//		POIFSFileSystem fs = null;
//		HSSFWorkbook workbook = null;
//		//��ģ���ļ�����poi 
//		try {
//			fs = new POIFSFileSystem(new FileInputStream(inputFile));
//			//����ģ�幤���� 
//			workbook = new HSSFWorkbook(fs);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace(System.out);
//		} catch (IOException e) {
//			e.printStackTrace(System.out);
//		}
//		//ֱ��ȡģ���һ��sheet����
//		HSSFSheet templateSheet = workbook.getSheetAt(1);
//		//�õ�ģ��ĵ�һ��sheet�ĵ�һ�ж���   Ϊ�˵õ�ģ����ʽ 
//		//HSSFRow templateRow = templateSheet.getRow(0);
//		//ȡ��Excel�ļ��������� 
//		int columns = templateSheet.getRow((short) 0).getPhysicalNumberOfCells();
//		//������ʽ���� 
//		HSSFCellStyle styleArray[] = new HSSFCellStyle[columns];
//		//һ���Դ��������е���ʽ���������� 
//		for (int s = 0; s < columns; s++) {
//			//�õ�����ʵ�� 
//			styleArray[s] = workbook.createCellStyle();
//		}
//		//ѭ����ÿһ����Ԫ����и�ֵ   ����Ҫ��ģ���������list�е�ֵҪһһ��Ӧ 
//		//��λ�� 
//		for (int rowId = 1; rowId <= dataList.size(); rowId++) {
//			//����ȡ��rowId������   ÿһ��������valueList 
//			List<?> valueList = (List<?>) dataList.get(rowId - 1);
//			//��λ�� 
//			for (int columnId = 0; columnId < valueList.size(); columnId++) {
//				//����ȡ����Ӧ��colunmId�е�ֵ
//				//ÿһ����Ԫ���ֵ
//				String dataValue = (String) valueList.get(columnId);
//				//ȡ��colunmId�еĵ�style
//				//ģ��ÿһ�е���ʽ
//				HSSFCellStyle style = styleArray[columnId];
//				//ȡģ���colunmId�еĵ�Ԫ�����
//				//ģ�嵥Ԫ����� 
//				//HSSFCell templateCell = templateRow.getCell((short) columnId);
//				//����һ���µ�rowId��   �ж���
//				//�½����ж���   
//				HSSFRow hssfRow = templateSheet.createRow(rowId);
//				//�����µ�rowId��   columnId��   ��Ԫ�����
//				//�½��ĵ�Ԫ����� 
//				HSSFCell cell = hssfRow.createCell((short) columnId);
//				//�����Ӧ��ģ�嵥Ԫ��   ��ʽΪ������
//				HSSFFont font = workbook.createFont();
//				//String columnName = templateCell.getStringCellValue().trim();
//				//����ǲ�׼�޸ĵ������ɫ��ʾ����
//				if (columnId == 0 || columnId == 1 || columnId == 2 || columnId == 3 || columnId == 5 || columnId == 7 || columnId == 13 || columnId == 15) {
//					//���ô���styleΪ������ 
//					//style.setLocked(false); 
//					font.setColor(HSSFFont.COLOR_RED);
//					style.setFont(font);
//					//���õ��µĵ�Ԫ���� 
//					cell.setCellStyle(style);
//				} else {  //������ʽΪ����   ��ͨ��ɫ
//					//���ô���styleΪ���� 
//					//style.setLocked(true); 
//					font.setColor(HSSFFont.COLOR_NORMAL);
//					style.setFont(font);
//					//���õ��µ�Ԫ���� 
//					cell.setCellStyle(style);
//				}
//				//���ñ��� 
//				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//				//����ֵ   ͳһΪString 
//				cell.setCellValue(dataValue);
//			}
//		}
//		try {
//			//���������� 
//			FileOutputStream fOut  = new FileOutputStream(outputFile);
//			//��ģ�������д������ļ��� 
//			workbook.write(fOut);
//			fOut.flush();
//			//�����������ر��ļ� 
//			fOut.close();
//		} catch (Exception e1) {
//			e1.printStackTrace(System.out);
//
//		}
//	}
//
//	public void exportExcelFile(String outputFile, List<?> dataList) {
//		//���������� 
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		//����sheet 
//		HSSFSheet sheet = workbook.createSheet();
//		//ѭ������ 
//		for (int rowId = 0; rowId < dataList.size(); rowId++) {
//			//ȡ����Ӧ�е������б���� 
//			List<?> valueList = (List<?>) dataList.get(rowId);
//			//�ӵ�0�п�ʼ���� 
//			HSSFRow hsrow = sheet.createRow(rowId);
//			//����д��ÿһ����Ԫ�� 
//			for (int columnId = 0; columnId < valueList.size(); columnId++) {
//				//�õ���Ӧ��Ԫ���ֵ 
//				String dataValue = (String) valueList.get(columnId);
//				//�������еĵ�Ԫ�� 
//				HSSFCell cell = hsrow.createCell((short) columnId);
//				//���ñ��� 
//				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//				//����ֵ 
//				cell.setCellValue(dataValue);
//			}
//		}
//		try {
//			//д�����ļ�
//			FileOutputStream os = new FileOutputStream(outputFile);
//			workbook.write(os);
//			os.flush();
//			//�ر��ļ���
//			os.close();
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//		}
//	}

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println(" ��ʼ����Excel�ļ� ");

		File f = new File("E://qt.xls");
		PoiExcelServletUtil ps = new PoiExcelServletUtil();
		ps.initWorkBook(new FileOutputStream(f));
		ps.createSheet(0, "Э���б�1");
		ps.createRow(0, 15);
		ps.setCell(0, "������� ", ps.getTitleStyle());
		ps.setCell(1, "����", ps.getTitleStyle());
		ps.setCell(2, "��ֵ", ps.getTitleStyle());
		ps.setCell(3, "�Ѷ�", ps.getTitleStyle());
		ps.setCell(4, "����", ps.getTitleStyle());
		ps.setCell(5, "֪ʶ��", ps.getTitleStyle());
		ps.createRow(1, 15);
		ps.setCell(0, "t1",ps.getContentStyle());
		ps.setCell(1, 1,ps.getContentStyle());
		ps.setCell(2, 3.0, ps.getContentStyle());
		ps.setCell(3, 1,ps.getContentStyle());
		ps.setCell(4, "��Ҫ",ps.getContentStyle());
		ps.setCell(5, "רҵ",ps.getContentStyle());
		ps.createSheet(1, "Э���б�2");
		ps.createRow(0, 15);
		ps.setCell(0, "�������", ps.getTitleStyle());
		ps.setCell(1, "����", ps.getTitleStyle());
		ps.setCell(2, "��ֵ", ps.getTitleStyle());
		ps.setCell(3, "�Ѷ�", ps.getTitleStyle());
		ps.setCell(4, "����", ps.getTitleStyle());
		ps.setCell(5, "֪ʶ��", ps.getTitleStyle());
		ps.createRow(1, 15);
		ps.setCell(0, "t1",ps.getContentStyle());
		ps.setCell(1, 1,ps.getContentStyle());
		ps.setCell(2, 3.0, ps.getContentStyle());
		ps.setCell(3, 1,ps.getContentStyle());
		ps.setCell(4, new Date(), ps.getContentStyle());
		ps.setCell(5, "רҵ",ps.getContentStyle());

		try {
			ps.exportFile();
			System.out.println(" ����Excel�ļ�[�ɹ�] ");
		} catch (Exception ex) {
			System.out.println(" ����Excel�ļ�[ʧ��] ");
			ex.printStackTrace();
		}

		// File file = new File("C://qt.xls");
		// PoiExcelUtil readExcel = new PoiExcelUtil();
		// try {
		// readExcel.initRead(file);
		// readExcel.open();
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		// readExcel.setSheetNum(1); // ���ö�ȡ����Ϊ0�Ĺ�����
		// // ������
		// int count = readExcel.getRowCount();
		// for (int i = 0; i <= count; i++) {
		// String[] rows = readExcel.readExcelLine(i);
		// for (int j = 0; j < rows.length; j++) {
		// System.out.print(rows[j] + " ");
		// }
		// System.out.print("/n");
		// }
	}

	/**
	 * // ����excel�ĵ� HSSFWorkbook wb = new HSSFWorkbook(); HSSFSheet sheet1 =
	 * wb.createSheet(); wb.setSheetName(0, "Э�鵥λ�б�",(short)1);
	 *  // ������ HSSFRow row = sheet1.createRow((short) 0); HSSFCell cell =
	 * row.createCell((short) 0); cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("���"); cell =
	 * row.createCell((short) 1); cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("��λ����");
	 * cell = row.createCell((short) 2);
	 * cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("��ϵ��");
	 * cell = row.createCell((short) 3);
	 * cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("�绰"); cell =
	 * row.createCell((short) 4); cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("��ע"); cell =
	 * row.createCell((short) 5); cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("�Ǽ�ʱ��");
	 *  // ������ List<ContractualUnit> list =
	 * contractualUnitManager.findMerAllContractualUnit(mer.getId()); for (int i =
	 * 0; i< list.size(); i++ ) { ContractualUnit unit = list.get(i); row =
	 * sheet1.createRow((short) (i+1)); cell = row.createCell((short) 0);
	 * cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC); cell.setCellValue((i+1));
	 * cell = row.createCell((short) 1);
	 * cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	 * cell.setCellValue(unit.getCompany()); cell = row.createCell((short) 2);
	 * cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	 * cell.setCellValue(unit.getLinkman()); cell = row.createCell((short) 3);
	 * cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	 * cell.setCellValue(unit.getTelphone()); cell = row.createCell((short) 4);
	 * cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16);
	 * cell.setCellValue(unit.getRemark()); // ���ڲ�Ϊ��ʱ if (unit.getCreateTime() !=
	 * null ) { cell = row.createCell((short) 5);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue(new
	 * Date(unit.getCreateTime().getTime())); HSSFCellStyle cellStyle =
	 * wb.createCellStyle(); // �����µ�cell��ʽ
	 * cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy/mm/dd")); //
	 * ����cell��ʽΪ���Ƶ����ڸ�ʽ cell.setCellStyle(cellStyle); // ���ø�cell���ڵ���ʾ��ʽ } } //
	 * FileOutputStream fileout=new FileOutputStream("workbook.xls");
	 * ByteArrayOutputStream os = new ByteArrayOutputStream(); wb.write(os);
	 * byte[] content = os.toByteArray(); InputStream is = new
	 * ByteArrayInputStream(content); // ���л��ֽ��� // InputStreamSerializable iss =
	 * new InputStreamSerializable(is); // return new
	 * ModelAndView("downPoolReportFile","contentStream",iss.getInStream());
	 */
}
