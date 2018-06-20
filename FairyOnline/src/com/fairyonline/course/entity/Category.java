package com.fairyonline.course.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.admin.entity.Admin;

@Entity
@Table(name="category")
public class Category {
	
	private int ID;
	private String categoryName;
	private Date uptime;
	private Admin adminId;
	private String introduce;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	@ManyToOne
	@JoinColumn(name="adminId")
	public Admin getAdminId() {
		return adminId;
	}
	public void setAdminId(Admin adminId) {
		this.adminId = adminId;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	@OneToMany//(mappedBy="Category", targetEntity=Course.class, cascade=CascadeType.ALL)
	@JoinColumn(name="categoryID")
	public Set<Course> getCourseSet() {
		return courseSet;
	}
	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}
	
	

}
