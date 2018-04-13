package com.fairyonline.xiaoye.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairyonline.xiaoye.dao.SideDaoImpl;
import com.fairyonline.xiaoye.entity.Side;

@Service
@Repository
public class SideServiceImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private SideDaoImpl sideDaoImpl;
	
	/*Ìí¼Ó±ß*/
	public void Add(Side side) {
		System.out.println("get sivers");
		Session session = sessionFactory.openSession();
		this.sideDaoImpl.save(side);
		session.close();
		System.out.println("out sivers");
		
	}
}




