package com.fairyonline.xiaoye.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairyonline.xiaoye.entity.Vertex;
import com.fairyonline.xiaoye.service.VertexServiceImpl;

@Controller
@Repository
@RequestMapping("/vertex")
public class VertexController {
	@Resource
	private VertexServiceImpl vertexServiceImpl;
	
	/*Ìí¼Ó½Úµã*/
	@RequestMapping("/Add")
	public String AddVertex() {//@RequestParam("name") String name
		System.out.println("get controller");
		Vertex ver = new Vertex(3,"name1");
		vertexServiceImpl.Add(ver);
		return "Xiaoye/success";
	}
}
