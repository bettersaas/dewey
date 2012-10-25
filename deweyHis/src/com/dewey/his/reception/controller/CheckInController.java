package com.dewey.his.reception.controller;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.crm.service.ContractualUnitManager;
import com.dewey.his.param.service.RoomTypeManager;
import com.dewey.his.reception.model.CheckIn;
import com.dewey.his.reception.service.CheckInManager;
import com.dewey.his.sys.model.MerRoom;
import com.dewey.his.sys.model.MerUser;
import com.dewey.his.sys.model.RoomBed;
import com.dewey.his.sys.service.MerRoomManager;
import common.base.constant.VOConstantList;
import common.base.controller.BaseController;
import common.util.json.JsonBinder;

@Controller
@RequestMapping("/checkIn")
public class CheckInController extends BaseController<CheckIn, Long> {

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Timestamp.class, new PropertyEditorSupport() {
			public void setAsText(String value) {
				if (value == null || "".equals(value.trim())){
					setValue(null);
					return;
				}
				try {
					String formatStr = null;
					if(value.length()==16) {
						formatStr = "yyyy-MM-dd HH:mm";
					} else if (value.length()==10) {
						formatStr = "yyyy-MM-dd";
					} else {
						formatStr = "yyyy-MM-dd HH:mm:ss";
					}
					Date date = new SimpleDateFormat(formatStr).parse(value);
					setValue(new Timestamp(date.getTime()));
				} catch (java.text.ParseException e) {
					setValue(null);
				}
			}
			public String getAsText() {
				Date value = (Date)getValue();
				return value == null ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);
			}
		});
	}

	private CheckInManager checkInManager;

	public void setCheckInManager(CheckInManager checkInManager) {
		this.checkInManager = checkInManager;
	}

	/**
	 * ACTION视图
	 */
	private final String SHOW_ACTION_VIEW = pre_forward + "/checkIn/show"; // 详细视图

	/**
	 * PAGE视图
	 */
	private final String NEW_PAGE_VIEW = "/reception/checkIn/new";      // 新增页面
	private final String SHOW_PAGE_VIEW = "/reception/checkIn/show"; // 详细页面
	private final String SHOW1_PAGE_VIEW = "/reception/checkIn/show1"; // 详细页面
	private final String EDIT_PAGE_VIEW = "/reception/checkIn/edit";       // 编辑页面

	private final String OBJ_MODEL = "checkIn";

	/**
	 * 房型
	 */
	private RoomTypeManager roomTypeManager;

	public void setRoomTypeManager(RoomTypeManager roomTypeManager) {
		this.roomTypeManager = roomTypeManager;
	}

	private final String ROOMTYPE_LIST_MODEL = "roomTypeList";

	/**
	 * 协议单位
	 */
	private ContractualUnitManager contractualUnitManager;

	public void setContractualUnitManager(ContractualUnitManager contractualUnitManager) {
		this.contractualUnitManager = contractualUnitManager;
	}

	private final String CONTRACTUALUNIT_LIST_MODEL = "contractualUnitList";
	
	/**
	 *  商户房间
	 */
	private MerRoomManager merRoomManager;
	
	public void setMerRoomManager(MerRoomManager merRoomManager) {
		this.merRoomManager = merRoomManager;
	}
	
//	/**
//	 * 入住客房
//	 */
//	private CustCheckInRoomManager custCheckInRoomManager;
//	
//	public void setCustCheckInRoomManager(CustCheckInRoomManager custCheckInRoomManager) {
//		this.custCheckInRoomManager = custCheckInRoomManager;
//	}
	
