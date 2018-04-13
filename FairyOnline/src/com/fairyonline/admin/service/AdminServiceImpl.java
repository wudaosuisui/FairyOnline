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
	public boolean findByNamePsd(String name,String psd) {
		Admin admin = adi.findByNamePsd(name, psd);
		if(admin!=null) {
			return true;
		}
		return false;
	}
}
