package com.dewey.his.crm.service;

import java.util.List;

import com.dewey.his.crm.model.ContractualUnit;

public interface ContractualUnitManager {
	
	public Long save(ContractualUnit transientInstance);
	
	public void update(ContractualUnit transientInstance);
	
	public ContractualUnit getById(long id) ;
	
	public int deleteById(long id);
	
	public List<ContractualUnit> findMerAllContractualUnit(long merId);
}
