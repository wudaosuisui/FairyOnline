package com.fairyonline.course.controller;



import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairyonline.course.entity.Course;
import com.fairyonline.course.service.CourseServiceImpl;

@Controller
@Repository
@RequestMapping("course")
public class CourseControllerImpl {
	
	@Resource
	private CourseServiceImpl csi;
	
	//添加
	
		@RequestMapping(value="/Add")/*方法对应地址*/
		public String Add() {/*驼峰式命名*/
			System.out.println("get add");
			Date now = null;
			
			Course course = new Course("courseName",1,now, 1);
			csi.Add(course);
			return "Example/Example";
		}
		
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
//		@RequestMapping("/list")
//		public String getCourseByPartName(Model model,String courseName) {
//			Course list = this.csi.getCourseByPartName(courseName);
//			model.addAttribute("list", list);
//			System.out.println(list.);
//			return "";
//		}
	
	
	

}
