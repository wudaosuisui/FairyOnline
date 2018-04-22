package com.fairyonline.xiaoye.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
 
import com.fairyonline.xiaoye.entity.Fileses;
import com.fairyonline.xiaoye.entity.Vertex;


public class FileseController {
	

	//读取并分片
	@RequestMapping("/raSliceFile")
	public String RedAndSliceFile() {//Slice 分片
	        String encoding = "UTF-8";  
	        //
	        File file = new File("F:\\Documents\\File\\coqytest3.txt"); 
	        //可以读取.xls
//	        File file = new File("F:\\Documents\\File\\coqytest3.xls"); 
	        
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
	        try {  
	        	//以encoding(utf-8)的格式，将filecontent的内容 存到 str中
	             String str = new String(filecontent, encoding); 
	             String[] strs = str.split("\r\n");
	             String[][] ses = new String[strs.length][];
	             for(int i=0 ;i<strs.length;i++) {
		             ses[i] = strs[i].split("\t");
	             }
	             
	             //print
	             for(int i =0;i<ses.length;i++) {
	            	 for(int b =0;b<ses[i].length;b++) 
		            	 System.out.println(ses[i][b]+"----\\t");
	            	 System.out.println("-------------------");
	             }
	        } catch (UnsupportedEncodingException e) {  
	            System.err.println("The OS does not support " + encoding);  
	            e.printStackTrace();  
	            return null;  
	        }  
		return "Xiaoye/Test";
	}
	//读取并转存到另一个新文件
	@RequestMapping("/rasFile")
	public String RedAndSaveFile() {//获取文件  MultipartFile  file
	        String encoding = "UTF-8";  
	        //
	        File file = new File("F:\\Documents\\File\\coqytest3.txt"); 
//	        File file2 = new File("F:\\Documents\\File\\coqytest2.txt"); //无需在此创建新文件
	        
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
				FileOutputStream file2 = new FileOutputStream("F:\\Documents\\File\\coqytest3.xls",true);
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
		return "Xiaoye/Test";
	}
	
	//读取文件内容
	@RequestMapping("/redFile")
	public String RedFile() {//获取文件  MultipartFile  file
	        String encoding = "UTF-8";  
	        //
//	        File file = new File("F:\\Documents\\File\\coqytest.txt"); 
	        //可以读取.xls
	        File file = new File("F:\\Documents\\File\\coqytest3.xls"); 
	        
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
	        try {  
	        	//以encoding(utf-8)的格式，将filecontent的内容 存到 str中
	             String str = new String(filecontent, encoding);  
	             System.out.println(str);
	        } catch (UnsupportedEncodingException e) {  
	            System.err.println("The OS does not support " + encoding);  
	            e.printStackTrace();  
	            return null;  
	        }  
	       
		return "Xiaoye/Test";
	}
	
	//向文件内写入内容
	@RequestMapping("/writeFile")
	public String WriteFile(@RequestParam String textarea) {
		System.out.println("get ReadFile controller");
		//声明流对象 
		FileOutputStream file = null; 
		try {
			//创建流对象 并选择“追加”方式   写入内容
//			file = new FileOutputStream("F:\\Documents\\File\\coqytest3.txt",true);
			//可创建.xls文件
			file = new FileOutputStream("F:\\Documents\\File\\coqytest3.xls",true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//依次转换成字节
//		byte[] b1 = textarea.getBytes();
		byte[] b2 = "\r\n".getBytes(); 
		byte[] b3 = "\r".getBytes();
		byte[] b4 = "line".getBytes();
		byte[] b5 = "\t".getBytes();
		try {
			//依次写入
			file.write(b4);//1
			file.write(b2);
			file.write(b4);//2
			file.write(b2);
			file.write(b4);//3
			file.write(b5);
			file.write(b4);//4
			file.write(b5);
			file.write(b4);//5
			file.write(b5);
			file.write(b4);//6
			file.write(b2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//关闭流
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Xiaoye/Test";
	}	
	
//	原代码
//	@RequestMapping("/writeFile")
//	public String WriteFile(@RequestParam String textarea) {
//		System.out.println("get ReadFile controller");
//		System.out.println("textarea  ："+textarea);
//		//声明流对象 
//		FileOutputStream file = null; 
//		try {
//			//创建流对象 并选择“追加”方式   写入内容
//			file = new FileOutputStream("F:\\Documents\\File\\coqytest.txt",true);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		//依次转换成字节
//		byte[] b1 = textarea.getBytes();
//		byte[] b2 = "\r\n".getBytes(); 
//		try {
//			//依次写入
//			file.write(b1);
//			file.write(b2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			//关闭流
//			file.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "Xiaoye/Test";
//	}
	//获取文件并保存
	@RequestMapping("/saveFile")
	public String SaveFile(MultipartFile  file) {
		File newFile = new File("F:\\Documents\\File\\"+ "coqytest.txt");//创建文件 
        try {
			file.transferTo(newFile);//将页面传入的文件，保存到刚刚创建的文件
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 将内存中的数据写入磁盘
		return "Xiaoye/Test";
	}
	

}
