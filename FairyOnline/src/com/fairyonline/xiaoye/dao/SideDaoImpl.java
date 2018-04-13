package com.fairyonline.xiaoye.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.xiaoye.entity.Side;

@Repository
public class SideDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	/*save*/
	public void save(Side side) {
		Session session = sessionFactory.getCurrentSession();//获取sessio
		Transaction tra = session.beginTransaction();//开启事务
		session.save(side);	
		session.flush();
		tra.commit();
	}
	/*get*/
//	get list
	public List<Side> getList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Side");
		return q.list();
	}
//	get by id 
	public Side getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tra = session.beginTransaction();
		Side sid = session.get(Side.class, id);
		tra.commit();
		return sid;
	}
	/*update*/
//	update 
	public void update(Side sid) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tra = session.beginTransaction();
		session.update(sid);
		session.flush();
		tra.commit();
	}
//	update by id
	public void updateById(int id ) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tra = session.beginTransaction();
		Side sid = session.get(Side.class, id);
		session.update(sid);
		session.flush();
		tra.commit();
	}
	/*delete*/
//	delete
	public void delete(Side sid) {
		Session session = sessionFactory.getCurrentSession(); 
		Transaction tra = session.beginTransaction();
		session.delete(sid);
		session.flush();
		tra.commit();
	}
//	delete by id
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession(); 
		Transaction tra = session.beginTransaction();
		Side sid = session.get(Side.class, id);
		session.delete(sid);
		session.flush();
		tra.commit();
	}
}
