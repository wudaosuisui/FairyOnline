package com.fairyonline.user.service;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fairyonline.user.dao.UserDaoImpl;
import com.fairyonline.user.entity.User;
import com.fairyonline.user.entity.UserLogin;


@Service
@Transactional(readOnly=true)
public class UserServiceImpl {
	@Resource
	private UserDaoImpl userDaoImpl;
	
	public List<User> listAll(){
		return this.userDaoImpl.findAll();
	}
	public List<UserLogin> allUserLogin(){
		List<UserLogin> list = this.userDaoImpl.allUserLogin();
		return list;
	}
	public boolean addUserLogin(UserLogin UserLogin) {
		return this.userDaoImpl.addUserLogin(UserLogin);
	}
	
	public boolean addUser(User user) {
		return this.userDaoImpl.addUser(user);
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
	
	public boolean addupUser(User user) {
		return this.userDaoImpl.addUser(user);
	}
}
