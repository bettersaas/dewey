package com.dewey.his.sys.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.param.service.RoomTypeManager;
import com.dewey.his.sys.model.MerRoom;
import com.dewey.his.sys.model.RoomBed;
import com.dewey.his.sys.service.MerRoomManager;

import common.base.constant.VOConstantList;
import common.base.controller.BaseController;
import common.util.sort.SortInt;

@Controller
@RequestMapping("/merRoom")
public class MerRoomController extends BaseController<MerRoom, Long> {

	private MerRoomManager merRoomManager;
	
	public void setMerRoomManager(MerRoomManager merRoomManager) {
		this.merRoomManager = merRoomManager;
	}
	
	/**
	 * ACTION视图
	 */
	private final String QUERY_ACTION_VIEW = pre_redirect + "/merRoom/query";     // 查询视图
	private final String LIST_ACTION_VIEW      = pre_forward + "/merRoom/list";         // 列表视图
	
	/**
	 * PAGE视图
	 */
	private final String LIST_PAGE_VIEW          = "/sys/merRoom/list";           // 列表页面
	private final String NEW_PAGE_VIEW         = "/sys/merRoom/new";        // 新增页面
	private final String EDIT_PAGE_VIEW          = "/sys/merRoom/edit";         // 修改页面
	
	private final String LIST_MODEL          = "merRoomList";
	private final String OBJ_MODEL           = "merRoom";
	
	/**
	 * 房型
	 */
	private RoomTypeManager roomTypeManager;

	public void setRoomTypeManager(RoomTypeManager roomTypeManager) {
		this.roomTypeManager = roomTypeManager;
	}
	
	private final String ROOMTYPE_LIST_MODEL = "roomTypeList";
	
	/**
	 * 进入查询页面
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/query")
	public ModelAndView query(HttpServletRequest request) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		ModelAndView model = new ModelAndView();
		model.addObject(ROOMTYPE_LIST_MODEL, roomTypeManager.findMerAllRoomType(mer.getId()));
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}
	
	/**
	 * 查询结果显示页面
	 * @param request
	 * @param roomTypeId
	 * @return
	 */
	@RequestMapping(value = "/list")
	public ModelAndView index(HttpServletRequest request,@RequestParam("roomType.id") String roomTypeId) {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		ModelAndView model = new ModelAndView();
		List<MerRoom> merRooms = null;
		if (roomTypeId == null || "".equals(roomTypeId.trim())) {
			merRooms = merRoomManager.findMerAllMerRoom(mer.getId());
		} else {
			merRooms = merRoomManager.findMerAllRoomTypeRooms(Long.parseLong(roomTypeId));
		}
		for (MerRoom merRoom:merRooms) {
			// 房间状态转码
			merRoom.setStateDesc(VOConstantList.getMerRoomStateMap().get(merRoom.getState()));
		}
		model.addObject(LIST_MODEL, merRooms);
		model.addObject(ROOMTYPE_LIST_MODEL, roomTypeManager.findMerAllRoomType(mer.getId()));
		model.setViewName(LIST_PAGE_VIEW);
		return model;
	}

	/**
	 * 进入新增
	 */
	@RequestMapping(value = "/new")
	public String _new(HttpServletRequest request, ModelMap model) {
		MerRoom merRoom = new MerRoom();
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		merRoom.setMer(mer);
		// 新增房间默认状态为维修
		merRoom.setState("4");
		model.addAttribute(OBJ_MODEL, merRoom);
		model.addAttribute(ROOMTYPE_LIST_MODEL, roomTypeManager.findMerAllRoomType(mer.getId()));
		return NEW_PAGE_VIEW;
	}

	/**
	 * 保存新增
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView create(HttpServletRequest request,MerRoom merRoom) throws Exception {
		List<RoomBed> roomBeds = merRoom.getRoomBeds();
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		// 更新床位的关联信息
		for (RoomBed roomBed :  roomBeds) {
			roomBed.setMerId(mer.getId());
			roomBed.setMerRoom(merRoom);
		}
		merRoomManager.save(merRoom);
		return new ModelAndView(QUERY_ACTION_VIEW);
	}

//	/** 显示 */
//	@RequestMapping(value = "/show/{id}")
//	public ModelAndView show(@PathVariable(value="id")	int id, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		MerRoom merRoom = (MerRoom) merRoomManager.getById(id);
//		return new ModelAndView(SHOW_PAGE_VIEW, OBJ_MODEL, merRoom);
//	}

	/** 进入编辑 */
	@RequestMapping(value = "/edit/{id}")
	public String edit(@PathVariable(value="id") 	int id, HttpServletRequest request,ModelMap model) throws Exception {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		MerRoom merRoom = merRoomManager.getById(id);
		// 房间状态转码
		merRoom.setStateDesc(VOConstantList.getMerRoomStateMap().get(merRoom.getState()));
		model.addAttribute(OBJ_MODEL, merRoom);
		model.addAttribute(ROOMTYPE_LIST_MODEL, roomTypeManager.findMerAllRoomType(mer.getId()));
		return EDIT_PAGE_VIEW;
	}
	
	/** 保存更新 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(@Valid MerRoom merRoom, @RequestParam(value="deletedIndexes",required=false) Integer[] deletedIndexes,HttpServletRequest request) throws Exception {
		if (deletedIndexes != null) {
			Arrays.sort(deletedIndexes,   new SortInt(SortInt.UP));
		}
		// 更新床位的关联信息
		List<RoomBed> roomBeds = merRoom.getRoomBeds();
		for (RoomBed bed : roomBeds) {
			bed.setMerId(merRoom.getMer().getId());
			bed.setMerRoom(merRoom);
		}
		merRoomManager.update(merRoom, deletedIndexes);
		return new ModelAndView(QUERY_ACTION_VIEW);
	}

	/** 删除 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="id") 	int id) {
		merRoomManager.deleteById(id);
		return new ModelAndView(LIST_ACTION_VIEW);
	}
	
	/** 批量修改状态 */
	@RequestMapping(value = "/batchUpdateState")
	public ModelAndView batchUpdateState(@RequestParam("ids") int[] items,@RequestParam("state") String state) {
		for (int i = 0; i < items.length; i++) {
			java.lang.Long id = new java.lang.Long(items[i]);
			merRoomManager.updateState(id, state);
		}
		return new ModelAndView(LIST_ACTION_VIEW);
	}
}