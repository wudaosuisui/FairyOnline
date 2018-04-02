package com.fairyonline.xiaoye.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairyonline.xiaoye.dao.VertexDaoImpl;
import com.fairyonline.xiaoye.entity.Vertex;

@Service
@Repository
public class VertexServiceImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private VertexDaoImpl vertexDaoImpl;
	
	/*Ìí¼Ó½Úµã*/
	public void Add(Vertex vertex) {
		System.out.println("get sivers");
		Session session = sessionFactory.openSession();
		System.out.println("open session success!");
		this.vertexDaoImpl.save(vertex);
		session.close();
		System.out.println("out sivers");
	}
	
	
}






