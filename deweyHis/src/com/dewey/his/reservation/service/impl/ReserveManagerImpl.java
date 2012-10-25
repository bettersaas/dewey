package com.dewey.his.reservation.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.support.GenericXmlContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.reception.dao.CheckInDAO;
import com.dewey.his.reception.dao.ForegiftDAO;
import com.dewey.his.reception.model.CheckIn;
import com.dewey.his.reception.model.CustCheckInRoom;
import com.dewey.his.reception.model.Foregift;
//import com.dewey.his.reception.service.CheckInManager;
import com.dewey.his.reservation.service.ReserveManager;
import com.dewey.his.sys.dao.MerRoomDAO;
import com.dewey.his.sys.dao.RoomBedDAO;
import common.base.model.vo.PagerVO;

@Service("reserveManager")
@Scope("singleton")
@Transactional
public class ReserveManagerImpl implements ReserveManager {

	private CheckInDAO checkInDAO;
	
	private MerRoomDAO merRoomDAO;
	
	private ForegiftDAO foregiftDAO;
	
	private RoomBedDAO roomBedDAO;

	public void setRoomBedDAO(RoomBedDAO roomBedDAO) {
		this.roomBedDAO = roomBedDAO;
	}

	public void setForegiftDAO(ForegiftDAO foregiftDAO) {
		this.foregiftDAO = foregiftDAO;
	}

	public void setMerRoomDAO(MerRoomDAO merRoomDAO) {
		this.merRoomDAO = merRoomDAO;
	}

	public void setCheckInDAO(CheckInDAO checkInDAO) {
		this.checkInDAO = checkInDAO;
	}

	@Transactional(readOnly = true)
	public CheckIn getById(long id) {
		return (CheckIn)checkInDAO.getById(CheckIn.class,id);
	}
	
	public void update(CheckIn checkIn) {
		checkInDAO.update(checkIn);
	}
	
	@Transactional(readOnly = true)
	public PagerVO getPageCheckIn(CheckIn checkIn,Integer pageNo,Integer pageSize) {
		return checkInDAO.getPageCheckIn(checkIn, pageNo, pageSize);
	}

	public Long checkInRoomSetDoorCard(CheckIn checkIn) {
		// �޸ķ���״̬Ϊ��ס��״̬
		List<CustCheckInRoom>  checkInRooms = checkIn.getCustCheckInRooms();
		for (CustCheckInRoom checkInRoom:checkInRooms)  {
			Long roomId = checkInRoom.getRoomId();
			Long bedId = checkInRoom.getBedId();
			if (bedId == null && roomId != null) {
				// �ͷ���ס
				merRoomDAO.updateState(roomId, "2");
			} else if(bedId != null){
				// ��λ��ס
				roomBedDAO.updateState(bedId, "0");
			}
			checkInRoom.setCheckIn(checkIn);
			// ���ֵ����Ա��Ϣ
			checkInRoom.setMerOnDutyUserId(checkIn.getMerOnDutyUserId());
			checkInRoom.setMerOnDutyUserName(checkIn.getMerOnDutyUserName());
		}
		// ����
		if (checkIn.getPeopleNum() == null) {
			checkIn.setPeopleNum(checkInRooms.size());
		}
		// ������ס��¼
		Long checkInId =  checkInDAO.save(checkIn);
		if (checkIn.getDeposit() != null && checkIn.getDeposit() > 0) {
			// ��ȡѺ��
			Foregift foregift = new Foregift();
			foregift.setMerId(checkIn.getMer().getId());
			CustCheckInRoom cust = checkIn.getCustCheckInRooms().get(0);
			foregift.setCustCheckInRoom(cust);
			foregift.setRoomNo(cust.getRoomNo());
			foregift.setPayAmount(checkIn.getDeposit());
			foregift.setMerUserId(checkIn.getMerOnDutyUserId());
			foregift.setMerUserName(checkIn.getMerOnDutyUserName());
			foregift.setPayType(checkIn.getSettleMode());
			foregiftDAO.save(foregift);
		}
		return checkInId;
	}
	
	@Transactional(readOnly = true)
	public List<CustCheckInRoom> findCustCheckInRoomPagerListBySearch(PagerVO pager,Long merId, String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo, String contractualUnitName,
			Date planDepartureDateStart,Date planDepartureDateEnd) {
		return checkInDAO.findCustCheckInRoomPagerListBySearch(pager,merId, custName, idNo, lcdStart, lcdEnd, status, roomNo, contractualUnitName, planDepartureDateStart, planDepartureDateEnd);
	}
	
	@Transactional(readOnly = true)
	public List<CheckIn> findCheckInPagerListBySearch(PagerVO pager, Long merId, String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo,
			String contractualUnitName, Date planDepartureDateStart, Date planDepartureDateEnd) {
		return checkInDAO.findCheckInPagerListBySearch(pager,merId, custName, idNo, lcdStart, lcdEnd, status, roomNo, contractualUnitName, planDepartureDateStart, planDepartureDateEnd);
	}
	
	@Transactional(readOnly = true)
	public List<CustCheckInRoom> findCustCheckInRoomListBySearch(Long merId, String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo,
			String contractualUnitName, Date planDepartureDateStart, Date planDepartureDateEnd) {
		return checkInDAO.findCustCheckInRoomListBySearch(merId, custName, idNo, lcdStart, lcdEnd, status, roomNo, contractualUnitName, planDepartureDateStart, planDepartureDateEnd);
	}
	
	/**
	 * ����������
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String resource = "classpath:/spring/*-resource.xml";
		String dao = "classpath:/spring/*-dao.xml";
		String service = "classpath:/spring/*-service.xml";
		ApplicationContext applicationContext = new GenericXmlContextLoader().loadContext(resource, dao, service);
		ReserveManager checkInManager = (ReserveManager) applicationContext.getBean("ReserveManager");
//		List<CustCheckInRoom> rooms = checkInManager.findCheckInListBySearch(1L, null, null, null, null, null, null, null, null, null);
//		for(CustCheckInRoom room  :  rooms) {
//			CheckIn checkIn = room.getCheckIn();
//			System.out.println("����ţ�" + room.getRoomNo() + "   ��λ�ţ�"  + room.getBedNo() + "���ͣ�" + checkIn.getRoomType().getName()); // + merRomm.getRoomType().getName()
//		}
		
		// ��ҳ��ѯ��ס�ͷ�
		PagerVO pager1 = new PagerVO(2,1);
		List<CustCheckInRoom> rooms1 = checkInManager.findCustCheckInRoomPagerListBySearch(pager1, 1L, null, null, null, null, null, null, null, null, null);
		for(CustCheckInRoom room  :  rooms1) {
			CheckIn checkIn = room.getCheckIn();
			System.out.println("����ţ�" + room.getRoomNo() + "   ��λ�ţ�"  + room.getBedNo() + "���ͣ�" + checkIn.getRoomType().getName()); // + merRomm.getRoomType().getName()
		}
		
		// ��ҳ��ѯ
		PagerVO pager2 = new PagerVO(1,15);
		List<CheckIn> rooms2 = checkInManager.findCheckInPagerListBySearch(pager2, 1L, null, null, null, null, null, null, null, null, null);
		for(CheckIn checkIn  :  rooms2) {
			System.out.println("�ͻ����ƣ�" + checkIn.getCustName() + "   Э�鵥λ��"  + checkIn.getContractualUnitName());
		}
	}
}