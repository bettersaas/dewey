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
	
	// @Autowired 注解进行装配，只能是根据类型进行匹配
	// @Autowired 注解可以用于 Setter 方法、构造函数、字段，甚至普通方法，前提是方法必须有至少一个参数
	// @Resource 使用 byName 的方式执行自动封装。
	// @Resource(name="dataSource")
	// @Resource(type=DataSource.class)
	@Autowired
	protected SessionFactory sessionFactory;  // @Resource
	
	@PostConstruct
	public void init() {
		logger.info(this.getClass().getName() + "  Hibernate3Dao对象初始化！");
	}
	
	@PreDestroy
	public void destroy() {
		logger.info("Hibernate3Dao对象销毁!");
	}
	
	/**
	 * 保存
	 * @param transientInstance
	 * @return
	 */
	public Long save(Object transientInstance) {
			return (Long)this.getHibernateTemplate().save(transientInstance);
	}
	
	/**
	 * 对象有Id时更新，否则保存
	 * @param chargeRuleSetting
	 */
	public void saveOrUpdate(Object transientInstance) {
		this.getHibernateTemplate().saveOrUpdate(transientInstance);
	}
	
	/**
	 * 更新
	 * @param transientInstance
	 */
	public void update(Object transientInstance) {
		this.getHibernateTemplate().update(transientInstance);
	}
	
	/**
	 * 删除
	 * @param persistentInstance
	 */
	public void delete(Object persistentInstance) {
			this.getHibernateTemplate().delete(persistentInstance);
	}
	
	/**
	 * 根据Id获得对象
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public Object getById(Class<?> entityClass,Long id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * 根据Id删除对象
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
	 * 分页查询
	 * @param countSqlStr
	 * @param sqlStr
	 * @param param
	 * @return
	 */
	public PagerVO queryPageForList(String countSqlStr, String sqlStr, Object param) {
		// 分页信息存储bean的解析
		PagerVO pager = (PagerVO)param;
		if (pager == null) {
			throw new IllegalArgumentException("分页查询需要继承分页类，且不能为null");
		}
		logger.info(pager);

		// 设置总记录数
		Session session = this.getSession();
		int countAll = (Integer) session.createQuery(countSqlStr).uniqueResult();
		logger.info("总记录数为：" + countAll);
		pager.setCountAll(countAll);
		
		Query query = session.createQuery(sqlStr);
		query.setFirstResult(pager.getOffset());
		query.setMaxResults(pager.getLimit());

		List<?> list = query.list();
		// 设置分页显示的List数据
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
