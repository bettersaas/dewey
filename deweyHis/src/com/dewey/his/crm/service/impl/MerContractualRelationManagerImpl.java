package com.dewey.his.crm.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.crm.dao.MerContractualRelationDAO;
import com.dewey.his.crm.model.MerContractualRelation;
import com.dewey.his.crm.service.MerContractualRelationManager;

@Service("merContractualRelationManager")
@Scope("singleton")
@Transactional
public class MerContractualRelationManagerImpl implements MerContractualRelationManager {
	
	private MerContractualRelationDAO merContractualRelationDAO;
	
	public void setMerContractualRelationDAO(MerContractualRelationDAO merContractualRelationDAO) {
		this.merContractualRelationDAO = merContractualRelationDAO;
	}

	@Transactional(readOnly = true)
	public List<MerContractualRelation> getContractualRelationByUnitId(Long unitId, Long roomTypeId) {
		return merContractualRelationDAO.getContractualRelationByUnitId(unitId, roomTypeId);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
