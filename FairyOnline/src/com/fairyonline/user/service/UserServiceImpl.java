package com.fairyonline.user.service;

import java.util.List;


import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fairyonline.user.dao.UserDaoImpl;
import com.fairyonline.user.entity.User;
import com.fairyonline.user.entity.UserLogin;
import com.fairyonline.user.entity.UserLogin1;


@Service
@Transactional(readOnly=true)
public class UserServiceImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private UserDaoImpl userDaoImpl;
	
	public List<User> listAll(){
		return this.userDaoImpl.findAll();
	}
	public List<UserLogin> allUserLogin(){
		List<UserLogin> list = this.userDaoImpl.allUserLogin();
		return list;
	}
	
	public void addUserLogin(UserLogin userLogin) {
		Session session = sessionFactory.openSession();
		this.userDaoImpl.addUserLogin(userLogin);
		session.close();
	}
	public void addUser(User user) {
		Session session = sessionFactory.openSession();
		this.userDaoImpl.addupUser(user);
		session.close();
	}
	public UserLogin login(String UserName,String PassWord) {
		UserLogin userLogin = this.userDaoImpl.login(UserName, PassWord);
		return userLogin;
	}
	public UserLogin findUserLogin(String UserName) {
		UserLogin userLogin = this.userDaoImpl.findUserLogin(UserName);
		return userLogin;
	}
	
	public User  findUserById(int ID) {
		User user = this.userDaoImpl. findUserById(ID);
		return user;
	}
	
	public boolean updateUser(User user) {
		return this.userDaoImpl.updateUser(user);
	}
	
	public User findUser(String UserName) {
		User user = this.userDaoImpl.findUser(UserName);
		return user;
	}
	/*public void addupUser(User user) {
		Session session = sessionFactory.openSession();
		this.userDaoImpl.addupUser(user);
		session.close();
	} */
}
