package com.dewey.his.common.service.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.test.context.support.GenericXmlContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.dewey.his.common.model.Mer;
import com.dewey.his.common.service.MerUserLoginManager;
import com.dewey.his.sys.dao.MerUserDAO;
import com.dewey.his.sys.dao.MerUserLogDAO;
import com.dewey.his.sys.model.MerUser;
import com.dewey.his.sys.model.MerUserLog;

@Service("merUserLoginManager")
@Scope("singleton")
@Transactional
public class MerUserLoginManagerImpl implements MerUserLoginManager {

	private MerUserDAO merUserDAO;

	public void setMerUserDAO(MerUserDAO merUserDAO) {
		this.merUserDAO = merUserDAO;
	}
	
	private MerUserLogDAO merUserLogDAO;

	public void setMerUserLogDAO(MerUserLogDAO merUserLogDAO) {
		this.merUserLogDAO = merUserLogDAO;
	}

	@Transactional(readOnly = true)
	public MerUser getUserByUserName(String deweyNo, String loginName) {
		return merUserDAO.getUserByUserName(deweyNo, loginName);
	}
	
	@Transactional(readOnly = true)
	public Object[] getUserMerByUserName(String deweyNo,String loginName) {
		return merUserDAO.getUserMerByUserName(deweyNo, loginName);
	}
	
	@Transactional
	public int changeUserPassword(String password,Long userId) {
		return merUserDAO.updateUserPassword(password, userId);
	}
	
	public Long save(MerUserLog transientInstance) {
		return merUserLogDAO.save(transientInstance);
	}

	/**
	 * 测试主函数
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = null;
		try {
			applicationContext = new GenericXmlContextLoader().loadContext(
					"classpath:/spring/*-resource.xml",
					"classpath:/spring/*-dao.xml",
					"classpath:/spring/*-service.xml");
		} catch (Exception e) {
			System.out.println("Spring初始化失败！");
			e.printStackTrace();
		}

		MerUserLoginManager merUserLoginManager = (MerUserLoginManager) applicationContext.getBean("merUserLoginManager");
		MerUser merUser = merUserLoginManager.getUserByUserName("dewey", "admin1");
		System.out.println("查询出来的对象:" + "   " + merUser.getPassword());
		
		Object[]  oa = merUserLoginManager.getUserMerByUserName("dewey", "admin1");
		System.out.println("查询出来的对象:" + "   " +((MerUser)oa[0]).getChineseName());
		System.out.println("查询出来的对象:" + "   " +((Mer)oa[1]).getDeweyNo());
		
		System.out.println("更新了多少行：" + merUserLoginManager.changeUserPassword("admin1", 1L));
	}
}
