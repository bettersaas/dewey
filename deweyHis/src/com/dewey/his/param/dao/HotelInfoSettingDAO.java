package com.dewey.his.param.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.param.model.HotelInfoSetting;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("hotelInfoSettingDAO")
public class HotelInfoSettingDAO extends Hibernate3Dao {
	
	public HotelInfoSetting getByMerId(long merId) {
		String queryString = "from HotelInfoSetting as model where model.mer.id= ?";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		return  (HotelInfoSetting)queryObject.uniqueResult();
	}
}