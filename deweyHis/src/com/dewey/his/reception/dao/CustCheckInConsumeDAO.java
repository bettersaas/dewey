package com.dewey.his.reception.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.reception.model.CustCheckInConsume;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("custCheckInConsumeDAO")
public class CustCheckInConsumeDAO extends Hibernate3Dao{
	
	@SuppressWarnings("unchecked")
	public List<CustCheckInConsume> getByCustCheckInRoomId(Long merId,Long  custCheckInRoomId) {
		String queryString = "from CustCheckInConsume as model where model.merId=:merId and model.custCheckInRoom.id=:custCheckInRoomId order by model.id desc";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter("merId", merId);
		queryObject.setParameter("custCheckInRoomId", custCheckInRoomId);
		return queryObject.list();
	}
}
