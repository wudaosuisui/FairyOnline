package com.fairyonline.teacher.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="teacher")
public class Teacher {
	private String id;
	private String information;
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
}
