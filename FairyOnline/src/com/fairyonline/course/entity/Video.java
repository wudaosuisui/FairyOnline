package com.fairyonline.course.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.user.entity.RCourse;
import com.fairyonline.user.entity.RUser;

@Entity
@Table(name="video")
public class Video {
	private int ID;
	private String Name;
	private Chapters ChapterID;
	private int TID;//后期再加一对多
	private String URL;
	private List<RCourse> reportVideoList = new ArrayList<RCourse>();
	
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
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	
	@ManyToOne
	@JoinColumn(name="ChapterID")
	public Chapters getChapterID() {
		return ChapterID;
	}
	public void setChapterID(Chapters chapterID) {
		ChapterID = chapterID;
	}
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
	
	@OneToMany(mappedBy="rid", targetEntity=RUser.class, 
	        cascade=CascadeType.ALL)
	public List<RCourse> getReportVideoList() {
		return reportVideoList;
	}
	public void setReportVideoList(List<RCourse> reportVideoList) {
		this.reportVideoList = reportVideoList;
	}

	
}
