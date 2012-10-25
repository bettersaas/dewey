package com.dewey.his.reception.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.reception.model.CustCheckInConsume;
import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.service.CustCheckInConsumeManager;
import com.dewey.his.sys.model.MerServices;
import com.dewey.his.sys.service.MerServicesManager;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/custCheckInConsume")
public class CustCheckInConsumeController extends BaseController<CustCheckInConsumeController, Long> {
	
	/**
	 * ���Ѽ�¼
	 */
	private CustCheckInConsumeManager custCheckInConsumeManager;
	
	public void setCustCheckInConsumeManager(CustCheckInConsumeManager custCheckInConsumeManager) {
		this.custCheckInConsumeManager = custCheckInConsumeManager;
	}
	
	private MerServicesManager merServicesManager;
	
	public void setMerServicesManager(MerServicesManager merServicesManager) {
		this.merServicesManager = merServicesManager;
	}
	
	/**
	 * ACTION��ͼ
	 */
	private final String LIST_ACTION_VIEW = pre_redirect  + "/custCheckInConsume/list/"; // �б���ͼ

	/**
	 * PAGE��ͼ
	 */
	private final String LIST_PAGE_VIEW     = "/reception/custCheckInConsume/list";        // �б�ҳ��
	private final String NEW_PAGE_VIEW    = "/reception/custCheckInConsume/new";      // ����ҳ��
	private final String EDIT_PAGE_VIEW     = "/reception/custCheckInConsume/edit";      // �༭ҳ��

	private final String OBJ_MODEL = "custCheckInConsume";
	private final String LIST_MODEL = "custCheckInConsumeList";

	/**
	 * �������Ѽ�¼�б�ҳ��
	 * @param request
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list/{custCheckInRoomId}")
	public ModelAndView custCheckInConsumeList(HttpServletRequest request, @PathVariable(value="custCheckInRoomId") Long custCheckInRoomId,ModelAndView model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<CustCheckInConsume> list = custCheckInConsumeManager.getByCustCheckInRoomId(mer.getId(), custCheckInRoomId);
		model.addObject(LIST_MODEL, list);
		model.addObject("custCheckInRoomId", custCheckInRoomId);
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}
	
	/**
	 * �������Ѽ�¼����
	 */
	@RequestMapping(value = "/new/{custCheckInRoomId}")
	public String _custCheckInConsumeNew(@PathVariable(value="custCheckInRoomId") Long custCheckInRoomId, HttpServletRequest request, ModelMap model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<MerServices> merServicesList = merServicesManager.findMerAllMerServices(mer.getId());
		CustCheckInRoom custCheckInRoom = new CustCheckInRoom();
		custCheckInRoom.setId(custCheckInRoomId);
		CustCheckInConsume custCheckInConsume = new  CustCheckInConsume();
		custCheckInConsume.setMerId(mer.getId());
		custCheckInConsume.setCustCheckInRoom(custCheckInRoom);
		model.addAttribute("merServicesList", merServicesList);
		model.addAttribute(OBJ_MODEL, custCheckInConsume);
		return NEW_PAGE_VIEW;
	}
	
	/**
	 * �������Ѽ�¼����
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView custCheckInConsumeCreate(CustCheckInConsume custCheckInConsume,@RequestParam(value="roomNo")String roomNo) {
		custCheckInConsumeManager.save(custCheckInConsume);
		return new ModelAndView(LIST_ACTION_VIEW + custCheckInConsume.getCustCheckInRoom().getId() + "?roomNo=" + roomNo);
	}
	
	/** 
	 * �������Ѽ�¼�༭
	 */
	@RequestMapping(value = "/edit/{id}")
	public String custCheckInConsumeEdit(@PathVariable(value="id") int id, HttpServletRequest request,ModelMap model) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<MerServices> merServicesList = merServicesManager.findMerAllMerServices(mer.getId());
		model.addAttribute("merServicesList", merServicesList);
		model.addAttribute(OBJ_MODEL, custCheckInConsumeManager.getById(id));
		return EDIT_PAGE_VIEW;
	}
	
	/** 
	 * �������Ѽ�¼����
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView custCheckInConsumeUpdate(CustCheckInConsume custCheckInConsume,HttpServletRequest request,@RequestParam(value="roomNo")String roomNo) {
		custCheckInConsumeManager.update(custCheckInConsume);
		return new ModelAndView(LIST_ACTION_VIEW + custCheckInConsume.getCustCheckInRoom().getId()+ "?roomNo=" + roomNo);
	}
	
	/** 
	 * ���Ѽ�¼ɾ��
	 */
	@RequestMapping(value = "/delete/{id}/{custCheckInRoomId}", method = RequestMethod.GET)
	public ModelAndView custCheckInConsumeDelete(@PathVariable(value="id") Long id,@PathVariable(value="custCheckInRoomId") Long custCheckInRoomId,@RequestParam(value="roomNo")String roomNo) {
		custCheckInConsumeManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW + custCheckInRoomId+ "?roomNo=" + roomNo);
	}
}
