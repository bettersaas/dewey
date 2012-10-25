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

	// 设置cell编码解决中文高位字节截断
	//private static short XLS_ENCODING = HSSFCell.ENCODING_UTF_16;

	// 定制浮点数格式
	private static String NUMBER_FORMAT = "#,##0.00";

	// 定制日期格式
	private static String DATE_FORMAT = "m/d/yy"; // "m/d/yy h:mm"

	private HSSFWorkbook wb = null;// book [includes sheet]

	private HSSFSheet sheet = null;

	private HSSFRow row = null;

	private int sheetNum = 0; // 第sheetnum个工作表

	private int rowNum = 0;

	private FileInputStream fis = null;

	private File file = null;

	private OutputStream out = null;

	private HSSFWorkbook workbook = null;

	public PoiExcelFileUtil() {
	}

	/*
	 * 初始化 read
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
	 * 读取excel文件获得HSSFWorkbook对象
	 */
	public void open() throws IOException {
		fis = new FileInputStream(file);
		wb = new HSSFWorkbook(new POIFSFileSystem(fis));
		fis.close();
	}

	/**
	 * 返回sheet表数目
	 * 
	 * @return int
	 */
	public int getSheetCount() {
		int sheetCount = -1;
		sheetCount = wb.getNumberOfSheets();
		return sheetCount;
	}

	/**
	 * sheetNum下的记录行数
	 * 
	 * @return int
	 */
	public int getRowCount() {
		if (wb == null)
			System.out.println("=============>WorkBook为空");
		HSSFSheet sheet = wb.getSheetAt(this.sheetNum);
		int rowCount = -1;
		rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	/**
	 * 读取指定sheetNum的rowCount
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
	 * 得到指定行的内容
	 * 
	 * @param lineNum
	 * @return String[]
	 */
	public String[] readExcelLine(int lineNum) {
		return readExcelLine(this.sheetNum, lineNum);
	}

	/**
	 * 指定工作表和行数的内容
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
	 * 读取指定列的内容
	 * 
	 * @param cellNum
	 * @return String
	 */
	public String readStringExcelCell(int cellNum) {
		return readStringExcelCell(this.rowNum, cellNum);
	}

	/**
	 * 指定行和列编号的内容
	 * 
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 */
	public String readStringExcelCell(int rowNum, int cellNum) {
		return readStringExcelCell(this.sheetNum, rowNum, cellNum);
	}

	/**
	 * 指定工作表、行、列下的内容
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
	 * 初始化write
	 */
	public void initWorkBook(OutputStream out) {
		this.out = out;
		this.workbook = new HSSFWorkbook();
	}
	 
	/**
	 * 增加一个sheet
	 */
	public void createSheet(int sheetNo,String sheetName) {
		this.sheet = workbook.createSheet();
		this.workbook.setSheetName(sheetNo, sheetName);  // , (short)1
	}

	/**
	 * 导出Excel文件
	 * @throws Exception
	 */
	public void export() throws Exception {
		try {
			workbook.write(out);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			throw new Exception(" 生成导出Excel文件出错! ", e);
		} catch (IOException e) {
			throw new Exception(" 写入Excel文件出错! ", e);
		}
	}

	/**
	 * 增加一行
	 * @param index   行号
	 */
	public HSSFRow createRow(int index, float height) {
		this.row = this.sheet.createRow(index);
		this.row.setHeightInPoints(height);
		return this.row;
	}

	/**
	 * 获取单元格的值
	 * @param index
	 *            列号
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
	 * 设置单元格
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, int value) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, double value) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
		HSSFCellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
		HSSFDataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT)); // 设置cell样式为定制的浮点数格式
		cell.setCellStyle(cellStyle); // 设置该cell浮点数的显示格式
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, String value) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		//cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value);
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值
	 */
	public void setCell(int index, Calendar value) {
		HSSFCell cell = this.row.createCell(index);
		//cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value.getTime());
		HSSFCellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // 设置cell样式为定制的日期格式
		cell.setCellStyle(cellStyle); // 设置该cell日期的显示格式
	}
	
	/**
	 * 设置单元格
	 * 
	 * @param index   列号
	 * @param value   单元格填充值
	 */
	public void setCell(int index, Date value) {
		HSSFCell cell = this.row.createCell(index);
		//cell.setEncoding(XLS_ENCODING);
		cell.setCellValue(value);
		HSSFCellStyle cellStyle = workbook.createCellStyle(); // 建立新的cell样式
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT)); // 设置cell样式为定制的日期格式
		cell.setCellStyle(cellStyle); // 设置该cell日期的显示格式
	}

	public static void main(String[] args) {
		System.out.println(" 开始导出Excel文件 ");

		File f = new File("E://qt.xls");
		PoiExcelFileUtil ps = new PoiExcelFileUtil();
		try {
			ps.initWorkBook(new FileOutputStream(f));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		ps.createSheet(0, "协议列表1");		
		ps.createRow(0,20);
		ps.setCell(0, "试题编码 ");
		ps.setCell(1, "题型");
		ps.setCell(2, "分值");
		ps.setCell(3, "难度");
		ps.setCell(4, "级别");
		ps.setCell(5, "知识点");
		ps.setCell(6, "时间");
		ps.createRow(1,15);
		ps.setCell(0, "t1");
		ps.setCell(1, 1);
		ps.setCell(2, 3.0);
		ps.setCell(3, 1);
		ps.setCell(4, "重要");
		ps.setCell(5, "专业");
		ps.setCell(6, new Date());
		ps.createSheet(1, "协议列表2");		
		ps.createRow(0,20);
		ps.setCell(0, "试题编码 ");
		ps.setCell(1, "题型");
		ps.setCell(2, "分值");
		ps.setCell(3, "难度");
		ps.setCell(4, "级别");
		ps.setCell(5, "知识点");
		ps.setCell(6, "时间");
		ps.createRow(1,15);
		ps.setCell(0, "t1");
		ps.setCell(1, 1);
		ps.setCell(2, 3.0);
		ps.setCell(3, 1);
		ps.setCell(4, "重要");
		ps.setCell(5, "专业");
		ps.setCell(6, new Date());

		try {
			ps.export();
			System.out.println(" 导出Excel文件[成功] ");
		} catch (Exception ex) {
			System.out.println(" 导出Excel文件[失败] ");
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
//		readExcel.setSheetNum(1); // 设置读取索引为0的工作表
//		// 总行数
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
