package common.base.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.base.model.vo.NameValueVO;

/**
 * ϵͳ�������У���Ҫ�����е�ֵ���б�ӳ�䡢ҳ���ModelMap����
 * ���У� ModelMap�����е�������һ�±�ʾΪ ������+List ��������������ĸ��д��������ʾΪ������
 * @author Administrator
 */
public class VOConstantList {
	
	/****************************************************************************************
	 * �ͷ�
	 *   MerRoom    ��
	 * 	       state    ����״̬   ����״̬(1��Ԥ����2����ס��3�����෿4��ά�޷�5���վ���)
	 ****************************************************************************************/
	public static  List<NameValueVO> merRoomStateList = new ArrayList<NameValueVO>();
	
	public static Map<String, String> getMerRoomStateMap() {
		return NameValueVO.listToMap(merRoomStateList);
	}
	
	public static Map<String,List<NameValueVO>> getMerRoomStateListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("StateList ", merRoomStateList);
		return map;
	}
	
	
	/****************************************************************************************
	 * ������Ŀ
	 *   MerServices    ��
	 * 	       consumeType    �������
	 ****************************************************************************************/
	public static  List<NameValueVO> merServicesConsumeTypeList = new ArrayList<NameValueVO>();
	
	/**
	 * �õ�����ӳ��
	 *   ת��Ϊ����ʹ�ã�   
		Map<String, String> map = VOConstant.getConsumeTypeMap();
		for(MerServices merServices : merServicesList ) {
			merServices.setConsumeType(map.get(merServices.getConsumeType()));
		}
	 */
	public static Map<String, String> getMerServicesConsumeTypeMap() {
		return NameValueVO.listToMap(merServicesConsumeTypeList);
	}
	
	/**
	 * �õ�ҳ���model����ӳ��
	 *   ʹ�ã�   model.addAllAttributes(VOConstant.getConsumeTypeListModelMap());
	 */
	public static Map<String,List<NameValueVO>> getMerServicesConsumeTypeListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("ConsumeTypeList", merServicesConsumeTypeList);
		return map;
	}
	
	/****************************************************************************************
	 * �̻��û�
	 * MerUser    ��
	 *         type           �û�����
	 *         status        �û�״̬
	****************************************************************************************/
	public static  List<NameValueVO> merUserTypeList = new ArrayList<NameValueVO>();
	public static  List<NameValueVO> merUserStatusList = new ArrayList<NameValueVO>();
	
	public static Map<String, String> getMerUserTypeMap() {
		return NameValueVO.listToMap(merUserTypeList);
	}
	
	public static Map<String,List<NameValueVO>> getMerUserTypeListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("TypeList", merUserTypeList);
		return map;
	}
	
	public static Map<String, String> getMerUserStatusMap() {
		return NameValueVO.listToMap(merUserStatusList);
	}
	
	public static Map<String,List<NameValueVO>> getMerUserStatusListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("StatusList", merUserStatusList);
		return map;
	}
	/****************************************************************************************
	 * �̻�״̬
	 * Mer    ��
	 *         status        �̻�״̬
	****************************************************************************************/
	public static  List<NameValueVO> merStatusList = new ArrayList<NameValueVO>();
	
	public static Map<String, String> getMerStatusMap() {
		return NameValueVO.listToMap(merStatusList);
	}
	/****************************************************************************************
	 * �̻���ɫ
	 *   MerRole    ��
	 * 	       readwrite    ��ɫ����
	 ****************************************************************************************/
	public static  List<NameValueVO> merRoleReadwriteList = new ArrayList<NameValueVO>();
	
	public static Map<String, String> getMerRoleReadwriteMap() {
		return NameValueVO.listToMap(merRoleReadwriteList);
	}
	
	public static Map<String,List<NameValueVO>> getMerRoleReadwriteListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("ReadwriteList", merRoleReadwriteList);
		return map;
	}
	
	/****************************************************************************************
	 * ��ס�ǼǱ�
	 *   CheckIn    ��
	 * 	      sex                     �Ա�
	 *       idType               ֤������
	 *       stayType           ��ס����
	 *       settleMode       ���ʽ
	 *       custType           �ÿ����
	 *       status                ��ס״̬
	 ****************************************************************************************/
	public static  List<NameValueVO> checkInSexList = new ArrayList<NameValueVO>();
	public static  List<NameValueVO> checkInIdTypeList = new ArrayList<NameValueVO>();
	public static  List<NameValueVO> checkInStayTypeList = new ArrayList<NameValueVO>();
	public static  List<NameValueVO> checkInSettleModeList = new ArrayList<NameValueVO>();
	public static  List<NameValueVO> checkInCustTypeList = new ArrayList<NameValueVO>();
	public static  List<NameValueVO> checkInStatusList = new ArrayList<NameValueVO>();
	
	public static Map<String, String> getCheckInSexMap() {
		return NameValueVO.listToMap(checkInSexList);
	}
	
	public static Map<String,List<NameValueVO>> getCheckInSexListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("SexList", checkInSexList);
		return map; 
	}
	
	public static Map<String, String> getCheckInIdTypeMap() {
		return NameValueVO.listToMap(checkInIdTypeList);
	}
	
	public static Map<String,List<NameValueVO>> getCheckInIdTypeListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("IdTypeList", checkInIdTypeList);
		return map;
	}
	
	public static Map<String, String> getCheckInStayTypeMap() {
		return NameValueVO.listToMap(checkInStayTypeList);
	}
	
	public static Map<String,List<NameValueVO>> getCheckInStayTypeListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("StayTypeList", checkInStayTypeList);
		return map;
	}
	
	public static Map<String, String> getCheckInSettleModeMap() {
		return NameValueVO.listToMap(checkInSettleModeList);
	}
	
	public static Map<String,List<NameValueVO>> getCheckInSettleModeListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("SettleModeList", checkInSettleModeList);
		return map;
	}
	
	public static Map<String, String> getCheckInCustTypeMap() {
		return NameValueVO.listToMap(checkInCustTypeList);
	}
	
	public static Map<String,List<NameValueVO>> getCheckInCustTypeListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("CustTypeList", checkInCustTypeList);
		return map;
	}
	
	public static Map<String, String> getCheckInStatusMap() {
		return NameValueVO.listToMap(checkInStatusList);
	}
	
	public static Map<String,List<NameValueVO>> getCheckInStatusListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("StatusList", checkInStatusList);
		return map; 
	}
	
	/****************************************************************************************
	 * Ѻ���
	 *   Foregift    ��
	 *       payType       ֧����ʽ
	 ****************************************************************************************/
	public static  List<NameValueVO> foregiftPayTypeList = new ArrayList<NameValueVO>();
	
	public static Map<String, String> getForegiftPayTypeMap() {
		return NameValueVO.listToMap(foregiftPayTypeList);
	}
	
	public static Map<String,List<NameValueVO>> getForegiftPayTypeListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("PayTypeList", foregiftPayTypeList);
		return map;
	}
	
	// ��̬��ʼ��
	static {
		// �ͷ� - ����״̬
		merRoomStateList.add(new NameValueVO("Ԥ����","1"));
		merRoomStateList.add(new NameValueVO("��ס��","2"));
		merRoomStateList.add(new NameValueVO("���෿","3"));
		merRoomStateList.add(new NameValueVO("ά�޷�","4"));
		merRoomStateList.add(new NameValueVO("�վ���","5"));
		// ������Ŀ - �������
		merServicesConsumeTypeList.add(new NameValueVO("ϵͳ����","1"));
		merServicesConsumeTypeList.add(new NameValueVO("��Ʒ����","2"));
		merServicesConsumeTypeList.add(new NameValueVO("����",        "3"));
		// �̻��û� - �û�����
		merUserTypeList.add(new NameValueVO("��������Ա","V"));
		merUserTypeList.add(new NameValueVO("һ���û�","N"));
		// �̻��û� - �û�״̬
		merUserStatusList.add(new NameValueVO("����","1"));
		merUserStatusList.add(new NameValueVO("ͣ��","2"));
		merUserStatusList.add(new NameValueVO("����ִ���û����","3"));
		// ƽ̨����- �̻�״̬
		merUserStatusList.add(new NameValueVO("����","1"));
		merUserStatusList.add(new NameValueVO("ͣ��","2"));
		merUserStatusList.add(new NameValueVO("����ִ���û����","3"));
		// �̻���ɫ - ��ɫ����
		merRoleReadwriteList.add(new NameValueVO("ǰ̨�Ӵ�","F01"));
		merRoleReadwriteList.add(new NameValueVO("��ס�Ǽ�","F01" + "01"));
		merRoleReadwriteList.add(new NameValueVO("�ÿ��б�","F01" + "02"));
		merRoleReadwriteList.add(new NameValueVO("���ѹ���","F01" + "03"));
		merRoleReadwriteList.add(new NameValueVO("Ѻ�����","F01" + "04"));
		merRoleReadwriteList.add(new NameValueVO("����",        "F01" + "05"));
		// ��ס�Ǽ� - �Ա�
		checkInSexList.add(new NameValueVO("��","M"));
		checkInSexList.add(new NameValueVO("Ů","F"));
		// ��ס�Ǽ� - ��ס����
		checkInStayTypeList.add(new NameValueVO("���췿","1"));
		checkInStayTypeList.add(new NameValueVO("ȫ�շ�","2"));
		checkInStayTypeList.add(new NameValueVO("�ӵ㷿","3"));
		checkInStayTypeList.add(new NameValueVO("������","4"));
		// ��ס�Ǽ� - ���ʽ
		checkInSettleModeList.add(new NameValueVO("�ֽ�",    "1"));
		checkInSettleModeList.add(new NameValueVO("���ÿ�","2"));
		checkInSettleModeList.add(new NameValueVO("֧Ʊ",    "3"));
		checkInSettleModeList.add(new NameValueVO("��ǿ�","4"));
		checkInSettleModeList.add(new NameValueVO("����ȯ","5"));
		checkInSettleModeList.add(new NameValueVO("POSԤ��Ȩ",    "6"));
		checkInSettleModeList.add(new NameValueVO("Э�鵥λ����","7"));
		checkInSettleModeList.add(new NameValueVO("����","8"));
		// ��ס�Ǽ� - �ÿ����
		checkInCustTypeList.add(new NameValueVO("ɢ��","1"));
		checkInCustTypeList.add(new NameValueVO("����","2"));
		checkInCustTypeList.add(new NameValueVO("��Ա","3"));
		checkInCustTypeList.add(new NameValueVO("����","4"));
		checkInCustTypeList.add(new NameValueVO("Э��","5"));
		// ��ס�Ǽ� - ֤������
		checkInIdTypeList.add(new NameValueVO("���֤","1"));
		checkInIdTypeList.add(new NameValueVO("����֤","2"));
		checkInIdTypeList.add(new NameValueVO("����֤","3"));
		checkInIdTypeList.add(new NameValueVO("��ʻ֤","4"));
		checkInIdTypeList.add(new NameValueVO("����",    "5"));
		checkInIdTypeList.add(new NameValueVO("����",    "6"));
		// ��ס�Ǽ� - ��ס״̬
		checkInStatusList.add(new NameValueVO("��ס",    "1"));
		checkInStatusList.add(new NameValueVO("����",    "2"));
		checkInStatusList.add(new NameValueVO("�ѽ���","3"));
		// Ѻ�� - ֧����ʽ
		foregiftPayTypeList.add(new NameValueVO("�ֽ�",    "1"));
		foregiftPayTypeList.add(new NameValueVO("���ÿ�",    "2"));
		foregiftPayTypeList.add(new NameValueVO("֧Ʊ",    "3"));
		foregiftPayTypeList.add(new NameValueVO("��ǿ�",    "4"));
		foregiftPayTypeList.add(new NameValueVO("����ȯ",    "5"));
		foregiftPayTypeList.add(new NameValueVO("POSԤ��Ȩ",    "6"));
		foregiftPayTypeList.add(new NameValueVO("Э�鵥λ����",    "7"));
		foregiftPayTypeList.add(new NameValueVO("����",    "8"));
		foregiftPayTypeList.add(new NameValueVO("ҹ�����",    "15"));
	}
}
