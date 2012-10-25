package com.dewey.his.platForm.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.common.model.Mer;
import com.dewey.his.platForm.dao.PlatformDAO;
import com.dewey.his.platForm.service.PlatformManager;

@Service("platformManager")
@Scope("singleton")
@Transactional
public class PlatformManagerImpl implements PlatformManager {
	
	private PlatformDAO platformDAO;

	public void setPlatformDAO(PlatformDAO platformDAO) {
		this.platformDAO = platformDAO;
	}

	public void delete(Mer persistentInstance) {
		platformDAO.delete(persistentInstance);
	}
	
	public int deleteById(long id) {
		return platformDAO.deleteById(Mer.class,id);
	}
	
	public void update(Mer transientInstance) {
		platformDAO.update(transientInstance);
	}
	@Transactional(readOnly = true)
	public List<Mer> getAllMer(){
		return platformDAO.getAllMer();
	}
	
//	@Transactional(readOnly = true)
//	public List<Mer> getByMerLoginName(long merId, String loginName) {
//		return platformDAO.getByMerLoginName(merId, loginName);
//	}

	@Transactional(readOnly = true)
	public Mer getById(Long id) {
		return (Mer)platformDAO.getById(Mer.class,id);
	}

	public Long save(Mer transientInstance) {
		return platformDAO.save(transientInstance);
	}
	
	public int updateUserRole(String role,Long userId) {
		return platformDAO.updateUserRole(role, userId);
	}

}
