package com.fairyonline.course.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.teacher.entity.Teacher;

@Entity
@Table(name="coursebk")
public class Coursebk {
	
	private int ID;
	private String CName;
	private int Price;
	private Category categoryID;
	private Date UPTime;
	private Teacher tId;
	private String cIntroduction;
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
	@JoinColumn(name="categoryID")
	public Category getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}
	public Date getUPTime() {
		return UPTime;
	}
	public void setUPTime(Date uPTime) {
		this.UPTime = uPTime;
	}
	@ManyToOne
	@JoinColumn(name="tId")
	public Teacher gettId() {
		return tId;
	}
	public void settId(Teacher tId) {
		this.tId = tId;
	}
	public String getcIntroduction() {
		return cIntroduction;
	}
	public void setcIntroduction(String cIntroduction) {
		this.cIntroduction = cIntroduction;
	}
	
	

}
