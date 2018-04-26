package com.fairyonline.admin.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairyonline.admin.entity.Admins;
import com.fairyonline.admin.service.AdminsServiceImpl;


@Controller
public class AdminsControllerImpl {
	@Resource
	private AdminsServiceImpl adminsServiceImpl;
	
	@RequestMapping("/Alogin")
	public String regist(@RequestParam(value = "radio") int num,
			String userName,String password,
			@RequestParam(value = "power", required = false) String[] powers
			) {
		Admins[] admins = new Admins[num];
		String power = new String();
		for(String str:powers) {
			power+=(str+";");
			
		}
		for(int i=0;i<num;i++) {
			admins[i]=new Admins();
			admins[i].setUserName(userName+(i+1));
			admins[i].setPassWord(password+(i+1));
			admins[i].setPower(power);
			adminsServiceImpl.regist(admins[i]);
		}
		return "redirect:/admin/html/index.html";
	}
}
