package com.dewey.his.reception.service;

import java.util.List;

import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.model.ExchangeRoom;

public interface ExchangeRoomManager {
	
	public ExchangeRoom getById(long id);
	
	public void update(ExchangeRoom transientInstance);
	
	public Long save(ExchangeRoom transientInstance);
	
	public int deleteById(long id);
	
	public List<ExchangeRoom> getByCheckInId(Long checkInId);

	public boolean  exchangeRoomAction(Long checkInId,Long custCheckInRoomId,ExchangeRoom exchangeRoom,CustCheckInRoom custCheckInRoom) throws  Exception ;
	
}
