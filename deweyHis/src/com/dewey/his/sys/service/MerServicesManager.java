package com.dewey.his.sys.service;

import java.util.List;

import com.dewey.his.sys.model.MerServices;

public interface MerServicesManager {
	
	public Long save(MerServices transientInstance);
	
	public void update(MerServices transientInstance);
	
	public MerServices getById(long id);
	
	public int deleteById(long id);
	
	public List<MerServices> findMerAllMerServices(long merId); 
	
	public List<MerServices> findConsumeTypeMerServices(long merId, String consumeType);
}
