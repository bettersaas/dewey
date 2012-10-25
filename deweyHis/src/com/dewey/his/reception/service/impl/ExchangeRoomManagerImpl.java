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
//	 * ��ס�Ǽ�
//	 */
//	private CheckInDAO checkInDAO;
//
//	public void setCheckInDAO(CheckInDAO checkInDAO) {
//		this.checkInDAO = checkInDAO;
//	}
	
	/**
	 * ��ס�ͷ�
	 */
	private CustCheckInRoomDAO custCheckInRoomDAO;
	
	public void setCustCheckInRoomDAO(CustCheckInRoomDAO custCheckInRoomDAO) {
		this.custCheckInRoomDAO = custCheckInRoomDAO;
	}
	
	/**
	 * ��λ��Ϣ
	 */
	private RoomBedDAO roomBedDAO;
	
	public void setRoomBedDAO(RoomBedDAO roomBedDAO) {
		this.roomBedDAO = roomBedDAO;
	}
	
	/**
	 * �̻��ͷ���Ϣ
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
	 * �����ľ������
	 * @throws Exception 
	 */
	public boolean  exchangeRoomAction(Long checkInId,Long custCheckInRoomId,ExchangeRoom exchangeRoom,CustCheckInRoom custCheckInRoomNew) throws  Exception {
		
		/**
		 * ԭ���Ŀͷ�
		 */ 
		CustCheckInRoom custCheckInRoomOld = (CustCheckInRoom)custCheckInRoomDAO.getById(CustCheckInRoom.class,custCheckInRoomId);
		Long bedId = custCheckInRoomOld.getBedId();
		// �޸Ĵ�λ״̬Ϊ�����ࡱ
		if (bedId != null) {
			roomBedDAO.updateState(bedId, "5");
		} else {// �޸Ŀͷ�״̬Ϊ"���෿"
			merRoomDAO.updateState(custCheckInRoomOld.getRoomId(), "3");
		}
		
		/**
		 * ɾ��ԭ������ס�ͷ���¼
		 */
		//custCheckInRoomDAO.deleteById(CustCheckInRoom.class, custCheckInRoomId);
		// BeanUtils.copyProperties
		// PropertyUtils.copyProperties(custCheckInRoomDAO.getById(CustCheckInRoom.class, custCheckInRoomId), custCheckInRoom);
		
		/**
		 * ������Ϣ
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
		 * �µĿͷ�״̬��Ϣ
		 */
		bedId = custCheckInRoomNew.getBedId();
		// �޸Ĵ�λ��ס
		if (bedId != null) {
			roomBedDAO.updateState(bedId, "0");
		} else {// �ͷ���ס
			merRoomDAO.updateState(custCheckInRoomNew.getRoomId(), "2");
		}
		
		/**
		 * ������¼
		 */ 
		exchangeRoom.setExchangeTime(new Timestamp(new Date().getTime()));
		exchangeRoomDAO.save(exchangeRoom);
		return true;
	}
}
