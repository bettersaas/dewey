package com.dewey.his.param.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.param.model.ChargeRuleSetting;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("chargeRuleSettingDAO")
public class ChargeRuleSettingDAO extends Hibernate3Dao{
	
	public ChargeRuleSetting getByMerId(long merId) {
		String queryString = "from ChargeRuleSetting as model where model.mer.id= ?";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		return  (ChargeRuleSetting)queryObject.uniqueResult();
	}
}