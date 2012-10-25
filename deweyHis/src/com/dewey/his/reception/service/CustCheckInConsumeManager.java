package com.dewey.his.reception.service;

import java.util.List;

import com.dewey.his.reception.model.CustCheckInConsume;

public interface CustCheckInConsumeManager {
	
	public Long save(CustCheckInConsume custCheckInConsume);
	
	public CustCheckInConsume getById(long id);
	
	public void update(CustCheckInConsume custCheckInConsume);
	
	public int deleteById(long id);
	
	public List<CustCheckInConsume> getByCustCheckInRoomId(Long merId,Long  custCheckInRoomId);

}
