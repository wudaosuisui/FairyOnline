package com.fairyonline.xiaoye.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="vertex")
public class Vertex {
	
	private int id;	
	private int FirstSideId;
	private int LastSideId;
	/*someThing others*/
//	private String name;//这个字符串   可以由多个名称合并
//	private int sign;//标记   对节点进行分类
//	private String detail;//详情
//	private String correlation;//相关内容
//	private int hot;//热度
	
	/*构造函数*/
	//默认构造
	public Vertex() {
	}
	//全构造
	public Vertex(int id, int firstSideId, int lastSideId) {
		/*super();*/
		this.id = id;
		FirstSideId = firstSideId;
		LastSideId = lastSideId;
	}
	//一般构造
	public Vertex(int firstSideId, int lastSideId) {
		/*super();*/
		FirstSideId = firstSideId;
		LastSideId = lastSideId;
	}
	/*setter&getter*/
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFirstSideId() {
		return FirstSideId;
	}
	public void setFirstSideId(int firstSideId) {
		FirstSideId = firstSideId;
	}
	public int getLastSideId() {
		return LastSideId;
	}
	public void setLastSideId(int lastSideId) {
		LastSideId = lastSideId;
	}
	
}
