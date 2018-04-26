package com.fairyonline.course.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	private int ID;
	private String CategoryName;
	private Set courseSet = new HashSet<Course>();
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	@OneToMany(mappedBy="CategoryID", targetEntity=Course.class,cascade=CascadeType.ALL)
	public Set getCourseSet() {
		return courseSet;
	}
	public void setCourseSet(Set courseSet) {
		this.courseSet = courseSet;
	}

}
