package com.fairyonline.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Table(name="Admin")
public class Admin {
	private String UserName;
	private String PassWord;
	
	@Id
	@GenericGenerator(name="loginId", strategy="assigned")
	@GeneratedValue(generator="loginId")
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
