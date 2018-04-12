package com.fairyonline.admin.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fairyonline.admin.dao.AdminDaoImpl;
import com.fairyonline.admin.entity.Admin;

@Service
public class AdminServiceImpl {
	@Resource
	private AdminDaoImpl adi;
	
	public List<Admin> findAll(){
		List<Admin> list = adi.findAll();
		return list;
	}
	public boolean findByNamePsd(String userName,String password) {
		Admin admin = adi.findByNamePsd(userName, password);
		if(admin!=null) {
			return true;
		}
		return false;
	}
}
