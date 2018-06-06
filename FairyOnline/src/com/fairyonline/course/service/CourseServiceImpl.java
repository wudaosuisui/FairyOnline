package com.fairyonline.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fairyonline.course.dao.CourseDaoImpl;
import com.fairyonline.course.entity.Cart;
import com.fairyonline.course.entity.CartItem;
import com.fairyonline.course.entity.Category;
import com.fairyonline.course.entity.Chapters;
import com.fairyonline.course.entity.Course;
import com.fairyonline.course.entity.Coursebk;
import com.fairyonline.course.entity.FollowCourse;
import com.fairyonline.course.entity.Video;
import com.fairyonline.user.entity.User;

@Service
public class CourseServiceImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private CourseDaoImpl cdi;
	
	/*添加对象*/
	public void Add(Course course) {
		Session session = sessionFactory.openSession();
		this.cdi.save(course);
		session.close();//session打开后 记得关闭
	}
	
	//课程查询
	public List<Course> getList(){
		List<Course> list = cdi.getList();
		return list;	
	}
	public Chapters selectBycId(int cid) {
		Session session = sessionFactory.openSession();
		Chapters chapter = cdi.selectBycId(cid);
		session.close();
		return chapter;
	}
	
	//由ID查询课程
	public Course selectById(int id) {
		Course course = cdi.selectById(id);
		return course;
	}
	//观看视频
	public Video videoview(int id) {
		Video video = cdi.videoview(id);
		return video;
	}
	//收藏课程
	public void collection(int id,int ID) {
		cdi.collection(id, ID);
	}
	//取消收藏
	public void unCollection(int id,int uid) {
		cdi.unCollection(id,uid);
	}
	//查询收藏的课程
	public List<FollowCourse> selectfc() {
		List<FollowCourse> list = cdi.selectfc();
		return list;
		
	}
	//购物车
	public List<Cart> selectAll(){
		List<Cart> list = cdi.selectAll();
		return list;
	}
    
    public void addCart(int id,int ID ) {
			cdi.addCart(id, ID);
	}
    
    public List<Cart> selectById(String[] c){
			List<Cart> list = cdi.selectById(c);
			return list;
	}
    
    public List<Cart> selectByUserId(int userId){
		List<Cart> list = cdi.selectByUserId(userId);
		return list;
	}
    
    public void deleteCart(int cartId) {
			cdi.deleteCart(cartId);
	}
		
	public User addCount(int id) {
			User user = cdi.addCount(id);
			return user;
	}
		
	public void misCount(int id) {
			cdi.misCount(id);
	}
	
	public CourseDaoImpl getCartDao() {
			return cdi;
	}
	
	public void setCartDao(CourseDaoImpl cdi) {
			this.cdi = cdi;
	}
    
	//审核课程列表
	public List<Coursebk> getcbkList(){
		List<Coursebk> list = cdi.getcbkList();
		return list;	
	}
	//审查课程详情
	public Coursebk selectBycbkId(int id) {
		Coursebk coursebk = cdi.selectBycbkId(id);
		return coursebk;
	}
	public List<Category> getcList(){
		List<Category> list = cdi.getcList();
		return list;	
	}
	
//	 public List<Course> getAllCourse() {
//		  
//		  return cdi.getALL();
//		 }
//	 public void buyCourse(int id, Cart cart) {
//		 Course course = cdi.find(id);
//		 cart.add(course);  
//	 }
//	 public void updateCart(Cart cart, String CName, String quantity) {
//	     CartItem item = cart.getMap().get(CName);
//	     item.setQuantity(Integer.parseInt(quantity));
//	 } 
//	 public void deleteCartItem(Cart cart, String CName) {
//		 cart.getMap().remove(CName);
//	 }
//	 public void clearCart(Cart cart) {
//	     cart.getMap().clear();
//	 }
	//模糊课程查询
//	public List<Course> getCourseByPartName(String courseName){
//		Course list = cdi.getCourseByPartName(courseName);
//		return list;
//	}
	
	

	

}
