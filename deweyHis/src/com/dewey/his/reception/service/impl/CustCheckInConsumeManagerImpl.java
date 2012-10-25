package com.dewey.his.reception.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.reception.dao.CustCheckInConsumeDAO;
import com.dewey.his.reception.model.CustCheckInConsume;
import com.dewey.his.reception.service.CustCheckInConsumeManager;

@Service("custCheckInConsumeManager")
@Scope("singleton")
@Transactional
public class CustCheckInConsumeManagerImpl implements CustCheckInConsumeManager{

	private CustCheckInConsumeDAO custCheckInConsumeDAO;

	public void setCustCheckInConsumeDAO(CustCheckInConsumeDAO custCheckInConsumeDAO) {
		this.custCheckInConsumeDAO = custCheckInConsumeDAO;
	}

	@Transactional(readOnly = true)
	public CustCheckInConsume getById(long id) {
		return (CustCheckInConsume)custCheckInConsumeDAO.getById(CustCheckInConsume.class,id);
	}

	@Transactional(readOnly = true)
	public List<CustCheckInConsume> getByCustCheckInRoomId(Long merId, Long custCheckInRoomId) {
		return custCheckInConsumeDAO.getByCustCheckInRoomId(merId, custCheckInRoomId);
	}

	public Long save(CustCheckInConsume custCheckInConsume) {
		return custCheckInConsumeDAO.save(custCheckInConsume);
	}
	
	public int deleteById(long id) {
		return custCheckInConsumeDAO.deleteById(CustCheckInConsume.class,id);
	}

	public void update(CustCheckInConsume custCheckInConsume) {
		custCheckInConsumeDAO.update(custCheckInConsume);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
}
