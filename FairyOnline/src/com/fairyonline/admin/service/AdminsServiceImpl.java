package com.fairyonline.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fairyonline.admin.dao.AdminsDaoImpl;
import com.fairyonline.admin.entity.Admins;
import com.fairyonline.admin.entity.Gag;
import com.fairyonline.admin.entity.Title;
import com.fairyonline.user.entity.RCourse;
import com.fairyonline.user.entity.RUser;



@Service
@Transactional(readOnly=true)
public class AdminsServiceImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private AdminsDaoImpl adminsDaoImpl;
	
	public List<RUser> listAllRUser(){
		return this.adminsDaoImpl.findAllRUser();
	}
	
	public int totalPages() {
		return this.adminsDaoImpl.totalPages();
	}
	public List<RUser> findRUserByPage(Integer pages){
		return this.adminsDaoImpl.findRUserByPage(pages);
	}
	public RUser  findRUserById(int id) {
		return this.adminsDaoImpl.findRUserById(id);
	}
	public List<RCourse> findRCourseByPage(Integer pages){
		return this.adminsDaoImpl.findRCourseByPage(pages);
	}
	public RCourse  findRCourseById(int id) {
		return this.adminsDaoImpl.findRCourseById(id);
	}
	public Admins findAdminsByName(String aName) {
		return this.adminsDaoImpl.findAdminsByName(aName);
	}
	public List<Gag> listAllGag(){
		return this.adminsDaoImpl.listAllGag();
	}

	public void addGag(Gag gag) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		this.adminsDaoImpl.addGag(gag);
		session.close();
	}

	public List<Title> listAllTitle() {
		// TODO Auto-generated method stub
		return this.adminsDaoImpl.listAllTitle();
	}
	public void addTitle(Title title) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		this.adminsDaoImpl.addTitle(title);
		session.close();
	}

	public List<Gag> findGagByPage(Integer pages) {
		// TODO Auto-generated method stub
		return this.adminsDaoImpl.findGagByPage(pages);
	}

	public List<Title> findTitleByPage(Integer pages) {
		// TODO Auto-generated method stub
		return this.adminsDaoImpl.findTitleByPage(pages);
	}
	public void updateRUser(RUser ruser) {
		Session session = sessionFactory.openSession();
		this.adminsDaoImpl.updateRUser(ruser);
		session.close();
	}
}
