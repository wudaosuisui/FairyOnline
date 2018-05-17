package com.fairyonline.course.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.course.entity.Cart;
import com.fairyonline.course.entity.Category;
import com.fairyonline.course.entity.Chapters;
import com.fairyonline.course.entity.Course;
import com.fairyonline.user.entity.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;



@Repository
public class CourseDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	/*save*//*保存*/
	public void save(Course course) {
		Session session = sessionFactory.getCurrentSession();//获取sessio
		Transaction tra = session.beginTransaction();//开启事务
		session.save(course);
		System.out.println("save success!");
		session.flush();
		tra.commit();
		System.out.println("out dao");
	}
	
	/*查询*/
	public List<Course> getList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Course");
		//List<Course> c=this.sessionFactory.getCurrentSession().createQuery("from Course").list();
		return q.list();
	}
	public Chapters selectBycId(int id){
		Session session = sessionFactory.openSession();
		System.out.println("****************chapter");
//		Query query = session.createQuery("select Chapters");
//		//.ID,Chapters.CID,Chapters.ChapterNum,Chapters.ChapterName from Chapters c1,Course c2 where c1.CID = c2.id
//		//List<Course> c=this.sessionFactory.getCurrentSession().createQuery("from Course").list();
//		System.out.println("****************chapter");
//		query.setParameter(0, id);
//		System.out.println("****************chapter");
//		Chapters chapter = (Chapters)query.uniqueResult();
		Chapters chapter = session.get(Chapters.class , id);
		return chapter;
	}
	
	public Course selectById(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		System.out.println("get dao success");
//		Query query = session.createQuery("from Course where id = ?");
//		query.setParameter(0, id);
//		Course course = (Course)query.uniqueResult();
		Course course = session.get(Course.class,id);
		session.close();
//		System.out.println("get dao success course name is : " + course.getCName());
		System.out.println("get dao2 success");
		return course; 
	}
	
	//购物车
	public List<Cart> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart");
		List<Cart> list = query.list();
		return list;
	}
	
	public Boolean addCart(int id, int ID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Course where ID=?");
		query.setParameter(0,ID);
		Course Course = (Course) query.uniqueResult();
		
		User user = session.get(User.class, new Integer(id));
		Set<Cart> set = user.getCartSet();
		Iterator<Cart> it = set.iterator();
		while(it.hasNext()) {
			Cart c = it.next();
			if(c.getCourseId().equals(ID)) {
				int count = c.getCount();
				c.setCount(count+1);
				session.update(c);
				tx.commit();
				session.close();
				return true;
			}
		}
		Cart c = new Cart();
		c.setCourseId(Course);;
		c.setCount(1);
		c.setUserId(user);
		user.getCartSet().add(c);
		session.save(c);
		session.update(user);
		tx.commit();
		session.close();
		return true;
	}
	
	public List<Cart> selectByUserId(int userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where userId=?");
		query.setParameter(0, userId);
		List<Cart> list = query.list();
		return list;
	}
	public List<Cart> selectById(String[] c){
		Session session = sessionFactory.openSession();
		List<Cart> list = new ArrayList<Cart>();
		for(int i =0; i < c.length; i ++) {
			Query query = session.createQuery("from Cart where cartId=?");
			query.setParameter(0, Integer.parseInt(c[i]));
			Cart cart = (Cart)query.uniqueResult();
			list.add(cart);
		}
		return list;
	}

	public void deleteCart(int cartId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Cart cart = session.get(Cart.class,new Integer(cartId));
		session.delete(cart);
		tx.commit();
		session.close();
	}
	
	public User addCount(int id) {
		Session session = sessionFactory.getCurrentSession();
		Cart cart = session.get(Cart.class, new Integer(id));
		int count = cart.getCount();
		cart.setCount(count+1);
		session.update(cart);
		int userId = 1;
		Query query = session.createQuery("from User where id=?");
		query.setParameter(0, userId);
		User user = (User) query.uniqueResult();
		//User user = session.get(User.class, new Integer(shopping.getUser().getId()));
		//Query query = session.createQuery("select user from Shopping where id=?");
		//query.setParameter(0, id);
		//User user = shopping.getUser();
		return user;
	}
	
	public void misCount(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Cart cart = session.get(Cart.class, new Integer(id));
		int count = cart.getCount();
		cart.setCount(count-1);
		session.update(cart);
		tx.commit();
		session.close();
	}
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	 public Course find(int id) {
//	 Session session = sessionFactory.openSession();
//	 Course course = session.get(Course.class,id);
//	 session.close(); 
//	 return course; 
//	 }
//public List<Course> getALL() {
//	 Query q=this.sessionFactory.getCurrentSession().createQuery("from Course");
//	//List<Course> c=this.sessionFactory.getCurrentSession().createQuery("from Course").list();
//	 return q.list();
//	 }
//	/*模糊查询*/
//	public List<Course> getCourseByPartName(String courseName){
//		Query q = this.sessionFactory.getCurrentSession().createQuery("from Watch where name like ?");
//		q.setString(0, "%"+courseName+"%");
//		return q.list();
//	}
	
	
	
}
