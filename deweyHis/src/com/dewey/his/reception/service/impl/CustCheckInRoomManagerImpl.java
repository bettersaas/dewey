package com.dewey.his.reception.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.reception.dao.CustCheckInRoomDAO;
import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.service.CustCheckInRoomManager;

@Service("custCheckInRoomManager")
@Scope("singleton")
@Transactional
public class CustCheckInRoomManagerImpl implements CustCheckInRoomManager{
	
	private CustCheckInRoomDAO custCheckInRoomDAO;

	public void setCustCheckInRoomDAO(CustCheckInRoomDAO custCheckInRoomDAO) {
		this.custCheckInRoomDAO = custCheckInRoomDAO;
	}

	@Transactional(readOnly = true)
	public CustCheckInRoom getById(long id) {
		return (CustCheckInRoom)custCheckInRoomDAO.getById(CustCheckInRoom.class,id);
	}

	public void update(CustCheckInRoom custCheckInRoom) {
		custCheckInRoomDAO.update(custCheckInRoom);
	}
	
	public Long save(CustCheckInRoom custCheckInRoom) {
		return custCheckInRoomDAO.save(custCheckInRoom);
	}
	
	public int updateRemark(long id, String remark) {
		return custCheckInRoomDAO.updateRemark(id, remark);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
