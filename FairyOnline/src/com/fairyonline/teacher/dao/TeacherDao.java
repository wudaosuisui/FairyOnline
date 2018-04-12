package com.fairyonline.teacher.dao;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.bear.online.entity.Teacher;
@Repository
public class TeacherDao {
	@Resource
	private SessionFactory sessionFactory;
	public boolean submit(String id,String information) {
		Teacher t=new Teacher();
		t.setID(id);
		t.setInformation(information);
		Session s=this.sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		s.save(t);
		tr.commit();
		s.close();
		return true;
	}
}
