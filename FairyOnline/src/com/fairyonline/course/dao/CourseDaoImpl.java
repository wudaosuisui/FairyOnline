package com.fairyonline.course.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.course.entity.Category;
import com.fairyonline.course.entity.Chapters;
import com.fairyonline.course.entity.Course;
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
	 public Course find(int id) {
		 Session session = sessionFactory.openSession();
		 Course course = session.get(Course.class,id);
		 session.close(); 
		 return course; 
		 }
	 public List<Course> getALL() {
		 Query q=this.sessionFactory.getCurrentSession().createQuery("from Course");
		//List<Course> c=this.sessionFactory.getCurrentSession().createQuery("from Course").list();
		 return q.list();
		 }
	
//	/*模糊查询*/
//	public List<Course> getCourseByPartName(String courseName){
//		Query q = this.sessionFactory.getCurrentSession().createQuery("from Watch where name like ?");
//		q.setString(0, "%"+courseName+"%");
//		return q.list();
//	}
	
	
	
}
