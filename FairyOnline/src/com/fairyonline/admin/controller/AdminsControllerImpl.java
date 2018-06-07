package com.fairyonline.admin.controller;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairyonline.admin.entity.Admins;
import com.fairyonline.admin.entity.Gag;
import com.fairyonline.admin.entity.Title;
import com.fairyonline.admin.service.AdminsServiceImpl;
import com.fairyonline.user.entity.RCourse;
import com.fairyonline.user.entity.RUser;
import com.fairyonline.user.entity.User;
import com.fairyonline.user.service.UserServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminsControllerImpl {
	@Resource
	private AdminsServiceImpl adminsServiceImpl;
	@Resource
	private UserServiceImpl userServiceImpl;
	
	//用户举报列表
		@RequestMapping("/reportUserList")
		public String reportUserList(Integer pages,Model model) {
			int totalPages = this.adminsServiceImpl.totalPages();
			if(pages == null) {
				pages = 1;
			}
			if(pages < 1) {
				pages = 1;
			}
			if(pages > totalPages) {
				pages = totalPages;
			}
			
			List<RUser> reportUserList = this.adminsServiceImpl.findRUserByPage(pages);
			if(reportUserList != null) {
				model.addAttribute("reportUserList",reportUserList);
				model.addAttribute("totalPages",totalPages);
				model.addAttribute("pages",pages);
				return "admin/html/reportUserList";
			}
			return "admin/html/reportUserList";
		}
		
		//用户举报详情
		@RequestMapping("/reportDetail")
		public String reportDetail(Model model,int id) {
			RUser ruser = this.adminsServiceImpl.findRUserById(id);
			model.addAttribute("ruser",ruser);
			return "admin/html/reportDetail";
		}
		
		//视频举报列表
		@RequestMapping("/reportVideoList")
		public String reportViedoList(Integer pages,Model model) {
			int totalPages = this.adminsServiceImpl.totalPages();
			if(pages == null) {
				pages = 1;
			}
			if(pages < 1) {
				pages = 1;
			}
			if(pages > totalPages) {
				pages = totalPages;
			}
			List<RCourse> reportVideoList = this.adminsServiceImpl.findRCourseByPage(pages);
			if(reportVideoList != null) {
				model.addAttribute("reportVideoList",reportVideoList);
				model.addAttribute("totalPages",totalPages);
				model.addAttribute("pages",pages);
				return "admin/html/reportVideoList";
			}
			return "admin/html/reportVideoList";
		}	
		
		//视频举报详情
		@RequestMapping("/reportVideoDetail")
		public String reporttVideoDetail(Model model,int id) {
			RCourse rcourse = this.adminsServiceImpl.findRCourseById(id);
			model.addAttribute("rcourse",rcourse);
			return "admin/html/reportVideoDetail";
		}
		
		//禁言
		@RequestMapping("gag")
		public String gag(HttpServletRequest request,HttpServletResponse response,Model model,String aName,int id) {
			String gagTime = request.getParameter("gagTime");
			String gagReason = request.getParameter("gagReason");
			User gagUser = this.userServiceImpl.findUserById(id);
			Admins gagAdmins = this.adminsServiceImpl.findAdminsByName(aName);
			//当前禁言时间
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
			String str = df.format(now);
			//禁言结束时间
			int gagTime1 = Integer.valueOf(gagTime).intValue();
			cal.add(Calendar.DATE,gagTime1);
			now = cal.getTime();
			String str1 = df.format(now);
			
			List<Gag> gagList = this.adminsServiceImpl.listAllGag();
			Gag gag = new Gag();
			gag.setTime(gagTime);
			gag.setReason(gagReason);
			gag.setsTime(str);
			gag.seteTime(str1);
			gag.setUid(gagUser);
			gag.setaName(gagAdmins);
			gagList.add(gag);
			this.adminsServiceImpl.addGag(gag);
			return "admin/html/index.html";
		}
		
       //封号
		@RequestMapping("title")
		public String title(HttpServletRequest request,HttpServletResponse response,Model model,String aName,int id) {
			String titleReason = request.getParameter("titleReason");
			User titleUser = this.userServiceImpl.findUserById(id);
			Admins titleAdmins = this.adminsServiceImpl.findAdminsByName(aName);
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
			String str = df.format(now);
			List<Title> titleList = this.adminsServiceImpl.listAllTitle();
			Title title = new Title();
			title.setTime(str);
			title.setUid(titleUser);
			title.setaName(titleAdmins);
			title.setReason(titleReason);
			titleList.add(title);
			this.adminsServiceImpl.addTitle(title);
			return "admin/html/index.html";
		}
		
		//禁言列表
				@RequestMapping("/gagList")
				public String gagList(Integer pages,Model model) {
					int totalPages = this.adminsServiceImpl.totalPages();
					if(pages == null) {
						pages = 1;
					}
					if(pages < 1) {
						pages = 1;
					}
					if(pages > totalPages) {
						pages = totalPages;
					}
					List<Gag> gagList = this.adminsServiceImpl.findGagByPage(pages);
					if(gagList != null) {
						model.addAttribute("gagList",gagList);
						model.addAttribute("totalPages",totalPages);
						model.addAttribute("pages",pages);
						return "admin/html/gagList";
					}
					return "admin/html/gagList";
				}	
				//封号列表
				@RequestMapping("/titleList")
				public String titleList(Integer pages,Model model) {
					int totalPages = this.adminsServiceImpl.totalPages();
					if(pages == null) {
						pages = 1;
					}
					if(pages < 1) {
						pages = 1;
					}
					if(pages > totalPages) {
						pages = totalPages;
					}
					List<Title> titleList = this.adminsServiceImpl.findTitleByPage(pages);
					if(titleList != null) {
						model.addAttribute("titleList",titleList);
						model.addAttribute("totalPages",totalPages);
						model.addAttribute("pages",pages);
						return "admin/html/titleList";
					}
					return "admin/html/titleList";
				}	
}


