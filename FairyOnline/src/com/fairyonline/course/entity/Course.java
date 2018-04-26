package com.fairyonline.course.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="course")
public class Course {
	private int ID;
	private String CName;
	private int Price;
	private Course CategoryID;
	private Date UPTime;
	private int TID;
	private Set<Video> videoSet = new HashSet<Video>();
	
	public Course() {
		
	}
	public Course(String cName,int Price,Date UPTime,int TID) {
		this.CName=cName;
		this.Price=Price;
		this.CategoryID =CategoryID;
		this.UPTime = UPTime;
		this.TID = TID;
		
	}
	public Course(String cName2, int price2, java.sql.Date now1, int tID2) {
		// TODO Auto-generated constructor stub
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
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		this.CName = cName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		this.Price = price;
	}
	@ManyToOne
	@JoinColumn(name="CategoryID")
	public Course getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(Course categoryID) {
		CategoryID = categoryID;
	}
	public Date getUPTime() {
		return UPTime;
	}
	public void setUPTime(Date uPTime) {
		UPTime = uPTime;
	}
	public int getTID() {
		return TID;
	}
	public void setTID(int tID) {
		this.TID = tID;
	}
	@OneToMany
	@JoinColumn(name="CID")
	public Set<Video> getVideoSet() {
		return videoSet;
	}
	public void setVideoSet(Set<Video> videoSet) {
		this.videoSet = videoSet;
	}
	

}
