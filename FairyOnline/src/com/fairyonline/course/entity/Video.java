package com.fairyonline.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="video")
public class Video {
	private int ID;
	private String name;
	//private Chapters ChapterID;
	private int TID;//后期再加一对多
	private String URL;
	
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
//	@ManyToOne
//	@JoinColumn(name="ChapterID")
//	public Chapters getChapterID() {
//		return ChapterID;
//	}
//	public void setChapterID(Chapters chapterID) {
//		ChapterID = chapterID;
//	}
	public int getTID() {
		return TID;
	}
	public void setTID(int tID) {
		this.TID = tID;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		this.URL = uRL;
	}

}
