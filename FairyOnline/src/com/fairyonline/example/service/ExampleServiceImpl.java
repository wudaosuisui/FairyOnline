package com.fairyonline.example.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairyonline.example.dao.ExampleDaoImpl;
import com.fairyonline.example.entity.Example;

@Service
@Repository
public class ExampleServiceImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private ExampleDaoImpl exampleDaoImpl;
	
	/*每一个方法上，都要有该方法的简单说明。*/
	/*添加对象*/
	public void Add(Example example) {
		Session session = sessionFactory.openSession();
		this.exampleDaoImpl.save(example);
		session.close();//session打开后 记得关闭
	}
	/*删除对象*/
	/*更新对象*/
	/*。。。*/
	
}
