package com.dewey.his.sys.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.sys.dao.MerRoleDAO;
import com.dewey.his.sys.model.MerRole;
import com.dewey.his.sys.service.MerRoleManager;

@Service("merRoleManager")
@Scope("singleton")
@Transactional
public class MerRoleManagerImpl implements  MerRoleManager{
	
	private MerRoleDAO merRoleDAO;

	public void setMerRoleDAO(MerRoleDAO merRoleDAO) {
		this.merRoleDAO = merRoleDAO;
	}

	public int deleteById(long id) {
		return merRoleDAO.deleteById(MerRole.class,id);
	}

	@Transactional(readOnly = true)
	public List<MerRole> getMerAllRole(long merId) {
		return merRoleDAO.getMerAllRole(merId);
	}
	
	@Transactional(readOnly = true)
	public List<MerRole> getByMerRoleName(long merId, String roleName) {
		return merRoleDAO.getByMerRoleName(merId, roleName);
	}

	@Transactional(readOnly = true)
	public MerRole getById(long id) {
		return (MerRole)merRoleDAO.getById(MerRole.class,id);
	}

	public Long save(MerRole transientInstance) {
		return merRoleDAO.save(transientInstance);
	}

	public void update(MerRole transientInstance) {
		merRoleDAO.update(transientInstance);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
}
