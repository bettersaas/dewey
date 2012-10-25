package common.poi;

/**
 *  
 * @File name:  CreateExcelMoBusiness.java 
 * @Create on:  2011-02-12 11:48:453
 * @Author   :  zhys513
 * @ChangeList
 * ---------------------------------------------------
 * Date         Editor              ChangeReasons
 *
 */

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

public class CreateExcelMoBusiness {

	private static String EXCEL_HIDE_SHEET_NAME = "excelhidesheetname";
	private static String HIDE_SHEET_NAME_SEX = "sexList";
	private static String HIDE_SHEET_NAME_PROVINCE = "provinceList";

	@SuppressWarnings("unused")
	//private HashMap<?, ?> map = new HashMap();
	// ���������б������
	private static String[] sexList = { "��", "Ů" };
	private static String[] provinceList = { "�㽭", "ɽ��", "����", "����", "�Ĵ�" };
	private static String[] zjProvinceList = { "�㽭", "����", "����", "����" };
	private static String[] sdProvinceList = { "ɽ��", "����", "�ൺ", "��̨" };
	private static String[] jxProvinceList = { "����", "�ϲ�", "����", "ӥ̶", "����" };
	private static String[] jsProvinceList = { "����", "�Ͼ�", "����", "����" };
	private static String[] scProvinceList = { "�Ĵ�", "�ɶ�", "����", "�Թ�" };

