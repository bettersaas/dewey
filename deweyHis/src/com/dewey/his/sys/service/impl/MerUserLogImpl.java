package com.dewey.his.sys.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.sys.dao.MerUserLogDAO;
import com.dewey.his.sys.model.MerUserLog;
import com.dewey.his.sys.service.MerUserLogManager;

@Service("merUserLogManager")
@Scope("singleton")
@Transactional
public class MerUserLogImpl implements MerUserLogManager{
	
	private MerUserLogDAO merUserLogDAO;

	public void setMerUserLogDAO(MerUserLogDAO merUserLogDAO) {
		this.merUserLogDAO = merUserLogDAO;
	}

	@Transactional(readOnly = true)
	public List<MerUserLog> getMerUserLog(long merUserId) {
		return merUserLogDAO.getMerUserLog(merUserId);
	}
}
