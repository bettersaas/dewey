package com.dewey.his.reception.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("custCheckInRoomDAO")
public class CustCheckInRoomDAO extends Hibernate3Dao{
	
	public int updateRemark(long id, String remark) {
		String queryString = "update CustCheckInRoom set remark=:remark  where id=:id ";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setLong("id", id);
		query.setString("remark", remark);
		return query.executeUpdate();
	}
}