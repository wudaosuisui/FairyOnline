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
	/*主要属性*///5
	private int id ;
	//以下两个节点 顺序先后 ，没有其他意义
	private int nodeOneId;//边链接的第一个节点
	private int nodeTwoId;//边链接的第二个节点
	//以下两个节点 顺序先后，与前面两个节点相对应
	private int oneNextSideId;//第一个节点的下一条边；如果是此节点的最后一条边，则为空或为0
	private int twoNextSideId;//第二个节点的下一条边；如果是此节点的最后一条边，则为空或为0
	/*一般属性*///6
	private String verNumber;//版本号 	version number
	private String noName;//节点一name NodeOneName
	private int noRelDegree;//节点一 相关度Related degree; degree of association
	private String ntName;//节点二name NodeTwoName
	private int ntRelDegree;//节点二 相关度Related degree; degree of association
	private String content;//详细解释
	
	/*构造函数*/
	//全构造
	public Side(int id, int nodeOneId, int nodeTwoId, int oneNextSideId, int twoNextSideId, String verNumber,
			String noName, int noRelDegree, String ntName, int ntRelDegree, String content) {
		this.id = id;
		this.nodeOneId = nodeOneId;
		this.nodeTwoId = nodeTwoId;
		this.oneNextSideId = oneNextSideId;
		this.twoNextSideId = twoNextSideId;
		this.verNumber = verNumber;
		this.noName = noName;
		this.noRelDegree = noRelDegree;
		this.ntName = ntName;
		this.ntRelDegree = ntRelDegree;
		this.content = content;
	}
	//无id 全构造
	public Side(int nodeOneId, int nodeTwoId, int oneNextSideId, int twoNextSideId, String verNumber,
			String noName, int noRelDegree, String ntName, int ntRelDegree, String content) {
		this.nodeOneId = nodeOneId;
		this.nodeTwoId = nodeTwoId;
		this.oneNextSideId = oneNextSideId;
		this.twoNextSideId = twoNextSideId;
		this.verNumber = verNumber;
		this.noName = noName;
		this.noRelDegree = noRelDegree;
		this.ntName = ntName;
		this.ntRelDegree = ntRelDegree;
		this.content = content;
	}
	//一般构造
	public Side(  String verNumber,	String noName, int noRelDegree, String ntName, int ntRelDegree, String content) {
		this.oneNextSideId = 0;
		this.twoNextSideId = 0;
		this.verNumber = verNumber;
		this.noName = noName;
		this.noRelDegree = noRelDegree;
		this.ntName = ntName;
		this.ntRelDegree = ntRelDegree;
		this.content = content;
	}
	//测试构造
	public Side(String test) {
		this.nodeOneId = 0;
		this.nodeTwoId = 0;
		this.oneNextSideId = 0;
		this.twoNextSideId = 0;
		this.verNumber = "1.0.0";
		this.noName = "web";
		this.noRelDegree = 5;
		this.ntName = "css";
		this.ntRelDegree = 5;
		this.content = "一个十分详细的解释！！！当然 也不知道是不是真的详细。总之是详细就对了。some English words!To test";
	}
	//默认构造
	public Side() {}
	/*特殊的方法*/
	//根据node  name 进行set nextside
	public void setNextSidId(Node node,Side nexSid) {
		if(this.noName.equals(node.getName())) 
			this.setOneNextSideId(nexSid.getId());
		else 
			this.setTwoNextSideId(nexSid.getId());
	}
	//展示side
	public void show() {
		System.out.println(
				this.id+"\t"+
				this.nodeOneId+"\t"+
				this.nodeTwoId+"\t"+
				this.noName+"\t"+
				this.ntName+"\t"+
				this.oneNextSideId+"\t"+
				this.twoNextSideId+"\t"+
				this.verNumber+"\t"+
				this.noName+"\t"+
				this.noRelDegree+"\t"+
				this.ntName+"\t"+
				this.ntRelDegree+"\t"+
				this.content
				);
	}
	/*set&get*/
	@Id//自增id
	@GeneratedValue(generator="my_gen")
    @GenericGenerator(name="my_gen", strategy="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNodeOneId() {
		return nodeOneId;
	}
	public void setNodeOneId(int nodeOneId) {
		this.nodeOneId = nodeOneId;
	}
	public int getNodeTwoId() {
		return nodeTwoId;
	}
	public void setNodeTwoId(int nodeTwoId) {
		this.nodeTwoId = nodeTwoId;
	}
	public int getOneNextSideId() {
		return oneNextSideId;
	}
	public void setOneNextSideId(int oneNextSideId) {
		this.oneNextSideId = oneNextSideId;
	}
	public int getTwoNextSideId() {
		return twoNextSideId;
	}
	public void setTwoNextSideId(int twoNextSideId) {
		this.twoNextSideId = twoNextSideId;
	}
	public String getVerNumber() {
		return verNumber;
	}
	public void setVerNumber(String verNumber) {
		this.verNumber = verNumber;
	}
	public String getNoName() {
		return noName;
	}
	public void setNoName(String noName) {
		this.noName = noName;
	}
	public int getNoRelDegree() {
		return noRelDegree;
	}
	public void setNoRelDegree(int noRelDegree) {
		this.noRelDegree = noRelDegree;
	}
	public String getNtName() {
		return ntName;
	}
	public void setNtName(String ntName) {
		this.ntName = ntName;
	}
	public int getNtRelDegree() {
		return ntRelDegree;
	}
	public void setNtRelDegree(int ntRelDegree) {
		this.ntRelDegree = ntRelDegree;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
