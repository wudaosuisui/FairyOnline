package com.fairyonline.course.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.user.entity.User;
@Entity
//@Table(name="cart")
public class Cart{
	
	 //private Map<String,Course> map = new LinkedHashMap<String, Course>(); 
	 //用户会买一本书多本,会出现重复的书,要使用购物项,避免重复书出现。
	// private Map<String,CartItem> map = new LinkedHashMap<String, CartItem>();
	// private int price;  //总计
	 private int cartId;
	// private int count;
     private User userId;
   	 private Course courseId;
   	 
   	 public Cart() {}
   	 public Cart(int id ) {
   		 this.cartId = id;
   	 }
   	 
   	 
   	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")  
   	 public int getCartId() {
			return cartId;
	    }
     
     public void setCartId(int cartId) {
			this.cartId = cartId;
		}
//    @ManyToOne(cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
     @ManyToOne(cascade = { CascadeType.PERSIST,CascadeType.MERGE}) 
	@JoinColumn(name="userId")
	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
//	@ManyToOne(cascade = { CascadeType.PERSIST,CascadeType.MERGE},fetch=FetchType.EAGER)
	@ManyToOne(cascade = { CascadeType.PERSIST,CascadeType.MERGE}) 
//	@ManyToOne(cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(name="courseId")
	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
//     public double getPrice() {
//			return price;
//		}
//
//	 public void setPrice(int price) {
//			this.price = price;
//		}
   	   
//	   public void add(Course course){
//		  //首先判断要买的书是否已经在购物车里
//		  CartItem  item = map.get(course.getID());
//		  if(item!=null){
//		   item.setQuantity(item.getQuantity()+1);
//		  }else{
//		   //第一次买这本书
//		   item = new CartItem();
//		   item.setCourse(course);
//		   item.setQuantity(1);
//		   map.put(course.getCName(),item);
//		  }
//		  
//	    }
		 
//	    public Map<String, CartItem> getMap() {
//		  return map;
//	    }
//
//	    public void setMap(Map<String, CartItem> map) {
//		  this.map = map;
//	    }
//	  
//        public double getPrice() {
//		  double totalprice =0;
//		  for(Map.Entry<String,CartItem> me: map.entrySet()){
//		      totalprice = totalprice+me.getValue().getPrice();
//		  }
//		  this.price=totalprice;
//		  return price;
//	    }
//      
//        public void setPrice(double price) {
//		  this.price = price;
//	    }
        
//        public int getCount() {
//			return count;
//		}
//
//		public void setCount(int count) {
//			this.count = count;
//		}
//		@ManyToOne(cascade = { CascadeType.PERSIST,CascadeType.MERGE},optional = false,fetch = FetchType.LAZY)
     	
		
		 

	
}
