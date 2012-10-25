package com.dewey.his.common.service;

import com.dewey.his.sys.model.MerUser;
import com.dewey.his.sys.model.MerUserLog;

public interface MerUserLoginManager {
	
	/**
	 * ���ݶ����ź͵�¼����ȡ�û���Ϣ
	 * @param deweyNo
	 * @param loginName
	 * @return
	 */ 
	public MerUser getUserByUserName(String deweyNo,String loginName);
	
	/**
	 * ���ݶ����ź͵�¼����ȡ�û���Ϣ���̻���Ϣ
	 * @param deweyNo
	 * @param loginName
	 * @return
	 */
	public Object[] getUserMerByUserName(String deweyNo,String loginName);
	
	/**
	 * �����û�id�����û�����
	 * @param password
	 * @param userId
	 * @return
	 */
	public int changeUserPassword(String password,Long userId) ;
	
	/**
	 * �����û���¼��־
	 * @param transientInstance
	 * @return
	 */
	public Long save(MerUserLog transientInstance);
}
