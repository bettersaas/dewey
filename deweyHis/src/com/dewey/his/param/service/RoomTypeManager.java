package com.dewey.his.param.service;

import java.util.List;

import com.dewey.his.param.model.RoomType;

public interface RoomTypeManager {
	
	public Long save(RoomType transientInstance);
	
	public void update(RoomType transientInstance);
	
	public RoomType getById(long id);
	
	public int deleteById(long id);
	
	public List<RoomType> findMerAllRoomType(long merId);
	
	public List<RoomType> getByMerRoomTypeName(long merId,String roomTypeName);
}
