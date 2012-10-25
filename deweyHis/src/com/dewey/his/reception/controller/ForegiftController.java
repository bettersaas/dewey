package com.dewey.his.reception.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.model.Foregift;
import com.dewey.his.reception.service.ForegiftManager;
import com.dewey.his.sys.model.MerUser;

import common.base.constant.VOConstantList;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/foregift")
public class ForegiftController extends BaseController<Foregift, Long> {
	
	/**
	 * Ѻ�����
	 */
	private ForegiftManager foregiftManager;

	public void setForegiftManager(ForegiftManager foregiftManager) {
		this.foregiftManager = foregiftManager;
	}
	
	/**
	 * ACTION��ͼ
	 */
	private final String LIST_ACTION_VIEW = pre_redirect  + "/foregift/list/"; // �б���ͼ
	
	/**
	 * PAGE��ͼ
	 */
	private final String LIST_PAGE_VIEW     = "/reception/foregift/list";        // �б�ҳ��
	private final String NEW_PAGE_VIEW    = "/reception/foregift/new";      // ����ҳ��
	private final String EDIT_PAGE_VIEW     = "/reception/foregift/edit";      // �༭ҳ��

	private final String OBJ_MODEL = "foregift";
	private final String LIST_MODEL = "foregiftList";
	
	/**
	 * ����Ѻ���¼�б�ҳ��
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list/{custCheckInRoomId}")
	public ModelAndView foregiftList(HttpServletRequest request, @PathVariable(value="custCheckInRoomId") Long custCheckInRoomId,ModelAndView model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<Foregift> list = foregiftManager.getByCustCheckInRoomId(mer.getId(), custCheckInRoomId);
		for(Foregift foregift:list) {
			// ת��
			Map<String, String> payType = VOConstantList.getForegiftPayTypeMap();
			foregift.setPayType(payType.get(foregift.getPayType()));
		}
		model.addObject(LIST_MODEL, list);
		model.addObject("custCheckInRoomId", custCheckInRoomId);
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}
	
	/**
	 * ����Ѻ���¼����
	 */
	@RequestMapping(value = "/new/{custCheckInRoomId}")
	public String _foregiftNew(@PathVariable(value="custCheckInRoomId") Long custCheckInRoomId, HttpServletRequest request, ModelMap model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		
		CustCheckInRoom custCheckInRoom = new  CustCheckInRoom();
		custCheckInRoom.setId(custCheckInRoomId);
		
		Foregift foregift = new Foregift();
		foregift.setMerId(mer.getId());
		foregift.setCustCheckInRoom(custCheckInRoom);
		model.addAttribute(OBJ_MODEL, foregift);
		model.addAllAttributes(VOConstantList.getForegiftPayTypeListModelMap());
		return NEW_PAGE_VIEW;
	}
	
	/**
	 * ����Ѻ���¼����
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView foregiftCreate(HttpServletRequest request,Foregift foregift,@RequestParam(value="roomNo") String roomNo) {
		MerUser  userinfo = (MerUser) request.getSession(false).getAttribute("MER_USER");
		// ���ֵ����Ա��Ϣ
		foregift.setMerUserId(userinfo.getId());
		foregift.setMerUserName(userinfo.getChineseName());
		foregift.setLcd(new Timestamp(new Date().getTime()));
		foregiftManager.save(foregift);
		return new ModelAndView(LIST_ACTION_VIEW + foregift.getCustCheckInRoom().getId()+ "?roomNo=" + roomNo);
	}
	
	/** 
	 * ����Ѻ���¼�༭
	 */
	@RequestMapping(value = "/edit/{id}")
	public String foregiftEdit(@PathVariable(value="id") int id, HttpServletRequest request,ModelMap model) {
		model.addAttribute(OBJ_MODEL, foregiftManager.getById(id));
		model.addAllAttributes(VOConstantList.getForegiftPayTypeListModelMap());
		return EDIT_PAGE_VIEW;
	}
	
	/** 
	 * ����Ѻ���¼����
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView foregiftUpdate(Foregift foregift,HttpServletRequest request, @RequestParam(value="roomNo")  String roomNo) {
		MerUser  userinfo = (MerUser) request.getSession(false).getAttribute("MER_USER");
		// ���ֵ����Ա��Ϣ
		foregift.setMerUserId(userinfo.getId());
		foregift.setMerUserName(userinfo.getChineseName());
		foregift.setLcd(new Timestamp(new Date().getTime()));
		foregiftManager.update(foregift);
		return new ModelAndView(LIST_ACTION_VIEW + foregift.getCustCheckInRoom().getId() + "?roomNo=" + roomNo);
	}
	
	/** 
	 * Ѻ���¼ɾ��
	 */
	@RequestMapping(value = "/delete/{id}/{custCheckInRoomId}", method = RequestMethod.GET)
	public ModelAndView foregiftDelete(@PathVariable(value="id") Long id,@PathVariable(value="custCheckInRoomId") Long custCheckInRoomId,@RequestParam(value="roomNo")  String roomNo) {
		foregiftManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW + custCheckInRoomId+ "?roomNo=" + roomNo);
	}
}