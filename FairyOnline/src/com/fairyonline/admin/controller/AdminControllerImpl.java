package com.fairyonline.admin.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AdminControllerImpl {
	@Resource
	private AdminServiceImpl adminServiceImpl;
	
	@RequestMapping("/login")
	public String login(String userName,String password,HttpServletRequest request) {
		if(adminServiceImpl.findByNamePsd(userName, password)) {
			request.getSession().setAttribute("admin", userName);
			return "redirect:/admin/html/index.html";
		}else {
			String msg = "输入错误";
			request.getSession().setAttribute("error",msg);
			String buttonMsg="错误";
			request.getSession().setAttribute("button",buttonMsg);
			return "redirect:/admin/404.jsp";
		}
	}
}
