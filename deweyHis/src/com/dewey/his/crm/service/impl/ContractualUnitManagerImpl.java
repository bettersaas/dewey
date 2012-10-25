package com.dewey.his.crm.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.support.GenericXmlContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.crm.dao.ContractualUnitDAO;
import com.dewey.his.crm.dao.MerContractualRelationDAO;
import com.dewey.his.crm.model.ContractualUnit;
import com.dewey.his.crm.model.MerContractualRelation;
import com.dewey.his.crm.service.ContractualUnitManager;

@Service("contractualUnitManager")
@Scope("singleton")
@Transactional
public class ContractualUnitManagerImpl  implements ContractualUnitManager{
	
	private ContractualUnitDAO contractualUnitDAO;
	
	public void setContractualUnitDAO(ContractualUnitDAO contractualUnitDAO) {
		this.contractualUnitDAO = contractualUnitDAO;
	}
	
	private MerContractualRelationDAO merContractualRelationDAO;

	public void setMerContractualRelationDAO(MerContractualRelationDAO merContractualRelationDAO) {
		this.merContractualRelationDAO = merContractualRelationDAO;
	}

	public Long save(ContractualUnit transientInstance) {
		return contractualUnitDAO.save(transientInstance);
	}
	
	public void update(ContractualUnit transientInstance) {
		contractualUnitDAO.update(transientInstance);
	}
	
	@Transactional(readOnly = true)
	public ContractualUnit getById(long id)  {
		ContractualUnit contractualUnit = (ContractualUnit)contractualUnitDAO.getById(ContractualUnit.class,id);
		List<MerContractualRelation> merContractualRelations = merContractualRelationDAO.getContractualRelationByUnitId(contractualUnit.getId(), null);
		contractualUnit.setMerContractualRelations(merContractualRelations);
		return contractualUnit;
	}
	
	public int deleteById(long id) {
		return contractualUnitDAO.deleteById(ContractualUnit.class,id);
	}
	
	@Transactional(readOnly = true)
	public List<ContractualUnit> findMerAllContractualUnit(long merId) {
		return contractualUnitDAO.findMerAllContractualUnit(merId);
	}
	
	public static void main(String[] argv) {
		ApplicationContext applicationContext = null;
		try {
			applicationContext = new GenericXmlContextLoader().loadContext(
					"classpath:/spring/*-resource.xml",
					"classpath:/spring/*-dao.xml",
					"classpath:/spring/*-service.xml");
		} catch (Exception e) {
			System.out.println("Spring��ʼ��ʧ�ܣ�");
			e.printStackTrace();
		}

		ContractualUnitManager contractualUnitManager = (ContractualUnitManager) applicationContext.getBean("contractualUnitManager");
		ContractualUnit unit = contractualUnitManager.getById(4L);
		List<MerContractualRelation> list = unit.getMerContractualRelations();
		for(MerContractualRelation rs : list) {
			System.out.println("�̻�ID��" + rs.getMerId());
			System.out.println("Э��ۣ�" + rs.getContractualPrice());
		}
	}
	
//	// Э�鵥λ�ĺͷ��͵Ĺ�ϵ�б�
//	List<MerContractualRelation> merContractualRelations = contractualUnit.getMerContractualRelations();
//	List<RoomType>        merRoomTypes = roomTypeDAO.findMerAllRoomType(contractualUnit.getMer().getId());
//	// �Ӻ������ϵ�б������ڵķ��͹�ϵ����ɾ������
//	for (int i=merContractualRelations.size()-1 ; i>=0 ; i--) {
//		MerContractualRelation merContractualRelation = merContractualRelations.get(i);
//		long rId = merContractualRelation.getRoomType().getId();
//		// ������Ϣ����
//		boolean flag = false;
//		for (RoomType merRoomType:merRoomTypes) {
//			long tId = merRoomType.getId();
//			if(tId == rId) {
//				flag = true;
//				break;
//			}
//		}
//		// ������Ϣ������
//		if(!flag) {
//			// ɾ�����ù�ϵ��Ϣ
//			merContractualRelationDAO.deleteById(merContractualRelation.getId());
//			// ɾ�����õĹ�ϵ����
//			merContractualRelations.remove(merContractualRelation);
//		}
//	}
}
