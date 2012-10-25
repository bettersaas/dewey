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

	// ������������ݿⷽ��
	public Connection getConnection() {
		try {
			Class.forName(DBDRIVER);
			// ����ʱ������д�û���������
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			if (conn != null) {
				System.out.println("���ݿ��Ѿ����ӳɹ� !\n");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return conn;
	}

	// ����ǹر����ӷ���
	public void closeConnection() {
		try {			
			conn.close();
			System.out.println("�ر����ݿ� ��\n");
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

		// 1������յ�BLOB
		String sql = "insert into TEST_CBOB(F_ID,F_BLOB) values(12, empty_blob())";
		stmt.executeUpdate(sql);

		// 2����ѯ��BLOB
		sql = "select F_BLOB from  TEST_CBOB where F_ID=12 for update";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			BLOB blob = (BLOB) rs.getBlob("F_BLOB");

			OutputStream os = blob.getBinaryOutputStream();
			BufferedOutputStream output = new BufferedOutputStream(os);

			BufferedInputStream input = new BufferedInputStream(new File("c:\\as.jpg").toURL().openStream());
			byte[] buff = new byte[2048]; //�����ļ�д��Ļ���
			int bytesRead;
			while (-1 != (bytesRead = input.read(buff, 0, buff.length))) {
				output.write(buff, 0, bytesRead);
				System.out.println(bytesRead);
			}
			output.flush();
			output.close();	
			input.close();					
		}

		// �������SQL���
		sql = "select F_ID,F_BLOB from  TEST_CBOB";
		rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("F_ID"));
			
			BLOB  blob = (BLOB)rs.getBlob("F_BLOB");
			// ��ȡ
			InputStream is = blob.getBinaryStream();
	        BufferedInputStream input = new BufferedInputStream(is);
	        // ���
	        File file = new File("c:\\a.txt");
	        OutputStream fout = new FileOutputStream(file);
	        
	        //���潫BLOB����д���ļ�
	        byte[] buff = new byte[1024];
	        int len = 0;
	        while ( (len = input.read(buff)) != -1) {
	          fout.write(buff, 0, len);
	        }
	        //���ιر�
	        fout.close();
	        is.close();
//	        byte[] buff = new byte[2048];
//	        int bytesRead = 0;
//	        while(-1 != (bytesRead = input.read(buff, 0, buff.length))) {
//	        	//������ִ��д�룬��д�뵽�ļ���
//	        	System.out.println(new String(buffer))
//	        }
		}
		rs.close();
		stmt.close();
		conn.commit();
		co.closeConnection();
	}

}