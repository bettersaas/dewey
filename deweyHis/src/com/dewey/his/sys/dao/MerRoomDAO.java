package com.dewey.his.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.param.model.RoomType;
import com.dewey.his.sys.model.MerRoom;
import com.dewey.his.sys.model.RoomBed;

import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("merRoomDAO")
public class MerRoomDAO extends Hibernate3Dao {
	
	public int updateState(Long id, String state) {
		String queryString = "update MerRoom set state=:state  where id = :id ";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setLong("id", id);
		query.setString("state", state);
		return query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<MerRoom> findMerAllMerRoom(long merId) {
		String queryString = "from MerRoom as model where model.mer.id= ? order by id";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		return queryObject.list();
	}
	
	public MerRoom getByRoomNo(Long merId,String roomNo) {
		String queryString = "from MerRoom as model where model.mer.id= ? and model.roomNo= ?";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		queryObject.setParameter(1, roomNo);
		return (MerRoom)queryObject.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<MerRoom> findMerAllRoomTypeRooms(long merRoomTypeId) {
		String queryString = "from MerRoom as model where model.roomType.id= ? order by id";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merRoomTypeId);
		return queryObject.list();
	}
	
	/**
	 * 获得商户特定房态的房子列表信息
	 * @param merId
	 * @param optMerRoomTypeId  可选的商户房型
	 * @param optState                     可选的房间状态
	 * @param optHireFlag
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MerRoom>  findMerSpecifyStateAllRooms(Long  merId, Long optMerRoomTypeId, String optState, String optHireFlag) {
		StringBuffer queryString = new StringBuffer("from MerRoom as model where model.mer.id=:id");
		if (optMerRoomTypeId != null) {
			queryString.append(" and model.roomType.id= :merRoomTypeId");
		}
		if (optState != null) {
			queryString.append(" and model.state=:state ");
		}
		if (optHireFlag != null) {
			queryString.append(" and model.hireFlag=:hireFlag ");
		}
		queryString.append(" order by model.roomType.id,model.id ");
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString.toString());
		queryObject.setParameter("id", merId);
		if (optMerRoomTypeId != null) {
			queryObject.setParameter("merRoomTypeId", optMerRoomTypeId);
		}
		if (optState != null) {
			queryObject.setParameter("state", optState);
		}
		if (optHireFlag != null) {
			queryObject.setParameter("hireFlag", optHireFlag);
		}
		return queryObject.list();
	}
	
	/**
	 * 获得商户特定房态的房子床位列表信息
	 * @param merId
	 * @param optMerRoomTypeId
	 * @param roomState
	 * @param bedUseFlag
	 * @param hireFlag
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<RoomBed>  findMerEmptyCleanAllRoomBeds(Long  merId, String optRoomNo,Long optMerRoomTypeId, String roomState, String bedUseFlag, String hireFlag) {
		List<RoomBed> roomBeds = new ArrayList<RoomBed>();
		StringBuffer queryString = new StringBuffer("select room,bed,roomType from MerRoom as room,RoomBed as bed,RoomType as roomType " +
				" where  bed.merRoom=room and room.roomType=roomType and room.mer.id=:id " +
				" and room.state=:state " +
				" and room.hireFlag=:hireFlag " +
				" and bed.useFlag=:bedUseFlag ");
		if (optRoomNo != null && !"".equals(optRoomNo.trim())) {
			queryString.append(" and room.roomNo=:roomNo");
		}
		if (optMerRoomTypeId != null) {
			queryString.append(" and room.roomType.id=:merRoomTypeId");
		}
		queryString.append(" order by room.roomType.id,room.id ");
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString.toString());
		queryObject.setParameter("id", merId);
		if (optRoomNo != null && !"".equals(optRoomNo.trim())) {
			queryObject.setParameter("roomNo", optRoomNo);
		}
		if (optMerRoomTypeId != null) {
			queryObject.setParameter("merRoomTypeId", optMerRoomTypeId);
		}
		queryObject.setParameter("bedUseFlag", bedUseFlag);
		queryObject.setParameter("state", roomState);
		queryObject.setParameter("hireFlag", hireFlag);
		List<Object[]> list = queryObject.list();
		for (Object[] roomAndBed : list) {
			MerRoom room = (MerRoom)roomAndBed[0];
			RoomBed bed = (RoomBed)roomAndBed[1];
			RoomType roomType = (RoomType)roomAndBed[2];
			room.setRoomType(roomType);
			bed.setMerRoom(room);
			roomBeds.add(bed);
		}
		return roomBeds;
	}
}
