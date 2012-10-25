package com.dewey.his.crm.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.crm.model.ContractualUnit;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("contractualUnitDAO")
public class ContractualUnitDAO extends Hibernate3Dao{

	@SuppressWarnings("unchecked")
	public List<ContractualUnit> findMerAllContractualUnit(long merId) {
		String queryString = "from ContractualUnit as model where model.mer.id= ? order by id";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		return queryObject.list();
	}
}