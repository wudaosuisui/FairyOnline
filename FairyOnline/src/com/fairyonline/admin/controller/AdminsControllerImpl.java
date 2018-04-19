package com.fairyonline.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairyonline.admin.entity.Admins;
import com.fairyonline.admin.service.AdminsServiceImpl;

@Controller
public class AdminsControllerImpl {
	@Resource
	private AdminsServiceImpl adminsServiceImpl;
	
	@RequestMapping("/Alogin")
	public String regist(String userName,String password/*int power*/) {
		Admins au=new Admins();
		au.setUserName(userName);
		au.setPassWord(password);
		adminsServiceImpl.regist(au);
		return "redirect:/admin/html/index.html";
	}
}
