package com.fairyonline.course.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class Video {
	private int ID;
	private String Name;
	private Course CID;
	private int TID;//后期再加一对多
	private String URL;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@ManyToOne
	@JoinColumn(name="CID")
	public Course getCID() {
		return CID;
	}
	public void setCID(Course cID) {
		CID = cID;
	}
	public int getTID() {
		return TID;
	}
	public void setTID(int tID) {
		TID = tID;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}

}
