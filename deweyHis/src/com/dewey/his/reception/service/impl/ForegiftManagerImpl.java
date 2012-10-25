package com.dewey.his.reception.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.reception.dao.ForegiftDAO;
import com.dewey.his.reception.model.Foregift;
import com.dewey.his.reception.service.ForegiftManager;

@Service("foregiftManager")
@Scope("singleton")
@Transactional
public class ForegiftManagerImpl implements ForegiftManager {
	
	private ForegiftDAO foregiftDAO;

	public void setForegiftDAO(ForegiftDAO foregiftDAO) {
		this.foregiftDAO = foregiftDAO;
	}

	@Transactional(readOnly = true)
	public Foregift getById(long id) {
		return (Foregift)foregiftDAO.getById(Foregift.class, id);
	}

	public Long save(Foregift transientInstance) {
		return foregiftDAO.save(transientInstance);
	}

	public void update(Foregift transientInstance) {
		foregiftDAO.update(transientInstance);
	}
	
	public int deleteById(long id) {
		return foregiftDAO.deleteById(Foregift.class,id);
	}
	
	@Transactional(readOnly = true)
	public List<Foregift> getByCustCheckInRoomId(Long merId, Long custCheckInRoomId) {
		return foregiftDAO.getByCustCheckInRoomId(merId, custCheckInRoomId);
	}
}