package com.dewey.his.platForm.service;

import java.util.List;

import com.dewey.his.common.model.Mer;
import com.dewey.his.sys.model.MerUser;

public interface PlatformManager {
	
	public Long save(Mer transientInstance);
	
	public void delete(Mer persistentInstance) ;
	
	public int deleteById(long id);
	
	public void update(Mer transientInstance);
	
	public Mer getById(Long id);
	
	public List<Mer> getAllMer() ;
	
	//public List<MerUser> getByMerLoginName(long merId, String loginName);

	public int updateUserRole(String role,Long userId);
}
