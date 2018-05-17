package com.fairyonline.teacher.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class Office {
	private int ID;
	private int TiD;
	private String name;
	private String URL;
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public int getTiD() {
		return TiD;
	}
	public void setTiD(int TiD) {
		this.TiD = TiD;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String URL) {
		this.URL = URL;
	}
}
