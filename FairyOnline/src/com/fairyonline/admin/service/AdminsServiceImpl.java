package com.fairyonline.admin.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fairyonline.admin.dao.AdminsDaoImpl;
import com.fairyonline.admin.entity.Admins;

@Service
@Transactional(readOnly=false)
public class AdminsServiceImpl {
	@Resource
	private AdminsDaoImpl adminsDaoImpl;
	
	public void regist(Admins au) {
		this.adminsDaoImpl.saveUser(au);
	}
}
