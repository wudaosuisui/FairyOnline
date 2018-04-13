package com.fairyonline.example.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.fairyonline.example.entity.Example;

@Repository
public class ExampleDaoImpl {/*�շ�ʽ����*/
	
	@Resource
	private SessionFactory sessionFactory;
	
	/*ÿһ�෽�����ֺ��ࣻ
	 * Dao��ֻ��һ�¼����������Ҫ��service��Ĺ��ܲ������*/
	/*save*//*����*/
	public void save(Example example) {
		Session session = sessionFactory.getCurrentSession();//��ȡsessio
		Transaction tra = session.beginTransaction();//��������
		session.save(example);
		System.out.println("save success!");
		session.flush();
		tra.commit();
		System.out.println("out dao");
	}
	
	
	/*get*//*��ѯ*/
	/*�շ�ʽ��������ʽ��
	 * ��ÿ�������ϱ�ע�����࣬��List��id ����name �ȵ� */
	//List
	public List<Example> getList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Example");
		return q.list();
	}
	//id
	//name
	/*update*//*����*/
	
	/*delete*//*ɾ��*/
}
