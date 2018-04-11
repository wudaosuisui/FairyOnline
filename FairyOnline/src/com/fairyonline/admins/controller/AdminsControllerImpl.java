package com.fairyonline.admins.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AdminsControllerImpl {
	@Resource
	private AdminsServiceImpl adminsServiceImpl;
	
	@RequestMapping("/Alogin")
	public String regist(String userName,String password/*int power*/) {
		Admins au=new Admins();
		au.setUserName(userName);
		au.setPassword(password);
		adminsServiceImpl.regist(au);
		return "redirect:/admin/html/index.html";
	}
}
