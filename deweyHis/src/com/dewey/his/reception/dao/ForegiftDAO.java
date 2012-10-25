package com.dewey.his.reception.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.reception.model.Foregift;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("foregiftDAO")
public class ForegiftDAO  extends Hibernate3Dao{
	
	@SuppressWarnings("unchecked")
	public List<Foregift> getByCustCheckInRoomId(Long merId,Long  custCheckInRoomId) {
		String queryString = "from Foregift as model where model.merId=:merId and model.custCheckInRoom.id=:custCheckInRoomId order by model.id desc";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter("merId", merId);
		queryObject.setParameter("custCheckInRoomId", custCheckInRoomId);
		return queryObject.list();
	}
}