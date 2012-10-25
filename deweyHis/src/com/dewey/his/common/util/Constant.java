package com.dewey.his.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.dewey.his.common.model.FunctionVO;
import common.util.json.JsonBinder;

public class Constant {

	/**
	 * ��¼����:   0:��¼ʧ�� 1:��¼�ɹ� 2:�˳�
	 */
	public static final String USER_LOGIN_INFO_ACTION_FAILURE   = "0";
	public static final String USER_LOGIN_INFO_ACTION_SUCCESS = "1";
	public static final String USER_LOGIN_INFO_ACTION_QUIT           = "2";

	/**
	 * JSON������
	 */
	private static JsonBinder binder ;

	/**
	 * �в㼶��ϵ�������б�tree
	 */
	private static FunctionVO functionsTreeConstant ;

	/**
	 * ��Id �͹��ܶ����ӳ��
	 */
	private static Map<String, FunctionVO> functionsMapConstant ;

	static {
		binder = JsonBinder.buildNonDefaultBinder();
		functionsMapConstant = createNewFunctionsMapConstant();
		// �޳�url - Mapɾ������
		Iterator<Entry<String, FunctionVO>> it = functionsMapConstant.entrySet().iterator();
		 while (it.hasNext()) {
			 Entry<String, FunctionVO> entry = it.next();
		     //String  key = entry.getKey();
		     FunctionVO  value = entry.getValue();
		     value.setUrl(null);
		 }
		functionsTreeConstant = functionsMapConstant.get("FM");
	}

	/**
	 * ��̬���������¼������б�
	 * @param arr
	 * @return
	 */
	public static List<FunctionVO> createFunctionVOList(FunctionVO... voArray) {
		List<FunctionVO> list = new ArrayList<FunctionVO>();
		for (FunctionVO element : voArray) {
			list.add(element);
		}
		return list;
	}

