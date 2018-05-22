package com.fairyonline.course.entity;

import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.user.entity.User;

@Entity
@Table(name="orders")
public class Orders {
	
	private int ID;
	private User userId;
	private Date time;
	private Date Ptime;
	private int state;
	private Set<Course> courseSet = new HashSet<Course>();
	
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@ManyToMany//(mappedBy="Course")
	public Set<Course> getCourseSet() {
		return courseSet;
	}
	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}
	

}
