package com.fairyonline.user.entity;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.fairyonline.course.entity.Cart;
import com.fairyonline.course.entity.Orders;

@Entity
@Table(name="user")
public class User {
	private int id;
	private String petName;
	private String img;
	private String tName;
	private String sex;
	private UserLogin userLogin;
	private Set<Cart> cartSet = new HashSet<Cart>();
	private Set<Orders> orderSet = new HashSet<Orders>();
	
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
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="UserId")
	public Set<Cart> getCartSet() {
		// TODO Auto-generated method stub
		return cartSet;
	}
	public void setCartSet(Set<Cart> cartSet) {
		this.cartSet = cartSet;
	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="UserId")
	public Set<Orders> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}

	
}
