//package test;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//
//import com.dewey.his.userlogin.model.User;
//import com.dewey.his.userlogin.service.UserManager;
//
//@ContextConfiguration("classpath:/spring/*-resource.xml classpath:/spring/*-dao.xml")
//public class SpringTest1 {
//
//	@Autowired
//	@Resource(name="userManager")
//	private UserManager userManager;
//
//	public void setUserManager(UserManager userManager) {
//		this.userManager = userManager;
//	}
//
//	@Test
//	public void testSave() {
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/beans.xml"); 
//		UserManager userManager = (UserManager)ctx.getBean("userManager");
//		User user = new User();
//		user.setPassword("1234");
//		user.setLoginName("张三3");
//		userManager.save(user);
//	}
//
//	@Test
//	public void testExits() {
//		User user = new User();
//		user.setPassword("1234");
//		user.setLoginName("张三");
//		userManager.getUserByUserName(user.getLoginName());
//	}
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	}
//
//}
