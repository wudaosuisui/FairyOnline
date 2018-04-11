package com.fairyonline.admins.service;

import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly=false)
public class AdminsServiceImpl {
	@Resource
	private AdminsDaoImpl adminsDaoImpl;
	
	public void regist(Admins au) {
		this.adminsDaoImpl.saveUser(au);
	}
}
