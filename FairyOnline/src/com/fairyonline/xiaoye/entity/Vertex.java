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
//	private String name;//����ַ���   �����ɶ�����ƺϲ�
//	private int sign;//���   �Խڵ���з���
//	private String detail;//����
//	private String correlation;//�������
//	private int hot;//�ȶ�
	
	/*���캯��*/
	//Ĭ�Ϲ���
	public Vertex() {
	}
	//ȫ����
	public Vertex(int id, int firstSideId, int lastSideId) {
		/*super();*/
		this.id = id;
		FirstSideId = firstSideId;
		LastSideId = lastSideId;
	}
	//һ�㹹��
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
