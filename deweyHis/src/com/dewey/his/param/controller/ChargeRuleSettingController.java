package com.dewey.his.param.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dewey.his.common.model.Mer;
import com.dewey.his.param.model.ChargeRuleSetting;
import com.dewey.his.param.service.ChargeRuleSettingManager;
import common.base.controller.BaseController;

@Controller
@RequestMapping("/chargeRuleSetting")
public class ChargeRuleSettingController  extends BaseController<ChargeRuleSetting, Long>  {
	
	private ChargeRuleSettingManager chargeRuleSettingManager;

	public void setChargeRuleSettingManager(ChargeRuleSettingManager chargeRuleSettingManager) {
		this.chargeRuleSettingManager = chargeRuleSettingManager;
	}
	
	/**
	 * ACTION��ͼ
	 */
	private final String EDIT_ACTION_VIEW = "redirect:/chargeRuleSetting/edit";        // �б���ͼ
	
	/**
	 * PAGE��ͼ
	 */
	private final String EDIT_PAGE_VIEW   = "/param/chargeRuleSetting/edit";         // �޸�ҳ��
	
	private final String OBJ_MODEL           = "chargeRuleSetting";
	
	/** ����༭ */
	@RequestMapping(value = "/edit")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Mer  mer = (Mer) request.getSession(false).getAttribute("MER");
		ChargeRuleSetting chargeRuleSetting = (ChargeRuleSetting) chargeRuleSettingManager.getByMerId(mer.getId());
		if (chargeRuleSetting == null) {
			chargeRuleSetting = new ChargeRuleSetting();
			chargeRuleSetting.setMer(mer);
		}
		return new ModelAndView(EDIT_PAGE_VIEW, OBJ_MODEL, chargeRuleSetting);
	}

	/** ������� */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(ChargeRuleSetting chargeRuleSetting) throws Exception {
		ChargeRuleSetting chargeRuleSettingPersistent = null;
		if (chargeRuleSetting.getId() != null) {
			// ���ض���
			chargeRuleSettingPersistent = (ChargeRuleSetting) chargeRuleSettingManager.getById(chargeRuleSetting.getId());
			// ���Կ���
			BeanUtils.copyProperties(chargeRuleSetting, chargeRuleSettingPersistent);
		} else {
			chargeRuleSettingPersistent = chargeRuleSetting;
		}
		chargeRuleSettingManager.saveOrUpdate(chargeRuleSettingPersistent);
		return new ModelAndView(EDIT_ACTION_VIEW);
	}
}