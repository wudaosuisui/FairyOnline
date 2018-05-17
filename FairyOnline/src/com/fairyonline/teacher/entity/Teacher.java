package com.fairyonline.teacher.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.course.entity.Course;


@Entity
@Table(name="teacher")
public class Teacher {
	private int ID;
	private int UID;
	private String IDName;
	private String name;
	private Set<Course> course = new HashSet<Course>();
	
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment") 
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public int getUID() {
		return UID;
	}
	public void setUID(int uid) {
		this.UID = uid;
	}
	public String getIDName() {
		return IDName;
	}
	public void setIDName(String IDName) {
		this.IDName = IDName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany//(mappedBy="Category", targetEntity=Course.class, cascade=CascadeType.ALL)
	@JoinColumn(name="tId")
	public Set<Course> getCourse() {
		return course;
	}
	public void setCourse(Set<Course> course) {
		this.course = course;
	}
}
