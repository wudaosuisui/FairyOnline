package com.fairyonline.admins.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Admins")
public class Admins {
	private String UserName;
	private String PassWord;
	/*private int Power;*/
	
	@Id
	@GenericGenerator(name="loginId", strategy="assigned")
	@GeneratedValue(generator="loginId")
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		this.UserName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		this.PassWord = passWord;
	}
	/*public int getPower() {
		return Power;
	}
	public void setPower(int power) {
		this.Power = power;
	}*/
	
	
}
