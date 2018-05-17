package com.fairyonline.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userLogin1")
public class UserLogin1 {
	//private int LoginId;
	private String UserName;
	private String PassWord;
	
	public UserLogin1() {
	}
	public UserLogin1(String UserName,String PassWord) {
		// TODO Auto-generated constructor stub
		this.UserName = UserName;
		this.PassWord = PassWord;
	}
	
	/*public int getLoginId() {
		return LoginId;
	}
	public void setLoginId(int loginId) {
		LoginId = loginId;
	}  */
	@Id
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
	
	
}
