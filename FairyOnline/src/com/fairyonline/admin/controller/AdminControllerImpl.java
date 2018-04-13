package com.fairyonline.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairyonline.admin.service.AdminServiceImpl;

@Controller
public class AdminControllerImpl {
	@Resource
	private AdminServiceImpl adminServiceImpl;
	
	@RequestMapping("/login")
	public String login(String name,String password,HttpServletRequest request) {
		if(adminServiceImpl.findByNamePsd(name, password)) {
			request.getSession().setAttribute("admin", name);
			return "redirect:/admin/index.html";
		}else {
			String msg = "输入错误";
			request.getSession().setAttribute("error",msg);
			String buttonMsg="错误";
			request.getSession().setAttribute("button",buttonMsg);
			return "redirect:/admin/404.jsp";
		}
	}
}
