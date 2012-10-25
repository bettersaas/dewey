package test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

public class ExeInsertUpdateDelete {
	static Logger log = Logger.getLogger("logfile");

	//插入insert into tableName(key,key...key) values(value,value...value)
	public final static int INSERT = 1;

	//修改update tableName set key=value,key=value..key=value where key=value and key=value
	public final static int UPDATE = 2;

	//删除delete from tableName where key=value and key=value
	public final static int DELETE = 3;

	public static String keyMark = "$"; //关键子段标识－where字句中的key=value对

	public static String nonKeyMark = "_"; //一般字段标识－非where字句中key=value对

	/** 
	 * 函数功能：处理传入的SQL语句参数并执行该SQL语句
	 * tableName 为表名称，
	 * tableAction 为执行的操作（即插入、修改、删除），其对应的值取1、2、3
	 * dbParam 为哈希表，存放所有的字段和对应的值，如果执行成功，则返回true，否则返回false
	 */
	public static boolean execSql(String tableName, int tableAction,
			Hashtable<String, String> dbParam) throws Exception {
		//HsahTable的容量
		int keySize = dbParam.size();

		//存放完整的SQL语句
		StringBuffer sqlStatement = new StringBuffer();

		//键的 Set 视图
		Set<String> set = dbParam.keySet();

		//存放键的数组
		String[] keyArray = new String[keySize];

		//存放值的数组
		String[] valueArray = new String[keySize];

		//遍历set集合，保存键值数组中
		int keyNum = 0;
		for (String key : set) {
			keyArray[keyNum] = (String) key;
			valueArray[keyNum] = (String) dbParam.get(key);
			keyNum++;
		}

		//键列表－诸如key,key,key形式语句
		StringBuffer keyList = new StringBuffer();
		
		//SQL Server中的sql语句不管是否为数字或字符都可以加''来给列赋值,数字似乎在数据库中自己进行数据类型转换(字符串型转换为数字可以反之则不行)所以统一定为‘value’

		//值列表－诸如'value','value','value'形式语句
		StringBuffer valueList = new StringBuffer();

		//非关键子段的键值对列表－诸如key='value',key='value'形式语句
		StringBuffer notKeyMarkKeyValue = new StringBuffer();

		//关键子段的键值对列表－诸如key=value and key=value形式语句
		StringBuffer isKeyMarkKeyValue = new StringBuffer();		

		
		for (keyNum = 0; keyNum < keySize; keyNum++) {
			
			try {
				//关键字段键值对的构造
				if (isKeyMark(keyArray[keyNum])) {
					//and key = 'value'
					isKeyMarkKeyValue.append("and ").append(keyArray[keyNum].substring(1))
											   		.append("='")
											   		.append(valueArray[keyNum])
											   		.append("' ");
				} //非关键字段键值对的构造
				else {
					//,key
					keyList = keyList.append(",").append(keyArray[keyNum].substring(1));

					//,'value'
					valueList = valueList.append(",'")
										 .append(valueArray[keyNum])
										 .append("'");									 

					//,key = 'value'
					notKeyMarkKeyValue = notKeyMarkKeyValue.append(",")
											 .append(keyArray[keyNum].substring(1))
											 .append("='")
											 .append(valueArray[keyNum])
											 .append("'");
				}
			} catch (Exception e) {
				log.error("execSql(String tableName, int tableAction,Hashtable<String, String> dbParam)执行SQL语句构造时失败");
				log.info(e.getMessage());
			}
		}

		switch(tableAction){
		//insert语句：insert into tableName(keyList) values(valueList)
		case INSERT:		
				sqlStatement = sqlStatement.append("insert into ")
											.append(tableName)
											.append("(")
											.append(keyList.substring(1))
											.append(") values(")
											.append(valueList.substring(1))
											.append(")");
				break;
		//update语句:update tableName set notKeyMarkKeyValue where isKeyMarkKeyValue
		case UPDATE:
			sqlStatement = sqlStatement.append("update ")
			.append(tableName)
			.append(" set ")
			.append(notKeyMarkKeyValue.substring(1))
			.append(" where ")
			.append(isKeyMarkKeyValue.substring(4));
			break;
		//delete语句:delete from tableName where isKeyMarkKeyValue		
		case DELETE:
			sqlStatement = sqlStatement.append("delete from ")
			.append(tableName)
			.append(" where ")
			.append(isKeyMarkKeyValue.substring(4));
			break;
		default:
				log.error("传入的ACTION参数不符合要求！");			
		}

		log.info("execSql(String tableName, int tableAction,Hashtable<String, String> dbParam)构造的SQL语句为："+sqlStatement.toString());
		
		return execSql(sqlStatement.toString());
	}

	/**
	 * 函数功能：执行一个完整的sql语句
	 * @param sqlStr
	 * @return
	 */
	public static boolean execSql(String sqlStr) {
		Connection conn = null;
		Statement st = null;

		try {
			conn = DBconn.getConnection();
			st = conn.createStatement();
			st.execute(sqlStr);
			return true;
		} catch (Exception e) {
			log.error("数据库连接异常", e);
			log.info(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("数据库关闭失败！");
			}
		}
		return false;
	}

	/**
	 * 函数功能：一个事务的处理(一组SQL操作语句,都执行成功返回true,否则返回false)
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean execSql(String[] sql) throws SQLException{
		Connection conn = null;
		Statement st = null;

		try {
			conn = DBconn.getConnection();
			st = conn.createStatement();
			
			//设置为手动提交，取消默认的每个语句自动提交
			conn.setAutoCommit(false);

			//逐个执行SQL语句
			for (int i = 0; i < sql.length; i++) {
				st.execute(sql[i]);
			}
			
			//事务提交
			conn.commit();
			
			return true;
		} catch (Exception e) {
			log.error("数据库连接异常", e);
			log.error(e.getMessage());
			
			//出现异常实行事务回滚
			conn.rollback();
			log.info("SQL事务执行失败，已执行回滚操作！");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("数据库关闭失败！");
			}
		}
		return false;
	}

	public static boolean isKeyMark(String str) throws Exception {
		if (str.startsWith(keyMark)) {
			return true;
		} else if (str.startsWith(nonKeyMark)) {
			return false;
		} else{
			log.error("传入的字段名不符合要求!无效字段名为"+str);
			throw new Exception("非有效字段！");
		}
	}
}
