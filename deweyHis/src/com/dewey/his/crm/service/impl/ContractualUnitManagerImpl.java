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
			System.out.println("Spring初始化失败！");
			e.printStackTrace();
		}

		ContractualUnitManager contractualUnitManager = (ContractualUnitManager) applicationContext.getBean("contractualUnitManager");
		ContractualUnit unit = contractualUnitManager.getById(4L);
		List<MerContractualRelation> list = unit.getMerContractualRelations();
		for(MerContractualRelation rs : list) {
			System.out.println("商户ID：" + rs.getMerId());
			System.out.println("协议价：" + rs.getContractualPrice());
		}
	}
	
//	// 协议单位的和房型的关系列表
//	List<MerContractualRelation> merContractualRelations = contractualUnit.getMerContractualRelations();
//	List<RoomType>        merRoomTypes = roomTypeDAO.findMerAllRoomType(contractualUnit.getMer().getId());
//	// 从后遍历关系列表，不存在的房型关系给予删除处理
//	for (int i=merContractualRelations.size()-1 ; i>=0 ; i--) {
//		MerContractualRelation merContractualRelation = merContractualRelations.get(i);
//		long rId = merContractualRelation.getRoomType().getId();
//		// 房型信息存在
//		boolean flag = false;
//		for (RoomType merRoomType:merRoomTypes) {
//			long tId = merRoomType.getId();
//			if(tId == rId) {
//				flag = true;
//				break;
//			}
//		}
//		// 房型信息不存在
//		if(!flag) {
//			// 删除无用关系信息
//			merContractualRelationDAO.deleteById(merContractualRelation.getId());
//			// 删除无用的关系对象
//			merContractualRelations.remove(merContractualRelation);
//		}
//	}
}
