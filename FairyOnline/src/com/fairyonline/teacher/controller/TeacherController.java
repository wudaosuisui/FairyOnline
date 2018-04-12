package com.fairyonline.teacher.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bear.online.teacher.service.TeacherService;

@Controller
@RequestMapping("teacher")
public class TeacherController {
	@Resource
	private TeacherService teacherService;
	@RequestMapping("/submit")
	public String regist(Model model,
			HttpServletRequest request,
			@RequestParam("id")String id,
			@RequestParam("information")String information){
			boolean flag = teacherService.submit(id,information);
			if (flag) {
				return "submitSuccess";
			} else {
				model.addAttribute("errorMsg", "Ã·Ωª  ß∞‹");
				return "tijaioziliao";
			}
		
	}
}
