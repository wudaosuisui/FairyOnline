package com.fairyonline.course.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cart{
	
	 //private Map<String,Course> map = new LinkedHashMap<String, Course>(); 
	 //用户会买一本书多本,会出现重复的书,要使用购物项,避免重复书出现。
	 private Map<String,CartItem> map = new LinkedHashMap<String, CartItem>();
	 private double price;  //总计
	 
	 public void add(Course course){
		  //首先判断要买的书是否已经在购物车里
		  CartItem  item = map.get(course.getID());
		  if(item!=null){
		   item.setQuantity(item.getQuantity()+1);
		  }else{
		   //第一次买这本书
		   item = new CartItem();
		   item.setCourse(course);
		   item.setQuantity(1);
		   map.put(course.getCName(),item);
		  }
		  
		 }
		 
		 public Map<String, CartItem> getMap() {
		  return map;
		 }

		 public void setMap(Map<String, CartItem> map) {
		  this.map = map;
		 }

		 public double getPrice() {
		  double totalprice =0;
		  for(Map.Entry<String,CartItem> me: map.entrySet()){
		   totalprice = totalprice+me.getValue().getPrice();
		  }
		  this.price=totalprice;
		  return price;
		 }

		 public void setPrice(double price) {
		  this.price = price;
		 }
}
