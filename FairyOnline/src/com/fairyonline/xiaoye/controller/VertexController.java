package com.fairyonline.xiaoye.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairyonline.xiaoye.entity.Side;
import com.fairyonline.xiaoye.entity.Vertex;
import com.fairyonline.xiaoye.service.SideServiceImpl;
import com.fairyonline.xiaoye.service.VertexServiceImpl;


public class VertexController {
//	@Resource
//	private VertexServiceImpl vertexServiceImpl;
//	@Resource
//	private SideServiceImpl sideServiceImpl;
//	/*添加节点*/
//	@RequestMapping("/AddVertex")
//	public String AddVertex() {//@RequestParam("name") String name
//		System.out.println("get controller");
//		Vertex ver = new Vertex(3,4);
//		vertexServiceImpl.Add(ver);
//		return "Xiaoye/success";
//	}
//	/*获取节点*/
//	//get list
//	@RequestMapping("/getList")
//	public String getList() {
//		List<Vertex> verList = this.vertexServiceImpl.getList();
//		System.out.println("============ Vertex List ===========");
//		System.out.println("id	FirstSideId    LastSideId ");
//		for(Vertex ver :verList) {
//			System.out.println(ver.getId() +"       "+ver.getFirstSideId()+"       "+ver.getLastSideId());
//		}
//		System.out.println("============ Vertex List end ===========");
//		return "Xiaoye/success";
//	}
//	@RequestMapping("/getVertexById")
//	public String getVertexById(@RequestParam int id) {//@RequestParam(value="pageN" ) int pageN
//		Vertex ver = this.vertexServiceImpl.getById(id);
//		System.out.println("============ Vertex  ===========");
//		System.out.println(ver.getId() +"       "+ver.getFirstSideId()+"       "+ver.getLastSideId());
//		return "Xiaoye/success";
//	}
//	
//	@RequestMapping("/AddSide")
//	public String AddSide() {
//		System.out.println("get controller");
////		Side side = new Side(1,2,0,0);
////		this.sideServiceImpl.Add(side);
//		return "Xiaoye/success";
//	}
}
