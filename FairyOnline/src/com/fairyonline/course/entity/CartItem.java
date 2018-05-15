package com.fairyonline.course.entity;

public class CartItem {

	 private Course course;
	 private int quantity;
	 
	 private double price; //Ð¡¼Æ

	 public Course getCourse() {
	  return course;
	 }

	 public void setCourse(Course course) {
	  this.course = course;
	 }

	 public int getQuantity() {
	  return quantity;
	 }

	 public void setQuantity(int quantity) {  
	  this.quantity = quantity;
	  this.price = this.course.getPrice()*this.quantity;
	 }

	 public double getPrice() {
	  return price;
	 }

	 public void setPrice(double price) {
	  this.price = price;
	 }
}