	public static void main(String[] args) {
		// ʹ������
		Workbook wb = new HSSFWorkbook();
		createExcelMo(wb);
		creatExcelHidePage(wb);
		setDataValidation(wb);
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("E://excel_template.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createExcelMo(Workbook wb) {
		Sheet sheet = wb.createSheet("�û������������");
		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("�ֻ�����");
		cell.setCellStyle(getTitleStyle(wb));
		cell = row.createCell(1);
		cell.setCellValue("��������");
		cell.setCellStyle(getTitleStyle(wb));
		cell = row.createCell(2);
		cell.setCellValue("��������");
		cell.setCellStyle(getTitleStyle(wb));
		cell = row.createCell(3);
	}

	/**
	 * ����ģ���ļ��ĺ����ͷ��Ԫ�����ʽ
	 * 
	 * @param wb
	 * @return
	 */
	private static CellStyle getTitleStyle(Workbook wb) {
		CellStyle style = wb.createCellStyle();
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
		Font font = wb.createFont();
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		style.setFont(font);
		return style;
	}

	/**
	 * ����ģ���ļ��ĺ����ͷ��Ԫ�����ʽ
	 * 
	 * @param wb
	 * @return
	 */
	public static void creatExcelHidePage(Workbook workbook) {
		Sheet hideInfoSheet = workbook.createSheet(EXCEL_HIDE_SHEET_NAME);// ����һЩ��Ϣ
		// ������ҳ����ѡ����Ϣ
		// ��һ�������Ա���Ϣ
		Row sexRow = hideInfoSheet.createRow(0);
		creatRow(sexRow, sexList);
		// �ڶ�������ʡ�������б�
		Row provinceNameRow = hideInfoSheet.createRow(1);
		creatRow(provinceNameRow, provinceList);
		// ���������ó��������б�
		Row cityNameRow = hideInfoSheet.createRow(2);
		creatRow(cityNameRow, zjProvinceList);

		cityNameRow = hideInfoSheet.createRow(3);
		creatRow(cityNameRow, sdProvinceList);

		cityNameRow = hideInfoSheet.createRow(4);
		creatRow(cityNameRow, jxProvinceList);

		cityNameRow = hideInfoSheet.createRow(5);
		creatRow(cityNameRow, jsProvinceList);

		cityNameRow = hideInfoSheet.createRow(6);
		creatRow(cityNameRow, scProvinceList);
		// ���ƹ���
		// ��һ�������Ա���Ϣ
		creatExcelNameList(workbook, HIDE_SHEET_NAME_SEX, 1, sexList.length, false);
		// �ڶ�������ʡ�������б�
		creatExcelNameList(workbook, HIDE_SHEET_NAME_PROVINCE, 2, provinceList.length, false);
		// �Ժ�̬��С����ʡ�ݶ�Ӧ�ĳ����б�
		creatExcelNameList(workbook, provinceList[0], 3, zjProvinceList.length, true);
		creatExcelNameList(workbook, provinceList[1], 4, sdProvinceList.length, true);
		creatExcelNameList(workbook, provinceList[2], 5, jxProvinceList.length, true);
		creatExcelNameList(workbook, provinceList[3], 6, jsProvinceList.length, true);
		creatExcelNameList(workbook, provinceList[4], 7, scProvinceList.length, true);
		// ��������ҳ��־
		workbook.setSheetHidden(workbook.getSheetIndex(EXCEL_HIDE_SHEET_NAME), true);
	}

	/**
	 * ����һ������
	 * @param workbook
	 */
	private static void creatExcelNameList(Workbook workbook, String nameCode, int order, int size, boolean cascadeFlag) {
		Name name;
		name = workbook.createName();
		name.setNameName(nameCode);
		name.setRefersToFormula(EXCEL_HIDE_SHEET_NAME + "!" + creatExcelNameList(order, size, cascadeFlag));
	}

	/**
	 * �����������м�����ʽ
	 * 
	 * @param workbook
	 */
	private static String creatExcelNameList(int order, int size, boolean cascadeFlag) {
		char start = 'A';
		if (cascadeFlag) {
			start = 'B';
			if (size <= 25) {
				char end = (char) (start + size - 1);
				return "$" + start + "$" + order + ":$" + end + "$" + order;
			} else {
				char endPrefix = 'A';
				char endSuffix = 'A';
				if ((size - 25) / 26 == 0 || size == 51) {// 26-51֮�䣬�����߽磨��������ĸ����㣩
					if ((size - 25) % 26 == 0) {// �߽�ֵ
						endSuffix = (char) ('A' + 25);
					} else {
						endSuffix = (char) ('A' + (size - 25) % 26 - 1);
					}
				} else {// 51����
					if ((size - 25) % 26 == 0) {
						endSuffix = (char) ('A' + 25);
						endPrefix = (char) (endPrefix + (size - 25) / 26 - 1);
					} else {
						endSuffix = (char) ('A' + (size - 25) % 26 - 1);
						endPrefix = (char) (endPrefix + (size - 25) / 26);
					}
				}
				return "$" + start + "$" + order + ":$" + endPrefix + endSuffix + "$" + order;
			}
		} else {
			if (size <= 26) {
				char end = (char) (start + size - 1);
				return "$" + start + "$" + order + ":$" + end + "$" + order;
			} else {
				char endPrefix = 'A';
				char endSuffix = 'A';
				if (size % 26 == 0) {
					endSuffix = (char) ('A' + 25);
					if (size > 52 && size / 26 > 0) {
						endPrefix = (char) (endPrefix + size / 26 - 2);
					}
				} else {
					endSuffix = (char) ('A' + size % 26 - 1);
					if (size > 52 && size / 26 > 0) {
						endPrefix = (char) (endPrefix + size / 26 - 1);
					}
				}
				return "$" + start + "$" + order + ":$" + endPrefix + endSuffix + "$" + order;
			}
		}
	}

	/**
	 * ����һ������
	 * 
	 * @param currentRow
	 * @param textList
	 */
	private static void creatRow(Row currentRow, String[] textList) {
		if (textList != null && textList.length > 0) {
			int i = 0;
			for (String cellValue : textList) {
				Cell userNameLableCell = currentRow.createCell(i++);
				userNameLableCell.setCellValue(cellValue);
			}
		}
	}

	/**
	 * ���������֤ѡ��
	 * @param sheet
	 */
	public static void setDataValidation(Workbook wb) {
		int sheetIndex = wb.getNumberOfSheets();
		if (sheetIndex > 0) {
			for (int i = 0; i < sheetIndex; i++) {
				Sheet sheet = wb.getSheetAt(i);
				if (!EXCEL_HIDE_SHEET_NAME.equals(sheet.getSheetName())) {
					DataValidation data_validation_list = null;
					// ʡ��ѡ�������֤����
					for (int a = 2; a < 3002; a++) {
						data_validation_list = getDataValidationByFormula(HIDE_SHEET_NAME_PROVINCE, a, 2);
						sheet.addValidationData(data_validation_list);
						// ����ѡ�������֤����
						data_validation_list = getDataValidationByFormula("INDIRECT(B" + a + ")", a, 3);
						sheet.addValidationData(data_validation_list);
						// �Ա������֤����
						data_validation_list = getDataValidationByFormula(HIDE_SHEET_NAME_SEX, a, 1);
						sheet.addValidationData(data_validation_list);
					}
				}
			}
		}
	}

	/**
	 * ʹ���Ѷ��������Դ��ʽ����һ��������֤
	 * 
	 * @param formulaString
	 * @param naturalRowIndex
	 * @param naturalColumnIndex
	 * @return
	 */
	private static DataValidation getDataValidationByFormula(String formulaString, int naturalRowIndex, int naturalColumnIndex) {
		// ���������б�����
		DVConstraint constraint = DVConstraint.createFormulaListConstraint(formulaString);
		// ����������Ч�Լ������ĸ���Ԫ���ϡ�
		// �ĸ������ֱ��ǣ���ʼ�С���ֹ�С���ʼ�С���ֹ��
		int firstRow = naturalRowIndex - 1;
		int lastRow = naturalRowIndex - 1;
		int firstCol = naturalColumnIndex - 1;
		int lastCol = naturalColumnIndex - 1;
		CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
		// ������Ч�Զ���
		DataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
		// ����������Ϣ��ʾ��Ϣ
		data_validation_list.createPromptBox("����ѡ����ʾ", "��ʹ��������ʽѡ����ʵ�ֵ��");
		// �������������ʾ��Ϣ
		data_validation_list.createErrorBox("ѡ�������ʾ", "�������ֵδ�ڱ�ѡ�б��У�������ѡ����ʵ�ֵ��");
		return data_validation_list;
	}

	public static DataValidation getDataValidationByDate(int naturalRowIndex, int naturalColumnIndex) {
		// ���������б�����
		DVConstraint constraint = DVConstraint.createDateConstraint(DVConstraint.OperatorType.BETWEEN, "1900-01-01", "5000-01-01", "yyyy-mm-dd");
		// ����������Ч�Լ������ĸ���Ԫ���ϡ�
		// �ĸ������ֱ��ǣ���ʼ�С���ֹ�С���ʼ�С���ֹ��
		int firstRow = naturalRowIndex - 1;
		int lastRow = naturalRowIndex - 1;
		int firstCol = naturalColumnIndex - 1;
		int lastCol = naturalColumnIndex - 1;
		CellRangeAddressList regions = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
		// ������Ч�Զ���
		DataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
		// ����������Ϣ��ʾ��Ϣ
		data_validation_list.createPromptBox("���ڸ�ʽ��ʾ", "�밴��'yyyy-mm-dd'��ʽ��������ֵ��");
		// �������������ʾ��Ϣ
		data_validation_list.createErrorBox("���ڸ�ʽ������ʾ", "����������ڸ�ʽ������'yyyy-mm-dd'��ʽ�淶�����������룡");
		return data_validation_list;
	}
}