package com.fairyonline.admin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fairyonline.user.entity.User;

@Entity
@Table(name="title")
public class Title {
	private int id;
	private String time;
	private String reason;
	private User uid;
	private Admins aName;
	
	public Title() {}
	public Title(String time,User uid,Admins aName) {
		this.time = time;
		this.uid= uid;
		this.aName = aName;
	}
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	@JoinColumn(name="AName")
	@NotFound(action=NotFoundAction.IGNORE)
	public Admins getaName() {
		return aName;
	}
	public void setaName(Admins aName) {
		this.aName = aName;
	}
	
	
}
