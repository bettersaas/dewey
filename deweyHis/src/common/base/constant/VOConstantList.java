package common.base.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.base.model.vo.NameValueVO;

/**
 * 系统常量池中，主要返回列的值域列表、映射、页面的ModelMap对象。
 * 其中： ModelMap对象中的属性名一致表示为 属性名+List 其中属性名首字母大写，这样标示为常量。
 * @author Administrator
 */
public class VOConstantList {
	
	/****************************************************************************************
	 * 客房
	 *   MerRoom    类
	 * 	       state    房间状态   房间状态(1：预订房2：在住房3：空脏房4：维修房5：空净房)
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
	 * 消费项目
	 *   MerServices    类
	 * 	       consumeType    消费类别
	 ****************************************************************************************/
	public static  List<NameValueVO> merServicesConsumeTypeList = new ArrayList<NameValueVO>();
	
	/**
	 * 得到消费映射
	 *   转码为名字使用：   
		Map<String, String> map = VOConstant.getConsumeTypeMap();
		for(MerServices merServices : merServicesList ) {
			merServices.setConsumeType(map.get(merServices.getConsumeType()));
		}
	 */
	public static Map<String, String> getMerServicesConsumeTypeMap() {
		return NameValueVO.listToMap(merServicesConsumeTypeList);
	}
	
	/**
	 * 得到页面的model属性映射
	 *   使用：   model.addAllAttributes(VOConstant.getConsumeTypeListModelMap());
	 */
	public static Map<String,List<NameValueVO>> getMerServicesConsumeTypeListModelMap() {
		Map<String,List<NameValueVO>> map = new HashMap<String, List<NameValueVO>>();
		map.put("ConsumeTypeList", merServicesConsumeTypeList);
		return map;
	}
	
	/****************************************************************************************
	 * 商户用户
	 * MerUser    类
	 *         type           用户类型
	 *         status        用户状态
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
	 * 商户状态
	 * Mer    类
	 *         status        商户状态
	****************************************************************************************/
	public static  List<NameValueVO> merStatusList = new ArrayList<NameValueVO>();
	
	public static Map<String, String> getMerStatusMap() {
		return NameValueVO.listToMap(merStatusList);
	}
	/****************************************************************************************
	 * 商户角色
	 *   MerRole    类
	 * 	       readwrite    角色功能
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
	 * 入住登记表
	 *   CheckIn    类
	 * 	      sex                     性别
	 *       idType               证件类型
	 *       stayType           入住类型
	 *       settleMode       付款方式
	 *       custType           旅客类别
	 *       status                入住状态
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
	 * 押金表
	 *   Foregift    类
	 *       payType       支付方式
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
	
	// 静态初始化
	static {
		// 客房 - 房间状态
		merRoomStateList.add(new NameValueVO("预订房","1"));
		merRoomStateList.add(new NameValueVO("在住房","2"));
		merRoomStateList.add(new NameValueVO("空脏房","3"));
		merRoomStateList.add(new NameValueVO("维修房","4"));
		merRoomStateList.add(new NameValueVO("空净房","5"));
		// 消费项目 - 消费类别
		merServicesConsumeTypeList.add(new NameValueVO("系统服务","1"));
		merServicesConsumeTypeList.add(new NameValueVO("用品消费","2"));
		merServicesConsumeTypeList.add(new NameValueVO("其他",        "3"));
		// 商户用户 - 用户类型
		merUserTypeList.add(new NameValueVO("超级管理员","V"));
		merUserTypeList.add(new NameValueVO("一般用户","N"));
		// 商户用户 - 用户状态
		merUserStatusList.add(new NameValueVO("启用","1"));
		merUserStatusList.add(new NameValueVO("停用","2"));
		merUserStatusList.add(new NameValueVO("正在执行用户审核","3"));
		// 平台管理- 商户状态
		merUserStatusList.add(new NameValueVO("启用","1"));
		merUserStatusList.add(new NameValueVO("停用","2"));
		merUserStatusList.add(new NameValueVO("正在执行用户审核","3"));
		// 商户角色 - 角色功能
		merRoleReadwriteList.add(new NameValueVO("前台接待","F01"));
		merRoleReadwriteList.add(new NameValueVO("入住登记","F01" + "01"));
		merRoleReadwriteList.add(new NameValueVO("旅客列表","F01" + "02"));
		merRoleReadwriteList.add(new NameValueVO("消费管理","F01" + "03"));
		merRoleReadwriteList.add(new NameValueVO("押金管理","F01" + "04"));
		merRoleReadwriteList.add(new NameValueVO("换房",        "F01" + "05"));
		// 入住登记 - 性别
		checkInSexList.add(new NameValueVO("男","M"));
		checkInSexList.add(new NameValueVO("女","F"));
		// 入住登记 - 入住类型
		checkInStayTypeList.add(new NameValueVO("半天房","1"));
		checkInStayTypeList.add(new NameValueVO("全日房","2"));
		checkInStayTypeList.add(new NameValueVO("钟点房","3"));
		checkInStayTypeList.add(new NameValueVO("长包房","4"));
		// 入住登记 - 付款方式
		checkInSettleModeList.add(new NameValueVO("现金",    "1"));
		checkInSettleModeList.add(new NameValueVO("信用卡","2"));
		checkInSettleModeList.add(new NameValueVO("支票",    "3"));
		checkInSettleModeList.add(new NameValueVO("借记卡","4"));
		checkInSettleModeList.add(new NameValueVO("代金券","5"));
		checkInSettleModeList.add(new NameValueVO("POS预授权",    "6"));
		checkInSettleModeList.add(new NameValueVO("协议单位挂账","7"));
		checkInSettleModeList.add(new NameValueVO("其他","8"));
		// 入住登记 - 旅客类别
		checkInCustTypeList.add(new NameValueVO("散客","1"));
		checkInCustTypeList.add(new NameValueVO("团体","2"));
		checkInCustTypeList.add(new NameValueVO("会员","3"));
		checkInCustTypeList.add(new NameValueVO("会议","4"));
		checkInCustTypeList.add(new NameValueVO("协议","5"));
		// 入住登记 - 证件类型
		checkInIdTypeList.add(new NameValueVO("身份证","1"));
		checkInIdTypeList.add(new NameValueVO("军官证","2"));
		checkInIdTypeList.add(new NameValueVO("警官证","3"));
		checkInIdTypeList.add(new NameValueVO("驾驶证","4"));
		checkInIdTypeList.add(new NameValueVO("护照",    "5"));
		checkInIdTypeList.add(new NameValueVO("其他",    "6"));
		// 入住登记 - 入住状态
		checkInStatusList.add(new NameValueVO("在住",    "1"));
		checkInStatusList.add(new NameValueVO("挂账",    "2"));
		checkInStatusList.add(new NameValueVO("已结账","3"));
		// 押金 - 支付方式
		foregiftPayTypeList.add(new NameValueVO("现金",    "1"));
		foregiftPayTypeList.add(new NameValueVO("信用卡",    "2"));
		foregiftPayTypeList.add(new NameValueVO("支票",    "3"));
		foregiftPayTypeList.add(new NameValueVO("借记卡",    "4"));
		foregiftPayTypeList.add(new NameValueVO("代金券",    "5"));
		foregiftPayTypeList.add(new NameValueVO("POS预授权",    "6"));
		foregiftPayTypeList.add(new NameValueVO("协议单位挂账",    "7"));
		foregiftPayTypeList.add(new NameValueVO("其他",    "8"));
		foregiftPayTypeList.add(new NameValueVO("夜审过账",    "15"));
	}
}
