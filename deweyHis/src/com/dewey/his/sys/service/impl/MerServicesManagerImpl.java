package com.dewey.his.sys.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.sys.dao.MerServicesDAO;
import com.dewey.his.sys.model.MerServices;
import com.dewey.his.sys.service.MerServicesManager;

@Service("merServicesManager")
@Scope("singleton")
@Transactional
public class MerServicesManagerImpl implements MerServicesManager {
	
	private MerServicesDAO merServicesDAO;

	public void setMerServicesDAO(MerServicesDAO merServicesDAO) {
		this.merServicesDAO = merServicesDAO;
	}

	public int deleteById(long id) {
		return merServicesDAO.deleteById(MerServices.class,id);
	}

	@Transactional(readOnly = true)
	public List<MerServices> findMerAllMerServices(long merId) {
		return  merServicesDAO.findMerAllMerServices(merId);
	}
	
	@Transactional(readOnly = true)
	public List<MerServices> findConsumeTypeMerServices(long merId, String consumeType) {
		return  merServicesDAO.findConsumeTypeMerServices(merId, consumeType);
	}

	@Transactional(readOnly = true)
	public MerServices getById(long id) {
		return (MerServices)merServicesDAO.getById(MerServices.class,id);
	}

	public Long save(MerServices transientInstance) {
		return merServicesDAO.save(transientInstance);
	}

	public void update(MerServices transientInstance) {
		merServicesDAO.update(transientInstance);
	}
}
