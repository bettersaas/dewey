package com.dewey.his.reception.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.param.model.RoomType;
import com.dewey.his.reception.model.CheckIn;
import com.dewey.his.reception.model.CustCheckInRoom;
import common.base.dao.hibernate3.Hibernate3Dao;
import common.base.model.vo.PagerVO;

@Repository("checkInDAO")
public class CheckInDAO extends Hibernate3Dao {

	@SuppressWarnings("unchecked")
	public List<CustCheckInRoom> findCustCheckInRoomPagerListBySearch(PagerVO pager, Long merId,String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo, String contractualUnitName, Date planDepartureDateStart,Date planDepartureDateEnd) {
		List<CustCheckInRoom> rtnList = new ArrayList<CustCheckInRoom>();
		StringBuffer queryAllString = new StringBuffer("select count(*)  from ");
		StringBuffer queryPagerString = new StringBuffer("select checkInRoom,checkIn,roomType from ");
		StringBuffer queryString = new StringBuffer(" CustCheckInRoom as checkInRoom, CheckIn as checkIn, RoomType as roomType" + 
				" where checkInRoom.checkIn = checkIn  and checkIn.roomType=roomType and checkInRoom.merId=:merId ");
		if (custName != null && !"".equals(custName.trim())) {
			queryString.append(" and checkIn.custName like :custName ");
		}
		if (idNo != null && !"".equals(idNo.trim())) {
			queryString.append(" and checkIn.idNo=:idNo ");
		}
		if (lcdStart != null) {
			queryString.append(" and checkIn.lcd>=:lcdStart ");
		}
		if (lcdEnd != null) {
			queryString.append(" and checkIn.lcd<=:lcdEnd ");
		}
		if (status != null && !"".equals(status.trim())) {
			queryString.append(" and checkIn.status=:status ");
		}
		if (roomNo != null && !"".equals(roomNo.trim())) {
			queryString.append(" and checkInRoom.roomNo=:roomNo ");
		}
		if (contractualUnitName != null && !"".equals(contractualUnitName.trim())) {
			queryString.append(" and checkIn.contractualUnitName like :contractualUnitName ");
		}
		if (planDepartureDateStart != null) {
			queryString.append(" and checkIn.planDepartureDate>=:planDepartureDateStart ");
		}
		if (planDepartureDateEnd != null) {
			queryString.append(" and checkIn.planDepartureDate<=:planDepartureDateEnd ");
		}
		queryAllString.append(queryString);
		queryPagerString.append(queryString);
		// 排序
		queryPagerString.append(" order by  checkIn.id desc,roomType.id asc ");
		// 查询总数
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryAllString.toString());
		queryObject.setLong("merId", merId);
		if (custName != null && !"".equals(custName.trim())) {
			queryObject.setString("custName", "%" + custName.trim() + "%");
		}
		if (idNo != null && !"".equals(idNo.trim())) {
			queryObject.setString("idNo", idNo.trim());
		}
		if (lcdStart != null) {
			queryObject.setTimestamp("lcdStart", lcdStart);
		}
		if (lcdEnd != null) {
			queryObject.setTimestamp("lcdEnd", lcdEnd);
		}
		if (status != null && !"".equals(status.trim())) {
			queryObject.setString("status", status.trim());
		}
		if (roomNo != null && !"".equals(roomNo.trim())) {
			queryObject.setString("roomNo", roomNo.trim());
		}
		if (contractualUnitName != null && !"".equals(contractualUnitName.trim())) {
			queryObject.setString("contractualUnitName", "%" + contractualUnitName.trim() + "%");
		}
		if (planDepartureDateStart != null) {
			queryObject.setTimestamp("planDepartureDateStart", planDepartureDateStart);
		}
		if (planDepartureDateEnd != null) {
			queryObject.setTimestamp("planDepartureDateEnd", planDepartureDateEnd);
		}
		Long countAll  =  (Long)queryObject.uniqueResult();
		pager.setCountAll(countAll.intValue());
		
