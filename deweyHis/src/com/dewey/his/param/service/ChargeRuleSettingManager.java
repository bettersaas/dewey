package com.dewey.his.param.service;

import com.dewey.his.param.model.ChargeRuleSetting;

public interface ChargeRuleSettingManager {
	
	public Long save(ChargeRuleSetting chargeRuleSetting);
	
	public void saveOrUpdate(ChargeRuleSetting chargeRuleSetting);
	
	public void update(ChargeRuleSetting chargeRuleSetting);
	
	public ChargeRuleSetting getById(long id);
	
	public ChargeRuleSetting getByMerId(long  merId);
	
	public int deleteById(long id);

}
