package com.dewey.his.reception.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.service.CustCheckInRoomManager;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/custCheckInRoom")
public class CustCheckInRoomController extends BaseController<CustCheckInRoom, Long> {
	
	/**
	 * 入住客房
	 */
	private CustCheckInRoomManager custCheckInRoomManager;
	
	public void setCustCheckInRoomManager(CustCheckInRoomManager custCheckInRoomManager) {
		this.custCheckInRoomManager = custCheckInRoomManager;
	}
	
	/**
	 * 更新入住客房信息，修改备注
	 * @param model
	 * @param checkInId
	 * @param custCheckInRoomId
	 * @param custCheckInRoomRemark
	 * @return
	 */
	@RequestMapping(value = "/updateRemark")
	public ModelAndView updateCustCheckInRoom(ModelAndView model,
			@RequestParam(value="checkInId")Long checkInId, 
			@RequestParam(value="custCheckInRoomId")Long custCheckInRoomId, 
			@RequestParam(value="custCheckInRoomRemark")String custCheckInRoomRemark) {
		custCheckInRoomManager.updateRemark(custCheckInRoomId, custCheckInRoomRemark);
		model.setViewName(pre_forward + "/checkIn/show/" + checkInId);
		return model;
	}
	
	/**
	 * Ajax 修改备注 成功为true，否则为false
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/updateRemarkAjax")
	@ResponseBody
	public String checkMerRoleNameUnique(HttpServletRequest request,
			@RequestParam(value="checkInId") Long checkInId, 
			@RequestParam(value="custCheckInRoomId") Long custCheckInRoomId, 
			@RequestParam(value="custCheckInRoomRemark") String custCheckInRoomRemark) throws UnsupportedEncodingException {
		// javascript沿用java的字符处理方式，内部是使用unicode来处理所有字符的
		// 用utf-8来send数据是不会出现乱码的，是后台程序没有正确解码才会出现乱码
		// //post 传递的时候,一定是用utf8编码的,url 自己可以设定
		custCheckInRoomRemark = URLDecoder.decode(custCheckInRoomRemark,"utf8");
		int count = custCheckInRoomManager.updateRemark(custCheckInRoomId, custCheckInRoomRemark);
		if (count == 1) {
			return "true";
		} else {
			return "false";
		}
	}
}
