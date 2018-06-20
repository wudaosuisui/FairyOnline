package com.fairyonline.course.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fairyonline.user.entity.User;

@Entity
@Table(name="followcourse")
public class FollowCourse {
	private int id;
	private User fuid;
    private Course fcid;
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(cascade = CascadeType.ALL,optional = false,fetch = FetchType.LAZY)
	@JoinColumn(name="fuid")
	public User getFuid() {
		return fuid;
	}
	public void setFuid(User fuid) {
		this.fuid = fuid;
	}
	@ManyToOne
	@JoinColumn(name="fcid")
	public Course getFcid() {
		return fcid;
	}
	public void setFcid(Course fcid) {
		this.fcid = fcid;
	}
	

	
	

}
