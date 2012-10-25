package com.dewey.his.sys.service;

import java.util.List;

import com.dewey.his.sys.model.MerUserLog;

public interface MerUserLogManager {
	
	public List<MerUserLog> getMerUserLog(long merUserId);

}
