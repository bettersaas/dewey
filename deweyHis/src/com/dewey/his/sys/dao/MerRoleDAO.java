package com.dewey.his.sys.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.sys.model.MerRole;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("merRoleDAO")
public class MerRoleDAO extends Hibernate3Dao {

	@SuppressWarnings("unchecked")
	public List<MerRole> getMerAllRole(long merId) {
		String queryString = "from MerRole as model where model.mer.id= ? order by id";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		return queryObject.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<MerRole> getByMerRoleName(long merId, String roleName) {
		String queryString = "from MerRole as model where model.mer.id= ? and model.roleName=?";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		queryObject.setParameter(1, roleName);
		return queryObject.list();
	}

}
