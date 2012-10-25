package com.dewey.his.sys.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("roomBedDAO")
public class RoomBedDAO extends Hibernate3Dao {
	
	public int updateState(Long id, String useFlag) {
		String queryString = "update RoomBed set useFlag=:useFlag  where id = :id ";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setLong("id", id);
		query.setString("useFlag", useFlag);
		return query.executeUpdate();
	}

//	@SuppressWarnings("unchecked")
//	public List<RoomBed> findMerAllRoomBed(long merId) {
//		String queryString = "from RoomBed as model where model.mer.id= ? order by id";
//		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
//		queryObject.setParameter(0, merId);
//		return queryObject.list();
//	}
//	
//	@SuppressWarnings("unchecked")
//	public List<RoomBed> findMerRoomAllRoomBed(long merRoomId) {
//		String queryString = "from RoomBed as model where model.merRoom.id= ? order by id";
//		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
//		queryObject.setParameter(0, merRoomId);
//		return queryObject.list();
//	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
}
