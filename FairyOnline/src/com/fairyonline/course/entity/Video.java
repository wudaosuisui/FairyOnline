package com.fairyonline.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="video")
public class Video {
	private int ID;
	private String Name;
	private Course CID;
	private int TID;//后期再加一对多
	private String URL;
	
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	@ManyToOne
	@JoinColumn(name="CID")
	public Course getCID() {
		return CID;
	}
	public void setCID(Course cID) {
		this.CID = cID;
	}
	public int getTID() {
		return TID;
	}
	public void setTID(int tID) {
		this.TID = tID;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		this.URL = uRL;
	}

}
