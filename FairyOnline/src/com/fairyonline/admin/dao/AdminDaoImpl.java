package com.fairyonline.admin.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<Admin> findAll(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Admin");
		List<Admin> list = q.list();
		return list;
	}
	
	public Admin findByNamePsd(String userName, String password) {
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Admin where userName=? and password=?");
		q.setString(0,userName);
		q.setString(1, password);
		Admin admin = (Admin) q.uniqueResult();
        return admin;
	}
}
