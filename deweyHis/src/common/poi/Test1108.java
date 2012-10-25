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
            FileInputStream file = new FileInputStream("d://��Ϸ���ݿ����.xls");
            HSSFWorkbook book = new HSSFWorkbook(new POIFSFileSystem(file));
            HSSFSheet sheet = book.getSheetAt(0);//0ҳ
            file.close();

            //ҳ��
            int sheetNum = book.getNumberOfSheets();
            //����
            int sheetRowNum = sheet.getLastRowNum();
            //ָ����������
            HSSFRow row = sheet.getRow(0);
            //����ָ����Ԫ�����
            HSSFCell cell = row.getCell(0);
            //�����������־�̬����
            /*
             * ���� HSSFCell.
             * CELL_TYPE_BLANK        �ո� 3
             * CELL_TYPE_BOOLEAN  ���� 4
             * CELL_TYPE_ERROR       �������� 5
             * CELL_TYPE_FORMULA ��ʽ 2
             * CELL_TYPE_NUMERIC  ���� 0
             * CELL_TYPE_STRING         �ַ��� 1
             * ENCODING_COMPRESSED_UNICODE      �ַ�����(Ĭ��Ϊunicode)
             * ENCODING_UTF_16        ����cell���������ĸ�λ�ֽڽض� �������
             */
            int cellTypeNum = cell.getCellType();
            //��õ�Ԫ������
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
            //book.setSheetName(0,"Э�鵥λ�б�");
            book.setSheetName(0, "Э�鵥λ�б�");  //,(short)1
    		
            /*����*/
            //����һ��
            HSSFRow row = sheet.createRow(0);
            //����һ����Ԫ��
            HSSFCell cell = row.createCell(0);              //����λ��
            //��������
            cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);  //����
            //����ֵ
            cell.setCellValue(0);
            
            /*������*/
            //������Ԫ����ʽ
            HSSFCellStyle cellType = book.createCellStyle();
            //������ʽ
            cellType.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
            //����һ����Ԫ��
            HSSFCell cell1 = row.createCell(1);
            //���õ�Ԫ����ʽ
            cell1.setCellStyle(cellType);//���ڸ�ʽ
            //�ַ�����
            //cell1.setEncoding(HSSFCell.ENCODING_UTF_16);//�������
            //����ֵ
            cell1.setCellValue("11.22");
            
            
            /*�ַ���*/
            //����һ����Ԫ��
            HSSFCell cell2 = row.createCell(2);
            //��������
            cell2.setCellType(HSSFCell.CELL_TYPE_STRING);//�ַ���
            //�ַ�����
            //cell2.setEncoding(HSSFCell.ENCODING_UTF_16);//�������
            //����ֵ
            cell2.setCellValue("����");
            
            /*����*/
            //������Ԫ����ʽ
            HSSFCellStyle cellType1 = book.createCellStyle();
            //������ʽ
            cellType1.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
            //����һ����Ԫ��
            HSSFCell cell3 = row.createCell(3);
            //���õ�Ԫ����ʽ
            cell3.setCellStyle(cellType1);//���ڸ�ʽ
            //�ַ�����
            //cell3.setEncoding(HSSFCell.ENCODING_UTF_16);//�������
            //����ֵ
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