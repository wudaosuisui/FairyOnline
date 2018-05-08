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
@Table(name="user")
public class User {
	private int ID;
	private String PetName;
	private String Img;
	private String TName;
	private String Sex;
	private UserLogin UserLogin;
	
	public User(String PetName,String Img,String TName,String Sex,UserLogin UserLogin) {
		// TODO Auto-generated constructor stub
		this.PetName = PetName;
		this.Img = Img;
		this.TName = TName;
		this.Sex = Sex;
		this.UserLogin = UserLogin;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="UserName")
	public UserLogin getUserLogin() {
		return UserLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		UserLogin = userLogin;
	}

	public String getPetName() {
		return PetName;
	}
	public void setPetName(String petName) {
		PetName = petName;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	public String getTName() {
		return TName;
	}
	public void setTName(String tName) {
		TName = tName;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	
	
}
