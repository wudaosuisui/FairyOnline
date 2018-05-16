package com.fairyonline.user.dao;

import java.util.List;


import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fairyonline.user.entity.User;
import com.fairyonline.user.entity.UserLogin;
import com.fairyonline.user.entity.UserLogin1;


@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<User> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from User");
		return q.list();
	}
	
	public List<UserLogin> allUserLogin(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserLogin");
		List<UserLogin> list = query.list();
		return list;
	}
	
	public void addUserLogin(UserLogin userLogin) {
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tra = session.beginTransaction();//开启事务
		session.save(userLogin);
		System.out.println("save success");
		session.flush();
		tra.commit();
		System.out.println("out Dao");
	}
	
	public boolean addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
        return true;
	}
	
	
	public UserLogin login(String userName,String passWord) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserLogin where userName=? and passWord=?");
		query.setParameter(0,userName);
		query.setParameter(1,passWord);
		UserLogin userLogin = (UserLogin)query.uniqueResult();
		if(userLogin!=null) {
			return userLogin;
		}else {
			System.out.println("userLogin Dao出错");
			return null;
		}
	}
	
	public UserLogin findUserLogin(String userName) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserLogin where userName=?");
		query.setParameter(0,userName);
		UserLogin userLogin = (UserLogin)query.uniqueResult();
		return userLogin;
	}
	
	public User findUserById(int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from User where id=?");
		query.setParameter(0,id);
		User user = (User)query.uniqueResult();
		return user;
	}
	
	/*public boolean updateUser(User user) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("update User set petName=?,img=?,sex=?,tName=? where id=?");
		query.setParameter(0,user.getPetName());
		query.setParameter(1,user.getImg());
		query.setParameter(2,user.getSex());
		query.setParameter(3,user.gettName());
		query.setParameter(4,user.getid());
		int i = query.executeUpdate();
		if(i>0) {
			System.out.println("updateUserDao执行成功");
			return true;
		}else {
			System.out.println("updateUserDao执行失败");
			return false;
		}
	}*/
	public void updateUser(User user) {//更新user
		Session session = sessionFactory.getCurrentSession();
		Transaction tra = session.beginTransaction();//开启事务
		session.update(user);
		session.flush();
		tra.commit();
	}
	public UserLogin findUser(String userName) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserLogin where userName=?");
		query.setParameter(0,userName);
		UserLogin user = (UserLogin)query.uniqueResult();
		return user;
	}

	public List<UserLogin> getUserByPartName(String userName){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from UserLogin where userName like ?");
		query.setString(0,"%"+userName+"%");
		return query.list();
	}
	
}
