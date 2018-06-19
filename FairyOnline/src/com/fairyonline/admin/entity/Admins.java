package com.fairyonline.admin.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.user.entity.RCourse;
@Entity
@Table(name="Admins")
public class Admins {
	private String UserName;
	private String PassWord;
	private String Power;
	private List<Gag> gagList = new ArrayList<Gag>();
	private List<Title> titleList = new ArrayList<Title>();
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
	public String getPower() {
		return Power;
	}
	public void setPower(String power) {
		this.Power = power;
	}
	@OneToMany(mappedBy="aName", targetEntity=Gag.class, 
	        cascade=CascadeType.ALL)
	public List<Gag> getGagList() {
		return gagList;
	}
	public void setGagList(List<Gag> gagList) {
		this.gagList = gagList;
	}
	@OneToMany(mappedBy="aName", targetEntity=Title.class, 
	        cascade=CascadeType.ALL)
	public List<Title> getTitleList() {
		return titleList;
	}
	public void setTitleList(List<Title> titleList) {
		this.titleList = titleList;
	}
	
}		

