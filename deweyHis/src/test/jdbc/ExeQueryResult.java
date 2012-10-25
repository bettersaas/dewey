package test.jdbc;

import java.sql.*;
import java.util.Vector;

import org.apache.log4j.Logger;

public class ExeQueryResult {

	static Logger log = Logger.getLogger("logfile");
	
	//保存结果集的列数和行数
	static public int col = 0;
	static public int row = 0;

	/**
	 * 查询语句得执行结果进行封装，返回为一个二维列表对应得二维数组
	 * @param sql语句
	 * @return String[][]二维数组
	 */
	public static String[][] getSelectResultWithStringArray(String sql) {
		
		String[][] result = null;
		
		Vector<String[]> v = new Vector<String[]>();

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		log.info("查询SQL语句为："+sql);
		
		try { //执行SQL语句返回二维列表形式的结果集
			conn = DBconn.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);

			//从ResultSet对象的元数据中的获得列数信息
			col = rs.getMetaData().getColumnCount();
			
			log.info("结果集字段数为："+col);

			//遍历结果集中的记录
			while(rs.next()) {
				String[] vx = new String[col];
				for (int c = 0; c < col; c++) {
					//据字段索引获取该字段的内容（索引从1开始）
					vx[c] =rs.getString(c + 1);					
				}
				v.add(vx);
			}					
			//获得结果集中的记录数
			row = v.size();
			
			log.info("结果集元组数为："+ row +"行(影响了的行数)");
			
			//初始化二维数组的大小
			result = new String[row][col];
			
			//引用二维数组
			result = v.toArray(result);
		} catch (SQLException e) {
			//SQL查询语句执行出错
			log.error("执行SQL查询语句失败!");
			log.info(e.getMessage());
		} finally {
			//结果集以二维字符数组保存返回，关闭连接
			DBconn.closeConnection(conn);
		}
		return result;
	}

}