	/**
	 * �����µĹ�����
	 * @return
	 */
	public static Map<String, FunctionVO> createNewFunctionsMapConstant() {
		// ����ӳ�����
		Map<String, FunctionVO> functionsMapConstant = new HashMap<String, FunctionVO>();

		/**
		 * ϵͳ���ܶ���
		 */
		// ǰ̨�Ӵ�
		FunctionVO FM0101 = new FunctionVO("FM0101", "��ס�Ǽ�", "0", "FM01", "/checkIn/new", true, true, null);
		FunctionVO FM0102 = new FunctionVO("FM0102", "�ÿ��б�", "0", "FM01", "/guestList/query", true, true, null);
		FunctionVO FM01 = new FunctionVO("FM01", "ǰ̨�Ӵ�", "0", "FM", "", false, false, createFunctionVOList(FM0101,FM0102));
		functionsMapConstant.put(FM0101.getId(), FM0101);
		functionsMapConstant.put(FM0102.getId(), FM0102);
		functionsMapConstant.put(FM01.getId(), FM01);
		// ǰ̨����
		FunctionVO FM0201 = new FunctionVO("FM0201", "�ϲ��˵�", "0", "FM02", "", false, true, null);
		FunctionVO FM0202 = new FunctionVO("FM0202", "����˵�", "0", "FM02", "", false, true, null);
		FunctionVO FM0203 = new FunctionVO("FM0203", "�����˷�", "0", "FM02", "", false, true, null);
		FunctionVO FM0204 = new FunctionVO("FM0204", "�˵��б�", "0", "FM02", "", false, true, null);
		FunctionVO FM02 = new FunctionVO("FM02", "ǰ̨����", "0", "FM", "", false, false,  createFunctionVOList(FM0201, FM0202, FM0203,FM0204));
		functionsMapConstant.put(FM0201.getId(), FM0201);
		functionsMapConstant.put(FM0202.getId(), FM0202);
		functionsMapConstant.put(FM0203.getId(), FM0203);
		functionsMapConstant.put(FM0204.getId(), FM0204);
		functionsMapConstant.put(FM02.getId(), FM02);
		// Ԥ������
		FunctionVO FM0301 = new FunctionVO("FM0301", "����Ԥ��", "0", "FM03", "/reserve/new", false, true, null);
		FunctionVO FM0302 = new FunctionVO("FM0302", "Ԥ���б�", "0", "FM03", "/reserveList/query", false, true, null);
		FunctionVO FM03 = new FunctionVO("FM03", "Ԥ������", "0", "FM", "",  false, false, createFunctionVOList(FM0301, FM0302));
		functionsMapConstant.put(FM0301.getId(), FM0301);
		functionsMapConstant.put(FM0302.getId(), FM0302);
		functionsMapConstant.put(FM03.getId(), FM03);
		// �ͷ�����
		//FunctionVO FM0401 = new FunctionVO("FM0401", "��̬չʾ", "0", "FM04", "", false, true, null);
		FunctionVO FM0402 = new FunctionVO("FM0402", "�ͷ��б�", "0", "FM04", "/merRoom/query", false, true, null);
		FunctionVO FM04 = new FunctionVO("FM04", "�ͷ�����", "0", "FM", "",  false, false, createFunctionVOList(FM0402));
		//functionsMapConstant.put(FM0401.getId(), FM0401);
		functionsMapConstant.put(FM0402.getId(), FM0402);
		functionsMapConstant.put(FM04.getId(), FM04);
		/* �ֽ����
		FunctionVO FM0501 = new FunctionVO("FM0501", "����",         "0", "FM05", "", false, true, null);
		FunctionVO FM0502 = new FunctionVO("FM0502", "������ʷ", "0", "FM05", "", false, true, null);
		FunctionVO FM0503 = new FunctionVO("FM0503", "�ؿ�ƻ�", "0", "FM05", "", false, true, null);
		FunctionVO FM05 = new FunctionVO("FM05", "�ֽ����", "0", "FM", "",  false, false, createFunctionVOList(FM0501, FM0502, FM0503));
		functionsMapConstant.put(FM0501.getId(), FM0501);
		functionsMapConstant.put(FM0502.getId(), FM0502);
		functionsMapConstant.put(FM0503.getId(), FM0503);
		functionsMapConstant.put(FM05.getId(), FM05);
		*/
		/* ��ѯ
		FunctionVO FM0601 = new FunctionVO("FM0601", "�տ����", "0", "FM06", "", false, true, null);
		FunctionVO FM0602 = new FunctionVO("FM0602", "�������", "0", "FM06", "", false, true, null);
		FunctionVO FM0603 = new FunctionVO("FM0603", "�ʻ���ѯ", "0", "FM06", "", false, true, null);
		FunctionVO FM06 = new FunctionVO("FM06", "��ѯ", "0", "FM", "",  false, false, createFunctionVOList(FM0601, FM0602, FM0603));
		functionsMapConstant.put(FM0601.getId(), FM0601);
		functionsMapConstant.put(FM0602.getId(), FM0602);
		functionsMapConstant.put(FM0603.getId(), FM0603);
		functionsMapConstant.put(FM06.getId(), FM06);
		*/
		// �ͻ���ϵ����
		FunctionVO FM0701 = new FunctionVO("FM0701", "Э�鵥λ����", "0", "FM07", "/contractualUnit/list", true, true, null);
		FunctionVO FM07 = new FunctionVO("FM07", "�ͻ���ϵ����", "0", "FM", "", false, false, createFunctionVOList(FM0701));
		functionsMapConstant.put(FM0701.getId(), FM0701);
		functionsMapConstant.put(FM07.getId(), FM07);
		// ��������
		FunctionVO FM0801 = new FunctionVO("FM0801", "Ӫҵ�ձ�", "0", "FM08", "", false, true, null);
		FunctionVO FM0802 = new FunctionVO("FM0802", "Ӫҵ����", "0", "FM08", "", false, true, null);
		FunctionVO FM0803 = new FunctionVO("FM0803", "Ӫҵ�±�", "0", "FM08", "", false, true, null);
		FunctionVO FM08 = new FunctionVO("FM08", "��������", "0", "FM", "",  false, false, createFunctionVOList(FM0801, FM0802, FM0803));
		functionsMapConstant.put(FM0801.getId(), FM0801);
		functionsMapConstant.put(FM0802.getId(), FM0802);
		functionsMapConstant.put(FM0803.getId(), FM0803);
		functionsMapConstant.put(FM08.getId(), FM08);
		/* �ӿڹ���
		FunctionVO FM0901 = new FunctionVO("FM0901", "�绰�Ʒѹ���", "0", "FM09", "", false, true, null);
		FunctionVO FM0902 = new FunctionVO("FM0902", "������������", "0", "FM09", "", false, true, null);
		FunctionVO FM09 = new FunctionVO("FM09", "�ӿڹ���", "0", "FM", "",  false, false, createFunctionVOList(FM0901, FM0902));
		functionsMapConstant.put(FM0901.getId(), FM0901);
		functionsMapConstant.put(FM0902.getId(), FM0902);
		functionsMapConstant.put(FM09.getId(), FM09);
		*/
		// ����ά��
		FunctionVO FM1001 = new FunctionVO("FM1001", "��������",         "0", "FM10", "/roomType/list",                 false, true, null);
		FunctionVO FM1002 = new FunctionVO("FM1002", "�Ƶ���Ϣ����", "0", "FM10", "/hotelInfoSetting/edit",      false, true, null);
		FunctionVO FM1003 = new FunctionVO("FM1003", "�Ʒ�����",         "0", "FM10", "/chargeRuleSetting/edit", false, true, null);
		FunctionVO FM10 = new FunctionVO("FM10", "����ά��", "0", "FM", "",  false, false, createFunctionVOList(FM1001, FM1002, FM1003));
		functionsMapConstant.put(FM1001.getId(), FM1001);
		functionsMapConstant.put(FM1002.getId(), FM1002);
		functionsMapConstant.put(FM1003.getId(), FM1003);
		functionsMapConstant.put(FM10.getId(), FM10);
		// ϵͳ����
		//FunctionVO FM1101 = new FunctionVO("FM1101", "����ά��",         "0", "FM11", "/merRoom/query",      false, true, null);
		FunctionVO FM1102 = new FunctionVO("FM1102", "������Ŀά��", "0", "FM11", "/merServices/query", false, true, null);
		FunctionVO FM1103 = new FunctionVO("FM1103", "�û�ά��",         "0", "FM11", "/merUser/list",             false, true, null);
		FunctionVO FM1104 = new FunctionVO("FM1104", "��ɫά��",         "0", "FM11", "/merRole/list",             false, true, null);
		FunctionVO FM1105 = new FunctionVO("FM1105", "ע����Ϣά��", "0", "FM11", "",                                  false, true, null);
		FunctionVO FM1106 = new FunctionVO("FM1106", "��־��ѯ",         "0", "FM11", "",                                  false, true, null);
		FunctionVO FM11 = new FunctionVO("FM11", "ϵͳ����", "0", "FM", "",  false, false, createFunctionVOList(FM1102, FM1103, FM1104, FM1105, FM1106));
		//functionsMapConstant.put(FM1101.getId(), FM1101);
		functionsMapConstant.put(FM1102.getId(), FM1102);
		functionsMapConstant.put(FM1103.getId(), FM1103);
		functionsMapConstant.put(FM1104.getId(), FM1104);
		functionsMapConstant.put(FM1105.getId(), FM1105);
		functionsMapConstant.put(FM1106.getId(), FM1106);
		functionsMapConstant.put(FM11.getId(), FM11);

		/**
		 * ϵͳ���ܲ˵����Ĺ��� unctionsTreeConstant
		 */
		//FunctionVO FM = new FunctionVO("FM", "���ܲ˵���ʾ��", "0", "-1", "",  false, false, createFunctionVOList(FM01, FM02, FM03, FM04, FM05, FM06, FM07, FM08, FM09, FM10, FM11));
		FunctionVO FM = new FunctionVO("FM", "���ܲ˵���ʾ��", "0", "-1", "",  false, false, createFunctionVOList(FM01, FM02, FM03, FM04, FM07, FM08, FM10, FM11));
		functionsMapConstant.put(FM.getId(), FM);
		return functionsMapConstant;
	}

