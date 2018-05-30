package com.fairyonline.teacher.service;

import javax.annotation.Resource;

import com.fairyonline.teacher.dao.VideoDao;

public class VideoService {
	@Resource
	private VideoDao videoDao;
	public boolean submit(String CName,String ChapterName) {
		return videoDao.submit(CName, ChapterName);
	}
}
