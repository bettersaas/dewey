package com.dewey.his.param.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.param.model.HotelInfoSetting;
import com.dewey.his.param.service.HotelInfoSettingManager;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/hotelInfoSetting")
public class HotelInfoSettingController  extends BaseController<HotelInfoSetting, Long>  {
	
	private HotelInfoSettingManager hotelInfoSettingManager;

	public void setHotelInfoSettingManager(HotelInfoSettingManager hotelInfoSettingManager) {
		this.hotelInfoSettingManager = hotelInfoSettingManager;
	}
	
	/**
	 * ACTION视图
	 */
	private final String EDIT_ACTION_VIEW = "redirect:/hotelInfoSetting/edit";        // 列表视图
	
	/**
	 * PAGE视图
	 */
	private final String EDIT_PAGE_VIEW   = "/param/hotelInfoSetting/edit";         // 修改页面
	
	private final String OBJ_MODEL           = "hotelInfoSetting";

	/** 进入编辑 */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		HotelInfoSetting hotelInfoSetting = (HotelInfoSetting) hotelInfoSettingManager.getByMerId(mer.getId());
		if (hotelInfoSetting == null) {
			hotelInfoSetting = new HotelInfoSetting();
			hotelInfoSetting.setMer(mer);
		}
		return new ModelAndView(EDIT_PAGE_VIEW, OBJ_MODEL, hotelInfoSetting);
	}

	/** 保存更新 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HotelInfoSetting hotelInfoSetting) throws Exception {
		HotelInfoSetting hotelInfoSettingPersistent = null;
		if (hotelInfoSetting.getId() != null) {
			hotelInfoSettingPersistent = (HotelInfoSetting) hotelInfoSettingManager.getById(hotelInfoSetting.getId());
			BeanUtils.copyProperties(hotelInfoSetting, hotelInfoSettingPersistent);
		} else {
			hotelInfoSettingPersistent = hotelInfoSetting;
		}
		hotelInfoSettingManager.saveOrUpdate(hotelInfoSettingPersistent);
		return new ModelAndView(EDIT_ACTION_VIEW);
	}
}
