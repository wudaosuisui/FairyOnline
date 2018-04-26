package com.fairyonline.course.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairyonline.course.entity.Course;
import com.fairyonline.course.service.CourseServiceImpl;

@Controller
@RequestMapping("course")
public class CourseControllerImpl {
	
	@Resource
	private CourseServiceImpl csi;
	
	//课程查询
	@RequestMapping("/list")
	public String getList(Model model) {
		List<Course> list = this.csi.getList();
		model.addAttribute("list", list);
		System.out.println("****************");
		System.out.println(list.size());
		return "course/CurriculumSpecial";
	}
	//课程模糊查询
//	@RequestMapping("/list")
//	public String getCourseByPartName(Model model,String courseName) {
//		Course list = this.csi.getCourseByPartName(courseName);
//		model.addAttribute("list", list);
//		System.out.println(list.);
//		return "";
//	}
	
	

}
