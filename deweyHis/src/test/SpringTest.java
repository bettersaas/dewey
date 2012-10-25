//package test;
//
//import static junit.framework.Assert.assertNotNull;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Collection;
//import java.util.Iterator;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.support.GenericXmlContextLoader;
//import org.springframework.test.context.transaction.AfterTransaction;
//import org.springframework.test.context.transaction.BeforeTransaction;
//
//import com.dewey.his.userlogin.dao.accessLog.AccessLogHbmDao;
//import com.dewey.his.userlogin.dao.user.UserJdbcDao;
//import com.dewey.his.userlogin.model.AccessLog;
//import com.dewey.his.userlogin.model.User;
//import com.dewey.his.userlogin.service.UserManager;
//
//import common.base.model.Pager;
//
///**
// * 本基类主要为子类指定好要装载的spring配置文件
// * 所以你要装载的资源文件应改为"classpath:/spring/*-test-resource.xml"
// * 
// * Object obj = Class.forName("test.spring.B").newInstance();
// */
//@ContextConfiguration(locations = { "classpath:/spring/*-resource.xml", "classpath:/spring/*-dao.xml" })
//public class SpringTest {
//
//	public final static void setApplicationContext(ApplicationContext applicationContext) {
//		SpringTest.applicationContext = applicationContext;
//	}
//
//	protected final Log logger = LogFactory.getLog(getClass());
//
//	protected static ApplicationContext applicationContext;
//
//	protected DataSource getDataSource() {
//		DataSource ds = (DataSource) applicationContext.getBean("dataSource");
//		assertNotNull("not found 'dataSource'", ds);
//		return ds;
//	}
//
//	@BeforeTransaction
//	public void onSetUpBeforeTransaction() throws Exception {
//		System.out.println("事务前");
//	}
//
//	@AfterTransaction
//	public void onTearDownAfterTransaction() throws Exception {
//		System.out.println("事务后");
//	}
//
//	/**
//	 * @param args
//	 * @throws Exception
//	 */
//	public static void main(String[] args) {
//		// "classpath*:spring/*.xml"
//		try {
//			applicationContext = new GenericXmlContextLoader().loadContext(
//					"classpath:/spring/*-resource.xml",
//					"classpath:/spring/*-dao.xml",
//					"classpath:/spring/*-service.xml");
//		} catch (Exception e) {
//			System.out.println("Spring初始化失败！");
//			e.printStackTrace();
//		}
//		
//		/***
//		 * hibernate3:
//		 */
//		UserManager userManager = (UserManager) applicationContext.getBean("userManager");
//		User user = new User();
//		user.setDepId(1L);
//		user.setLoginName("liuhonggang231");
//		user.setPassword("123");
//		Long id = (Long)userManager.save(user);
//		System.out.println("保存的对象:" + id+ "                 "+ userManager.loadUser(id).toString());
//		for (User auser: (Collection<User>)userManager.getUserVets()) {
//			System.out.println("查询出来的对象:" +"                 "+ auser);
//		}
//		
////		baseJdbcInsert();
////		jdbcBaseOper();
////		hibernateSelect();
////		try {
////			ibatis3();
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		hibernate3Page();
//	}
//	
//	public static void jdbcBaseOper() {
//
//		UserJdbcDao userManager = (UserJdbcDao) applicationContext.getBean("userJdbcDao");
//		User user = new User();
//		user.setId(11L);
//		user.setLoginName("liuhonggang1");
//		user.setPassword("1234");
//		userManager.updateUser(user);
//	}
//	
//	public static void hibernateSelect() {
//		AccessLogHbmDao userManager = (AccessLogHbmDao) applicationContext.getBean("userHbmDao");
//		Collection<AccessLog> vet = userManager.getAccessLogVets();
//		Iterator<AccessLog>  iterator= vet.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next());
//		}
//		
////		User user = new User();
////		user.setUserName("liuhonggang1");
////		user.setPassword("123");
////		user.setBirthDate(new Timestamp(new java.util.Date().getTime()));
////		user.setAge(12);
////		user.setSex(new Byte("1"));
////		System.out.println(userManager.save(user));
////		
////		user = new User();
////		user.setId(9L);
////		userManager.delete(user);
//	}
//	
//	public static void hibernate3Page() {
//		AccessLogHbmDao userManager = (AccessLogHbmDao) applicationContext.getBean("userHbmDao");
//		String[][] searchPara = new String[][]{new String[]{"loginName","=","liuhonggang1"}};
//		
//		/*分页，取第一页，前4 条，应该返回4*/
//		Pager pager = new Pager(1,4);
//		System.out.println(userManager.find(searchPara, pager));
//		
//		pager = new Pager(2, 4);
//		System.out.println(userManager.find(searchPara, pager));
//		
//		/*不分页，则取全部的，应该返回20*/
//		pager = new Pager();
//		pager.setPageAble(false);
//		System.out.println(userManager.find(searchPara, pager));
//	}
//	
//	public static void hibernate3()  throws Exception{
//		
//	}
//
//	public static void ibatis3() throws Exception{
//		UserManager userManager = (UserManager) applicationContext.getBean("userManager");
//		
////		// 插入用户信息
////		User user = new User();
////		user.setUserName("liuhonggang23");
////		user.setPassword("123");
////		user.setBirthDate(new java.sql.Date(new java.util.Date().getTime()));
////		user.setBirthDateStr("2010-12-13");
////		user.setAge(12);
////		user.setSex(new Byte("1"));
////		userManager.insertUser(user);
////		Map<String, String> map = new HashMap<String, String>();
////		map.put("loginName", "loginName");
////		map.put("password", "password");
////		map.put("birthdayStr", "2010-12-12");
////		map.put("sex", "12");
////		map.put("age", "30");
////		userManager.insertUser(map);
////		System.out.println("应该插入两个用户！");
////		
////		User user2 = new User();
////		user2.setUserName("liuhonggang32");
////		user2.setPassword("123");
////		user2.setBirthDate(new java.sql.Date(new java.util.Date().getTime()));
////		user2.setBirthDateStr("2010-12-13");
////		user2.setAge(12);
////		user2.setSex(new Byte("1"));
////		User user3 = new User();
////		user3.setUserName("liuhonggang42");
////		user3.setPassword("123");
////		user3.setBirthDate(new java.sql.Date(new java.util.Date().getTime()));
////		user3.setBirthDateStr("2010-12-13");
////		user3.setAge(12);
////		user3.setSex(new Byte("1"));
////		User[] users  = new  User[2];
////		users[0] = user2;
////		users[1] = user3;
////		userManager.insertBatchUser(users);
////		System.out.println("应该插入两个用户！");
////		
////		System.out.println(userManager.getUserById(48L));
//		
////		User user3 = new User();
////		user3.setUserName("loginName233");
////		user3.setPassword("loginName233");
////		user3.setBirthDate(new java.sql.Date(new java.util.Date().getTime()));
////		user3.setBirthDateStr("2010-12-23");
////		user3.setAge(24);
////		user3.setSex(new Byte("57"));
////		user3.setId(57L);
////		userManager.updateUser(user3);
//		
////		userManager.deleteUser(57L);
////		userManager.insertUserDescription(48L, "新的注释啊啊啊啊啊啊啊哈哈哈！");
////		System.out.println(userManager.getUserDescription(48L));		
//	}
//	
//	public static void baseJdbcInsert() {
////		// "classpath*:spring/*.xml"
////		try {
////			applicationContext = new GenericXmlContextLoader().loadContext(
////					"classpath:/spring/*-resource.xml",
////					"classpath:/spring/*-dao.xml");
////		} catch (Exception e) {
////			System.out.println("Spring初始化失败！");
////		}
//		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
//
//		Connection conn = null;
//		try {
//			if (dataSource != null)
//				conn = dataSource.getConnection();
//
//			conn.setAutoCommit(false);
//			PreparedStatement sta = conn.prepareStatement("INSERT INTO BASE_E_USER(id) VALUES(SEQ_BASE_E_USER.nextval)");
//			sta.execute();
//			conn.commit();
//		} catch (Exception e) {
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				System.out.println("数据库操作失败！");
//			}
//			System.out.println("数据库操作失败！");
//		}
//	}
//	
////	public static void maiana() {
////		try {
////			ApplicationContext context =  new GenericXmlContextLoader().loadContext(
////					"classpath:/spring/*-resource.xml",
////					"classpath:/spring/*-dao.xml",
////					"classpath:/spring/*-service.xml");
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		//new FileSystemXmlApplicationContext(CONTEXT_CONFIG_LOCATION);
////		//context.getBean("imageDatabase");
////	}
//}
