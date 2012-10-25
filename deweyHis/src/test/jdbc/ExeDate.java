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
	
	//��ʱ��
	static private Date login_time = null;
	
	//��½����
	static private int  login_count = 0;	
	
	//�м�SQL���Ĺ���
	static String  sql = null;
	
	//�Ƿ����Ա������SQL���������ݱ�
	private boolean isManager = false;
	
	//���ݿ�����ļ�¼ɸѡ����
	private String 	username = null;
	
	public ExeDate(boolean manager, String username) {
		super();
		isManager = manager;
		this.username = username;
	}
	
	/**
	 * ����˵������ѯ��ʱ��
	 */
	private void getTime(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		//���ݿ��ѯʱ��ʱֱ��תΪ���ڸ�ʽ���ַ����
		//SQL server������ת��(datetime to varchar(19)),style=2 ��120(*)ΪODBC�淶��ʾΪ��yyyy-mm-dd hh:mm:ss[.fff] 
		if (isManager)
			sql = "select CONVERT(varchar(19),LOGIN_TIME,20) from D_MANAGER where MANAGER_LOGIN='"+ username+"'";
		else
			sql = "select CONVERT(varchar(19),LOGIN_TIME,20) from D_USER where LOGIN_USER='" + username+"'";

		String timeString = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			conn = DBconn.getConnection();
			st = conn.createStatement();
			
			log.info("��ѯʱ���sql���Ϊ��"+sql);
			
			rs = st.executeQuery(sql);
			
			//ָ���һ�м�¼
			rs.next();
			
			//���д�1��ʼlogin_time = rs.getDate(1);	
			timeString = rs.getString(1);
			
			log.info("��ѯ���û���½ʱ��Ϊ��"+timeString);
			
			//NULLֵSQLת���ַ�����ΪNULL
			if (timeString == null) {
				login_time = null;
			} else {
				login_time = sdf.parse(timeString);
				//��ʾȡ�õ�ʱ��
				//ShowDate.show(login_time);
			}			
		} catch (Exception e) {
			log.error("��ѯ�õ�½�ߵĵ�½ʱ��SQL���ִ��ʧ�ܣ�"+sql);
			log.info(e.getMessage());
		} finally {
			DBconn.closeConnection(conn);
		}
	}
	
	/**
	 * ����˵������ѯ��½����
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
			
			log.info("ȡ��½������sql���Ϊ��"+sql);
			
			rs = st.executeQuery(sql);
			
			//ָ���һ�м�¼
			rs.next();
			
			//���д�1��ʼ
			login_count = rs.getInt(1);
			
			log.info("ȡ�õĵ�½����Ϊ"+login_count+"��1��");
		} catch (Exception e) {
			log.error("��ѯ�õ�½�ߵĵ�½����SQL���ִ��ʧ�ܣ�"+sql);
			log.info(e.getMessage());
		} finally {
			DBconn.closeConnection(conn);
		}
	}
	
	/**
	 * ����˵�������ݿ�ĸ������Ӳ���
	 * �����ó�ʼ״̬NULL��
	 * �����ý���ʱ�����
	 * �����õ�½����Ϊ0��
	 * ����μ�����½����
	 */
	private void setValue(){
		Connection conn = null;
		Statement st = null;		
		try {
			conn = DBconn.getConnection();
			st = conn.createStatement();
			
			log.info("������sql���Ϊ��"+sql);
			
			st.execute(sql);
		}catch(Exception e){
			log.error("ִ�и��µ�½����Ϣ��SQL���ִ��ʧ�ܣ�"+sql);
			log.info(e.getMessage());
		}finally{
			DBconn.closeConnection(conn);
		}
	}

	/**
	 * ����˵�������ݿ���μ��������ʱ���
	 */
	public void clockUpdateSqlDate() {
		
		getCount();
		
		//�������Ϊ��3��ʱ0,1,2������ʱ���
		if(login_count == 2){
			
			//��ʽ��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			//ȡ��ǰϵͳʱ��,��ʾ��ǰʱ��
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			
			//����30����֮���ʱ��
			cal.add(Calendar.MINUTE, 30);
			
			//����SQL����е�ʱ���ַ���
			String s = sdf.format(cal.getTime());
			
			//�������ݿ��ʱ��ʱ����ʽ���������ַ�ת��Ϊ���ݿ��ʱ������
			if (isManager)
				sql = "update D_MANAGER set  LOGIN_TIME=CAST('"+s+"' as datetime) where MANAGER_LOGIN='"+ username+"'";
			else
				sql = "update D_USER    set  LOGIN_TIME=CAST('"+s+"' as datetime) where LOGIN_USER='" + username+"'";
			
			setValue();
			
			//����ʱ������½������0
			login_count = 0;
			unclockSetSqlCount();			
		}else{ //�������С��3��ʱ��ÿ��һ��ʱ����������ۼ�1
			login_count++;
			if (isManager)
				sql = "update D_MANAGER set  LOGIN_COUNT="+Integer.toString(login_count)+" where MANAGER_LOGIN='"+ username+"'";
			else
				sql = "update D_USER    set  LOGIN_COUNT="+Integer.toString(login_count)+" where LOGIN_USER='" + username+"'";
			setValue();
		}
	}

	/**
	 * ����˵��������Ƿ��ڱ���״̬�����򷵻�true�����򷵻�false
	 * @return
	 */
	public boolean isClocked() {
		getTime();
		
		//���û������ʱ���־����ֱ�ӷ���false
		if (login_time == null) {
			log.info("��ѯʱ��Ϊ��!");
			return false;
		}
		
		//����ʱ���־��Ƚ�ʱ���Ƿ��Ѿ�����,ȡ��ǰϵͳʱ��,��ʾ��ǰʱ��
		Date now = new Date();
		Calendar calnow = Calendar.getInstance();
		calnow.setTime(now);
		
		Calendar calold = Calendar.getInstance();
		calold.setTime(login_time);

		//��⵱ǰ��ʱ���Ƿ��ѹ��˽���ʱ�䣬�����������ԭ��ʱ��ΪNULL,����û��false
		if (calnow.after(calold)) {
			unclockSetSqlTime();
			return false;
		} else
			return true;
	}

	/**
	 * ����˵������������֮һ-����������ʱ��ΪNULL
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
	 * ����˵������������֮��-���õ�½����Ϊ0�������½������¼
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