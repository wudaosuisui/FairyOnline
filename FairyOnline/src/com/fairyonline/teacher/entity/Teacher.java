package com.fairyonline.teacher.entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fairyonline.course.entity.Course;
import com.fairyonline.user.entity.User;


@Entity
@Table(name="teacher")
public class Teacher {
	private int ID;
	private String IDName;
	private String Name;
	private List<Course> courseList = new ArrayList<Course>();
	private List<User> userList = new ArrayList<User>();
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public String getIDName() {
		return IDName;
	}
	public void setIDName(String IDName) {
		this.IDName = IDName;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	@OneToMany(mappedBy="teacher", targetEntity=Course.class, 
	        cascade=CascadeType.ALL)
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	@ManyToMany(mappedBy="teacherList")
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	
}
