package com.fairyonline.xiaoye.controller;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fairyonline.xiaoye.service.NodeServiceImpl;
import com.fairyonline.xiaoye.service.SideServiceImpl;

@Controller
@Repository
@RequestMapping("/file")
public class FileController {

	@Resource
	private SideServiceImpl sideServiceImpl;
	@Resource
	private NodeServiceImpl nodeServiceImpl;
	
	
	@RequestMapping("/test")
	public String Test(@RequestParam(value="file") String  furl) {
		System.out.println("furl : "+furl+"  controller get");
		nodeServiceImpl.AddNodeByFile(furl);
		System.out.println("controller out");
		return "Xiaoye/filetest";
	}
}