	/**
	 * �����νṹ�Ĺ��ܲ˵���Json�ִ�����
	 * @return
	 */
	public static String getFunctionsTreeConstantJson() {
		return binder.toJson(functionsTreeConstant);
	}

	/**
	 * �����νṹ�Ĺ��ܲ˵��Ժÿ���Json�ִ�����
	 * @return
	 */
	public static String getPrettyPrintFunsTreeConstantJson() {
		return binder.toPrettyPrintingJson(functionsTreeConstant);
	}
	
	/**
	 * ��ÿ�ݲ˵��Ľڵ�ӳ���б�
	 * @param functionsMap
	 * @return
	 */
	public static List<FunctionVO> getQuickMenuFunctionsMap(Map<String, FunctionVO> functionsMap) {
		// ����ӳ�����
		List<FunctionVO> quickMenuFunsList = new ArrayList<FunctionVO>();
		Iterator<Entry<String, FunctionVO>> it = functionsMap.entrySet().iterator();
		while (it.hasNext()) {
			 Entry<String, FunctionVO> entry = it.next();
			 // Key
		     // String  key = entry.getKey();
		     // Value
		     FunctionVO  value = entry.getValue();
		     // ������ݲ˵�
		     if (value != null && value.isLeaf() && value.isQuickMenu()) {
		    	 quickMenuFunsList.add(value);
		     }
		 }
		 Collections.sort(quickMenuFunsList, new FunctionVOSort());
		return quickMenuFunsList;
	}
	
