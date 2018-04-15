package com.fairyonline.xiaoye.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
 
import com.fairyonline.xiaoye.entity.Fileses;

@Controller
@Repository	
@RequestMapping("/File")
public class FileseController {
//	@Resource
//	private Fileses file;
	
	//读取文件内容
	@RequestMapping("/redFile")
	public String RedFile() {//获取文件  MultipartFile  file
	        String encoding = "UTF-8";  
	        File file = new File("F:\\Documents\\File\\coqytest.txt");  
	        Long filelength = file.length();  
	        System.out.println("file length : " + file.length());
	        byte[] filecontent = new byte[filelength.intValue()];  
	        try {  
	            FileInputStream in = new FileInputStream(file);  
	            in.read(filecontent);  
	            in.close();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        try {  
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
		System.out.println("textarea  ："+textarea);
		//声明流对象 
		FileOutputStream file = null; 
		try {
			//创建流对象 并选择“追加”方式   写入内容
			file = new FileOutputStream("F:\\Documents\\File\\coqytest.txt",true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//依次转换成字节
		byte[] b1 = textarea.getBytes();
		byte[] b2 = "\r\n".getBytes(); 
		try {
			//依次写入
			file.write(b1);
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
