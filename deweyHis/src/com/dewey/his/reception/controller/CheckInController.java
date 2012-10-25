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
	 * ACTION��ͼ
	 */
	private final String SHOW_ACTION_VIEW = pre_forward + "/checkIn/show"; // ��ϸ��ͼ

	/**
	 * PAGE��ͼ
	 */
	private final String NEW_PAGE_VIEW = "/reception/checkIn/new";      // ����ҳ��
	private final String SHOW_PAGE_VIEW = "/reception/checkIn/show"; // ��ϸҳ��
	private final String SHOW1_PAGE_VIEW = "/reception/checkIn/show1"; // ��ϸҳ��
	private final String EDIT_PAGE_VIEW = "/reception/checkIn/edit";       // �༭ҳ��

	private final String OBJ_MODEL = "checkIn";

	/**
	 * ����
	 */
	private RoomTypeManager roomTypeManager;

	public void setRoomTypeManager(RoomTypeManager roomTypeManager) {
		this.roomTypeManager = roomTypeManager;
	}

	private final String ROOMTYPE_LIST_MODEL = "roomTypeList";

	/**
	 * Э�鵥λ
	 */
	private ContractualUnitManager contractualUnitManager;

	public void setContractualUnitManager(ContractualUnitManager contractualUnitManager) {
		this.contractualUnitManager = contractualUnitManager;
	}

	private final String CONTRACTUALUNIT_LIST_MODEL = "contractualUnitList";
	
	/**
	 *  �̻�����
	 */
	private MerRoomManager merRoomManager;
	
	public void setMerRoomManager(MerRoomManager merRoomManager) {
		this.merRoomManager = merRoomManager;
	}
	
//	/**
//	 * ��ס�ͷ�
//	 */
//	private CustCheckInRoomManager custCheckInRoomManager;
//	
//	public void setCustCheckInRoomManager(CustCheckInRoomManager custCheckInRoomManager) {
//		this.custCheckInRoomManager = custCheckInRoomManager;
//	}
	