//	private final String MER_ROOM_LIST_MODEL = "merRoomList";
//	
//	/**
//	 * 商户协议单位关联的协议价
//	 */
//	private MerContractualRelationManager merContractualRelationManager;
//	
//	public void setMerContractualRelationManager(MerContractualRelationManager merContractualRelationManager) {
//		this.merContractualRelationManager = merContractualRelationManager;
//	}
	
	/**
	 * 新增页面查询空净客房列表信息
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchRoom")
	@ResponseBody
	public void  searchRoom(@RequestParam(value="roomSearchNum",required=false)String roomSearchNum,
			@RequestParam(value="searchRroomTypeId",required=false)Long roomTypeId,
			@RequestParam(value="mer.id",required=true)Long merId,
			@RequestParam(value="contractualUnitId",required=false)Long contractualUnitId,HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		
		// 返回model
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		// 返回按房间出租的客房列表信息
		List<MerRoom> merRooms  = new ArrayList<MerRoom>();
		
		// 返回按床位出租的客房床位列表信息
		List<RoomBed> beds = new ArrayList<RoomBed>();
		
		// 查询方式一： 直接房号搜索查询
		if (roomSearchNum != null && !"".equals(roomSearchNum.trim())) {
			MerRoom merRoom = merRoomManager.getByRoomNo(merId, roomSearchNum.trim());
			if (merRoom == null  ||  !"5".equals(merRoom.getState())) {     // 客房不存在或者客房不是空净房间
				rtnMap.put("message", "无该空净房！");
			} else if("1".equals(merRoom.getHireFlag())) {                           // 该客房按床位出,查询客房的空净床位列表
				beds = merRoomManager.findMerEmptyCleanRoomBeds(merId, roomSearchNum.trim(), null);
				if(beds.isEmpty()) {
					rtnMap.put("message", "无该空净房！");
				} else {
					rtnMap.put("message", "");
				}
			} else {
				rtnMap.put("message", "");
				merRooms.add(merRoom);
			}
			// 选择了协议单位的情况下
			//if (contractualUnitId != null) {
			//	MerContractualRelation merR = merContractualRelationManager.getContractualRelationByUnitId(contractualUnitId, merRoom.getRoomType().getId()).get(0);
			//}
		}
		// 查询方式二： 通过房型查找该房型下的所有房间
		else if (roomTypeId != null) {
			merRooms = merRoomManager.findMerEmptyCleanRooms(merId, roomTypeId);
			beds = merRoomManager.findMerEmptyCleanRoomBeds(merId, null, roomTypeId);
			if(merRooms.isEmpty() && beds.isEmpty()) {
				rtnMap.put("message", "目前暂无空净房！");
			} else {
				rtnMap.put("message", "");
			}
			// 选择了协议单位的情况下
			//if (contractualUnitId != null) {
			//	MerContractualRelation merR = merContractualRelationManager.getContractualRelationByUnitId(contractualUnitId, roomTypeId).get(0);
			//}
		}
		// 返回查询到的空净房间床位列表
		List<Map> roomBedList  = new ArrayList<Map>();
		// 空净房间列表
		if (!merRooms.isEmpty()) {
			for (MerRoom  merRoom:merRooms) {
				Map<String, Object> roomBean = new HashMap<String, Object>();
				roomBean.put("roomId", merRoom.getId());
				roomBean.put("roomNo", merRoom.getRoomNo());
				roomBean.put("bedId", "");
				roomBean.put("bedNo", "");
				roomBean.put("roomTypeId", merRoom.getRoomType().getId());
				roomBean.put("roomTypeName", merRoom.getRoomType().getName());
				roomBean.put("alldayPrice", merRoom.getAlldayPrice());
				roomBean.put("halfdayPrice", merRoom.getHalfdayPrice());
				roomBean.put("hourMeasure", merRoom.getHourMeasure());
				roomBean.put("hourPrice", merRoom.getHourPrice());
				roomBean.put("hireFlag", merRoom.getHireFlag());
				roomBean.put("roomDesc", merRoom.getRoomDesc());
				roomBedList.add(roomBean);
			}
		}
		// 空净床位列表
		if (!beds.isEmpty()) {
			for (RoomBed bed:beds) {
				Map<String, Object> bedBean = new HashMap<String, Object>();
				bedBean.put("roomId", bed.getMerRoom().getId());
				bedBean.put("roomNo", bed.getMerRoom().getRoomNo());
				bedBean.put("bedId", bed.getId());
				bedBean.put("bedNo", bed.getBedNo());
				bedBean.put("roomTypeId", bed.getMerRoom().getRoomType().getId());
				bedBean.put("roomTypeName", bed.getMerRoom().getRoomType().getName());
				bedBean.put("alldayPrice", bed.getAlldayPrice());
				bedBean.put("halfdayPrice", bed.getHalfdayPrice());
				bedBean.put("hourMeasure", bed.getHourMeasure());
				bedBean.put("hourPrice", bed.getHourPrice());
				bedBean.put("hireFlag", bed.getMerRoom().getHireFlag());
				bedBean.put("roomDesc", bed.getMerRoom().getRoomDesc());
				roomBedList.add(bedBean);
			}
		}
		rtnMap.put("merRooms", roomBedList);
		// Jackson JSON直接写json字符串
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.writeValue(response.getOutputStream(), rtnMap);
		// 给页面写JSON字符串
		JsonBinder jsonBinder = new JsonBinder();
		jsonBinder.writeToPage(response.getOutputStream(), rtnMap);
	}
	
	/**
	 * 进入新增
	 */
	@RequestMapping(value = "/new")
	public String _new(HttpServletRequest request, ModelMap model) {
		model.addAllAttributes(VOConstantList.getCheckInSexListModelMap());
		model.addAllAttributes(VOConstantList.getCheckInIdTypeListModelMap());
		model.addAllAttributes(VOConstantList.getCheckInStayTypeListModelMap());
		model.addAllAttributes(VOConstantList.getCheckInSettleModeListModelMap());
		model.addAllAttributes(VOConstantList.getCheckInCustTypeListModelMap());
		model.addAllAttributes(VOConstantList.getCheckInStatusListModelMap());
		Mer mer = (Mer) request.getSession(false).getAttribute("MER");
		model.addAttribute(ROOMTYPE_LIST_MODEL, roomTypeManager.findMerAllRoomType(mer.getId()));
		model.addAttribute(CONTRACTUALUNIT_LIST_MODEL, contractualUnitManager.findMerAllContractualUnit(mer.getId()));
		//model.addAttribute(MER_ROOM_LIST_MODEL, merRoomManager.findMerAllEmptyCleanRooms(mer.getId(), null));  //<c:set var="merRoomList" value="${merRoomList}"  scope="page"/>
		CheckIn checkIn = new CheckIn();
		checkIn.setMer(mer);
		//checkIn.setBillNo("A0509160001");
		model.addAttribute(OBJ_MODEL, checkIn);
		return NEW_PAGE_VIEW;
	}

	/**
	 * 保存新增   订房制卡的操作
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(HttpServletRequest request, HttpServletResponse response, CheckIn checkIn) {
		MerUser  userinfo = (MerUser) request.getSession(false).getAttribute("MER_USER");
		// 填充值班人员信息
		checkIn.setMerOnDutyUserId(userinfo.getId());
		checkIn.setMerOnDutyUserName(userinfo.getChineseName());
		// 入住状态为在住
		checkIn.setStatus("1");
		Long  checkInId = checkInManager.checkInRoomSetDoorCard(checkIn);
		return SHOW_ACTION_VIEW +"/" + checkInId;
	}

	/** 
	 * 显示
	 */
	@RequestMapping(value = "/show/{id}")
	public String show(@PathVariable(value="id") long id, ModelMap model) {
		CheckIn checkIn = checkInManager.getById(id);
		String checkInStatus = checkIn.getStatus();
		// 转码
		Map<String, String> sex = VOConstantList.getCheckInSexMap();
		checkIn.setSex(sex.get(checkIn.getSex()));
		Map<String, String> idType = VOConstantList.getCheckInIdTypeMap();
		checkIn.setIdType(idType.get(checkIn.getIdType()));
		Map<String, String> stayType = VOConstantList.getCheckInStayTypeMap();
		checkIn.setStayType(stayType.get(checkIn.getStayType()));
		Map<String, String> settleModel = VOConstantList.getCheckInSettleModeMap();
		checkIn.setSettleMode(settleModel.get(checkIn.getSettleMode()));
		Map<String, String> custType = VOConstantList.getCheckInCustTypeMap();
		checkIn.setCustType(custType.get(checkIn.getCustType()));
		Map<String, String> status = VOConstantList.getCheckInStatusMap();
		checkIn.setStatus(status.get(checkIn.getStatus()));
		model.addAttribute(OBJ_MODEL, checkIn);
		// 在住  情况下可以修改消费记录等等
		if ("1".equals(checkInStatus)) {
			return SHOW_PAGE_VIEW;
		}
		// 挂账、已结账 情况下只可查看消费记录
		return SHOW1_PAGE_VIEW;
	}
	
	/**
	 * 进入客人资料登记入住页面
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView checkInEdit(HttpServletRequest request,@PathVariable(value="id") Long id,ModelAndView model) {
		CheckIn checkIn = checkInManager.getById(id);
		// 转码
		Map<String, String> sex = VOConstantList.getCheckInSexMap();
		checkIn.setSex(sex.get(checkIn.getSex()));
		Map<String, String> idType = VOConstantList.getCheckInIdTypeMap();
		checkIn.setIdType(idType.get(checkIn.getIdType()));
		Map<String, String> stayType = VOConstantList.getCheckInStayTypeMap();
		checkIn.setStayType(stayType.get(checkIn.getStayType()));
		Map<String, String> settleModel = VOConstantList.getCheckInSettleModeMap();
		checkIn.setSettleMode(settleModel.get(checkIn.getSettleMode()));
		Map<String, String> custType = VOConstantList.getCheckInCustTypeMap();
		checkIn.setCustType(custType.get(checkIn.getCustType()));
		Map<String, String> status = VOConstantList.getCheckInStatusMap();
		checkIn.setStatus(status.get(checkIn.getStatus()));
		model.addObject(OBJ_MODEL, checkIn);
		model.setViewName(EDIT_PAGE_VIEW);
		return model;
	}
	
	/**
	 * 编辑更新客人资料登记入住信息
	 * @param model
	 * @param checkIn
	 * @return
	 */
	@RequestMapping(value = "/update")
	public ModelAndView checkInUpdate(ModelAndView model,CheckIn checkInPage) {
		CheckIn checkIn = checkInManager.getById(checkInPage.getId());
		// 更新部分字段信息
		checkIn.setPhone(checkInPage.getPhone());
		checkIn.setRemark(checkInPage.getRemark());
		checkInManager.update(checkIn);
		// 转到旅客登记详细页面
		model.setViewName(pre_redirect + "/checkIn/show/"+checkInPage.getId());
		return model;
	}
	
//	/**
//	 * 更新入住客房信息，修改备注
//	 * @param model
//	 * @param checkInId
//	 * @param custCheckInRoomId
//	 * @param custCheckInRoomRemark
//	 * @return
//	 */
//	@RequestMapping(value = "/updateCustCheckInRoom")
//	public ModelAndView updateCustCheckInRoom(ModelAndView model,Long checkInId, Long custCheckInRoomId, String custCheckInRoomRemark) {
//		CustCheckInRoom custCheckInRoom = custCheckInRoomManager.getById(custCheckInRoomId);
//		custCheckInRoom.setRemark(custCheckInRoomRemark);
//		custCheckInRoomManager.update(custCheckInRoom);
//		model.setViewName(pre_forward + "/checkIn/show/" + checkInId);
//		return model;
//	}
}