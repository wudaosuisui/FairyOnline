package com.fairyonline.course.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="chapters")
public class Chapters {
	
	
	private int ID;
    private Course CID;
    private String ChapterNum;
    private String ChapterName;
    private List<Video> videoList = new ArrayList<Video>();
    @Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		this.ID = iD;
	}
//	@ManyToOne(cascade={CascadeType.ALL})
//	@JoinColumn(name="CID"),referencedColumnName="CID"
	@ManyToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER)
    @JoinColumn(name="CID") 
	public Course getCID() {
		return CID;
	}
	public void setCID(Course cID) {
		this.CID = cID;
	}
	public String getChapterNum() {
		return ChapterNum;
	}
	public void setChapterNum(String chapterNum) {
		this.ChapterNum = chapterNum;
	}
	public String getChapterName() {
		return ChapterName;
	}
	public void setChapterName(String chapterName) {
		this.ChapterName = chapterName;
	}
	@OneToMany(fetch=FetchType.EAGER)//»ý¼«¼ÓÔØEAGER
	@JoinColumn(name="ChapterID")
	public List<Video> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}

}
