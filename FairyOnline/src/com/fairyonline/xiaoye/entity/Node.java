package com.fairyonline.xiaoye.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Node")
public class Node {
	/*主要属性*///3
	private int id;	
	private int firstSideId;
	private int lastSideId;
	/*一般属性*///8
	private String verNumber;//版本号 	version number // Timestamps  time stamp
	private int catNumber;//类型编号 	category number
	private String Name;//名称	
	private String preKnowledge;//前置知识 		Pre Knowledge
	private String sucKnowledge;//后继知识 		Successor Knowledge
	private String relKnowledge;//一般相关知识 	Related Konwledge
	private String content;//详细解释
	private int heat;//热度

	/*构造*/
	//全构造
	public Node(int id, int firstSideId, int lastSideId, String verNumber, int catNumber, String name,String names,
			String preKnowledge, String sucKnowledge, String relKnowledge, String content, int heat) {
		this.id = id;
		firstSideId = firstSideId;
		lastSideId = lastSideId;
		this.verNumber = verNumber;
		this.catNumber = catNumber;
		Name = name;
		this.preKnowledge = preKnowledge;
		this.sucKnowledge = sucKnowledge;
		this.relKnowledge = relKnowledge;
		this.content = content;
		this.heat = heat;
	}
	//无id 全构造
	public Node( int firstSideId, int lastSideId, String verNumber, int catNumber, String name,
			String preKnowledge, String sucKnowledge, String relKnowledge, String content, int heat) {
		firstSideId = firstSideId;
		lastSideId = lastSideId;
		this.verNumber = verNumber;
		this.catNumber = catNumber;
		Name = name;
		this.preKnowledge = preKnowledge;
		this.sucKnowledge = sucKnowledge;
		this.relKnowledge = relKnowledge;
		this.content = content;
		this.heat = heat;
	}
	//默认构造1
	public Node() {
	}
	//默认构造2
	public Node( String verNumber, int catNumber, String name,
			String preKnowledge, String sucKnowledge, String relKnowledge, String content, int heat) {
		firstSideId = 0;
		lastSideId = 0;
		this.verNumber = verNumber;
		this.catNumber = catNumber;
		Name = name;
		this.preKnowledge = preKnowledge;
		this.sucKnowledge = sucKnowledge;
		this.relKnowledge = relKnowledge;
		this.content = content;
		this.heat = heat;
	}
	//测试构造
	public Node(String test) {
		firstSideId = 0;
		lastSideId = 0;
		this.verNumber = "1.0.0";
		this.catNumber = 1;
		Name = "name1 name2 name3 name4";
		this.preKnowledge = "preKno1;preKno2;preKno3";
		this.sucKnowledge = "sucKno1;sucKno2;sucKno3";
		this.relKnowledge = "relKno1;relKno2;relKno3";
		this.content = "一个十分详细的解释！！！当然 也不知道是不是真的详细。总之是详细就对了。some English words!To test";
		this.heat = 5;
	}
	/*特殊的方法*/
	//打印node
	public void show() {
		System.out.println(
				" Id: "+this.id+
				" FirstSideId : "+this.firstSideId+
				" LastSideId : "+this.lastSideId+
				
				" verNumber : "+this.verNumber+
				" catNumber : "+this.catNumber+
				" Name : "+this.Name+
				" preKnowledge : "+this.preKnowledge+
				" sucKnowledge : "+this.sucKnowledge+
				" relKnowledge : "+this.relKnowledge+
				" content : "+this.content+
				" heat : "+this.heat
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
	public int getFirstSideId() {
		return firstSideId;
	}
	public void setFirstSideId(int firstSideId) {
		this.firstSideId = firstSideId;
	}
	public int getLastSideId() {
		return lastSideId;
	}
	public void setLastSideId(int lastSideId) {
		this.lastSideId = lastSideId;
	}
	public String getVerNumber() {
		return verNumber;
	}
	
	public void setVerNumber(String verNumber) {
		this.verNumber = verNumber;
	}
	public int getCatNumber() {
		return catNumber;
	}
	public void setCatNumber(int catNumber) {
		this.catNumber = catNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPreKnowledge() {
		return preKnowledge;
	}
	public void setPreKnowledge(String preKnowledge) {
		this.preKnowledge = preKnowledge;
	}
	public String getSucKnowledge() {
		return sucKnowledge;
	}
	public void setSucKnowledge(String sucKnowledge) {
		this.sucKnowledge = sucKnowledge;
	}
	public String getRelKnowledge() {
		return relKnowledge;
	}
	public void setRelKnowledge(String relKnowledge) {
		this.relKnowledge = relKnowledge;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHeat() {
		return heat;
	}
	public void setHeat(int heat) {
		this.heat = heat;
	}
	
}
