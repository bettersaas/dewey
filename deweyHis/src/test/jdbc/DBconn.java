package test.jdbc;

import java.sql.*;

import org.apache.log4j.Logger;

/**
 * 获得数据库连接(JDBC)
 * 
 * @retrun
 */

public class DBconn {

	static Logger log = Logger.getLogger("logfile");

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//数据库在控制面板的数据源(ODBC)中的配置-名称：BSManage 登陆ID：liu 密码为空
			conn = DriverManager.getConnection("jdbc:odbc:BSManage", "liu", "");
			if (conn != null) {
				log.info("数据源连接成功!");
			}
		} catch (Exception e) {
			System.out.println("数据库连接出现问题!");
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * 数据库连接关闭closeConnection
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.print("数据库关闭出错!" + e);
		}
	}
}