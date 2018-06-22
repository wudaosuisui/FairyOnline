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

import com.fairyonline.course.entity.Video;
import com.fairyonline.teacher.entity.Teacher;
import com.fairyonline.user.entity.RCourse;
import com.fairyonline.user.entity.RUser;
import com.fairyonline.user.entity.User;
import com.fairyonline.user.entity.UserLogin;



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
		System.out.println("user name : " +userLogin.getUserName()+"  user password :  "+userLogin.getPassWord() );
		session.save(userLogin);
		System.out.println("user name : " +userLogin.getUserName()+"  user password :  "+userLogin.getPassWord() );
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
	
	public User getUserById(int id){
		Session session = sessionFactory.getCurrentSession();
		Transaction tra = session.beginTransaction();//开启事务
		User u = session.get(User.class, id);
		session.flush();
		tra.commit();
		return u;
	}
	
	public Teacher findTeacher(String Name) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Teacher where Name=?");
		query.setParameter(0,Name);
		Teacher teacher = (Teacher)query.uniqueResult();
		return teacher;
	}
	
	public List<RUser> findAllRUser(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from RUser");
		return q.list();
	}
	
	public boolean addRUser(RUser ruser) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(ruser);
        return true;
	}
	
	public Video findVideoById(int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Video where id=?");
		query.setParameter(0,id);
		Video video = (Video)query.uniqueResult();
		return video;
	} 
	
	public List<RCourse> findAllRCourse(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from RCourse");
		return q.list();
	}
	
	public boolean addRCourse(RCourse rcourse) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(rcourse);
        return true;
	}
}