//	private final String MER_ROOM_LIST_MODEL = "merRoomList";
//	
//	/**
//	 * �̻�Э�鵥λ������Э���
//	 */
//	private MerContractualRelationManager merContractualRelationManager;
//	
//	public void setMerContractualRelationManager(MerContractualRelationManager merContractualRelationManager) {
//		this.merContractualRelationManager = merContractualRelationManager;
//	}
	
	/**
	 * ����ҳ���ѯ�վ��ͷ��б���Ϣ
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchRoom")
	@ResponseBody
	public void  searchRoom(@RequestParam(value="roomSearchNum",required=false)String roomSearchNum,
			@RequestParam(value="searchRroomTypeId",required=false)Long roomTypeId,
			@RequestParam(value="mer.id",required=true)Long merId,
			@RequestParam(value="contractualUnitId",required=false)Long contractualUnitId,HttpServletResponse response)
			throws JsonGenerationException, JsonMappingException, IOException {
		
		// ����model
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		
		// ���ذ��������Ŀͷ��б���Ϣ
		List<MerRoom> merRooms  = new ArrayList<MerRoom>();
		
		// ���ذ���λ����Ŀͷ���λ�б���Ϣ
		List<RoomBed> beds = new ArrayList<RoomBed>();
		
		// ��ѯ��ʽһ�� ֱ�ӷ���������ѯ
		if (roomSearchNum != null && !"".equals(roomSearchNum.trim())) {
			MerRoom merRoom = merRoomManager.getByRoomNo(merId, roomSearchNum.trim());
			if (merRoom == null  ||  !"5".equals(merRoom.getState())) {     // �ͷ������ڻ��߿ͷ����ǿվ�����
				rtnMap.put("message", "�޸ÿվ�����");
			} else if("1".equals(merRoom.getHireFlag())) {                           // �ÿͷ�����λ��,��ѯ�ͷ��Ŀվ���λ�б�
				beds = merRoomManager.findMerEmptyCleanRoomBeds(merId, roomSearchNum.trim(), null);
				if(beds.isEmpty()) {
					rtnMap.put("message", "�޸ÿվ�����");
				} else {
					rtnMap.put("message", "");
				}
			} else {
				rtnMap.put("message", "");
				merRooms.add(merRoom);
			}
			// ѡ����Э�鵥λ�������
			//if (contractualUnitId != null) {
			//	MerContractualRelation merR = merContractualRelationManager.getContractualRelationByUnitId(contractualUnitId, merRoom.getRoomType().getId()).get(0);
			//}
		}
		// ��ѯ��ʽ���� ͨ�����Ͳ��Ҹ÷����µ����з���
		else if (roomTypeId != null) {
			merRooms = merRoomManager.findMerEmptyCleanRooms(merId, roomTypeId);
			beds = merRoomManager.findMerEmptyCleanRoomBeds(merId, null, roomTypeId);
			if(merRooms.isEmpty() && beds.isEmpty()) {
				rtnMap.put("message", "Ŀǰ���޿վ�����");
			} else {
				rtnMap.put("message", "");
			}
			// ѡ����Э�鵥λ�������
			//if (contractualUnitId != null) {
			//	MerContractualRelation merR = merContractualRelationManager.getContractualRelationByUnitId(contractualUnitId, roomTypeId).get(0);
			//}
		}
		// ���ز�ѯ���Ŀվ����䴲λ�б�
		List<Map> roomBedList  = new ArrayList<Map>();
		// �վ������б�
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
		// �վ���λ�б�
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
		// Jackson JSONֱ��дjson�ַ���
		
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.writeValue(response.getOutputStream(), rtnMap);
		// ��ҳ��дJSON�ַ���
		JsonBinder jsonBinder = new JsonBinder();
		jsonBinder.writeToPage(response.getOutputStream(), rtnMap);
	}
	
	/**
	 * ��������
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
	 * ��������   �����ƿ��Ĳ���
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(HttpServletRequest request, HttpServletResponse response, CheckIn checkIn) {
		MerUser  userinfo = (MerUser) request.getSession(false).getAttribute("MER_USER");
		// ���ֵ����Ա��Ϣ
		checkIn.setMerOnDutyUserId(userinfo.getId());
		checkIn.setMerOnDutyUserName(userinfo.getChineseName());
		// ��ס״̬Ϊ��ס
		checkIn.setStatus("1");
		Long  checkInId = checkInManager.checkInRoomSetDoorCard(checkIn);
		return SHOW_ACTION_VIEW +"/" + checkInId;
	}

	/** 
	 * ��ʾ
	 */
	@RequestMapping(value = "/show/{id}")
	public String show(@PathVariable(value="id") long id, ModelMap model) {
		CheckIn checkIn = checkInManager.getById(id);
		String checkInStatus = checkIn.getStatus();
		// ת��
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
		// ��ס  ����¿����޸����Ѽ�¼�ȵ�
		if ("1".equals(checkInStatus)) {
			return SHOW_PAGE_VIEW;
		}
		// ���ˡ��ѽ��� �����ֻ�ɲ鿴���Ѽ�¼
		return SHOW1_PAGE_VIEW;
	}
	
	/**
	 * ����������ϵǼ���סҳ��
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView checkInEdit(HttpServletRequest request,@PathVariable(value="id") Long id,ModelAndView model) {
		CheckIn checkIn = checkInManager.getById(id);
		// ת��
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
	 * �༭���¿������ϵǼ���ס��Ϣ
	 * @param model
	 * @param checkIn
	 * @return
	 */
	@RequestMapping(value = "/update")
	public ModelAndView checkInUpdate(ModelAndView model,CheckIn checkInPage) {
		CheckIn checkIn = checkInManager.getById(checkInPage.getId());
		// ���²����ֶ���Ϣ
		checkIn.setPhone(checkInPage.getPhone());
		checkIn.setRemark(checkInPage.getRemark());
		checkInManager.update(checkIn);
		// ת���ÿ͵Ǽ���ϸҳ��
		model.setViewName(pre_redirect + "/checkIn/show/"+checkInPage.getId());
		return model;
	}
	
//	/**
//	 * ������ס�ͷ���Ϣ���޸ı�ע
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