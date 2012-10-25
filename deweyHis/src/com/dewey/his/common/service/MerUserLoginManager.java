package com.dewey.his.common.service;

import com.dewey.his.sys.model.MerUser;
import com.dewey.his.sys.model.MerUserLog;

public interface MerUserLoginManager {
	
	/**
	 * 根据杜威号和登录名获取用户信息
	 * @param deweyNo
	 * @param loginName
	 * @return
	 */ 
	public MerUser getUserByUserName(String deweyNo,String loginName);
	
	/**
	 * 根据杜威号和登录名获取用户信息、商户信息
	 * @param deweyNo
	 * @param loginName
	 * @return
	 */
	public Object[] getUserMerByUserName(String deweyNo,String loginName);
	
	/**
	 * 根据用户id更新用户密码
	 * @param password
	 * @param userId
	 * @return
	 */
	public int changeUserPassword(String password,Long userId) ;
	
	/**
	 * 保存用户登录日志
	 * @param transientInstance
	 * @return
	 */
	public Long save(MerUserLog transientInstance);
}
