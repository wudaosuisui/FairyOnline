package com.fairyonline.teacher.dao;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.teacher.entity.Teacher;


@Repository
public class TeacherDao {
	@Resource
	private SessionFactory sessionFactory;
	public boolean submit(int id,String information) {
		Teacher t=new Teacher();
		t.setID(id);
		
		Session s=this.sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		s.save(t);
		tr.commit();
		s.close();
		return true;
	}
}
