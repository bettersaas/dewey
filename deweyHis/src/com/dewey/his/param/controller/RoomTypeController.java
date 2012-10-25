package com.dewey.his.param.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.param.model.RoomType;
import com.dewey.his.param.service.RoomTypeManager;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/roomType")
public class RoomTypeController extends BaseController<RoomType, Long> {

	private RoomTypeManager roomTypeManager;

	public void setRoomTypeManager(RoomTypeManager roomTypeManager) {
		this.roomTypeManager = roomTypeManager;
	}

	/**
	 * ACTION��ͼ
	 */
	private final String LIST_ACTION_VIEW = "redirect:/roomType/list";        // �б���ͼ
	
	/**
	 * PAGE��ͼ
	 */
	private final String LIST_PAGE_VIEW          = "/param/roomType/list";           // �б�ҳ��
	private final String NEW_PAGE_VIEW         = "/param/roomType/new";        // ����ҳ��
	private final String EDIT_PAGE_VIEW          = "/param/roomType/edit";         // �޸�ҳ��
	
	private final String LIST_MODEL          = "roomTypeList";
	private final String OBJ_MODEL           = "roomType";
	
	@RequestMapping(value = "/list")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		model.addObject(LIST_MODEL, roomTypeManager.findMerAllRoomType(mer.getId()));
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}

	/**
	 * ��������
	 */
	@RequestMapping(value = "/new")
	public ModelAndView _new(HttpServletRequest request) {
		RoomType roomType = new RoomType();
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		roomType.setMer(mer);
		return new ModelAndView(NEW_PAGE_VIEW, OBJ_MODEL, roomType);
	}
	
	/**
	 * Ajax ����ɫ���Ƿ����  Y: ��ʹ�� N :û�б�ʹ��
	 */
	@RequestMapping(value = "/checkMerRoomTypeNameUnique", method = RequestMethod.GET)
	@ResponseBody
	public String checkMerRoomTypeUnique(HttpServletRequest request,@RequestParam(value="roomTypeName") String roomTypeName) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		List<RoomType> roomTypeList= roomTypeManager.getByMerRoomTypeName(mer.getId(), roomTypeName);
		if (roomTypeList == null || roomTypeList.isEmpty()) {
			return "true";
		}
		return "false";
	}

	/**
	 * ��������
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response, RoomType roomType) throws Exception {
		roomTypeManager.save(roomType);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
	
	/** ����༭ */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable(value="id") 	int id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RoomType roomType = (RoomType) roomTypeManager.getById(id);
		return new ModelAndView(EDIT_PAGE_VIEW, OBJ_MODEL, roomType);
	}

	/** ������� */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam 	Integer id,  RoomType roomType) throws Exception {
		RoomType roomTypePersistent = roomTypeManager.getById(id);
		BeanUtils.copyProperties(roomType, roomTypePersistent);
		roomTypeManager.update(roomTypePersistent);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** ɾ�� */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="id") 	int id, HttpServletRequest request, HttpServletResponse response) {
		roomTypeManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** ����ɾ�� */
	@RequestMapping(value = "/batchDelete")
	public ModelAndView batchDelete(@RequestParam("ids") int[] items,HttpServletRequest request) {
		// String[] items = request.getParameterValues("items");
		for (int i = 0; i < items.length; i++) {
			java.lang.Integer id = new java.lang.Integer(items[i]);
			roomTypeManager.deleteById(id);
		}
		return new ModelAndView(LIST_ACTION_VIEW);
	}
}