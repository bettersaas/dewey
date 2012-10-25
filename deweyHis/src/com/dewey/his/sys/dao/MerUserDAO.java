package com.dewey.his.sys.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dewey.his.common.model.Mer;
import com.dewey.his.sys.model.MerUser;
import common.base.dao.hibernate3.Hibernate3Dao;

@Repository("merUserDAO")
public class MerUserDAO extends Hibernate3Dao {
	
	@SuppressWarnings("unchecked")
	public List<MerUser> getMerAllUser(long merId) {
			String queryString = "from MerUser where mer.id=:merId";
			Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
			query.setLong("merId", merId);
			return (List<MerUser>)query.list();
	}
	
	/**
	 * 根据杜威号和登录名返回用户信息
	 */
	public MerUser getUserByUserName(String deweyNo,String loginName) {
		String queryString = "select t1 from MerUser as t1  where t1.mer.deweyNo=:deweyNo and  t1.loginName=:loginName";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setString("deweyNo", deweyNo);
		query.setString("loginName", loginName);
		return  (MerUser)query.uniqueResult();
	}
	
	/**
	 * 根据杜威号和登录名返回用户信息、商户信息
	 * 
	 * 返回两个对象 【0】：MerUser  【1】：Mer
	 * @param deweyNo
	 * @param loginName
	 * @return
	 */
	public Object[] getUserMerByUserName(String deweyNo,String loginName) {
		Object[]  bo = {null,null};
		String queryString = "select t1,t2 from MerUser as t1,Mer as t2  where  t1.mer.id=t2.id and  t2.deweyNo=:deweyNo and  t1.loginName=:loginName";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setString("deweyNo", deweyNo);
		query.setString("loginName", loginName);
		Object[] o = (Object[])query.uniqueResult();
		if (o == null) {
			bo = null;
		} else {
			bo[0] = (MerUser)o[0];
			bo[1] = (Mer)o[1];
		}
		return  bo;
	}
	
	/**
	 * 根据用户id更新用户的密码
	 */
	public int updateUserPassword(String password,Long userId) {
		String queryString = "update  MerUser   set   password = :password   where id = :id ";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setString("password", password);
		query.setLong("id", userId);
		return query.executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<MerUser> getByMerLoginName(long merId, String loginName) {
		String queryString = "from MerUser as model where model.mer.id= ? and model.loginName=?";
		Query queryObject = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, merId);
		queryObject.setParameter(1, loginName);
		return queryObject.list();
	}
	
	/**
	 * 根据用户id更新用户的角色
	 */
	public int updateUserRole(String role,Long userId) {
		String queryString = "update  MerUser   set   role = :role   where id = :id ";
		Query query = this.getSessionFactory().getCurrentSession().createQuery(queryString);
		query.setString("role", role);
		query.setLong("id", userId);
		return query.executeUpdate();
	}
}