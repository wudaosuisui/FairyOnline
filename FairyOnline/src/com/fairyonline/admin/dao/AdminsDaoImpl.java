package com.fairyonline.admin.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fairyonline.admin.entity.Admins;
import com.fairyonline.admin.entity.Gag;
import com.fairyonline.admin.entity.Title;
import com.fairyonline.user.entity.RCourse;
import com.fairyonline.user.entity.RUser;

@Repository
public class AdminsDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public List<RUser> findAllRUser(){
		Query q = this.sessionFactory.getCurrentSession().createQuery("from RUser");
		return q.list();
	}
	
	/*
	 * @return ×ÜµÄÒ³Êý
	 */
	
	int pageSize = 8;
	public int totalPages() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("select count(*) from RUser");
		Long count = (Long)query.uniqueResult();
		int totalPages = 0;
		if(count == pageSize){
			totalPages = 1;
		}
		if(count % pageSize == 0) {
			totalPages = (int)(count / pageSize);
		}
		if(count % pageSize != 0) {
			totalPages = (int)(count / pageSize) + 1;
		}
		return totalPages;
	}
	
	public List<RUser> findRUserByPage(Integer pages){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from RUser");
		query.setFirstResult(pageSize*(pages-1));
		query.setMaxResults(pageSize);
		return query.list();
	}
	public RUser findRUserById(int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from RUser where id=?");
		query.setParameter(0, id);
		RUser ruser = (RUser)query.uniqueResult();
		return ruser;
	}
	public List<RCourse> findRCourseByPage(Integer pages){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from RCourse");
		query.setFirstResult(pageSize*(pages-1));
		query.setMaxResults(pageSize);
		return query.list();
	}
	public RCourse findRCourseById(int id) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from RCourse where id=?");
		query.setParameter(0, id);
		RCourse rcourse = (RCourse)query.uniqueResult();
		return rcourse;
	}
	public Admins findAdminsByName(String aName) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Admins where UserName=?");
		query.setParameter(0, aName);
		Admins admins = (Admins)query.uniqueResult();
		return admins;
	}
	public List<Gag> listAllGag(){
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Gag");
		return query.list();
	}

	public boolean addGag(Gag gag) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(gag);
		return true;
	}

	public List<Title> listAllTitle() {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Title");
		return query.list();
	}

	public boolean addTitle(Title title) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.save(title);
		return true;
	}

	public List<Gag> findGagByPage(Integer pages) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Gag");
		query.setFirstResult(pageSize*(pages-1));
		query.setMaxResults(pageSize);
		return query.list();
	}

	public List<Title> findTitleByPage(Integer pages) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Title");
		query.setFirstResult(pageSize*(pages-1));
		query.setMaxResults(pageSize);
		return query.list();
	}
	
}
