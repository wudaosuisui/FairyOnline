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
	
	public Admin findByNamePsd(String name, String psd) {
		Query q = this.sessionFactory.getCurrentSession().createQuery("from Admin where name=? and password=?");
		q.setString(0,name);
		q.setString(1, psd);
		Admin admin = (Admin) q.uniqueResult();
        return admin;
	}
}
