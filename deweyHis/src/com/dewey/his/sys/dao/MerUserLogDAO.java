package com.dewey.his.sys.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.sys.model.MerUserLog;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("merUserLogDAO")
public class MerUserLogDAO extends Hibernate3Dao {

	@SuppressWarnings("unchecked")
	public List<MerUserLog> getMerUserLog(long merUserId) {
			String queryString = "from MerUserLog where merUserId=:merUserId";
			Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
			query.setLong("merUserId", merUserId);
			return query.list();
	}
}
