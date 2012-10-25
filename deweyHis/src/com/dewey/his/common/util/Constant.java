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
	 * 登录动作:   0:登录失败 1:登录成功 2:退出
	 */
	public static final String USER_LOGIN_INFO_ACTION_FAILURE   = "0";
	public static final String USER_LOGIN_INFO_ACTION_SUCCESS = "1";
	public static final String USER_LOGIN_INFO_ACTION_QUIT           = "2";

	/**
	 * JSON工具类
	 */
	private static JsonBinder binder ;

	/**
	 * 有层级关系的下拉列表tree
	 */
	private static FunctionVO functionsTreeConstant ;

	/**
	 * 有Id 和功能对象的映射
	 */
	private static Map<String, FunctionVO> functionsMapConstant ;

	static {
		binder = JsonBinder.buildNonDefaultBinder();
		functionsMapConstant = createNewFunctionsMapConstant();
		// 剔除url - Map删除对象
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
	 * 动态数组生成下级功能列表
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
	 * 生成新的功能树
	 * @return
	 */
	public static Map<String, FunctionVO> createNewFunctionsMapConstant() {
		// 功能映射对象
		Map<String, FunctionVO> functionsMapConstant = new HashMap<String, FunctionVO>();

		/**
		 * 系统功能对象
		 */
		// 前台接待
		FunctionVO FM0101 = new FunctionVO("FM0101", "入住登记", "0", "FM01", "/checkIn/new", true, true, null);
		FunctionVO FM0102 = new FunctionVO("FM0102", "旅客列表", "0", "FM01", "/guestList/query", true, true, null);
		FunctionVO FM01 = new FunctionVO("FM01", "前台接待", "0", "FM", "", false, false, createFunctionVOList(FM0101,FM0102));
		functionsMapConstant.put(FM0101.getId(), FM0101);
		functionsMapConstant.put(FM0102.getId(), FM0102);
		functionsMapConstant.put(FM01.getId(), FM01);
		// 前台收银
		FunctionVO FM0201 = new FunctionVO("FM0201", "合并账单", "0", "FM02", "", false, true, null);
		FunctionVO FM0202 = new FunctionVO("FM0202", "拆分账单", "0", "FM02", "", false, true, null);
		FunctionVO FM0203 = new FunctionVO("FM0203", "结账退房", "0", "FM02", "", false, true, null);
		FunctionVO FM0204 = new FunctionVO("FM0204", "账单列表", "0", "FM02", "", false, true, null);
		FunctionVO FM02 = new FunctionVO("FM02", "前台收银", "0", "FM", "", false, false,  createFunctionVOList(FM0201, FM0202, FM0203,FM0204));
		functionsMapConstant.put(FM0201.getId(), FM0201);
		functionsMapConstant.put(FM0202.getId(), FM0202);
		functionsMapConstant.put(FM0203.getId(), FM0203);
		functionsMapConstant.put(FM0204.getId(), FM0204);
		functionsMapConstant.put(FM02.getId(), FM02);
		// 预订管理
		FunctionVO FM0301 = new FunctionVO("FM0301", "房间预订", "0", "FM03", "/reserve/new", false, true, null);
		FunctionVO FM0302 = new FunctionVO("FM0302", "预订列表", "0", "FM03", "/reserveList/query", false, true, null);
		FunctionVO FM03 = new FunctionVO("FM03", "预订管理", "0", "FM", "",  false, false, createFunctionVOList(FM0301, FM0302));
		functionsMapConstant.put(FM0301.getId(), FM0301);
		functionsMapConstant.put(FM0302.getId(), FM0302);
		functionsMapConstant.put(FM03.getId(), FM03);
		// 客房管理
		//FunctionVO FM0401 = new FunctionVO("FM0401", "房态展示", "0", "FM04", "", false, true, null);
		FunctionVO FM0402 = new FunctionVO("FM0402", "客房列表", "0", "FM04", "/merRoom/query", false, true, null);
		FunctionVO FM04 = new FunctionVO("FM04", "客房管理", "0", "FM", "",  false, false, createFunctionVOList(FM0402));
		//functionsMapConstant.put(FM0401.getId(), FM0401);
		functionsMapConstant.put(FM0402.getId(), FM0402);
		functionsMapConstant.put(FM04.getId(), FM04);
		/* 现金管理
		FunctionVO FM0501 = new FunctionVO("FM0501", "交班",         "0", "FM05", "", false, true, null);
		FunctionVO FM0502 = new FunctionVO("FM0502", "交班历史", "0", "FM05", "", false, true, null);
		FunctionVO FM0503 = new FunctionVO("FM0503", "回款计划", "0", "FM05", "", false, true, null);
		FunctionVO FM05 = new FunctionVO("FM05", "现金管理", "0", "FM", "",  false, false, createFunctionVOList(FM0501, FM0502, FM0503));
		functionsMapConstant.put(FM0501.getId(), FM0501);
		functionsMapConstant.put(FM0502.getId(), FM0502);
		functionsMapConstant.put(FM0503.getId(), FM0503);
		functionsMapConstant.put(FM05.getId(), FM05);
		*/
		/* 查询
		FunctionVO FM0601 = new FunctionVO("FM0601", "收款管理", "0", "FM06", "", false, true, null);
		FunctionVO FM0602 = new FunctionVO("FM0602", "付款管理", "0", "FM06", "", false, true, null);
		FunctionVO FM0603 = new FunctionVO("FM0603", "帐户查询", "0", "FM06", "", false, true, null);
		FunctionVO FM06 = new FunctionVO("FM06", "查询", "0", "FM", "",  false, false, createFunctionVOList(FM0601, FM0602, FM0603));
		functionsMapConstant.put(FM0601.getId(), FM0601);
		functionsMapConstant.put(FM0602.getId(), FM0602);
		functionsMapConstant.put(FM0603.getId(), FM0603);
		functionsMapConstant.put(FM06.getId(), FM06);
		*/
		// 客户关系管理
		FunctionVO FM0701 = new FunctionVO("FM0701", "协议单位管理", "0", "FM07", "/contractualUnit/list", true, true, null);
		FunctionVO FM07 = new FunctionVO("FM07", "客户关系管理", "0", "FM", "", false, false, createFunctionVOList(FM0701));
		functionsMapConstant.put(FM0701.getId(), FM0701);
		functionsMapConstant.put(FM07.getId(), FM07);
		// 报表中心
		FunctionVO FM0801 = new FunctionVO("FM0801", "营业日报", "0", "FM08", "", false, true, null);
		FunctionVO FM0802 = new FunctionVO("FM0802", "营业汇总", "0", "FM08", "", false, true, null);
		FunctionVO FM0803 = new FunctionVO("FM0803", "营业月报", "0", "FM08", "", false, true, null);
		FunctionVO FM08 = new FunctionVO("FM08", "报表中心", "0", "FM", "",  false, false, createFunctionVOList(FM0801, FM0802, FM0803));
		functionsMapConstant.put(FM0801.getId(), FM0801);
		functionsMapConstant.put(FM0802.getId(), FM0802);
		functionsMapConstant.put(FM0803.getId(), FM0803);
		functionsMapConstant.put(FM08.getId(), FM08);
		/* 接口管理
		FunctionVO FM0901 = new FunctionVO("FM0901", "电话计费管理", "0", "FM09", "", false, true, null);
		FunctionVO FM0902 = new FunctionVO("FM0902", "电子门锁管理", "0", "FM09", "", false, true, null);
		FunctionVO FM09 = new FunctionVO("FM09", "接口管理", "0", "FM", "",  false, false, createFunctionVOList(FM0901, FM0902));
		functionsMapConstant.put(FM0901.getId(), FM0901);
		functionsMapConstant.put(FM0902.getId(), FM0902);
		functionsMapConstant.put(FM09.getId(), FM09);
		*/
		// 参数维护
		FunctionVO FM1001 = new FunctionVO("FM1001", "房型设置",         "0", "FM10", "/roomType/list",                 false, true, null);
		FunctionVO FM1002 = new FunctionVO("FM1002", "酒店信息设置", "0", "FM10", "/hotelInfoSetting/edit",      false, true, null);
		FunctionVO FM1003 = new FunctionVO("FM1003", "计费设置",         "0", "FM10", "/chargeRuleSetting/edit", false, true, null);
		FunctionVO FM10 = new FunctionVO("FM10", "参数维护", "0", "FM", "",  false, false, createFunctionVOList(FM1001, FM1002, FM1003));
		functionsMapConstant.put(FM1001.getId(), FM1001);
		functionsMapConstant.put(FM1002.getId(), FM1002);
		functionsMapConstant.put(FM1003.getId(), FM1003);
		functionsMapConstant.put(FM10.getId(), FM10);
		// 系统管理
		//FunctionVO FM1101 = new FunctionVO("FM1101", "房间维护",         "0", "FM11", "/merRoom/query",      false, true, null);
		FunctionVO FM1102 = new FunctionVO("FM1102", "消费项目维护", "0", "FM11", "/merServices/query", false, true, null);
		FunctionVO FM1103 = new FunctionVO("FM1103", "用户维护",         "0", "FM11", "/merUser/list",             false, true, null);
		FunctionVO FM1104 = new FunctionVO("FM1104", "角色维护",         "0", "FM11", "/merRole/list",             false, true, null);
		FunctionVO FM1105 = new FunctionVO("FM1105", "注册信息维护", "0", "FM11", "",                                  false, true, null);
		FunctionVO FM1106 = new FunctionVO("FM1106", "日志查询",         "0", "FM11", "",                                  false, true, null);
		FunctionVO FM11 = new FunctionVO("FM11", "系统管理", "0", "FM", "",  false, false, createFunctionVOList(FM1102, FM1103, FM1104, FM1105, FM1106));
		//functionsMapConstant.put(FM1101.getId(), FM1101);
		functionsMapConstant.put(FM1102.getId(), FM1102);
		functionsMapConstant.put(FM1103.getId(), FM1103);
		functionsMapConstant.put(FM1104.getId(), FM1104);
		functionsMapConstant.put(FM1105.getId(), FM1105);
		functionsMapConstant.put(FM1106.getId(), FM1106);
		functionsMapConstant.put(FM11.getId(), FM11);

		/**
		 * 系统功能菜单树的构建 unctionsTreeConstant
		 */
		//FunctionVO FM = new FunctionVO("FM", "功能菜单显示树", "0", "-1", "",  false, false, createFunctionVOList(FM01, FM02, FM03, FM04, FM05, FM06, FM07, FM08, FM09, FM10, FM11));
		FunctionVO FM = new FunctionVO("FM", "功能菜单显示树", "0", "-1", "",  false, false, createFunctionVOList(FM01, FM02, FM03, FM04, FM07, FM08, FM10, FM11));
		functionsMapConstant.put(FM.getId(), FM);
		return functionsMapConstant;
	}

	/**
	 * 将树形结构的功能菜单以Json字串返回
	 * @return
	 */
	public static String getFunctionsTreeConstantJson() {
		return binder.toJson(functionsTreeConstant);
	}

	/**
	 * 将树形结构的功能菜单以好看的Json字串返回
	 * @return
	 */
	public static String getPrettyPrintFunsTreeConstantJson() {
		return binder.toPrettyPrintingJson(functionsTreeConstant);
	}
	
	/**
	 * 获得快捷菜单的节点映射列表
	 * @param functionsMap
	 * @return
	 */
	public static List<FunctionVO> getQuickMenuFunctionsMap(Map<String, FunctionVO> functionsMap) {
		// 功能映射对象
		List<FunctionVO> quickMenuFunsList = new ArrayList<FunctionVO>();
		Iterator<Entry<String, FunctionVO>> it = functionsMap.entrySet().iterator();
		while (it.hasNext()) {
			 Entry<String, FunctionVO> entry = it.next();
			 // Key
		     // String  key = entry.getKey();
		     // Value
		     FunctionVO  value = entry.getValue();
		     // 创建快捷菜单
		     if (value != null && value.isLeaf() && value.isQuickMenu()) {
		    	 quickMenuFunsList.add(value);
		     }
		 }
		 Collections.sort(quickMenuFunsList, new FunctionVOSort());
		return quickMenuFunsList;
	}
	
	/**
	 * 剔除用户权限树上没有权限的子节点
	 * @param functionsMap
	 */
	public static void removeNoCheckedFunctionsMap(Map<String, FunctionVO> functionsMap) {
		// 删除掉没有的选择的功能
		Iterator<Entry<String, FunctionVO>> it = functionsMap.entrySet().iterator();
		 while (it.hasNext()) {
			 Entry<String, FunctionVO> entry = it.next();
			 // Key
		     //String  key = entry.getKey();
		     // Value
		     FunctionVO  value = entry.getValue();
		     // 没有选择的删除掉
		     if ("0".equals(value.getChecked())) {
		    	 it.remove();
		     } else {
			     // 子级菜单的删除
			     List<FunctionVO> list = value.getChildren();
			     if(list != null && !list.isEmpty()) {
			    	 // list倒叙删除对象
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
