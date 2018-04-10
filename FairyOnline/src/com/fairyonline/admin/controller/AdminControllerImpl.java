package com.fairyonline.admin.controller;

import org.springframework.stereotype.Controller;

@Controller
public class AdminControllerImpl {
	@Resource
	private AdminServiceImpl adminServiceImpl;
	
	@RequestMapping("/login")
	public String login(String name,String password,HttpServletRequest request) {
		if(adminServiceImpl.findByNamePsd(name, password)) {
			request.getSession().setAttribute("admin", name);
			return "redirect:/admin/index.jsp";//鍚庡彴椤甸潰
		}else {
			String msg = "鐢ㄦ埛鍚嶆垨瀵嗙爜閿欒...";
			request.getSession().setAttribute("error",msg);
			String buttonMsg="閲嶆柊鐧诲綍";
			request.getSession().setAttribute("button",buttonMsg);
			return "redirect:/admin/404.jsp";
		}
	}
	@RequestMapping("/registration")
	public String registration(String name,String password,String rePassword,Model model) {
		String msg = "娉ㄥ唽澶辫触锛�";
		Admin admin = new Admin();
		if(password.equals(rePassword)){
			admin.setName(name);
			admin.setPassword(password);
			adminServiceImpl.addAdmin(admin);
			return "redirect:/admin/login.jsp";
		}
		model.addAttribute("error",msg);
		return "redirect:/admin/404.jsp";
	}
}
