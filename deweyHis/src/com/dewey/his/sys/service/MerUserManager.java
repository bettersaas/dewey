package com.dewey.his.sys.service;

import java.util.List;

import com.dewey.his.sys.model.MerUser;

public interface MerUserManager {
	
	public Long save(MerUser transientInstance);
	
	public void delete(MerUser persistentInstance) ;
	
	public int deleteById(long id);
	
	public void update(MerUser transientInstance);
	
	public MerUser getById(Long id);
	
	public List<MerUser> getMerAllUser(long merId) ;
	
	public List<MerUser> getByMerLoginName(long merId, String loginName);

	public int updateUserRole(String role,Long userId);
}
