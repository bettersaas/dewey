package com.dewey.his.reception.service;

import java.util.Date;
import java.util.List;

import com.dewey.his.reception.model.CheckIn;
import com.dewey.his.reception.model.CustCheckInRoom;

import common.base.model.vo.PagerVO;

public interface CheckInManager {

	public CheckIn getById(long id);
	
	public void update(CheckIn checkIn);

	/**
	 * 分页查询入住记录
	 * 
	 * @param checkIn
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public PagerVO getPageCheckIn(CheckIn checkIn, Integer pageNo, Integer pageSize);

	/**
	 * 订房制卡
	 * 
	 * @param checkIn
	 * @return
	 */
	public Long checkInRoomSetDoorCard(CheckIn checkIn);

	/**
	 * 查询分页旅客入住客房列表
	 * 
	 * @param merId
	 * @param custName
	 * @param idNo
	 * @param lcd
	 * @param status
	 * @param roomNo
	 * @param contractualUnitCompany
	 * @param planDepartureDate
	 * @return
	 */
	public List<CustCheckInRoom> findCustCheckInRoomPagerListBySearch(PagerVO pager,Long merId, String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo, String contractualUnitName,
			Date planDepartureDateStart,Date planDepartureDateEnd);
	
	/**
	 * 查询分页旅客入住登记列表
	 * 
	 * @param pager
	 * @param merId
	 * @param custName
	 * @param idNo
	 * @param lcdStart
	 * @param lcdEnd
	 * @param status
	 * @param roomNo
	 * @param contractualUnitName
	 * @param planDepartureDateStart
	 * @param planDepartureDateEnd
	 * @return
	 */
	public List<CheckIn> findCheckInPagerListBySearch(PagerVO pager,Long merId, String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo, String contractualUnitName,
			Date planDepartureDateStart,Date planDepartureDateEnd);
	
	/**
	 * 查询全部旅客列表
	 * 
	 * @param merId
	 * @param custName
	 * @param idNo
	 * @param lcd
	 * @param status
	 * @param roomNo
	 * @param contractualUnitCompany
	 * @param planDepartureDate
	 * @return
	 */
	public List<CustCheckInRoom> findCustCheckInRoomListBySearch(Long merId, String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo, String contractualUnitName,
			Date planDepartureDateStart,Date planDepartureDateEnd);
}