package com.fairyonline.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fairyonline.admin.dao.AdminDaoImpl;
import com.fairyonline.user.entity.RCourse;
import com.fairyonline.user.entity.RUser;



@Service
@Transactional(readOnly=true)
public class AdminServiceImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private AdminDaoImpl adminDaoImpl;
	
	public List<RUser> listAllRUser(){
		return this.adminDaoImpl.findAllRUser();
	}
	
	public int totalPages() {
		return this.adminDaoImpl.totalPages();
	}
	public List<RUser> findRUserByPage(Integer pages){
		return this.adminDaoImpl.findRUserByPage(pages);
	}
	public RUser  findRUserById(int id) {
		return this.adminDaoImpl.findRUserById(id);
	}
	public List<RCourse> findRCourseByPage(Integer pages){
		return this.adminDaoImpl.findRCourseByPage(pages);
	}
	public RCourse  findRCourseById(int id) {
		return this.adminDaoImpl.findRCourseById(id);
	}
}
