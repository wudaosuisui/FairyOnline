package com.fairyonline.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;





@Entity
@Table(name="userLogin")
public class UserLogin {
	/*
	private int LoginID;
	private String UserName;
	private String PassWord;
	private User user;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getLoginID() {
		return LoginID;
	}
	public void setLoginID(int loginID) {
		LoginID = loginID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="ID")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	*/
	private String UserName;
	private String PassWord;
	private User user;
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	
	@OneToOne(mappedBy="userName")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserLogin() {
	}
	public UserLogin(String UserName,String PassWord) {
		// TODO Auto-generated constructor stub
				this.UserName = UserName;
				this.PassWord = PassWord;
	}
	
}
