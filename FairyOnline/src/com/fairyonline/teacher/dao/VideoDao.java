package com.fairyonline.teacher.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.fairyonline.teacher.entity.Chapters;
import com.fairyonline.teacher.entity.Course;



public class VideoDao {
	@Resource
	private SessionFactory sessionFactory;
	public boolean submit(String CName,String ChapterName) {
		Course c=new Course();
		c.setCName(CName);
		Chapters cs=new Chapters();
		cs.setChapterName(ChapterName);
		c.setChapters(cs);
		Session s=this.sessionFactory.openSession();
		Transaction tr=s.beginTransaction();
		s.save(c);
		tr.commit();
		s.close();
		return true;
	}
}
