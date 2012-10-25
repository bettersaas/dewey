package com.dewey.his.reception.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.reception.model.ExchangeRoom;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("exchangeRoomDAO")
public class ExchangeRoomDAO extends Hibernate3Dao{
	
	@SuppressWarnings("unchecked")
	public List<ExchangeRoom> getByCheckInId(Long checkInId) {
		String queryString = "from ExchangeRoom as model where model.checkIn.id=:checkInId order by model.id desc";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter("checkInId", checkInId);
		return queryObject.list();
	}
}