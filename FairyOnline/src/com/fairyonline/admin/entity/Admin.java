package com.fairyonline.admin.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.course.entity.Category;

@Entity
@Table(name="Admin")
public class Admin {
	private String userName;
	private String PassWord;
	
	@Id
	@GenericGenerator(name="loginId", strategy="assigned")
	@GeneratedValue(generator="loginId")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		userName = userName;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		PassWord = passWord;
	}
	
}
