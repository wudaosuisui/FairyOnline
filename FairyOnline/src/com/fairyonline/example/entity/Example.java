package com.fairyonline.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Example")/*���ݿ�sql������Ѿ��н����õ� ��Ӧ�ı�ͳһ�ñ�����ֽ����ࣻ����Ҫ�淶*/
public class Example {
	
	private int id ;
	private String name;
	
	//���캯��
	/* 1.һ�������κβ����Ĺ��캯��
	 * 2.������Ҫ�Ĺ��캯��*/
	public Example() {};
	public Example(String name) {
		this.name = name;
	}
	
	//setter & getter 
	/*���ñ�׼��set get�����������ײ��������ϵĴ���
	 * �Ҽ�-�� Source-��Generate Getter and Setters��*/
	 /*������id,����3��ע�ͼ���*/
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
