package com.dewey.his.platForm.service;

import java.util.List;

import com.dewey.his.sys.model.MerUserLog;

public interface PlatformLogManager {
	
	public List<MerUserLog> getMerUserLog(long merUserId);

}
