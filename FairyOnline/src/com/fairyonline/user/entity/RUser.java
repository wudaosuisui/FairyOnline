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

@Entity
@Table(name="ruser")
public class RUser {
	private int id;
	private String reason;
	private boolean tof;
	private User uid;
	private User rid;
	public RUser() {
	}
	public RUser(String reason,User uid,User rid) {
		this.reason = reason;
		this.uid = uid;
		this.rid = rid;
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
	public User getRid() {
		return rid;
	}
	
	public void setRid(User rid) {
		this.rid = rid;
	}

	
}
