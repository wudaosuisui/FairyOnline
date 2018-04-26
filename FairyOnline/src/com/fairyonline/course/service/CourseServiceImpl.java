package com.fairyonline.course.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.fairyonline.course.dao.CourseDaoImpl;
import com.fairyonline.course.entity.Course;

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
	//模糊课程查询
//	public List<Course> getCourseByPartName(String courseName){
//		Course list = cdi.getCourseByPartName(courseName);
//		return list;
//	}

	

}
