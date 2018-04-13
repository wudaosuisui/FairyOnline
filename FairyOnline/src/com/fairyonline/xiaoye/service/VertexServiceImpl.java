package com.fairyonline.xiaoye.service;

import java.util.List;

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
	
	/*��ӽڵ�*/
	public void Add(Vertex vertex) {
		Session session = sessionFactory.openSession();
		this.vertexDaoImpl.save(vertex);
		session.close();
	}
	/*��ȡ�ڵ�*/
//	get list
	public List<Vertex> getList(){
		return this.vertexDaoImpl.getList();
	}
//	ById
	public Vertex getById(int id ) {
		Session session = sessionFactory.openSession();
		return this.vertexDaoImpl.getById(id);
	}
	/*�޸Ľڵ�*/
//	update
	public void update(Vertex ver) {
		this.vertexDaoImpl.update(ver);
	}
//	public
	/*ɾ���ڵ�*/
	//ɾ���ڵ�ByVertex
	public void deleteByVertex(Vertex ver) {
		Session session = sessionFactory.openSession();
		this.vertexDaoImpl.delete(ver);
		session.close();
	}
	//ɾ���ڵ�Byid
	public void deleteById(int id) {
	Session session = sessionFactory.openSession();
	this.vertexDaoImpl.deleteById(id);
	session.close();
}
	
}






