package com.fairyonline.teacher.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fairyonline.teacher.entity.Video;
import com.fairyonline.teacher.entity.Office;
@Controller  
@RequestMapping("/office")
public class OfficeController {
		@Resource
		private SessionFactory sessionFactory;
		 @RequestMapping("/add")  
		    public String oneFileUpload(  
		            @RequestParam("file") MultipartFile files[],  
		            HttpServletRequest request, ModelMap model) throws org.bytedeco.javacv.FrameGrabber.Exception, IOException {  
		  
			 List<Office> list = new ArrayList<Office>();
			 List<String> list1 = new ArrayList<String>();
			    // 获得项目的路径  
			    ServletContext sc = request.getSession().getServletContext();  
			    // 上传位置  
			    String path = sc.getRealPath("/img") + "/"; // 设定文件保存的目录  
			    File f = new File(path);  
			    if (!f.exists())  
			        f.mkdirs();  
			  
			    for (int i = 0; i < files.length; i++) {  
			        // 获得原始文件名  
			        String fileName = files[i].getOriginalFilename();
			        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			        System.out.println("原始文件名:" + fileName);  
			        // 新文件名  
			        String newFileName = UUID.randomUUID() + fileName;
			        list1.add(path + newFileName);
			        officetoPDF op= new officetoPDF();
			        if(suffix=="doc"||suffix=="docx") {
			        	op.wordToPDF(files[i],path+newFileName );
			        }
			        if(suffix=="xls"||suffix=="xlsx") {
			        	op.excel2pdf(files[i],path+newFileName );
			        }
			        if(suffix=="ppt"||suffix=="pptx") {
			        	op.ppt2pdf(files[i],path+newFileName );
			        }
			        PdfToJpg pj=new PdfToJpg();
			        pj.changePdfToImg(path+newFileName, path);
			        try {
			            File fil = new File(path+newFileName);  
			            if (fil.delete()) {  
			              System.out.println(fil.getName() + " is deleted");  
			            } else {  
			              System.out.println("Delete failed.");  
			            }  
			          } catch (Exception e) {  
			            System.out.println("Exception occured");  
			            e.printStackTrace();  
			          }
			        System.out.println("上传图片到:" + path + newFileName);  
			        Office fi=(Office)files[i];
			        fi.setname(fileName);
			        fi.setURL(path+newFileName);
					Session s=this.sessionFactory.openSession();
					Transaction t=s.beginTransaction();
					s.save(fi);
					t.commit();
					s.close();
			        list.add(fi);  
			    }  
			 // 保存文件地址，用于JSP页面回显  
			    model.addAttribute("officeList", list);
			    model.addAttribute("jpgList", list1);  
			    return "Upload";   
		    }
		 @RequestMapping(value = "/drop", method = RequestMethod.POST)  
		 public String drop(Model model,
					HttpServletRequest request,
					@RequestParam("ID")String ID){ 
				Query c=this.sessionFactory.getCurrentSession().createQuery("from file where id=?");
				c.setParameter(0,ID);
				Office office = (Office)c.uniqueResult();
				String URL=office.getURL();
		        File targetFile = new File(URL);  
		        if (targetFile.exists()) {  
		            targetFile.delete();
		        }
		        Session s=this.sessionFactory.openSession();
				Transaction t=s.beginTransaction();
				Query u=this.sessionFactory.getCurrentSession().createQuery("delete from file where id=?");
				u.setParameter(0,ID);
				int ret = u.executeUpdate();
				t.commit();
				s.close();
		        return "Upload";  
		    }  
	}


