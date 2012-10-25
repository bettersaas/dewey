package com.dewey.his.sys.service;

import java.util.List;

import com.dewey.his.sys.model.MerRole;

public interface MerRoleManager {
	
	public Long save(MerRole transientInstance);
	
	public void update(MerRole transientInstance);
	
	public MerRole getById(long id);
	
	public int deleteById(long id);
	
	public List<MerRole> getMerAllRole(long merId);
	
	public List<MerRole> getByMerRoleName(long merId,String roleName);
}
