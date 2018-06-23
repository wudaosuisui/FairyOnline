package com.fairyonline.course.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.course.entity.Orders;
import com.fairyonline.course.entity.OrdersList;

@Repository
public class OrdersDao {
	@Resource
	private SessionFactory sessionFactory;
	
	public Orders  getOrdById(int id ) {
		Session session = sessionFactory.getCurrentSession();//获取sessio
		Transaction tra = session.beginTransaction();
		Orders ord = session.get(Orders.class, id);
		session.flush();
		tra.commit();
		return ord;
	}
	public void saveOrd(Orders ord) {
		Session session = sessionFactory.getCurrentSession();//获取sessio
		Transaction tra = session.beginTransaction();//开启事务
		session.save(ord);
		session.flush();
		tra.commit();
		System.out.println("out dao saveOrd");
	}
	public void saveOrdList(List<OrdersList> ordlist) {
		Session session = sessionFactory.getCurrentSession();//获取sessio
		Transaction tra = session.beginTransaction();//开启事务
		for(OrdersList or : ordlist) {
			System.out.println("ors Course name is "+ or.getCourse().getCName()+
					"ors ord id is "+or.getOrderId().getID());
			session.save(or);
		}
		session.flush();
		tra.commit();
		System.out.println("out dao saveOrdList");
	}
//	public void save(Course course) {
//		Session session = sessionFactory.getCurrentSession();//获取sessio
//		Transaction tra = session.beginTransaction();//开启事务
//		session.save(course);
//		System.out.println("save success!");
//		session.flush();
//		tra.commit();
//		System.out.println("out dao");
//	}
//	
}
