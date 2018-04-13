package com.fairyonline.xiaoye.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Side")
public class Side {
	
	private int id ;
	//���������ڵ� ˳���Ⱥ� ��û����������
	private int VertexOneId;//�����ӵĵ�һ���ڵ�
	private int VertexTwoId;//�����ӵĵڶ����ڵ�
	//���������ڵ� ˳���Ⱥ���ǰ�������ڵ����Ӧ
	private int NextSideOneId;//��һ���ڵ����һ���ߣ�����Ǵ˽ڵ�����һ���ߣ���Ϊ�ջ�Ϊ0
	private int NextSideTwoId;//�ڶ����ڵ����һ���ߣ�����Ǵ˽ڵ�����һ���ߣ���Ϊ�ջ�Ϊ0
	/*someThing others*/
	
	/*���캯��*/
	//Ĭ�Ϲ���
	public Side() {}
	//ȫ����
	public Side(int id, int vertexOneId, int vertexTwoId, int nextSideOneId, int nextSideTwoId) {
		/*super();*/
		this.id = id;
		VertexOneId = vertexOneId;
		VertexTwoId = vertexTwoId;
		NextSideOneId = nextSideOneId;
		NextSideTwoId = nextSideTwoId;
	}
	//��������
	public Side(int vertexOneId,int vertexTwoId, int nextSideOneId, int nextSideTwoId) {
		/*super();*/
		VertexOneId = vertexOneId;
		VertexTwoId = vertexTwoId;
		NextSideOneId = nextSideOneId;
		NextSideTwoId = nextSideTwoId;
	}

	/*Setter&Getter*/
	@Id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getVertexOneId() {
		return VertexOneId;
	}

	public void setVertexOneId(int vertexOneId) {
		VertexOneId = vertexOneId;
	}

	public int getVertexTwoId() {
		return VertexTwoId;
	}

	public void setVertexTwoId(int vertexTwoId) {
		VertexTwoId = vertexTwoId;
	}

	public int getNextSideOneId() {
		return NextSideOneId;
	}

	public void setNextSideOneId(int nextSideOneId) {
		NextSideOneId = nextSideOneId;
	}

	public int getNextSideTwoId() {
		return NextSideTwoId;
	}

	public void setNextSideTwoId(int nextSideTwoId) {
		NextSideTwoId = nextSideTwoId;
	}

	
	
	
}
