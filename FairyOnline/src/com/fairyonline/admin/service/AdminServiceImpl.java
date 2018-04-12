package com.fairyonline.admin.service;

import org.springframework.stereotype.Service;

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
