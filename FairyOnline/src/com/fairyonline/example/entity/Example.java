package com.fairyonline.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Example")/*数据库sql导入后，已经有建立好的 对应的表，统一用表的名字建立类；命名要规范*/
public class Example {
	
	private int id ;
	private String name;
	
	//构造函数
	/* 1.一个不含任何参数的构造函数
	 * 2.任意需要的构造函数*/
	public Example() {};
	public Example(String name) {
		this.name = name;
	}
	
	//setter & getter 
	/*采用标准的set get方法，不容易产生命名上的错误
	 * 右键-》 Source-》Generate Getter and Setters…*/
	 /*自增的id,用这3行注释即可*/
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	};

	
}
