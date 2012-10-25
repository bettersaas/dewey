package test.jdbc;

import java.sql.*;
import java.util.Vector;

import org.apache.log4j.Logger;

public class ExeQueryResult {

	static Logger log = Logger.getLogger("logfile");
	
	//��������������������
	static public int col = 0;
	static public int row = 0;

	/**
	 * ��ѯ����ִ�н�����з�װ������Ϊһ����ά�б��Ӧ�ö�ά����
	 * @param sql���
	 * @return String[][]��ά����
	 */
	public static String[][] getSelectResultWithStringArray(String sql) {
		
		String[][] result = null;
		
		Vector<String[]> v = new Vector<String[]>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		log.info("��ѯSQL���Ϊ��"+sql);
		
		try { //ִ��SQL��䷵�ض�ά�б���ʽ�Ľ����
			conn = DBconn.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			//��ResultSet�����Ԫ�����еĻ��������Ϣ
			col = rs.getMetaData().getColumnCount();
			
			log.info("������ֶ���Ϊ��"+col);

			//����������еļ�¼
			while(rs.next()) {
				String[] vx = new String[col];
				for (int c = 0; c < col; c++) {
					//���ֶ�������ȡ���ֶε����ݣ�������1��ʼ��
					vx[c] =rs.getString(c + 1);					
				}
				v.add(vx);
			}					
			//��ý�����еļ�¼��
			row = v.size();
			
			log.info("�����Ԫ����Ϊ��"+ row +"��(Ӱ���˵�����)");
			
			//��ʼ����ά����Ĵ�С
			result = new String[row][col];
			
			//���ö�ά����
			result = v.toArray(result);
		} catch (SQLException e) {
			//SQL��ѯ���ִ�г���
			log.error("ִ��SQL��ѯ���ʧ��!");
			log.info(e.getMessage());
		} finally {
			//������Զ�ά�ַ����鱣�淵�أ��ر�����
			DBconn.closeConnection(conn);
		}
		return result;
	}

}