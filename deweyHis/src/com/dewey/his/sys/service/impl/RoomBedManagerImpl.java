package com.dewey.his.sys.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.sys.dao.RoomBedDAO;
import com.dewey.his.sys.model.RoomBed;
import com.dewey.his.sys.service.RoomBedManager;

@Service("roomBedManager")
@Scope("singleton")
@Transactional
public class RoomBedManagerImpl implements RoomBedManager {
	
	private RoomBedDAO roomBedDAO;

	public void setRoomBedDAO(RoomBedDAO roomBedDAO) {
		this.roomBedDAO = roomBedDAO;
	}

	public int deleteById(long id) {
		return roomBedDAO.deleteById(RoomBed.class,id);
	}

//	@Transactional(readOnly = true)
//	public List<RoomBed> findMerAllRoomBed(long merId) {
//		return roomBedDAO.findMerAllRoomBed(merId);
//	}
//
//	@Transactional(readOnly = true)
//	public List<RoomBed> findMerRoomAllRoomBed(long merRoomId) {
//		return roomBedDAO.findMerRoomAllRoomBed(merRoomId);
//	}

	@Transactional(readOnly = true)
	public RoomBed getById(long id) {
		return (RoomBed)roomBedDAO.getById(RoomBed.class,id);
	}

	public Long save(RoomBed transientInstance) {
		return roomBedDAO.save(transientInstance);
	}

	public void update(RoomBed transientInstance) {
		roomBedDAO.update(transientInstance);
	}
	
	public int updateState(Long id, String useFlag) {
		return roomBedDAO.updateState(id, useFlag);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
