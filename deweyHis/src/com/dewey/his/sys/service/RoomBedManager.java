package com.dewey.his.sys.service;

import com.dewey.his.sys.model.RoomBed;

public interface RoomBedManager {
	
	public Long save(RoomBed transientInstance);
	
	public void update(RoomBed transientInstance) ;
	
	public int updateState(Long id, String useFlag);
	
	public RoomBed getById(long id);
	
	public int deleteById(long id);
	
//	public List<RoomBed> findMerAllRoomBed(long merId);
//	
//	public List<RoomBed> findMerRoomAllRoomBed(long merRoomId);
}
