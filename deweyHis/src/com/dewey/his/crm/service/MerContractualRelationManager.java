package com.dewey.his.crm.service;

import java.util.List;

import com.dewey.his.crm.model.MerContractualRelation;

public interface MerContractualRelationManager {
	
	public List<MerContractualRelation> getContractualRelationByUnitId(Long unitId, Long  roomTypeId);

}
