package com.dewey.his.param.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.param.dao.ChargeRuleSettingDAO;
import com.dewey.his.param.model.ChargeRuleSetting;
import com.dewey.his.param.service.ChargeRuleSettingManager;

@Service("chargeRuleSettingManager")
@Scope("singleton")
@Transactional
public class ChargeRuleSettingManagerImpl implements  ChargeRuleSettingManager{
	
	private ChargeRuleSettingDAO chargeRuleSettingDAO;

	public void setChargeRuleSettingDAO(ChargeRuleSettingDAO chargeRuleSettingDAO) {
		this.chargeRuleSettingDAO = chargeRuleSettingDAO;
	}

	@Transactional
	public int deleteById(long id) {
		return chargeRuleSettingDAO.deleteById(ChargeRuleSetting.class,id);
	}
	
	@Transactional
	public void saveOrUpdate(ChargeRuleSetting chargeRuleSetting) {
		chargeRuleSettingDAO.saveOrUpdate(chargeRuleSetting);		
	}

	@Transactional(readOnly = true)
	public ChargeRuleSetting getById(long id) {
		return (ChargeRuleSetting)chargeRuleSettingDAO.getById(ChargeRuleSetting.class,id);
	}

	@Transactional
	public Long save(ChargeRuleSetting chargeRuleSetting) {
		return chargeRuleSettingDAO.save(chargeRuleSetting);
	}

	@Transactional
	public void update(ChargeRuleSetting chargeRuleSetting) {
		chargeRuleSettingDAO.update(chargeRuleSetting);
	}
	
	@Transactional(readOnly = true)
	public ChargeRuleSetting getByMerId(long merId) {
		return chargeRuleSettingDAO.getByMerId(merId);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
