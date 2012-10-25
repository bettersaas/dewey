package com.dewey.his.sys.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.sys.model.MerServices;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("merServicesDAO")
public class MerServicesDAO extends Hibernate3Dao {

	@SuppressWarnings("unchecked")
	public List<MerServices> findMerAllMerServices(long merId) {
		String queryString = "from MerServices  where merId= ? order by id";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		return queryObject.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MerServices> findConsumeTypeMerServices(long merId, String consumeType) {
		String queryString = "from MerServices  where merId=? and consumeType=?  order by id";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		queryObject.setParameter(1, consumeType);
		return queryObject.list();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}

}
