package com.fairyonline.xiaoye.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.xiaoye.entity.Vertex;

@Repository
public class VertexDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	/*save*/
	public void save(Vertex vertex) {
		Session session = sessionFactory.getCurrentSession();//获取sessio
		Transaction tra = session.beginTransaction();//开启事务
		session.save(vertex);
		session.flush();
		tra.commit();
	}
	/*get*/
	
//	get List
	public List<Vertex> getList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Vertex");
		return q.list();
	}
//	get by id
	public Vertex getById(int id ) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tra = session.beginTransaction();
		Vertex ver = session.get(Vertex.class, id);
		tra.commit();
		session.close();
		return ver;
		}
	/*update*/
//	update 
	public void update(Vertex ver) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tra = session.beginTransaction();
		session.update(ver);
		session.flush();
		tra.commit();
	}
//	update by id  (无用)
//	public void updateById(int id ) {
//		Session session = sessionFactory.getCurrentSession();
//		Transaction tra = session.beginTransaction();
//		Vertex ver = session.get(Vertex.class,id);
//		session.update(ver);
//		session.flush();
//		tra.commit();
//	}
	/*delete*/
//	delete by vertex 
	public void delete(Vertex ver) {
		Session session = sessionFactory.getCurrentSession(); 
		Transaction tra = session.beginTransaction();
		session.delete(ver);
		session.flush();
		tra.commit();
	}
//	delete by id
	public void deleteById(int id ) {
		Session session = sessionFactory.getCurrentSession(); 
		Transaction tra = session.beginTransaction();
		Vertex ver = session.get(Vertex.class,id);
		session.delete(ver);
		tra.commit();
	}
}







