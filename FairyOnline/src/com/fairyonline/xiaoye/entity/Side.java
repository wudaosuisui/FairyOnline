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
	private int NodeOneId;//边链接的第一个节点
	private int NodeTwoId;//边链接的第二个节点
	//以下两个节点 顺序先后，与前面两个节点相对应
	private int OneNextSideId;//第一个节点的下一条边；如果是此节点的最后一条边，则为空或为0
	private int TwoNextSideId;//第二个节点的下一条边；如果是此节点的最后一条边，则为空或为0
	/*一般属性*///6
	private String verNumber;//版本号 	version number
	private String NoName;//节点一name NodeOneName
	private int NoRelDegree;//节点一 相关度Related degree; degree of association
	private String NtName;//节点二name NodeTwoName
	private int NtRelDegree;//节点二 相关度Related degree; degree of association
	private String content;//详细解释
	
	/*构造函数*/
	//全构造
	public Side(int id, int nodeOneId, int nodeTwoId, int oneNextSideId, int twoNextSideId, String verNumber,
			String noName, int noRelDegree ,String ntName, int ntRelDegree, String content) {
		this.id = id;
		NodeOneId = nodeOneId;
		NodeTwoId = nodeTwoId;
		OneNextSideId = oneNextSideId;
		TwoNextSideId = twoNextSideId;
		this.verNumber = verNumber;
		NoName = noName;
		NtName = ntName;
		NoRelDegree = noRelDegree;
		NtRelDegree = ntRelDegree;
		this.content = content;
	}
	//无id 全构造
	public Side(int nodeOneId, int nodeTwoId, int oneNextSideId, int twoNextSideId, String verNumber,
			String noName, int noRelDegree ,String ntName, int ntRelDegree, String content) {
		NodeOneId = nodeOneId;
		NodeTwoId = nodeTwoId;
		OneNextSideId = oneNextSideId;
		TwoNextSideId = twoNextSideId;
		this.verNumber = verNumber;
		NoName = noName;
		NtName = ntName;
		NoRelDegree = noRelDegree;
		NtRelDegree = ntRelDegree;
		this.content = content;
	}
	//一般构造
	public Side(String verNumber, String noName,int noRelDegree ,String ntName, int ntRelDegree, String content) {
		OneNextSideId=0;
		TwoNextSideId=0;
		this.verNumber = verNumber;
		NoName = noName;
		NtName = ntName;
		NoRelDegree = noRelDegree;
		NtRelDegree = ntRelDegree;
		this.content = content;
	}
	//测试构造
	public Side(String test) {
		NodeOneId = 1;
		NodeTwoId = 2;
		OneNextSideId = 0;
		TwoNextSideId = 0;
		this.verNumber = "1.0.0";
		NoName = "noName";
		NtName = "ntName";
		NoRelDegree = 5;
		NtRelDegree = 5;
		this.content = "一个十分详细的解释！！！当然 也不知道是不是真的详细。总之是详细就对了。some English words!To test";
	}
	//默认构造
	public Side() {}
	/*特殊的方法*/
	//根据node  name 进行set nextside
	public void setNextSidId(Node node,Side nexSid) {
		if(this.NoName.equals(node.getName())) 
			this.setOneNextSideId(nexSid.getId());
		else 
			this.setTwoNextSideId(nexSid.getId());
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
		return NodeOneId;
	}
	public void setNodeOneId(int nodeOneId) {
		NodeOneId = nodeOneId;
	}
	public int getNodeTwoId() {
		return NodeTwoId;
	}
	public void setNodeTwoId(int nodeTwoId) {
		NodeTwoId = nodeTwoId;
	}
	public int getOneNextSideId() {
		return OneNextSideId;
	}
	public void setOneNextSideId(int oneNextSideId) {
		OneNextSideId = oneNextSideId;
	}
	public int getTwoNextSideId() {
		return TwoNextSideId;
	}
	public void setTwoNextSideId(int twoNextSideId) {
		TwoNextSideId = twoNextSideId;
	}
	public String getVerNumber() {
		return verNumber;
	}
	public void setVerNumber(String verNumber) {
		this.verNumber = verNumber;
	}
	public String getNoName() {
		return NoName;
	}
	public void setNoName(String noName) {
		NoName = noName;
	}
	public String getNtName() {
		return NtName;
	}
	public void setNtName(String ntName) {
		NtName = ntName;
	}
	public int getNoRelDegree() {
		return NoRelDegree;
	}
	public void setNoRelDegree(int noRelDegree) {
		NoRelDegree = noRelDegree;
	}
	public int getNtRelDegree() {
		return NtRelDegree;
	}
	public void setNtRelDegree(int ntRelDegree) {
		NtRelDegree = ntRelDegree;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
