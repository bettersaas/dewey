package com.dewey.his.sys.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.sys.dao.MerUserDAO;
import com.dewey.his.sys.model.MerUser;
import com.dewey.his.sys.service.MerUserManager;

@Service("merUserManager")
@Scope("singleton")
@Transactional
public class MerUserManagerImpl implements MerUserManager {
	
	private MerUserDAO merUserDAO;

	public void setMerUserDAO(MerUserDAO merUserDAO) {
		this.merUserDAO = merUserDAO;
	}

	public void delete(MerUser persistentInstance) {
		merUserDAO.delete(persistentInstance);
	}
	
	public int deleteById(long id) {
		return merUserDAO.deleteById(MerUser.class,id);
	}
	
	public void update(MerUser transientInstance) {
		merUserDAO.update(transientInstance);
	}

	@Transactional(readOnly = true)
	public List<MerUser> getMerAllUser(long merId)  {
		return merUserDAO.getMerAllUser(merId);
	}
	
	@Transactional(readOnly = true)
	public List<MerUser> getByMerLoginName(long merId, String loginName) {
		return merUserDAO.getByMerLoginName(merId, loginName);
	}

	@Transactional(readOnly = true)
	public MerUser getById(Long id) {
		return (MerUser)merUserDAO.getById(MerUser.class,id);
	}

	public Long save(MerUser transientInstance) {
		return merUserDAO.save(transientInstance);
	}
	
	public int updateUserRole(String role,Long userId) {
		return merUserDAO.updateUserRole(role, userId);
	}
}