		// 分页记录列表
		queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryPagerString.toString());
		queryObject.setLong("merId", merId);
		if (custName != null && !"".equals(custName.trim())) {
			queryObject.setString("custName", "%" + custName.trim() + "%");
		}
		if (idNo != null && !"".equals(idNo.trim())) {
			queryObject.setString("idNo", idNo.trim());
		}
		if (lcdStart != null) {
			queryObject.setTimestamp("lcdStart", lcdStart);
		}
		if (lcdEnd != null) {
			queryObject.setTimestamp("lcdEnd", lcdEnd);
		}
		if (status != null && !"".equals(status.trim())) {
			queryObject.setString("status", status.trim());
		}
		if (roomNo != null && !"".equals(roomNo.trim())) {
			queryObject.setString("roomNo", roomNo.trim());
		}
		if (contractualUnitName != null && !"".equals(contractualUnitName.trim())) {
			queryObject.setString("contractualUnitName", "%" + contractualUnitName.trim() + "%");
		}
		if (planDepartureDateStart != null) {
			queryObject.setTimestamp("planDepartureDateStart", planDepartureDateStart);
		}
		if (planDepartureDateEnd != null) {
			queryObject.setTimestamp("planDepartureDateEnd", planDepartureDateEnd);
		}
		// 结果全部封装到入住客房对象中去
		queryObject.setFirstResult(pager.getOffset());
		queryObject.setMaxResults(pager.getLimit());
		List<Object[]> list = queryObject.list();
		for (Object[] objectArray : list) {
			CustCheckInRoom checkInRoom = (CustCheckInRoom)objectArray[0];
			CheckIn checkIn = (CheckIn)objectArray[1];
			RoomType roomType = (RoomType)objectArray[2];
			checkIn.setRoomType(roomType);
			checkInRoom.setCheckIn(checkIn);
			rtnList.add(checkInRoom);
		}
		return rtnList;
	}
	
	@SuppressWarnings("unchecked")
	public List<CheckIn> findCheckInPagerListBySearch(PagerVO pager, Long merId,String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo, String contractualUnitName, Date planDepartureDateStart,Date planDepartureDateEnd) {
		StringBuffer queryAllString = new StringBuffer("select count(distinct checkIn)  from ");
		StringBuffer queryPagerString = new StringBuffer("select distinct checkIn from ");
		StringBuffer queryString = new StringBuffer(" CustCheckInRoom as checkInRoom, CheckIn as checkIn, RoomType as roomType" + 
				" where checkInRoom.checkIn = checkIn  and checkIn.roomType=roomType and checkInRoom.merId=:merId ");
		if (custName != null && !"".equals(custName.trim())) {
			queryString.append(" and checkIn.custName like :custName ");
		}
		if (idNo != null && !"".equals(idNo.trim())) {
			queryString.append(" and checkIn.idNo=:idNo ");
		}
		if (lcdStart != null) {
			queryString.append(" and checkIn.lcd>=:lcdStart ");
		}
		if (lcdEnd != null) {
			queryString.append(" and checkIn.lcd<=:lcdEnd ");
		}
		if (status != null && !"".equals(status.trim())) {
			queryString.append(" and checkIn.status=:status ");
		}
		if (roomNo != null && !"".equals(roomNo.trim())) {
			queryString.append(" and checkInRoom.roomNo=:roomNo ");
		}
		if (contractualUnitName != null && !"".equals(contractualUnitName.trim())) {
			queryString.append(" and checkIn.contractualUnitName like :contractualUnitName ");
		}
		if (planDepartureDateStart != null) {
			queryString.append(" and checkIn.planDepartureDate>=:planDepartureDateStart ");
		}
		if (planDepartureDateEnd != null) {
			queryString.append(" and checkIn.planDepartureDate<=:planDepartureDateEnd ");
		}
		queryAllString.append(queryString);
		queryPagerString.append(queryString);
		// 排序
		queryPagerString.append(" order by  checkIn.id desc ");
		// 查询总数
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryAllString.toString());
		queryObject.setLong("merId", merId);
		if (custName != null && !"".equals(custName.trim())) {
			queryObject.setString("custName", "%" + custName.trim() + "%");
		}
		if (idNo != null && !"".equals(idNo.trim())) {
			queryObject.setString("idNo", idNo.trim());
		}
		if (lcdStart != null) {
			queryObject.setTimestamp("lcdStart", lcdStart);
		}
		if (lcdEnd != null) {
			queryObject.setTimestamp("lcdEnd", lcdEnd);
		}
		if (status != null && !"".equals(status.trim())) {
			queryObject.setString("status", status.trim());
		}
		if (roomNo != null && !"".equals(roomNo.trim())) {
			queryObject.setString("roomNo", roomNo.trim());
		}
		if (contractualUnitName != null && !"".equals(contractualUnitName.trim())) {
			queryObject.setString("contractualUnitName", "%" + contractualUnitName.trim() + "%");
		}
		if (planDepartureDateStart != null) {
			queryObject.setTimestamp("planDepartureDateStart", planDepartureDateStart);
		}
		if (planDepartureDateEnd != null) {
			queryObject.setTimestamp("planDepartureDateEnd", planDepartureDateEnd);
		}
		Long countAll  =  (Long)queryObject.uniqueResult();
		pager.setCountAll(countAll.intValue());
		
		// 分页记录列表
		queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryPagerString.toString());
		queryObject.setLong("merId", merId);
		if (custName != null && !"".equals(custName.trim())) {
			queryObject.setString("custName", "%" + custName.trim() + "%");
		}
		if (idNo != null && !"".equals(idNo.trim())) {
			queryObject.setString("idNo", idNo.trim());
		}
		if (lcdStart != null) {
			queryObject.setTimestamp("lcdStart", lcdStart);
		}
		if (lcdEnd != null) {
			queryObject.setTimestamp("lcdEnd", lcdEnd);
		}
		if (status != null && !"".equals(status.trim())) {
			queryObject.setString("status", status.trim());
		}
		if (roomNo != null && !"".equals(roomNo.trim())) {
			queryObject.setString("roomNo", roomNo.trim());
		}
		if (contractualUnitName != null && !"".equals(contractualUnitName.trim())) {
			queryObject.setString("contractualUnitName", "%" + contractualUnitName.trim() + "%");
		}
		if (planDepartureDateStart != null) {
			queryObject.setTimestamp("planDepartureDateStart", planDepartureDateStart);
		}
		if (planDepartureDateEnd != null) {
			queryObject.setTimestamp("planDepartureDateEnd", planDepartureDateEnd);
		}
		// 结果全部封装到入住客房对象中去
		queryObject.setFirstResult(pager.getOffset());
		queryObject.setMaxResults(pager.getLimit());
		List<CheckIn> list = queryObject.list();
