package com.fairyonline.user.entity;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

//<<<<<<< HEAD
import com.fairyonline.teacher.entity.Teacher;
//=======
import com.fairyonline.course.entity.Cart;
import com.fairyonline.course.entity.FollowCourse;
import com.fairyonline.course.entity.Orders;
import com.fairyonline.course.entity.OrdersList;
//>>>>>>> refs/remotes/origin/sy

@Entity
@Table(name="user")
public class User {
	private int id;
	private String petName;
	private String img;
	private String tName;
	private String sex;
	private UserLogin userLogin;
//<<<<<<< HEAD
	private List<User> followUserList = new ArrayList<User>();
	private List<Teacher> teacherList = new ArrayList<Teacher>();
	private List<RUser> reportUserList = new ArrayList<RUser>();
	//private List<User> reportUserList1 = new ArrayList<User>();
//=======
	private Set<Cart> cartSet = new HashSet<Cart>();
	private Set<Orders> orderSet = new HashSet<Orders>();
	private Set<FollowCourse> fcSet = new HashSet<FollowCourse>();
//>>>>>>> refs/remotes/origin/sy
	
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
	@ManyToMany
	@JoinTable(name="USERTEACHER", 
	    joinColumns=@JoinColumn(name="UID"),
	    inverseJoinColumns=@JoinColumn(name="TID"))
    public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
//<<<<<<< HEAD
	
	@OneToMany(mappedBy="rid", targetEntity=RUser.class, 
	        cascade=CascadeType.ALL)
	public List<RUser> getReportUserList() {
		return reportUserList;
	}
	public void setReportUserList(List<RUser> reportUserList) {
		this.reportUserList = reportUserList;
	}
//=======
//	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name="user")
//	public Set<OrdersList> getOrderListSet() {
//		return orderListSet;
//	}
//	public void setOrderListSet(Set<OrdersList> orderListSet) {
//		this.orderListSet = orderListSet;
//	}
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="fuid")
	public Set<FollowCourse> getFcSet() {
		return fcSet;
	}
	public void setFcSet(Set<FollowCourse> fcSet) {
		this.fcSet = fcSet;
	}
	
//>>>>>>> refs/remotes/origin/sy
	public Set<Cart> getCartSet() {
		return cartSet;
	}
	public void setCartSet(Set<Cart> cartSet) {
		this.cartSet = cartSet;
	}
	public Set<Orders> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Orders> orderSet) {
		this.orderSet = orderSet;
	}
	

	
	
}
