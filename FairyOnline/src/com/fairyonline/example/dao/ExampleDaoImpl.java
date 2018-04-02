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
public class ExampleDaoImpl {/*驼峰式命名*/
	
	@Resource
	private SessionFactory sessionFactory;
	
	/*每一类方法，分好类；
	 * Dao层只做一下几类操作，不要将service层的功能插入进来*/
	/*save*//*保存*/
	public void save(Example example) {
		Session session = sessionFactory.getCurrentSession();//获取sessio
		Transaction tra = session.beginTransaction();//开启事务
		session.save(example);
		System.out.println("save success!");
		session.flush();
		tra.commit();
		System.out.println("out dao");
	}
	
	/*get*//*查询*/
	/*驼峰式的命名方式；
	 * 在每个方法上标注上种类，是List、id 还是name 等等*/
	//List
	public List<Example> getList(){
		Query q=this.sessionFactory.getCurrentSession().createQuery("from Example");
		return q.list();
	}
	//id
	//name
	/*update*//*更新*/
	
	/*delete*//*删除*/
}
