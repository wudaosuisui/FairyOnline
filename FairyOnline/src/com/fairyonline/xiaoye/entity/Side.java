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
	//以下两个节点 顺序先后 ，没有其他意义
	private int VertexOneId;//边链接的第一个节点
	private int VertexTwoId;//边链接的第二个节点
	//以下两个节点 顺序先后，与前面两个节点相对应
	private int NextSideOneId;//第一个节点的下一条边；如果是此节点的最后一条边，则为空或为0
	private int NextSideTwoId;//第二个节点的下一条边；如果是此节点的最后一条边，则为空或为0
	/*someThing others*/
	
	/*构造函数*/
	//默认构造
	public Side() {}
	//全构造
	public Side(int id, int vertexOneId, int vertexTwoId, int nextSideOneId, int nextSideTwoId) {
		/*super();*/
		this.id = id;
		VertexOneId = vertexOneId;
		VertexTwoId = vertexTwoId;
		NextSideOneId = nextSideOneId;
		NextSideTwoId = nextSideTwoId;
	}
	//正常构造
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
