package com.fairyonline.teacher.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.online.entity.Teacher;
import com.bear.online.teacher.dao.TeacherDao;
@Service
@Transactional(readOnly=false)
public class TeacherService {
	@Resource
	private TeacherDao teacherDao;
	public boolean submit(String id,String information) {
		return teacherDao.submit(id, information);
	}
}
