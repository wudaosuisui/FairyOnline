package com.fairyonline.course.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="course")
public class Course {
	private int ID;
	private String CName;
	private int Price;
	private Category CategoryID;
	private Date UPTime;
	private int TID;
	private List<Chapters> chaptersList = new ArrayList<Chapters>();
	
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
	public  Category getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(Category categoryID) {
		this.CategoryID = categoryID;
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
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER)//»ý¼«¼ÓÔØEAGER
	@JoinColumn(name="CID")
//	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
//    @JoinColumn(name="CID")
	public List<Chapters> getChaptersList() {
		return chaptersList;
	}
	public void setChaptersList(List<Chapters> chaptersList) {
		this.chaptersList = chaptersList;
	}
	@Override
	public String toString() {
		return "Course [ID=" + ID + ", CName=" + CName + ", Price=" + Price + ", CategoryID=" + CategoryID + ", UPTime="
				+ UPTime + ", TID=" + TID + ", chaptersList=" + chaptersList + "]";
	}
	

}
