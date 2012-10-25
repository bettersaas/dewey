package test.jdbc;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class ExeDate {

	static Logger log = Logger.getLogger("logfile");
	
	//锁时间
	static private Date login_time = null;
	
	//登陆次数
	static private int  login_count = 0;	
	
	//中间SQL语句的构造
	static String  sql = null;
	
	//是否管理员，决定SQL操作的数据表
	private boolean isManager = false;
	
	//数据库操作的记录筛选条件
	private String 	username = null;
	
	public ExeDate(boolean manager, String username) {
		super();
		isManager = manager;
		this.username = username;
	}
	
	/**
	 * 功能说明：查询锁时间
	 */
	private void getTime(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		//数据库查询时间时直接转为日期格式的字符输出
		//SQL server的数据转换(datetime to varchar(19)),style=2 或120(*)为ODBC规范显示为：yyyy-mm-dd hh:mm:ss[.fff] 
		if (isManager)
			sql = "select CONVERT(varchar(19),LOGIN_TIME,20) from D_MANAGER where MANAGER_LOGIN='"+ username+"'";
		else
			sql = "select CONVERT(varchar(19),LOGIN_TIME,20) from D_USER where LOGIN_USER='" + username+"'";

		String timeString = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			conn = DBconn.getConnection();
			st = conn.createStatement();
			
			log.info("查询时间的sql语句为："+sql);
			
			rs = st.executeQuery(sql);
			
			//指向第一行记录
			rs.next();
			
			//序列从1开始login_time = rs.getDate(1);	
			timeString = rs.getString(1);
			
			log.info("查询该用户登陆时间为："+timeString);
			
			//NULL值SQL转换字符后仍为NULL
			if (timeString == null) {
				login_time = null;
			} else {
				login_time = sdf.parse(timeString);
				//显示取得的时间
				//ShowDate.show(login_time);
			}			
		} catch (Exception e) {
			log.error("查询该登陆者的登陆时间SQL语句执行失败："+sql);
			log.info(e.getMessage());
		} finally {
			DBconn.closeConnection(conn);
		}
	}
	
	/**
	 * 功能说明：查询登陆次数
	 */
	private void getCount(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		if (isManager)
			sql = "select LOGIN_COUNT from D_MANAGER where MANAGER_LOGIN='"+ username+"'";
		else
			sql = "select LOGIN_COUNT from D_USER where LOGIN_USER='" + username+"'";

		try {
			conn = DBconn.getConnection();
			st = conn.createStatement();
			
			log.info("取登陆次数的sql语句为："+sql);
			
			rs = st.executeQuery(sql);
			
			//指向第一行记录
			rs.next();
			
			//序列从1开始
			login_count = rs.getInt(1);
			
			log.info("取得的登陆次数为"+login_count+"＋1次");
		} catch (Exception e) {
			log.error("查询该登陆者的登陆次数SQL语句执行失败："+sql);
			log.info(e.getMessage());
		} finally {
			DBconn.closeConnection(conn);
		}
	}
	
	/**
	 * 功能说明：数据库的更新连接操作
	 * 或设置初始状态NULL、
	 * 或设置解锁时间戳、
	 * 或设置登陆次数为0、
	 * 或逐次激增登陆次数
	 */
	private void setValue(){
		Connection conn = null;
		Statement st = null;		
		try {
			conn = DBconn.getConnection();
			st = conn.createStatement();
			
			log.info("操作的sql语句为："+sql);
			
			st.execute(sql);
		}catch(Exception e){
			log.error("执行更新登陆者信息的SQL语句执行失败："+sql);
			log.info(e.getMessage());
		}finally{
			DBconn.closeConnection(conn);
		}
	}

	/**
	 * 功能说明：数据库逐次加锁或加锁时间戳
	 */
	public void clockUpdateSqlDate() {
		
		getCount();
		
		//错误次数为第3次时0,1,2，加锁时间戳
		if(login_count == 2){
			
			//格式化
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			//取当前系统时刻,显示当前时刻
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			
			//计算30分钟之后的时间
			cal.add(Calendar.MINUTE, 30);
			
			//构建SQL语句中的时间字符串
			String s = sdf.format(cal.getTime());
			
			//更新数据库的时间时将格式化的日期字符转化为数据库的时间类型
			if (isManager)
				sql = "update D_MANAGER set  LOGIN_TIME=CAST('"+s+"' as datetime) where MANAGER_LOGIN='"+ username+"'";
			else
				sql = "update D_USER    set  LOGIN_TIME=CAST('"+s+"' as datetime) where LOGIN_USER='" + username+"'";
			
			setValue();
			
			//加锁时间戳后登陆次数清0
			login_count = 0;
			unclockSetSqlCount();			
		}else{ //错误次数小于3次时，每错一次时，错误次数累加1
			login_count++;
			if (isManager)
				sql = "update D_MANAGER set  LOGIN_COUNT="+Integer.toString(login_count)+" where MANAGER_LOGIN='"+ username+"'";
			else
				sql = "update D_USER    set  LOGIN_COUNT="+Integer.toString(login_count)+" where LOGIN_USER='" + username+"'";
			setValue();
		}
	}

	/**
	 * 功能说明：检测是否处于被锁状态，是则返回true，否则返回false
	 * @return
	 */
	public boolean isClocked() {
		getTime();
		
		//如果没有锁定时间标志，则直接返回false
		if (login_time == null) {
			log.info("查询时间为空!");
			return false;
		}
		
		//有锁时间标志则比较时间是否已经到了,取当前系统时刻,显示当前时刻
		Date now = new Date();
		Calendar calnow = Calendar.getInstance();
		calnow.setTime(now);
		
		Calendar calold = Calendar.getInstance();
		calold.setTime(login_time);

		//检测当前的时间是否已过了解锁时间，过了则解锁还原锁时间为NULL,返回没锁false
		if (calnow.after(calold)) {
			unclockSetSqlTime();
			return false;
		} else
			return true;
	}

	/**
	 * 功能说明：解锁操作之一-即重新设置时间为NULL
	 *
	 */
	private void unclockSetSqlTime() {		
		if (isManager)
			sql = "update D_MANAGER set  LOGIN_TIME=NULL where MANAGER_LOGIN='"+ username+"'";
		else
			sql = "update D_USER    set  LOGIN_TIME=NULL where LOGIN_USER='" + username+"'";
		setValue();
	}
	
	/**
	 * 功能说明：解锁操作之二-设置登陆次数为0，清除登陆次数记录
	 *
	 */
	public void unclockSetSqlCount() {		
		if (isManager)
			sql = "update D_MANAGER set  LOGIN_COUNT=0 where MANAGER_LOGIN='"+ username+"'";
		else
			sql = "update D_USER    set  LOGIN_COUNT=0 where LOGIN_USER='" + username+"'";
		setValue();
	}
}