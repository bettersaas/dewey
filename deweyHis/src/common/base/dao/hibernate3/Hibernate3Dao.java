package common.base.dao.hibernate3;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import common.base.model.vo.PagerVO;

public class Hibernate3Dao  extends HibernateDaoSupport{
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	// @Autowired ע�����װ�䣬ֻ���Ǹ������ͽ���ƥ��
	// @Autowired ע��������� Setter ���������캯�����ֶΣ�������ͨ������ǰ���Ƿ�������������һ������
	// @Resource ʹ�� byName �ķ�ʽִ���Զ���װ��
	// @Resource(name="dataSource")
	// @Resource(type=DataSource.class)
	@Autowired
	protected SessionFactory sessionFactory;  // @Resource
	
	@PostConstruct
	public void init() {
		logger.info(this.getClass().getName() + "  Hibernate3Dao�����ʼ����");
	}
	
	@PreDestroy
	public void destroy() {
		logger.info("Hibernate3Dao��������!");
	}
	
	/**
	 * ����
	 * @param transientInstance
	 * @return
	 */
	public Long save(Object transientInstance) {
			return (Long)this.getHibernateTemplate().save(transientInstance);
	}
	
	/**
	 * ������Idʱ���£����򱣴�
	 * @param chargeRuleSetting
	 */
	public void saveOrUpdate(Object transientInstance) {
		this.getHibernateTemplate().saveOrUpdate(transientInstance);
	}
	
	/**
	 * ����
	 * @param transientInstance
	 */
	public void update(Object transientInstance) {
		this.getHibernateTemplate().update(transientInstance);
	}
	
	/**
	 * ɾ��
	 * @param persistentInstance
	 */
	public void delete(Object persistentInstance) {
			this.getHibernateTemplate().delete(persistentInstance);
	}
	
	/**
	 * ����Id��ö���
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public Object getById(Class<?> entityClass,Long id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * ����Idɾ������
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public int deleteById(Class<?> entityClass,Long id) {
		String queryString = "delete " + entityClass.getSimpleName() + " where id = :id ";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setLong("id", id);
		return query.executeUpdate();
	}
	
	/**
	 * ��ҳ��ѯ
	 * @param countSqlStr
	 * @param sqlStr
	 * @param param
	 * @return
	 */
	public PagerVO queryPageForList(String countSqlStr, String sqlStr, Object param) {
		// ��ҳ��Ϣ�洢bean�Ľ���
		PagerVO pager = (PagerVO)param;
		if (pager == null) {
			throw new IllegalArgumentException("��ҳ��ѯ��Ҫ�̳з�ҳ�࣬�Ҳ���Ϊnull");
		}
		logger.info(pager);

		// �����ܼ�¼��
		Session session = this.getSession();
		int countAll = (Integer) session.createQuery(countSqlStr).uniqueResult();
		logger.info("�ܼ�¼��Ϊ��" + countAll);
		pager.setCountAll(countAll);
		
		Query query = session.createQuery(sqlStr);
		query.setFirstResult(pager.getOffset());
		query.setMaxResults(pager.getLimit());

		List<?> list = query.list();
		// ���÷�ҳ��ʾ��List����
		pager.setPagerList(list);
		return pager;
	}
	
//	public Connection getConnection()  
//	  {  
//	    try  
//	    {
//	      Session curSeesion =null;  
//	      Connection con =null;  
//	      curSeesion = super.getHibernateTemplate().getSessionFactory().getCurrentSession();  
//	      con = curSeesion.connection();  
//	      return con;  
//	    }  
//	    catch(Exception es)  
//	    {  
//	      System.out.println(es.getMessage());  
//	      return null;  
//	    }  
//	  }  
//	  
//	  public ArrayList<Object> fetchObjects(ResultSet rs)  
//	  {  
//	    ArrayList<Object> ret = new ArrayList<Object>();  
//	    //example:  
//	    //while(rs.next())  
//	    //{  
//	    //Object object = new Object();  
//	    //rs.getString(1);  
//	    //rs.getString(2);  
//	    //ret.add(object);    
//	    //}  
//	    return ret;  
//	  }  
//	  
//	  public ArrayList<Object> getObjectsBySql(String pureSql)  
//	  {  
//	    Connection con = curSeesion.connection();  
//	    ps  =  con.prepareStatement(sqlbuf.toString());  
//	    rs = ps.executeQuery();  
//	    try  
//	    {  
//	      return this.fetchObjects(rs);  
//	    }  
//	    catch(Exception es)  
//	    {  
//	      System.out.println(es.getMessage());  
//	      return null;  
//	    }  
//	    finally  
//	    {  
//	      try  
//	      {  
//	        ps.close();  
//	        rs.close();  
//	        con.close();  
//	      }  
//	      catch (SQLException e) {  
//	        // TODO Auto-generated catch block  
//	        e.printStackTrace();  
//	      }  
//	    }  
//	  }  
}
