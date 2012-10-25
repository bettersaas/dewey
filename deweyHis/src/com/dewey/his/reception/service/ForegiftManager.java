package com.dewey.his.reception.service;

import java.util.List;

import com.dewey.his.reception.model.Foregift;

public interface ForegiftManager {
	
	public Foregift getById(long id);
	
	public void update(Foregift foregift);
	
	public Long save(Foregift foregift);
	
	public int deleteById(long id);
	
	public List<Foregift> getByCustCheckInRoomId(Long merId,Long  custCheckInRoomId);
}
