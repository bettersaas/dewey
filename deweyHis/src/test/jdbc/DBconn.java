package test.jdbc;

import java.sql.*;

import org.apache.log4j.Logger;

/**
 * ������ݿ�����(JDBC)
 * 
 * @retrun
 */

public class DBconn {

	static Logger log = Logger.getLogger("logfile");

	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			//���ݿ��ڿ�����������Դ(ODBC)�е�����-���ƣ�BSManage ��½ID��liu ����Ϊ��
			conn = DriverManager.getConnection("jdbc:odbc:BSManage", "liu", "");
			if (conn != null) {
				log.info("����Դ���ӳɹ�!");
			}
		} catch (Exception e) {
			System.out.println("���ݿ����ӳ�������!");
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * ���ݿ����ӹر�closeConnection
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.print("���ݿ�رճ���!" + e);
		}
	}
}