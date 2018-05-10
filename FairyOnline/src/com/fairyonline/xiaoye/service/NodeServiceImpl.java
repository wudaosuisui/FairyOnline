package com.fairyonline.xiaoye.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fairyonline.xiaoye.dao.NodeDaoImpl;
import com.fairyonline.xiaoye.entity.Node;

@Service
@Repository
public class NodeServiceImpl {
	@Resource
	private SessionFactory sessionFactory;
	@Resource
	private NodeDaoImpl nodeDaoImpl;
	/*主体方法*/
	
	public Node GetOneNode(int id) {
		Session session = sessionFactory.openSession();
		return nodeDaoImpl.getById(id);
	}
	
	public void AddOneNode(Node node) {
		System.out.println("service get");
		nodeDaoImpl.save(node);
		System.out.println("service out");
	}
	
	//获取文件内容、创建对象、存入数据库
	public void AddNodeByFile(String fileUrl) {
		System.out.println("service get");
		Session session = sessionFactory.openSession();
		//获取并拆分文件内容	返回一个文件内容而的String2维数组
		String[][] strArr = this.GetStrArr(fileUrl);
		//将获取到的数组  转换为对象数组
		Node[] nodeArr = this.GetNodSrr(strArr);
		//调用方法  存入数据库
		nodeDaoImpl.saveList(nodeArr);
		session.close();
		System.out.println("service out");
	}
	/*子方法*/
	//将获取到的数组中 转换为对象数组
	public Node[] GetNodSrr(String[][] strArr) {
		System.out.println("GetNodSrr get");
		Node[] nodArr = new Node[strArr.length-1];
		for(int i=0;i<(strArr.length-1);i++) {
			nodArr[i] = new Node(
					strArr[i+1][0],//版本号
					Integer.parseInt(strArr[i+1][1]),//类型编号  .toCharArray()[0]
					strArr[i+1][2],//名称
					strArr[i+1][3],//前置知识
					strArr[i+1][4],//后继知识
					strArr[i+1][5],//一般相关知识
					strArr[i+1][6],///详细解释
					2//热度
					);
			System.out.println(nodArr[i].getCatNumber());
		}
		System.out.println("GetNodSrr out");
		return nodArr;
	}
	//获取并拆分文件内容	返回一个文件内容而的2维数组
	public String[][] GetStrArr(String fileUrl) {
		System.out.println("GetStrArr get");
		String encoding = "UTF-8"; 
		String sign;//sign 分隔符   根据名称后缀  确定分隔符种类
		if(fileUrl.substring(fileUrl.lastIndexOf(".")).equals(".csv"))
			sign=",";
		else
			sign="\t";
		File file = new File(fileUrl);
		Long filelength = file.length();  //获取文件总长度
		byte[] filecontent = new byte[filelength.intValue()];// 创建文件长度的字节数组 
		try {  
            FileInputStream in = new FileInputStream(file);  //创建了一个新的什么东西
            in.read(filecontent);  //读取内容 到刚刚新创建的字节数组(字节数组 大概是长这个样子: [B@325b51b)
            in.close();  //关闭读取
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
		String str;
		try {
			str = new String(filecontent, encoding);
			String[] strs = str.split("\r\n");
			String[][] strArr = new String[strs.length][];
			for(int i=0 ;i<strs.length;i++) {
	             strArr[i] = strs[i].split(sign);
            }
			System.out.println("GetStrArr out");
			return strArr;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("GetStrArr out");
			return null;
		} 
	}
	
	
	/*尝试方法---------------------------*/
	//转存
	public void RedAndSaveFile(String url1,String url2) {//获取文件  MultipartFile  file
        String encoding = "UTF-8";  
        //
        File file = new File(url1); 
   
        //读
        Long filelength = file.length();  //获取文件总长度
        byte[] filecontent = new byte[filelength.intValue()];// 创建文件长度的字节数组 
        try {  
            FileInputStream in = new FileInputStream(file);  //创建了一个新的什么东西
            in.read(filecontent);  //读取内容 到刚刚新创建的字节数组
            in.close();  //关闭读取
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        
        //存
        try {
        	//创建一个读入流，如果目录内没有此文件  会自行创建
			FileOutputStream file2 = new FileOutputStream(url2,true);
			try {
				file2.write(filecontent);//写入
				file2.close();//关闭流
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	
}
