package com.fairyonline.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairyonline.admin.service.AdminServiceImpl;
import com.fairyonline.user.entity.RCourse;
import com.fairyonline.user.entity.RUser;

@Controller
@RequestMapping("admin")
public class AdminControllerImpl {
	@Resource
	private AdminServiceImpl adminServiceImpl;
	
	@RequestMapping("/reportUserList")
	public String reportUserList(Integer pages,Model model) {
		int totalPages = this.adminServiceImpl.totalPages();
		if(pages == null) {
			pages = 1;
		}
		if(pages < 1) {
			pages = 1;
		}
		if(pages > totalPages) {
			pages = totalPages;
		}
		
		List<RUser> reportUserList = this.adminServiceImpl.findRUserByPage(pages);
		if(reportUserList != null) {
			model.addAttribute("reportUserList",reportUserList);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("pages",pages);
			return "admin/html/reportUserList";
		}
		return "admin/html/reportUserList";
	}
	
	@RequestMapping("/reportDetail")
	public String reportDetail(Model model,int id) {
		RUser ruser = this.adminServiceImpl.findRUserById(id);
		model.addAttribute("ruser",ruser);
		return "admin/html/reportDetail";
	}
	
	@RequestMapping("/reportVideoList")
	public String reportViedoList(Integer pages,Model model) {
		int totalPages = this.adminServiceImpl.totalPages();
		if(pages == null) {
			pages = 1;
		}
		if(pages < 1) {
			pages = 1;
		}
		if(pages > totalPages) {
			pages = totalPages;
		}
		List<RCourse> reportVideoList = this.adminServiceImpl.findRCourseByPage(pages);
		if(reportVideoList != null) {
			model.addAttribute("reportVideoList",reportVideoList);
			model.addAttribute("totalPages",totalPages);
			model.addAttribute("pages",pages);
			return "admin/html/reportVideoList";
		}
		return "admin/html/reportVideoList";
	}	
	
	@RequestMapping("/reportVideoDetail")
	public String reporttVideoDetail(Model model,int id) {
		RCourse rcourse = this.adminServiceImpl.findRCourseById(id);
		model.addAttribute("rcourse",rcourse);
		return "admin/html/reportVideoDetail";
	}
}