	/**
	 * �޳��û�Ȩ������û��Ȩ�޵��ӽڵ�
	 * @param functionsMap
	 */
	public static void removeNoCheckedFunctionsMap(Map<String, FunctionVO> functionsMap) {
		// ɾ����û�е�ѡ��Ĺ���
		Iterator<Entry<String, FunctionVO>> it = functionsMap.entrySet().iterator();
		 while (it.hasNext()) {
			 Entry<String, FunctionVO> entry = it.next();
			 // Key
		     //String  key = entry.getKey();
		     // Value
		     FunctionVO  value = entry.getValue();
		     // û��ѡ���ɾ����
		     if ("0".equals(value.getChecked())) {
		    	 it.remove();
		     } else {
			     // �Ӽ��˵���ɾ��
			     List<FunctionVO> list = value.getChildren();
			     if(list != null && !list.isEmpty()) {
			    	 // list����ɾ������
				     for(int i=list.size()-1;i>-1;i--) {
				    	 FunctionVO vo = list.get(i);
				    	 if (vo != null && "0".equals(vo.getChecked())) {
				    		 list.remove(vo);
				    	 }
				     }
			     }
		     }
		 }
	}
	
	
	public static FunctionVO getFunctionsTreeConstant() {
		return functionsTreeConstant;
	}

	public static void setFunctionsTreeConstant(FunctionVO functionsTreeConstant) {
		Constant.functionsTreeConstant = functionsTreeConstant;
	}

	public static Map<String, FunctionVO> getFunctionsMapConstant() {
		return functionsMapConstant;
	}

	public static void setFunctionsMapConstant(Map<String, FunctionVO> functionsMapConstant) {
		Constant.functionsMapConstant = functionsMapConstant;
	}
}
