package common.poi;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class TestPOI {

	public static void main(String[] args) {
		FileOutputStream fileOut = null;
		BufferedImage bufferImg = null;
		BufferedImage bufferImg1 = null;
		try {
			// �ȰѶ�������ͼƬ�ŵ�һ��ByteArrayOutputStream�У��Ա����ByteArray
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			ByteArrayOutputStream byteArrayOut1 = new ByteArrayOutputStream();
			bufferImg = ImageIO.read(new File("D:\\lhg\\�ҵ�ͼƬ\\21611637.jpg"));
			bufferImg1 = ImageIO.read(new File("D:\\lhg\\�ҵ�ͼƬ\\21611631.jpg"));
			ImageIO.write(bufferImg, "jpg", byteArrayOut);
			ImageIO.write(bufferImg1, "jpg", byteArrayOut1);
			// ����һ��������
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet1 = wb.createSheet("����");
			// HSSFRow row = sheet1.createRow(2);
			HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
			HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 512, 255, (short) 1, 1, (short) 10, 20);
			HSSFClientAnchor anchor1 = new HSSFClientAnchor(0, 0, 512, 255, (short) 2, 30, (short) 10, 60);
			anchor1.setAnchorType(2);
			// ����ͼƬ
			patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
			patriarch.createPicture(anchor1, wb.addPicture(byteArrayOut1.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
			fileOut = new FileOutputStream("E:/workbook.xls");
			// д��excel�ļ�
			wb.write(fileOut);
			fileOut.close();
		} catch (IOException io) {
			io.printStackTrace();
			System.out.println("io erorr :  " + io.getMessage());
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}