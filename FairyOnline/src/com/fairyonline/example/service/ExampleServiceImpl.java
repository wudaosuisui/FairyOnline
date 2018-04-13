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
	
	/*ÿһ�������ϣ���Ҫ�и÷����ļ�˵����*/
	/*��Ӷ���*/
	public void Add(Example example) {
		Session session = sessionFactory.openSession();
		this.exampleDaoImpl.save(example);
		session.close();//session�򿪺� �ǵùر�
	}
	/*ɾ������*/
	/*���¶���*/
	/*������*/
	
}
