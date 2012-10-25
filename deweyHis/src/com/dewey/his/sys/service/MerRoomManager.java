package com.dewey.his.sys.service;

import java.util.List;

import com.dewey.his.sys.model.MerRoom;
import com.dewey.his.sys.model.RoomBed;

public interface MerRoomManager {
	
	public Long save(MerRoom transientInstance);
	
	public void update(MerRoom transientInstance);
	
	public void update(MerRoom merRoom,Integer[] deletedItemIndexes);
	
	public int updateState(Long id, String state) ;
	
	public MerRoom getById(long id) ;
	
	public int deleteById(long id);
	
	public List<MerRoom> findMerAllMerRoom(long merId);
     
	public List<MerRoom> findMerAllRoomTypeRooms(long merRoomTypeId);
	
	public List<MerRoom> findMerEmptyCleanRooms(Long merId,Long optMerRoomTypeId);
	
	public List<RoomBed> findMerEmptyCleanRoomBeds(Long merId,String optRoomNo,Long optMerRoomTypeId);
	
	public MerRoom getByRoomNo(Long merId,String roomNo);
}
