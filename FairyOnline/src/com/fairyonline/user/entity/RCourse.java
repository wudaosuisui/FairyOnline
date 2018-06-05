package com.fairyonline.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fairyonline.course.entity.Video;

@Entity
@Table(name="ruser")
public class RCourse {
	private int id;
	private String reason;
	private String date;
	private boolean tof;
	private User uid;
	private Video rid;
	
	public RCourse() {
		
	}
	public RCourse(String reason,User uid,Video rid) {
		this.reason = reason;
		this.uid = uid;
		this.rid= rid;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isTof() {
		return tof;
	}
	public void setTof(boolean tof) {
		this.tof = tof;
	}
	
	@ManyToOne
	@JoinColumn(name="UID")
	@NotFound(action=NotFoundAction.IGNORE)
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	
	@ManyToOne
	@JoinColumn(name="RID")
	@NotFound(action=NotFoundAction.IGNORE)
	public Video getRid() {
		return rid;
	}
	public void setRid(Video rid) {
		this.rid = rid;
	}
	
	
}
