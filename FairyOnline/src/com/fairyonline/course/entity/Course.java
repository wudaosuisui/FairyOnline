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
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="course")
public class Course {
	private int ID;
	private String CName;
	private int Price;
	private Category CategoryID;
	private Date time;
	private int TID;
	private Set videoSet = new HashSet<Video>();
	@Id
	@GeneratedValue(generator="id")
    @GenericGenerator(name="id", strategy="increment")
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
	public Category getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(Category categoryID) {
		this.CategoryID = categoryID;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getTID() {
		return TID;
	}
	public void setTID(int tID) {
		this.TID = tID;
	}
	@OneToMany(mappedBy="CID", targetEntity=Video.class,cascade=CascadeType.ALL)
	public Set getVideoSet() {
		return videoSet;
	}
	public void setVideoSet(Set videoSet) {
		this.videoSet = videoSet;
	}
	
	

}
