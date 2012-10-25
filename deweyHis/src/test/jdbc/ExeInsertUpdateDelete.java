package test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

public class ExeInsertUpdateDelete {
	static Logger log = Logger.getLogger("logfile");

	//����insert into tableName(key,key...key) values(value,value...value)
	public final static int INSERT = 1;

	//�޸�update tableName set key=value,key=value..key=value where key=value and key=value
	public final static int UPDATE = 2;

	//ɾ��delete from tableName where key=value and key=value
	public final static int DELETE = 3;

	public static String keyMark = "$"; //�ؼ��Ӷα�ʶ��where�־��е�key=value��

	public static String nonKeyMark = "_"; //һ���ֶα�ʶ����where�־���key=value��

	/** 
	 * �������ܣ��������SQL��������ִ�и�SQL���
	 * tableName Ϊ�����ƣ�
	 * tableAction Ϊִ�еĲ����������롢�޸ġ�ɾ���������Ӧ��ֵȡ1��2��3
	 * dbParam Ϊ��ϣ��������е��ֶκͶ�Ӧ��ֵ�����ִ�гɹ����򷵻�true�����򷵻�false
	 */
	public static boolean execSql(String tableName, int tableAction,
			Hashtable<String, String> dbParam) throws Exception {
		//HsahTable������
		int keySize = dbParam.size();

		//���������SQL���
		StringBuffer sqlStatement = new StringBuffer();

		//���� Set ��ͼ
		Set<String> set = dbParam.keySet();

		//��ż�������
		String[] keyArray = new String[keySize];

		//���ֵ������
		String[] valueArray = new String[keySize];

		//����set���ϣ������ֵ������
		int keyNum = 0;
		for (String key : set) {
			keyArray[keyNum] = (String) key;
			valueArray[keyNum] = (String) dbParam.get(key);
			keyNum++;
		}

		//���б�����key,key,key��ʽ���
		StringBuffer keyList = new StringBuffer();
		
		//SQL Server�е�sql��䲻���Ƿ�Ϊ���ֻ��ַ������Լ�''�����и�ֵ,�����ƺ������ݿ����Լ�������������ת��(�ַ�����ת��Ϊ���ֿ��Է�֮����)����ͳһ��Ϊ��value��

		//ֵ�б�����'value','value','value'��ʽ���
		StringBuffer valueList = new StringBuffer();

		//�ǹؼ��Ӷεļ�ֵ���б�����key='value',key='value'��ʽ���
		StringBuffer notKeyMarkKeyValue = new StringBuffer();

		//�ؼ��Ӷεļ�ֵ���б�����key=value and key=value��ʽ���
		StringBuffer isKeyMarkKeyValue = new StringBuffer();		

		
		for (keyNum = 0; keyNum < keySize; keyNum++) {
			
			try {
				//�ؼ��ֶμ�ֵ�ԵĹ���
				if (isKeyMark(keyArray[keyNum])) {
					//and key = 'value'
					isKeyMarkKeyValue.append("and ").append(keyArray[keyNum].substring(1))
											   		.append("='")
											   		.append(valueArray[keyNum])
											   		.append("' ");
				} //�ǹؼ��ֶμ�ֵ�ԵĹ���
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
				log.error("execSql(String tableName, int tableAction,Hashtable<String, String> dbParam)ִ��SQL��乹��ʱʧ��");
				log.info(e.getMessage());
			}
		}

		switch(tableAction){
		//insert��䣺insert into tableName(keyList) values(valueList)
		case INSERT:		
				sqlStatement = sqlStatement.append("insert into ")
											.append(tableName)
											.append("(")
											.append(keyList.substring(1))
											.append(") values(")
											.append(valueList.substring(1))
											.append(")");
				break;
		//update���:update tableName set notKeyMarkKeyValue where isKeyMarkKeyValue
		case UPDATE:
			sqlStatement = sqlStatement.append("update ")
			.append(tableName)
			.append(" set ")
			.append(notKeyMarkKeyValue.substring(1))
			.append(" where ")
			.append(isKeyMarkKeyValue.substring(4));
			break;
		//delete���:delete from tableName where isKeyMarkKeyValue		
		case DELETE:
			sqlStatement = sqlStatement.append("delete from ")
			.append(tableName)
			.append(" where ")
			.append(isKeyMarkKeyValue.substring(4));
			break;
		default:
				log.error("�����ACTION����������Ҫ��");			
		}

		log.info("execSql(String tableName, int tableAction,Hashtable<String, String> dbParam)�����SQL���Ϊ��"+sqlStatement.toString());
		
		return execSql(sqlStatement.toString());
	}

	/**
	 * �������ܣ�ִ��һ��������sql���
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
			log.error("���ݿ������쳣", e);
			log.info(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("���ݿ�ر�ʧ�ܣ�");
			}
		}
		return false;
	}

	/**
	 * �������ܣ�һ������Ĵ���(һ��SQL�������,��ִ�гɹ�����true,���򷵻�false)
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
			
			//����Ϊ�ֶ��ύ��ȡ��Ĭ�ϵ�ÿ������Զ��ύ
			conn.setAutoCommit(false);

			//���ִ��SQL���
			for (int i = 0; i < sql.length; i++) {
				st.execute(sql[i]);
			}
			
			//�����ύ
			conn.commit();
			
			return true;
		} catch (Exception e) {
			log.error("���ݿ������쳣", e);
			log.error(e.getMessage());
			
			//�����쳣ʵ������ع�
			conn.rollback();
			log.info("SQL����ִ��ʧ�ܣ���ִ�лع�������");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				log.error("���ݿ�ر�ʧ�ܣ�");
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
			log.error("������ֶ���������Ҫ��!��Ч�ֶ���Ϊ"+str);
			throw new Exception("����Ч�ֶΣ�");
		}
	}
}
