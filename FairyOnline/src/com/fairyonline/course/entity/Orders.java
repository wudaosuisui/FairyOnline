package com.fairyonline.course.entity;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.user.entity.User;

@Entity
@Table(name="orders")
public class Orders {
	
	private int ID;
	private User userId;
	private Date time;
	private Date Ptime;
	private Boolean state;
	private List<OrdersList> Item;//子订单列表  ont to many 单向

	public Orders() {}
    public Orders(User userId,Date time) {
    	this.time = time;
    	this.userId = userId;
    	this.state = false;
    }
    
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")  
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	@ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Date getPtime() {
		return Ptime;
	}
	public void setPtime(Date ptime) {
		this.Ptime = ptime;
	}
	public Boolean getState() {
		return state;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
//	@ManyToMany//(mappedBy="Course")
//	public Set<Course> getCourseSet() {
//		return courseSet;
//	}
//	public void setCourseSet(Set<Course> courseSet) {
//		this.courseSet = courseSet;
//	}
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)//积极加载  // @Cascade(value=CascadeType.ALL)
	@JoinColumn(name="orderid")
	public List<OrdersList> getItem() {
		return Item;
	}
	public void setItem(List<OrdersList> item) {
		this.Item = item;
	}
	

}
