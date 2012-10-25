package test.jdbc;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import oracle.sql.BLOB;

class ConnectionFunctions {
	String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	String DBURL = "jdbc:oracle:thin:@127.0.0.1:1521:HRMS";
	String DBUSER = "wintalent";
	String DBPASSWORD = "wintalent";
	private Connection conn = null;

	// 这个是连接数据库方法
	public Connection getConnection() {
		try {
			Class.forName(DBDRIVER);
			// 连接时必须填写用户名及密码
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			if (conn != null) {
				System.out.println("数据库已经连接成功 !\n");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return conn;
	}

	// 这个是关闭连接方法
	public void closeConnection() {
		try {			
			conn.close();
			System.out.println("关闭数据库 ！\n");
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
}

public class TestBLOB {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		ConnectionFunctions co = new ConnectionFunctions();
		Connection conn = co.getConnection();
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();
		ResultSet rs = null;

		// 1、插入空的BLOB
		String sql = "insert into TEST_CBOB(F_ID,F_BLOB) values(12, empty_blob())";
		stmt.executeUpdate(sql);

		// 2、查询改BLOB
		sql = "select F_BLOB from  TEST_CBOB where F_ID=12 for update";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			BLOB blob = (BLOB) rs.getBlob("F_BLOB");

			OutputStream os = blob.getBinaryOutputStream();
			BufferedOutputStream output = new BufferedOutputStream(os);

			BufferedInputStream input = new BufferedInputStream(new File("c:\\as.jpg").toURL().openStream());
			byte[] buff = new byte[2048]; //用做文件写入的缓冲
			int bytesRead;
			while (-1 != (bytesRead = input.read(buff, 0, buff.length))) {
				output.write(buff, 0, bytesRead);
				System.out.println(bytesRead);
			}
			output.flush();
			output.close();	
			input.close();					
		}

		// 创建表的SQL语句
		sql = "select F_ID,F_BLOB from  TEST_CBOB";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("F_ID"));
			
			BLOB  blob = (BLOB)rs.getBlob("F_BLOB");
			// 读取
			InputStream is = blob.getBinaryStream();
	        BufferedInputStream input = new BufferedInputStream(is);
	        // 输出
	        File file = new File("c:\\a.txt");
	        OutputStream fout = new FileOutputStream(file);
	        
	        //下面将BLOB数据写入文件
	        byte[] buff = new byte[1024];
	        int len = 0;
	        while ( (len = input.read(buff)) != -1) {
	          fout.write(buff, 0, len);
	        }
	        //依次关闭
	        fout.close();
	        is.close();
//	        byte[] buff = new byte[2048];
//	        int bytesRead = 0;
//	        while(-1 != (bytesRead = input.read(buff, 0, buff.length))) {
//	        	//在这里执行写入，如写入到文件的
//	        	System.out.println(new String(buffer))
//	        }
		}
		rs.close();
		stmt.close();
		conn.commit();
		co.closeConnection();
	}

}