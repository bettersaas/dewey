package com.dewey.his.sys.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.support.GenericXmlContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.sys.dao.MerRoomDAO;
import com.dewey.his.sys.dao.RoomBedDAO;
import com.dewey.his.sys.model.MerRoom;
import com.dewey.his.sys.model.RoomBed;
import com.dewey.his.sys.service.MerRoomManager;

@Service("merRoomManager")
@Scope("singleton")
@Transactional
public class MerRoomManagerImpl implements MerRoomManager {
	
	private MerRoomDAO merRoomDAO;

	public void setMerRoomDAO(MerRoomDAO merRoomDAO) {
		this.merRoomDAO = merRoomDAO;
	}
	
	private RoomBedDAO roomBedDAO;

	public void setRoomBedDAO(RoomBedDAO roomBedDAO) {
		this.roomBedDAO = roomBedDAO;
	}

	public int deleteById(long id) {
		return merRoomDAO.deleteById(MerRoom.class,id);
	}
	
	public int updateState(Long id, String state) {
		return merRoomDAO.updateState(id, state);
	}

	@Transactional(readOnly = true)
	public List<MerRoom> findMerAllMerRoom(long merId) {
		return merRoomDAO.findMerAllMerRoom(merId);
	}

	@Transactional(readOnly = true)
	public List<MerRoom> findMerAllRoomTypeRooms(long merRoomTypeId) {
		return merRoomDAO.findMerAllRoomTypeRooms(merRoomTypeId);
	}
	
	@Transactional(readOnly = true)
	public List<MerRoom> findMerEmptyCleanRooms(Long merId,Long optMerRoomTypeId){
		// �վ�����״̬Ϊ5  ���������0
		return merRoomDAO.findMerSpecifyStateAllRooms(merId, optMerRoomTypeId, "5", "0");
	}
	
	@Transactional(readOnly = true)
	public List<RoomBed> findMerEmptyCleanRoomBeds(Long merId,String optRoomNo,Long optMerRoomTypeId){
		// �վ�����״̬Ϊ5  ��λ����վ�״̬Ϊ4  ����λ����1
		return merRoomDAO.findMerEmptyCleanAllRoomBeds(merId, optRoomNo,optMerRoomTypeId, "5",  "4", "1");
	}
	
	@Transactional(readOnly = true)
	public MerRoom getByRoomNo(Long merId,String roomNo) {
		return merRoomDAO.getByRoomNo(merId,roomNo);
	}

	@Transactional(readOnly = true)
	public MerRoom getById(long id) {
		return (MerRoom)merRoomDAO.getById(MerRoom.class,id);
	}

	public Long save(MerRoom merRoom) {
		return merRoomDAO.save(merRoom);
	}

	public void update(MerRoom merRoom) {
		merRoomDAO.update(merRoom);
	}
	
	public void update(MerRoom merRoom, Integer[] deletedItemIndexes) {
		List<RoomBed> beds = merRoom.getRoomBeds();
		RoomBed bedItem = null;
		// ɾ����λ��Ϣ
		if(deletedItemIndexes != null){
			for(int i = deletedItemIndexes.length - 1; i >= 0; i--){
				bedItem = beds.get(deletedItemIndexes[i]);
				// ���ݿ�ɾ����λ��¼
				if (bedItem.getId() != null) {
					roomBedDAO.deleteById(RoomBed.class,bedItem.getId());
				}
				// ҳ�洲λ��Ϣɾ��
				beds.remove(bedItem);
			}
		}
		// ���¿ͷ���Ϣ
		merRoomDAO.update(merRoom);
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
		MerRoomManager merRoomManager = (MerRoomManager) applicationContext.getBean("merRoomManager");
//		List<MerRoom> merRooms = merRoomManager.findMerAllEmptyCleanRooms(1,null);
//		for(MerRoom merRomm :  merRooms) {
//			System.out.println("    " + merRomm.getRoomNo() + "   " + merRomm.getRoomType().getName());
//		}
		List<RoomBed> beds = merRoomManager.findMerEmptyCleanRoomBeds(1L,"104",1L);
		for(RoomBed bed :  beds) {
			MerRoom merRoom = bed.getMerRoom();
			System.out.println("����ţ�" + merRoom.getRoomNo() + "   ��λ�ţ�"  + bed.getBedNo() + "���ͣ�" + merRoom.getRoomType().getName()); // + merRomm.getRoomType().getName()
		}
	}
}