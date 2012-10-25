package com.dewey.his.common.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.util.Assert;

import com.dewey.his.common.service.MerUserLoginManager;
import com.dewey.his.sys.model.MerUser;

@ContextConfiguration(locations = { "classpath:/spring/*.xml" })
public class MerUserLoginManagerTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	@Autowired
	MerUserLoginManager merUserLoginManager;

	public void setMerUserLoginManager(MerUserLoginManager merUserLoginManager) {
		this.merUserLoginManager = merUserLoginManager;
	}
	
	@Test
	public void getUserByUserNameTest() {
		MerUser merUser = merUserLoginManager.getUserByUserName("dewey", "admin1");
		Assert.isNull(merUser, "¶ÔÏóÎª¿Õ");
	}

}