//		for (Object[] objectArray : list) {
//			CustCheckInRoom checkInRoom = (CustCheckInRoom)objectArray[0];
//			CheckIn checkIn = (CheckIn)objectArray[1];
//			RoomType roomType = (RoomType)objectArray[2];
//			checkIn.setRoomType(roomType);
//			checkInRoom.setCheckIn(checkIn);
//			rtnList.add(checkInRoom);
//		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<CustCheckInRoom> findCustCheckInRoomListBySearch(Long merId,String custName, String idNo, Date lcdStart, Date lcdEnd, String status, String roomNo, String contractualUnitName, Date planDepartureDateStart,Date planDepartureDateEnd) {
		List<CustCheckInRoom> rtnList = new ArrayList<CustCheckInRoom>();
		StringBuffer queryString = new StringBuffer("select checkInRoom,checkIn,roomType from " 
				+ " CustCheckInRoom as checkInRoom, CheckIn as checkIn, RoomType as roomType" 
				+ " where checkInRoom.checkIn = checkIn  and checkIn.roomType=roomType and checkInRoom.merId=:merId ");
		if (custName != null && !"".equals(custName.trim())) {
			queryString.append(" and checkIn.custName like :custName ");
		}
		if (idNo != null && !"".equals(idNo.trim())) {
			queryString.append(" and checkIn.idNo=:idNo ");
		}
		if (lcdStart != null) {
			queryString.append(" and checkIn.lcd>=:lcdStart ");
		}
		if (lcdEnd != null) {
			queryString.append(" and checkIn.lcd<=:lcdEnd ");
		}
		if (status != null && !"".equals(status.trim())) {
			queryString.append(" and checkIn.status=:status ");
		}
		if (roomNo != null && !"".equals(roomNo.trim())) {
			queryString.append(" and checkInRoom.roomNo=:roomNo ");
		}
		if (contractualUnitName != null && !"".equals(contractualUnitName.trim())) {
			queryString.append(" and checkIn.contractualUnitName like :contractualUnitName ");
		}
		if (planDepartureDateStart != null) {
			queryString.append(" and checkIn.planDepartureDate>=:planDepartureDateStart ");
		}
		if (planDepartureDateEnd != null) {
			queryString.append(" and checkIn.planDepartureDate<=:planDepartureDateEnd ");
		}
		// 排序
		queryString.append(" order by  checkIn.id desc,roomType.id asc ");
		// 查询总数
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString.toString());
		queryObject.setLong("merId", merId);
		if (custName != null && !"".equals(custName.trim())) {
			queryObject.setString("custName", "%" + custName.trim() + "%");
		}
		if (idNo != null && !"".equals(idNo.trim())) {
			queryObject.setString("idNo", idNo.trim());
		}
		if (lcdStart != null) {
			queryObject.setTimestamp("lcdStart", lcdStart);
		}
		if (lcdEnd != null) {
			queryObject.setTimestamp("lcdEnd", lcdEnd);
		}
		if (status != null && !"".equals(status.trim())) {
			queryObject.setString("status", status.trim());
		}
		if (roomNo != null && !"".equals(roomNo.trim())) {
			queryObject.setString("roomNo", roomNo.trim());
		}
		if (contractualUnitName != null && !"".equals(contractualUnitName.trim())) {
			queryObject.setString("contractualUnitName", "%" + contractualUnitName.trim() + "%");
		}
		if (planDepartureDateStart != null) {
			queryObject.setTimestamp("planDepartureDateStart", planDepartureDateStart);
		}
		if (planDepartureDateEnd != null) {
			queryObject.setTimestamp("planDepartureDateEnd", planDepartureDateEnd);
		}
		List<Object[]> list = queryObject.list();
		for (Object[] objectArray : list) {
			CustCheckInRoom checkInRoom = (CustCheckInRoom)objectArray[0];
			CheckIn checkIn = (CheckIn)objectArray[1];
			RoomType roomType = (RoomType)objectArray[2];
			checkIn.setRoomType(roomType);
			checkInRoom.setCheckIn(checkIn);
			rtnList.add(checkInRoom);
		}
		return rtnList;
	}
	
	@SuppressWarnings("unchecked")
	public PagerVO getPageCheckIn(CheckIn checkIn,Integer pageNo,Integer pageSize){
		// 取得请求页的数据
		PagerVO pager = new PagerVO(pageNo, pageSize);
		// 总记录数查询语句
		StringBuffer hqlCount = new StringBuffer("select count(checkIn) from CheckIn checkIn where 1=1 ");
		// 分页记录查询语句
		StringBuffer hql = new StringBuffer(" from CheckIn checkIn where 1=1 ");
		String custName= checkIn.getCustName();
		if(null!=custName && !"".equals(custName)) {
			hqlCount.append(" and checkIn.custName like '%").append(custName).append("%' ");
			hql.append(" and checkIn.custName like '%").append(custName).append("%' ");
		}
		if(checkIn.getRoomType()!=null) {
			hqlCount.append(" and checkIn.roomType.id=").append(checkIn.getRoomType().getId());
			hql.append(" and checkIn.roomType.id=").append(checkIn.getRoomType().getId());
		}
		// 总记录数
		Integer sumCount = (Integer) this.getSessionFactory().getCurrentSession().createQuery(hqlCount.toString()).uniqueResult();
		logger.info("总记录数为：" + sumCount);
		pager.setCountAll(sumCount);
		
		Query query =  this.getSessionFactory().getCurrentSession().createQuery(hql.toString());
		// = , Integer currentPage, Integer perPageRows
		query.setFirstResult(pager.getOffset());   // (currentPage - 1) * perPageRows
		query.setMaxResults(pager.getLimit());   // perPageRows
		
		List<CheckIn> list = query.list();
		for (CheckIn checkIn2 : list) {
			System.out.println("=");
			Hibernate.initialize(checkIn2.getRoomType());
		}
		// 设置分页显示的List数据
		pager.setPagerList(list);
		
		return pager;
	}
}