package com.fairyonline.teacher.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="video")
public class Video {
	private int ID;
	private int TID;
	private int CID;
	private String Name;
	private String URL;
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public int getTID() {
		return TID;
	}
	public void setTID(int TID) {
		this.TID = TID;
	}
	public int getCID() {
		return CID;
	}
	public void setCID(int cid) {
		this.CID = cid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
}
