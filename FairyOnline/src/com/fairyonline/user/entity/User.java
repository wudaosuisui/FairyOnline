package com.fairyonline.user.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User {
	private int id;
	private String petName;
	private String img;
	private String tName;
	private String sex;
	private UserLogin userLogin;
	private List<User> followUserList = new ArrayList<User>();
	
	public User(String petName,String img,String tName,String sex,UserLogin userLogin) {
		// TODO Auto-generated constructor stub
		this.petName = petName;
		this.img = img;
		this.tName = tName;
		this.sex = sex;
		this.userLogin = userLogin;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPetName() {
		return petName;
	}
	
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="UserName")
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	@ManyToMany
	@JoinTable(name="FOLLOWUSER", 
    joinColumns=@JoinColumn(name="UID"),
    inverseJoinColumns=@JoinColumn(name="FID"))
    public List<User> getFollowUserList() {
		return followUserList;
	}
	public void setFollowUserList(List<User> followUserList) {
		this.followUserList = followUserList;
	}
	
	
	
}
