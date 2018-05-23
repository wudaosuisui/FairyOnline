package com.fairyonline.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="followUser")
public class FollowUser {
    private int id;
    private String status;
    private User uid;
    private User fid;
    @Id
    @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@ManyToOne
	@JoinColumn(name="UID")
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	@ManyToOne
	@JoinColumn(name="FID")
	public User getFid() {
		return fid;
	}
	public void setFid(User fid) {
		this.fid = fid;
	}
    
}
