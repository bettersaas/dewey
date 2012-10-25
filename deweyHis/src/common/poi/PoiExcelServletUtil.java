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
	
	//private String excelFileFileName;    // 保存原始文件名  

	// 设置cell编码解决中文高位字节截断
	// private static short XLS_ENCODING = HSSFCell.ENCODING_UTF_16;

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

	private File excelFile = null;
	
	private OutputStream out = null;
	
	// private InputStream is = null;
	
	private HSSFWorkbook workbook = null;   // Workbook  HSSFWorkbook
	
	private HSSFFont font = null;
	
	private HSSFCellStyle style = null;
	
	public PoiExcelServletUtil() {
	}

	/**
	 * 初始化 read
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
	 * 读取excel文件获得HSSFWorkbook对象
	 */
	public void open() throws IOException {
		fis = new FileInputStream(excelFile);
		wb = new HSSFWorkbook(new POIFSFileSystem(fis));
		fis.close();
	}

	@SuppressWarnings("unchecked")
	public List<?> parseExcelFile(InputStream inputStream) throws IOException {
		// 设置通用对象列表
		List<?> dataList = new ArrayList();
		List<String> valueList = null;
		// 以文件流构造workbook
		HSSFWorkbook workbook = null;
		workbook = new HSSFWorkbook(inputStream);
		//int sheetNum = workbook.getNumberOfSheets();
		// 得到第一个sheet对象
		HSSFSheet templateSheet = workbook.getSheetAt(1);
		HSSFRow templateRow = templateSheet.getRow(0);
		// 得到总行数
		int rowNum = templateSheet.getPhysicalNumberOfRows();
		// 得到总列数
		int columnNum = templateSheet.getRow(0).getPhysicalNumberOfCells();
		// 循环每一行
		for (int rowId = 0; rowId < rowNum; rowId++) {
			// 得到第rowId行对象
			HSSFRow hsrow = templateSheet.getRow(rowId);
			// 创建一个值列表对象 分别存放每一个字段对应的值
			valueList = new ArrayList<String>();
			// 循环每一列
			for (int columnId = 0; columnId < columnNum; columnId++) {
				String value = null;
				// 得到一个单元格
				if (hsrow == null)
					return dataList;
				HSSFCell cell = hsrow.getCell(columnId);
				// 取模板第一个单元格
				HSSFCell templateCell = templateRow.getCell(columnId);
				// 取得列名称
				String columnName = templateCell.getStringCellValue().trim();
				// 只有单元格中有值时才做类型判断
				if (cell != null) {
					// 得到类型
					int cellType = cell.getCellType();
					switch (cellType) {
					// 如果是空串
					case HSSFCell.CELL_TYPE_BLANK:
						value = " ";
						break;
					// 如果是布尔型
					case HSSFCell.CELL_TYPE_BOOLEAN:
						value = cell.getBooleanCellValue() ? "TRUE " : "FALSE ";
						break;
					// 如果是错误型
					case HSSFCell.CELL_TYPE_ERROR:
						value = "#ERR " + cell.getErrorCellValue();
						break;
					// 如果是公式型
					case HSSFCell.CELL_TYPE_FORMULA:
						value = cell.getCellFormula();
						break;
					// 如果是数字型
					case HSSFCell.CELL_TYPE_NUMERIC:
						// 判断一下是否是日期类型
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							// 转为yyyy-MM-dd格式
							DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
							value = sdf.format(cell.getDateCellValue());
						} else { // 否则是数字
							if ("编号 ".equals(columnName) || "时限 ".equals(columnName)) {
								// 转为整数的字符串
								value = " " + (long) cell.getNumericCellValue();
							} else { // 其他全部转为小数型字符串
								value = cell.getNumericCellValue() + " ";
							}
						}
						break;
					// 字符串型
					case HSSFCell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						break;
					// 其它
					default:
						value = "Unknown   Cell   Type:   " + cell.getCellType();
					}
				}
				// 把转化后的值放入List 这里list中可能放入null 代表没有值
				valueList.add(value);
			}
		}
		// 返回通用列表全部为String 类型 或 Null
		return dataList;
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
	 * 获取单元格的值
	 * 
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
	 * 初始化write
	 */
	public void initWorkBook() {
		this.workbook = new HSSFWorkbook();
		// 设置字体等样式
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
	 * 设置模板文件的横向表头单元格的样式
	 * @param wb
	 * @return
	 */
	public HSSFCellStyle getTitleStyle() {
		HSSFCellStyle style = this.workbook.createCellStyle();
		// 对齐方式设置
		style.setAlignment(CellStyle.ALIGN_CENTER);
		// 边框颜色和宽度设置
		style.setBorderBottom(CellStyle.BORDER_THIN);
		style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderLeft(CellStyle.BORDER_THIN);
		style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderRight(CellStyle.BORDER_THIN);
		style.setRightBorderColor(IndexedColors.BLACK.getIndex());
		style.setBorderTop(CellStyle.BORDER_THIN);
		style.setTopBorderColor(IndexedColors.BLACK.getIndex());
		style.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		// 设置背景颜色
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		// 粗体字设置
		Font font = this.workbook.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}
	
	/**
	 * 设置模板文件的横向表头单元格的样式
	 * @param wb
	 * @return
	 */
	public HSSFCellStyle getContentStyle() {
		HSSFCellStyle style = this.workbook.createCellStyle();
		// 对齐方式设置
		style.setAlignment(CellStyle.ALIGN_RIGHT);
		// 边框颜色和宽度设置
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
	 * 初始化write
	 */
	public void initWorkBook(OutputStream out) {
		this.out = out;
		this.initWorkBook();
	}

	/**
	 * 增加一个sheet
	 */
	public void createSheet(int sheetNo, String sheetName) {
		this.sheet = workbook.createSheet();
		// this.sheet.setColumnWidth(i, (short) (5000)); // 设置sheet的列宽度
		this.workbook.setSheetName(sheetNo, sheetName);  //, (short) 1
	}

	/**
	 * 增加一行
	 * 
	 * @param index
	 *            行号
	 */
	public HSSFRow createRow(int index, float height) {
		this.row = this.sheet.createRow(index);
		this.row.setHeightInPoints(height);
		return this.row;
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值 数字
	 */
	public HSSFCell setCell(int index, int value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC); // 数字
		cell.setCellValue(value);
		// 建立新的单元格样式
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * 设置单元格
	 * 
	 * @param index
	 *            列号
	 * @param value
	 *            单元格填充值 浮点型
	 */
	public HSSFCell setCell(int index, double value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
		cell.setCellValue(value);
		// 建立新的单元格样式
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		HSSFDataFormat format = workbook.createDataFormat();
		// 设置样式
		// cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		// 设置cell样式为定制的浮点数格式
		cellStyle.setDataFormat(format.getFormat(NUMBER_FORMAT));
		// 设置该cell浮点数的显示格式
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * 设置单元格
	 * 
	 * @param index    列号
	 * @param value    单元格填充值
	 */
	public HSSFCell setCell(int index, String value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		// 设置类型
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		if (value != null) {
			cell.setCellValue(value);
		}
		// 建立新的单元格样式
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * 设置单元格
	 * 
	 * @param index    列号
	 * @param value    单元格填充值
	 */
	public HSSFCell setCell(int index, Calendar value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		if (value != null) {
			cell.setCellValue(value.getTime());
		}
		// 建立新的cell样式
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		// 设置cell样式为定制的日期格式
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT));
		// 设置该cell日期的显示格式
		cell.setCellStyle(cellStyle);
		return cell;
	}
	
	/**
	 * 设置单元格
	 * 
	 * @param index   列号
	 * @param value   单元格填充值
	 */
	public HSSFCell setCell(int index, Date value, HSSFCellStyle cellStyle) {
		HSSFCell cell = this.row.createCell(index);
		if (value != null) {
			cell.setCellValue(value);
		}
		// 建立新的cell样式
		if (cellStyle == null) {
			cellStyle = this.workbook.createCellStyle();
		}
		// 设置cell样式为定制的日期格式
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat(DATE_FORMAT));
		// 设置该cell日期的显示格式
		cell.setCellStyle(cellStyle);
		return cell;
	}

	/**
	 * 导出Excel文件
	 * 
	 * @throws Exception
	 */
	public InputStream exportServletInputStream() throws Exception {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			workbook.write(os);
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			// 序列化字节流
			// InputStreamSerializable iss = new InputStreamSerializable(is);
			// return new ModelAndView("downPoolReportFile","contentStream",iss.getInStream());
			return is;
		} catch (FileNotFoundException e) {
			throw new Exception(" 生成导出Excel文件出错! ", e);
		} catch (IOException e) {
			throw new Exception(" 写入Excel文件出错! ", e);
		}
	}

	/**
	 * 导出Excel文件
	 * 
	 * @throws Exception
	 */
	public void exportFile() throws Exception {
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

//	/**
//	 * 导出有模板文件的excel 
//	 */
//	public void exportStyleFile(String inputFile, String outputFile, List<?> dataList) {
//		POIFSFileSystem fs = null;
//		HSSFWorkbook workbook = null;
//		//用模板文件构造poi 
//		try {
//			fs = new POIFSFileSystem(new FileInputStream(inputFile));
//			//创建模板工作表 
//			workbook = new HSSFWorkbook(fs);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace(System.out);
//		} catch (IOException e) {
//			e.printStackTrace(System.out);
//		}
//		//直接取模板第一个sheet对象
//		HSSFSheet templateSheet = workbook.getSheetAt(1);
//		//得到模板的第一个sheet的第一行对象   为了得到模板样式 
//		//HSSFRow templateRow = templateSheet.getRow(0);
//		//取得Excel文件的总列数 
//		int columns = templateSheet.getRow((short) 0).getPhysicalNumberOfCells();
//		//创建样式数组 
//		HSSFCellStyle styleArray[] = new HSSFCellStyle[columns];
//		//一次性创建所有列的样式放在数组里 
//		for (int s = 0; s < columns; s++) {
//			//得到数组实例 
//			styleArray[s] = workbook.createCellStyle();
//		}
//		//循环对每一个单元格进行赋值   这里要求模板的列序与list中的值要一一对应 
//		//定位行 
//		for (int rowId = 1; rowId <= dataList.size(); rowId++) {
//			//依次取第rowId行数据   每一个数据是valueList 
//			List<?> valueList = (List<?>) dataList.get(rowId - 1);
//			//定位列 
//			for (int columnId = 0; columnId < valueList.size(); columnId++) {
//				//依次取出对应与colunmId列的值
//				//每一个单元格的值
//				String dataValue = (String) valueList.get(columnId);
//				//取出colunmId列的的style
//				//模板每一列的样式
//				HSSFCellStyle style = styleArray[columnId];
//				//取模板第colunmId列的单元格对象
//				//模板单元格对象 
//				//HSSFCell templateCell = templateRow.getCell((short) columnId);
//				//创建一个新的rowId行   行对象
//				//新建的行对象   
//				HSSFRow hssfRow = templateSheet.createRow(rowId);
//				//创建新的rowId行   columnId列   单元格对象
//				//新建的单元格对象 
//				HSSFCell cell = hssfRow.createCell((short) columnId);
//				//如果对应的模板单元格   样式为非锁定
//				HSSFFont font = workbook.createFont();
//				//String columnName = templateCell.getStringCellValue().trim();
//				//如果是不准修改的列则红色显示字体
//				if (columnId == 0 || columnId == 1 || columnId == 2 || columnId == 3 || columnId == 5 || columnId == 7 || columnId == 13 || columnId == 15) {
//					//设置此列style为非锁定 
//					//style.setLocked(false); 
//					font.setColor(HSSFFont.COLOR_RED);
//					style.setFont(font);
//					//设置到新的单元格上 
//					cell.setCellStyle(style);
//				} else {  //否则样式为锁定   普通颜色
//					//设置此列style为锁定 
//					//style.setLocked(true); 
//					font.setColor(HSSFFont.COLOR_NORMAL);
//					style.setFont(font);
//					//设置到新单元格上 
//					cell.setCellStyle(style);
//				}
//				//设置编码 
//				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//				//设置值   统一为String 
//				cell.setCellValue(dataValue);
//			}
//		}
//		try {
//			//设置输入流 
//			FileOutputStream fOut  = new FileOutputStream(outputFile);
//			//将模板的内容写到输出文件上 
//			workbook.write(fOut);
//			fOut.flush();
//			//操作结束，关闭文件 
//			fOut.close();
//		} catch (Exception e1) {
//			e1.printStackTrace(System.out);
//
//		}
//	}
//
//	public void exportExcelFile(String outputFile, List<?> dataList) {
//		//创建工作表 
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		//创建sheet 
//		HSSFSheet sheet = workbook.createSheet();
//		//循环导出 
//		for (int rowId = 0; rowId < dataList.size(); rowId++) {
//			//取出对应行的数据列表对象 
//			List<?> valueList = (List<?>) dataList.get(rowId);
//			//从第0行开始创建 
//			HSSFRow hsrow = sheet.createRow(rowId);
//			//依次写入每一个单元格 
//			for (int columnId = 0; columnId < valueList.size(); columnId++) {
//				//得到对应单元格的值 
//				String dataValue = (String) valueList.get(columnId);
//				//创建该行的单元格 
//				HSSFCell cell = hsrow.createCell((short) columnId);
//				//设置编码 
//				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
//				//设置值 
//				cell.setCellValue(dataValue);
//			}
//		}
//		try {
//			//写出到文件
//			FileOutputStream os = new FileOutputStream(outputFile);
//			workbook.write(os);
//			os.flush();
//			//关闭文件流
//			os.close();
//		} catch (Exception e) {
//			e.printStackTrace(System.out);
//		}
//	}

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println(" 开始导出Excel文件 ");

		File f = new File("E://qt.xls");
		PoiExcelServletUtil ps = new PoiExcelServletUtil();
		ps.initWorkBook(new FileOutputStream(f));
		ps.createSheet(0, "协议列表1");
		ps.createRow(0, 15);
		ps.setCell(0, "试题编码 ", ps.getTitleStyle());
		ps.setCell(1, "题型", ps.getTitleStyle());
		ps.setCell(2, "分值", ps.getTitleStyle());
		ps.setCell(3, "难度", ps.getTitleStyle());
		ps.setCell(4, "级别", ps.getTitleStyle());
		ps.setCell(5, "知识点", ps.getTitleStyle());
		ps.createRow(1, 15);
		ps.setCell(0, "t1",ps.getContentStyle());
		ps.setCell(1, 1,ps.getContentStyle());
		ps.setCell(2, 3.0, ps.getContentStyle());
		ps.setCell(3, 1,ps.getContentStyle());
		ps.setCell(4, "重要",ps.getContentStyle());
		ps.setCell(5, "专业",ps.getContentStyle());
		ps.createSheet(1, "协议列表2");
		ps.createRow(0, 15);
		ps.setCell(0, "试题编码", ps.getTitleStyle());
		ps.setCell(1, "题型", ps.getTitleStyle());
		ps.setCell(2, "分值", ps.getTitleStyle());
		ps.setCell(3, "难度", ps.getTitleStyle());
		ps.setCell(4, "级别", ps.getTitleStyle());
		ps.setCell(5, "知识点", ps.getTitleStyle());
		ps.createRow(1, 15);
		ps.setCell(0, "t1",ps.getContentStyle());
		ps.setCell(1, 1,ps.getContentStyle());
		ps.setCell(2, 3.0, ps.getContentStyle());
		ps.setCell(3, 1,ps.getContentStyle());
		ps.setCell(4, new Date(), ps.getContentStyle());
		ps.setCell(5, "专业",ps.getContentStyle());

		try {
			ps.exportFile();
			System.out.println(" 导出Excel文件[成功] ");
		} catch (Exception ex) {
			System.out.println(" 导出Excel文件[失败] ");
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
		// readExcel.setSheetNum(1); // 设置读取索引为0的工作表
		// // 总行数
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
	 * // 产生excel文档 HSSFWorkbook wb = new HSSFWorkbook(); HSSFSheet sheet1 =
	 * wb.createSheet(); wb.setSheetName(0, "协议单位列表",(short)1);
	 *  // 标题行 HSSFRow row = sheet1.createRow((short) 0); HSSFCell cell =
	 * row.createCell((short) 0); cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("序号"); cell =
	 * row.createCell((short) 1); cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("单位名称");
	 * cell = row.createCell((short) 2);
	 * cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("联系人");
	 * cell = row.createCell((short) 3);
	 * cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("电话"); cell =
	 * row.createCell((short) 4); cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("备注"); cell =
	 * row.createCell((short) 5); cell.setCellType(HSSFCell.CELL_TYPE_STRING);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue("登记时间");
	 *  // 内容行 List<ContractualUnit> list =
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
	 * cell.setCellValue(unit.getRemark()); // 日期不为空时 if (unit.getCreateTime() !=
	 * null ) { cell = row.createCell((short) 5);
	 * cell.setEncoding(HSSFCell.ENCODING_UTF_16); cell.setCellValue(new
	 * Date(unit.getCreateTime().getTime())); HSSFCellStyle cellStyle =
	 * wb.createCellStyle(); // 建立新的cell样式
	 * cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy/mm/dd")); //
	 * 设置cell样式为定制的日期格式 cell.setCellStyle(cellStyle); // 设置该cell日期的显示格式 } } //
	 * FileOutputStream fileout=new FileOutputStream("workbook.xls");
	 * ByteArrayOutputStream os = new ByteArrayOutputStream(); wb.write(os);
	 * byte[] content = os.toByteArray(); InputStream is = new
	 * ByteArrayInputStream(content); // 序列化字节流 // InputStreamSerializable iss =
	 * new InputStreamSerializable(is); // return new
	 * ModelAndView("downPoolReportFile","contentStream",iss.getInStream());
	 */
}
