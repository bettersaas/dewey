package com.dewey.his.param.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.support.GenericXmlContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.common.model.Mer;
import com.dewey.his.param.dao.RoomTypeDAO;
import com.dewey.his.param.model.RoomType;
import com.dewey.his.param.service.RoomTypeManager;

@Service("roomTypeManager")
@Scope("singleton")
@Transactional
public class RoomTypeManagerImpl implements RoomTypeManager {

	private RoomTypeDAO roomTypeDAO;

	public void setRoomTypeDAO(RoomTypeDAO roomTypeDAO) {
		this.roomTypeDAO = roomTypeDAO;
	}

	@Transactional
	public Long save(RoomType transientInstance) {
		return roomTypeDAO.save(transientInstance);
	}

	@Transactional
	public void update(RoomType transientInstance) {
		roomTypeDAO.update(transientInstance);
	}

	@Transactional
	public int deleteById(long id) {
		return roomTypeDAO.deleteById(RoomType.class,id);
	}

	@Transactional(readOnly = true)
	public List<RoomType> findMerAllRoomType(long merId) {
		return roomTypeDAO.findMerAllRoomType(merId);
	}
	
	@Transactional(readOnly = true)
	public List<RoomType> getByMerRoomTypeName(long merId,String roomTypeName) {
		return roomTypeDAO.getByMerRoomTypeName(merId, roomTypeName);
	}
	
	@Transactional(readOnly = true)
	public RoomType getById(long id) {
		return (RoomType)roomTypeDAO.getById(RoomType.class,id);
	}

	/**
	 * 测试主函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String resource = "classpath:/spring/*-resource.xml";
		String dao = "classpath:/spring/*-dao.xml";
		String service = "classpath:/spring/*-service.xml";
		ApplicationContext applicationContext = new GenericXmlContextLoader().loadContext(resource, dao, service);
		RoomTypeManager roomTypeManager = (RoomTypeManager) applicationContext.getBean("roomTypeManager");

		 RoomType roomType = new RoomType();
		 Mer mer = new Mer();
		 mer.setId(1L);
		 roomType.setMer(mer);
		 roomType.setName("豪华单间");
		 roomType.setRoomTypeDesc("豪华单间");
		 roomType.setComment("豪华单间");
		 roomType.setAlldayPrice(12.76);
		 System.out.println(roomTypeManager.save(roomType));

		// roomTypeManager.deleteById(1);

//		List<?> ls = roomTypeManager.findMerAllRoomType(1);
//		for (int i = 0; i < ls.size(); i++) {
//			RoomType ry = (RoomType) ls.get(i);
//			System.out.println(ry.getId() + "                " + ry.getName());
//			ry.setName("总统套房");
//			roomTypeManager.update(ry);
//		}
		
//		System.out.println((roomTypeManager.getById(2).getName()));
	}
}
