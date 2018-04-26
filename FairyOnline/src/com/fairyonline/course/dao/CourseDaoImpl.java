package com.fairyonline.course.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fairyonline.course.entity.Course;
import com.fairyonline.example.entity.Example;

@Repository
public class CourseDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	/*²éÑ¯*/
	public List<Course> getList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Course");
		//List<Course> c=this.sessionFactory.getCurrentSession().createQuery("from Course").list();
		return q.list();
	}
//	/*Ä£ºý²éÑ¯*/
//	public List<Course> getCourseByPartName(String courseName){
//		Query q = this.sessionFactory.getCurrentSession().createQuery("from Watch where name like ?");
//		q.setString(0, "%"+courseName+"%");
//		return q.list();
//	}

	
}
