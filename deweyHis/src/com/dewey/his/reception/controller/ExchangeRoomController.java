package com.dewey.his.reception.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.model.ExchangeRoom;
import com.dewey.his.reception.service.CheckInManager;
import com.dewey.his.reception.service.CustCheckInRoomManager;
import com.dewey.his.reception.service.ExchangeRoomManager;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/exchangeRoom")
public class ExchangeRoomController extends BaseController<ExchangeRoom, Long> {
	
	private ExchangeRoomManager exchangeRoomManager;

	public void setExchangeRoomManager(ExchangeRoomManager exchangeRoomManager) {
		this.exchangeRoomManager = exchangeRoomManager;
	}
	
	/**
	 * ACTION视图
	 */
	private final String CHECKIN_SHOW_ACTION_VIEW = pre_forward + "/checkIn/show"; // 详细视图
	
	/**
	 * PAGE视图
	 */
	private final String NEW_PAGE_VIEW = "/reception/exchangeRoom/new";      // 新增页面
	
	/**
	 * 入住登记
	 */
	private CheckInManager checkInManager;

	public void setCheckInManager(CheckInManager checkInManager) {
		this.checkInManager = checkInManager;
	}
	
	/**
	 * 入住客房
	 */
	private CustCheckInRoomManager custCheckInRoomManager;
	
	public void setCustCheckInRoomManager(CustCheckInRoomManager custCheckInRoomManager) {
		this.custCheckInRoomManager = custCheckInRoomManager;
	}
	
//	/**
//	 * 床位信息
//	 */
//	private RoomBedManager roomBedManager;
//	
//	public void setRoomBedManager(RoomBedManager roomBedManager) {
//		this.roomBedManager = roomBedManager;
//	}
//	
//	/**
//	 * 商户客房信息
//	 */
//	private MerRoomManager merRoomManager;
//
//	public void setMerRoomManager(MerRoomManager merRoomManager) {
//		this.merRoomManager = merRoomManager;
//	}

	/**
	 * 进入新增
	 */
	@RequestMapping(value = "/new")
	public String _new(@RequestParam(value="custCheckInRoomId") Long custCheckInRoomId,
			@RequestParam(value="checkInId") Long checkInId, HttpServletRequest request,ModelMap model) {
		model.addAttribute("checkIn", checkInManager.getById(checkInId));
		model.addAttribute("custCheckInRoom", custCheckInRoomManager.getById(custCheckInRoomId));
		return NEW_PAGE_VIEW;
	}
	
	/**
	 * 保存新增
	 * @throws Exception 
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="checkInId",required=true)Long checkInId, 
			@RequestParam(value="custCheckInRoomId",required=true)Long custCheckInRoomId, ExchangeRoom exchangeRoom,
			CustCheckInRoom custCheckInRoom) throws Exception {
		exchangeRoomManager.exchangeRoomAction(checkInId, custCheckInRoomId, exchangeRoom, custCheckInRoom);
		return CHECKIN_SHOW_ACTION_VIEW +"/" + checkInId;
	}
}