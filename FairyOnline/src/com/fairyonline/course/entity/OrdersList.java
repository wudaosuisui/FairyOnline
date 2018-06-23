package com.fairyonline.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.user.entity.User;

@Entity
@Table(name="orderlist")
public class OrdersList {
	
	private int id ;//流水号
	private Course course;//对应的书 (noe to noe)
	private Orders orderId;
//	private int number = 0;//购买的书的数量
//	private int price;//购买对应数量书的总价
	
	public OrdersList() {}

	public OrdersList( Course course,Orders order) {
		this.course = course;
		this.orderId= order;
	}
//	public OrdersItem(Book book, int number) {//price 自动计算
//		this.book = book;
//		this.number = number;
//		this.price = this.book.getPrice()*this.number;
//	}
	
//	@Id
//	@GeneratedValue(generator="id")
//	@GenericGenerator(name="id",strategy="increment")
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name="course")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
    @ManyToOne
    @JoinColumn(name="orderid")
	public Orders getOrderId() {
		return orderId;
    }
	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}


}
