package com.fairyonline.course.entity;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.teacher.entity.Teacher;

@Entity
@Table(name="course")
public class Course {
	private int ID;
	private String CName;
	private int Price;
	private Category categoryID;
	private Date UPTime;
	private Teacher tId;
	private String cImg;
	private String cIntroduction;
	private List<Chapters> chaptersList = new ArrayList<Chapters>();
//	private Set<Cart> cartSet = new HashSet<Cart>();
//	private Set<Orders> orderSet = new HashSet<Orders>();
	
	public Course() {
		
	}
	public Course(String cName,int Price,Date UPTime) {
		this.CName=cName;
		this.Price=Price;
		this.UPTime = UPTime;
	
		
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
	@JoinColumn(name="categoryID")
	public  Category getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}
	public Date getUPTime() {
		return UPTime;
	}
	public void setUPTime(Date uPTime) {
		UPTime = uPTime;
	}
	@ManyToOne
	@JoinColumn(name="tId")
	public Teacher gettId() {
		return tId;
	}
	public void settId(Teacher tId) {
		this.tId = tId;
	}
	public String getcImg() {
		return cImg;
	}
	public void setcImg(String cImg) {
		this.cImg = cImg;
	}
	public String getcIntroduction() {
		return cIntroduction;
	}
	public void setcIntroduction(String cIntroduction) {
		this.cIntroduction = cIntroduction;
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
//	@OneToMany
//	@JoinColumn(name="courseId")
//	public Set<Cart> getCartSet() {
//		return cartSet;
//	}
//	public void setCartSet(Set<Cart> cartSet) {
//		this.cartSet = cartSet;
//	}
//	@ManyToMany
//	@JoinTable(name="CARTLIST", 
//	    joinColumns=@JoinColumn(name="OID"),
//	    inverseJoinColumns=@JoinColumn(name="CID"))
//	public Set<Orders> getOrderSet() {
//		return orderSet;
//	}
//	public void setOrderSet(Set<Orders> orderSet) {
//		this.orderSet = orderSet;
//	}
	@Override
	public String toString() {
		return "Course [ID=" + ID + ", CName=" + CName + ", Price=" + Price + ", categoryID=" + categoryID + ", UPTime="
				+ UPTime + ", tId=" + tId + ", chaptersList=" + chaptersList + "]";
	}
	

}
