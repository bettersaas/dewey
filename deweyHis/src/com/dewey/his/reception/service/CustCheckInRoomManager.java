package com.dewey.his.reception.service;

import com.dewey.his.reception.model.CustCheckInRoom;

public interface CustCheckInRoomManager {
	
	public CustCheckInRoom getById(long id);
	
	public void update(CustCheckInRoom custCheckInRoom);
	
	public int updateRemark(long id,String remark);
	
	public Long save(CustCheckInRoom custCheckInRoom);
	
}
