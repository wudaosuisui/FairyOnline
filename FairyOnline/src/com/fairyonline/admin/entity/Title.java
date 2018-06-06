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
	private int time;
	private User uid;
	private Admins aName;
	
	public Title() {}
	public Title(int time,User uid,Admins aName) {
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
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
