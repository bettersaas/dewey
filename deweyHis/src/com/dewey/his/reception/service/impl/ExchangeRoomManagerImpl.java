package com.dewey.his.reception.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.reception.dao.CustCheckInRoomDAO;
import com.dewey.his.reception.dao.ExchangeRoomDAO;
import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.model.ExchangeRoom;
import com.dewey.his.reception.service.ExchangeRoomManager;
import com.dewey.his.sys.dao.MerRoomDAO;
import com.dewey.his.sys.dao.RoomBedDAO;

@Service("exchangeRoomManager")
@Scope("singleton")
@Transactional
public class ExchangeRoomManagerImpl implements ExchangeRoomManager {
	
	private ExchangeRoomDAO exchangeRoomDAO;

	public void setExchangeRoomDAO(ExchangeRoomDAO exchangeRoomDAO) {
		this.exchangeRoomDAO = exchangeRoomDAO;
	}
//	/**
//	 * 入住登记
//	 */
//	private CheckInDAO checkInDAO;
//
//	public void setCheckInDAO(CheckInDAO checkInDAO) {
//		this.checkInDAO = checkInDAO;
//	}
	
	/**
	 * 入住客房
	 */
	private CustCheckInRoomDAO custCheckInRoomDAO;
	
	public void setCustCheckInRoomDAO(CustCheckInRoomDAO custCheckInRoomDAO) {
		this.custCheckInRoomDAO = custCheckInRoomDAO;
	}
	
	/**
	 * 床位信息
	 */
	private RoomBedDAO roomBedDAO;
	
	public void setRoomBedDAO(RoomBedDAO roomBedDAO) {
		this.roomBedDAO = roomBedDAO;
	}
	
	/**
	 * 商户客房信息
	 */
	private MerRoomDAO merRoomDAO;

	public void setMerRoomDAO(MerRoomDAO merRoomDAO) {
		this.merRoomDAO = merRoomDAO;
	}

	public int deleteById(long id) {
		return exchangeRoomDAO.deleteById(ExchangeRoom.class, id);
	}

	@Transactional(readOnly = true)
	public List<ExchangeRoom> getByCheckInId(Long checkInId) {
		return exchangeRoomDAO.getByCheckInId(checkInId);
	}

	@Transactional(readOnly = true)
	public ExchangeRoom getById(long id) {
		return (ExchangeRoom)exchangeRoomDAO.getById(ExchangeRoom.class, id);
	}

	public Long save(ExchangeRoom transientInstance) {
		return exchangeRoomDAO.save(transientInstance);
	}

	public void update(ExchangeRoom transientInstance) {
		exchangeRoomDAO.update(transientInstance);
	}

	/**
	 * 换房的具体操作
	 * @throws Exception 
	 */
	public boolean  exchangeRoomAction(Long checkInId,Long custCheckInRoomId,ExchangeRoom exchangeRoom,CustCheckInRoom custCheckInRoomNew) throws  Exception {
		
		/**
		 * 原来的客房
		 */ 
		CustCheckInRoom custCheckInRoomOld = (CustCheckInRoom)custCheckInRoomDAO.getById(CustCheckInRoom.class,custCheckInRoomId);
		Long bedId = custCheckInRoomOld.getBedId();
		// 修改床位状态为“空脏”
		if (bedId != null) {
			roomBedDAO.updateState(bedId, "5");
		} else {// 修改客房状态为"空脏房"
			merRoomDAO.updateState(custCheckInRoomOld.getRoomId(), "3");
		}
		
		/**
		 * 删除原来的入住客房记录
		 */
		//custCheckInRoomDAO.deleteById(CustCheckInRoom.class, custCheckInRoomId);
		// BeanUtils.copyProperties
		// PropertyUtils.copyProperties(custCheckInRoomDAO.getById(CustCheckInRoom.class, custCheckInRoomId), custCheckInRoom);
		
		/**
		 * 换房信息
		 */
		custCheckInRoomOld.setRoomId(custCheckInRoomNew.getRoomId());
		custCheckInRoomOld.setRoomNo(custCheckInRoomNew.getRoomNo());
		custCheckInRoomOld.setBedId(custCheckInRoomNew.getBedId());
		custCheckInRoomOld.setBedNo(custCheckInRoomNew.getBedNo());
		custCheckInRoomOld.setRegistPrice(custCheckInRoomNew.getRegistPrice());
		custCheckInRoomOld.setDiscount(custCheckInRoomNew.getDiscount());
		custCheckInRoomOld.setAmount(custCheckInRoomNew.getAmount());
		custCheckInRoomDAO.update(custCheckInRoomOld);
		
		/**
		 * 新的客房状态信息
		 */
		bedId = custCheckInRoomNew.getBedId();
		// 修改床位在住
		if (bedId != null) {
			roomBedDAO.updateState(bedId, "0");
		} else {// 客房在住
			merRoomDAO.updateState(custCheckInRoomNew.getRoomId(), "2");
		}
		
		/**
		 * 换房记录
		 */ 
		exchangeRoom.setExchangeTime(new Timestamp(new Date().getTime()));
		exchangeRoomDAO.save(exchangeRoom);
		return true;
	}
}
