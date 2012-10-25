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
	 * ��ס�ͷ�
	 */
	private CustCheckInRoomManager custCheckInRoomManager;
	
	public void setCustCheckInRoomManager(CustCheckInRoomManager custCheckInRoomManager) {
		this.custCheckInRoomManager = custCheckInRoomManager;
	}
	
	/**
	 * ������ס�ͷ���Ϣ���޸ı�ע
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
	 * Ajax �޸ı�ע �ɹ�Ϊtrue������Ϊfalse
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value = "/updateRemarkAjax")
	@ResponseBody
	public String checkMerRoleNameUnique(HttpServletRequest request,
			@RequestParam(value="checkInId") Long checkInId, 
			@RequestParam(value="custCheckInRoomId") Long custCheckInRoomId, 
			@RequestParam(value="custCheckInRoomRemark") String custCheckInRoomRemark) throws UnsupportedEncodingException {
		// javascript����java���ַ�����ʽ���ڲ���ʹ��unicode�����������ַ���
		// ��utf-8��send�����ǲ����������ģ��Ǻ�̨����û����ȷ����Ż��������
		// //post ���ݵ�ʱ��,һ������utf8�����,url �Լ������趨
		custCheckInRoomRemark = URLDecoder.decode(custCheckInRoomRemark,"utf8");
		int count = custCheckInRoomManager.updateRemark(custCheckInRoomId, custCheckInRoomRemark);
		if (count == 1) {
			return "true";
		} else {
			return "false";
		}
	}
}
