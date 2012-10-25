package com.dewey.his.param.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.param.model.RoomType;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("roomTypeDAO")
public class RoomTypeDAO extends Hibernate3Dao {

	@SuppressWarnings("unchecked")
	public List<RoomType> findMerAllRoomType(long merId) {
		String queryString = "from RoomType as model where model.mer.id= ? order by id";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		return queryObject.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<RoomType> getByMerRoomTypeName(long merId,String roomTypeName) {
		String queryString = "from RoomType as model where model.mer.id= ? and  model.name=?  order by id";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		queryObject.setParameter(1, roomTypeName);
		return queryObject.list();
	}
}