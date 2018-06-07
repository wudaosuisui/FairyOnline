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
@Table(name="gag")
public class Gag {
     private int id;
     private String time;
     private String sTime;
     private String eTime;
     private String reason;
     private User uid;
     private Admins aName;
     
    public Gag() {}
    public Gag(String time,String eTime,String sTime,String reason,User uid,Admins aName) {
    	this.time = time;
    	this.eTime = eTime;
    	this.sTime = sTime;
    	this.reason = reason;
    	this.uid = uid;
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
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public String geteTime() {
		return eTime;
	}
	public void seteTime(String eTime) {
		this.eTime = eTime;
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
