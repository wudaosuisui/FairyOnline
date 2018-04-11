package com.fairyonline.admins.dao;

import org.springframework.stereotype.Repository;

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
