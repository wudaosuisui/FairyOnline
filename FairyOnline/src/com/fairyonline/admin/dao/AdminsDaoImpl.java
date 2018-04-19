package com.fairyonline.admin.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.admin.entity.Admins;

@Repository
public class AdminsDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public void saveUser(Admins au) {
		Session session = sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		
		session.save(au);
		tr.commit();
		session.close();
	}

}
