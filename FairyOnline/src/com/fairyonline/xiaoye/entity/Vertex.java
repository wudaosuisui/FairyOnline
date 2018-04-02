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
	private int sign;//标记   对节点进行分类
	private String name;//这个字符串   可以由多个名称合并
//	private String detail;//详情
//	private String correlation;//相关内容
//	private int hot;//热度
	public Vertex() {}
	public Vertex(int sign,String name) {
		this.sign = sign;
		this.name = name;
		System.out.println("println Vertex : "+getSign()+" "+getName());
	}
	/*public Vertex(int id ,int sign,String name) {
		this.id =id;
		this.sign = sign;
		this.name = name;
		System.out.println("println Vertex : "+getSign()+" "+getName());
	}*/
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSign() {
		return sign;
	}

	public void setSign(int sign) {
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getDetail() {
//		return detail;
//	}
//
//	public void setDetail(String detail) {
//		this.detail = detail;
//	}
//
//	public String getCorrelation() {
//		return correlation;
//	}
//
//	public void setCorrelation(String correlation) {
//		this.correlation = correlation;
//	}
	
	
}
