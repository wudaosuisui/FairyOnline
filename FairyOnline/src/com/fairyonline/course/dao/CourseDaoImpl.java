package com.fairyonline.course.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.course.entity.Course;

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
//	/*模糊查询*/
//	public List<Course> getCourseByPartName(String courseName){
//		Query q = this.sessionFactory.getCurrentSession().createQuery("from Watch where name like ?");
//		q.setString(0, "%"+courseName+"%");
//		return q.list();
//	}
	
	
	
}
