package com.dewey.his.common.util;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import common.base.dao.hibernate3.Hibernate3Dao;

/**
 * @author 陈存祥
 * 获取流水号
 */
@Repository("merDAO")
public class NumDAO extends Hibernate3Dao {
	/*
	 * merId 商户id
	 * type  流水号类型
	 */
	@SuppressWarnings("unchecked")
	public String getNum(long merId,String type) {
		String queryString = "from MerRole as model where model.mer.id= ? and model.num_type = ?";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		queryObject.setParameter(0, type);
		String s=queryObject.getQueryString();
		//原值增加1
		
		return s;
	}
	
}