package common.poi;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class Test1108 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	Test1108 test = new Test1108();
        //test.read();
        test.write();
    }

    public void read() {
        try {
            //file read
            FileInputStream file = new FileInputStream("d://游戏数据库设计.xls");
            HSSFWorkbook book = new HSSFWorkbook(new POIFSFileSystem(file));
            HSSFSheet sheet = book.getSheetAt(0);//0页
            file.close();

            //页数
            int sheetNum = book.getNumberOfSheets();
            //行数
            int sheetRowNum = sheet.getLastRowNum();
            //指定行数对象
            HSSFRow row = sheet.getRow(0);
            //行数指定单元格对象
            HSSFCell cell = row.getCell(0);
            //行数类型数字静态代表
            /*
             * 类型 HSSFCell.
             * CELL_TYPE_BLANK        空格 3
             * CELL_TYPE_BOOLEAN  布尔 4
             * CELL_TYPE_ERROR       错误类型 5
             * CELL_TYPE_FORMULA 公式 2
             * CELL_TYPE_NUMERIC  数字 0
             * CELL_TYPE_STRING         字符串 1
             * ENCODING_COMPRESSED_UNICODE      字符编码(默认为unicode)
             * ENCODING_UTF_16        设置cell编码解决中文高位字节截断 解决乱码
             */
            int cellTypeNum = cell.getCellType();
            //获得单元格内容
            String cellValue = cell.getStringCellValue();

            System.out.println("sheetNum:" + sheetNum);
            System.out.println("sheetRowNum:" + sheetRowNum);
            System.out.println("cellTypeNum:" + cellTypeNum);
            System.out.println("cellValue:" + cellValue);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void write() {
        try {
            //write
            HSSFWorkbook book = new HSSFWorkbook();
            HSSFSheet sheet = book.createSheet();
            //book.setSheetName(0,"协议单位列表");
            book.setSheetName(0, "协议单位列表");  //,(short)1
    		
            /*数字*/
            //建立一行
            HSSFRow row = sheet.createRow(0);
            //建立一个单元格
            HSSFCell cell = row.createCell(0);              //建立位置
            //设置类型
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);  //数字
            //设置值
            cell.setCellValue(0);
            
            /*浮点型*/
            //建立单元格样式
            HSSFCellStyle cellType = book.createCellStyle();
            //设置样式
            cellType.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
            //建立一个单元格
            HSSFCell cell1 = row.createCell(1);
            //设置单元格样式
            cell1.setCellStyle(cellType);//日期格式
            //字符编码
            //cell1.setEncoding(HSSFCell.ENCODING_UTF_16);//解决乱码
            //设置值
            cell1.setCellValue("11.22");
            
            
            /*字符串*/
            //建立一个单元格
            HSSFCell cell2 = row.createCell(2);
            //设置类型
            cell2.setCellType(HSSFCell.CELL_TYPE_STRING);//字符串
            //字符编码
            //cell2.setEncoding(HSSFCell.ENCODING_UTF_16);//解决乱码
            //设置值
            cell2.setCellValue("哈哈");
            
            /*日期*/
            //建立单元格样式
            HSSFCellStyle cellType1 = book.createCellStyle();
            //设置样式
            cellType1.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //建立一个单元格
            HSSFCell cell3 = row.createCell(3);
            //设置单元格样式
            cell3.setCellStyle(cellType1);//日期格式
            //字符编码
            //cell3.setEncoding(HSSFCell.ENCODING_UTF_16);//解决乱码
            //设置值
            cell3.setCellValue("2/31/2008");
            FileOutputStream out = new FileOutputStream("e://xx.xls");
            book.write(out);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    
//	File f = new File("/home/zhangyi/dell500.xls");
//
//	if (f.exists()) {
//		// read
//		try {
//			InputStream fis = new FileInputStream(f);
//			POIFSFileSystem poifs = new POIFSFileSystem(fis);
//			HSSFWorkbook wb = new HSSFWorkbook(poifs);
//			List retList = new ArrayList();
//			System.out.println("sheet number : " + wb.getNumberOfSheets());
//			HSSFSheet s = wb.getSheetAt(0);
//			System.out.println("sheet obj is : " + s);
//			for (int h = 0; h < wb.getNumberOfSheets(); ++h) {
//				List list = new ArrayList();
//				HSSFSheet sheet = wb.getSheetAt(h);
//				int rowcount = sheet.getLastRowNum();
//				rowcount++;
//				System.out.print("-----sheet[" + h + "]: row count = " + rowcount);
//				int colcount = 0;
//				for (int i = 0; i < rowcount; ++i) {
//					HSSFRow row = sheet.getRow(i); // i=0 indicate the
//					// first
//					// row
//					if (row == null)
//						continue; // without the row, break and continue;
//					if (colcount == 0) { // colunm count set to column of
//						// the first effective row
//						colcount = row.getLastCellNum();
//						System.out.println(", column count = " + colcount);
//					}
//					String[] fieldValue = new String[colcount];
//					for (short j = 0; j < colcount; ++j) { // column data
//						// in
//						// the current
//						HSSFCell cell = row.getCell(j);
//						// fieldValue[j] = getCellStringValue(cell);
//						if (cell != null) {
//							System.out.println("cell is: " + cell.getStringCellValue());
//						}
//						// System.out.println("cell is : " +cell.getCellComment());
//					}
//					list.add(fieldValue);
//				}
//				retList.add(list);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}