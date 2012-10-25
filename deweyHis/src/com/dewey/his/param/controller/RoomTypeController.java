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
	 * ACTION视图
	 */
	private final String LIST_ACTION_VIEW = "redirect:/roomType/list";        // 列表视图
	
	/**
	 * PAGE视图
	 */
	private final String LIST_PAGE_VIEW          = "/param/roomType/list";           // 列表页面
	private final String NEW_PAGE_VIEW         = "/param/roomType/new";        // 新增页面
	private final String EDIT_PAGE_VIEW          = "/param/roomType/edit";         // 修改页面
	
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
	 * 进入新增
	 */
	@RequestMapping(value = "/new")
	public ModelAndView _new(HttpServletRequest request) {
		RoomType roomType = new RoomType();
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		roomType.setMer(mer);
		return new ModelAndView(NEW_PAGE_VIEW, OBJ_MODEL, roomType);
	}
	
	/**
	 * Ajax 检测角色名是否存在  Y: 已使用 N :没有被使用
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
	 * 保存新增
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request, HttpServletResponse response, RoomType roomType) throws Exception {
		roomTypeManager.save(roomType);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
	
	/** 进入编辑 */
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView edit(@PathVariable(value="id") 	int id, HttpServletRequest request, HttpServletResponse response) throws Exception {
		RoomType roomType = (RoomType) roomTypeManager.getById(id);
		return new ModelAndView(EDIT_PAGE_VIEW, OBJ_MODEL, roomType);
	}

	/** 保存更新 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam 	Integer id,  RoomType roomType) throws Exception {
		RoomType roomTypePersistent = roomTypeManager.getById(id);
		BeanUtils.copyProperties(roomType, roomTypePersistent);
		roomTypeManager.update(roomTypePersistent);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** 删除 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="id") 	int id, HttpServletRequest request, HttpServletResponse response) {
		roomTypeManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW);
	}

	/** 批量删除 */
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