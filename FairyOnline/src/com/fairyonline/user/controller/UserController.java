package com.fairyonline.user.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fairyonline.course.entity.Course;
import com.fairyonline.course.entity.Video;
import com.fairyonline.teacher.entity.Teacher;
import com.fairyonline.user.entity.RCourse;
import com.fairyonline.user.entity.RUser;
import com.fairyonline.user.entity.User;
import com.fairyonline.user.entity.UserLogin;

import com.fairyonline.user.service.UserServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;




@Controller
@RequestMapping("user")
public class UserController {
	/*
	    private static List<UserLogin> userLoginList;
		
		public UserController() {
			super();
			userLoginList = new ArrayList<UserLogin>();
		}
	*/
		
		@Resource
		private UserServiceImpl userServiceImpl;
		
		/*@RequestMapping("/userList1")
		public String list(Model model) {
			List<User> list = this.userServiceImpl.listAll();
			User user1 = list.get(0);
			user1.setFollowUserList(list);
			userServiceImpl.updateUser(user1);
			model.addAttribute("list",list);
			return "user/userList1"; 
		}*/
		
		@RequestMapping("/regist1")
		public String regist(String userName)throws IOException{
			List<UserLogin> list = this.userServiceImpl.allUserLogin();
			System.out.println(userName);
			boolean flag = true;
			if(userName != null) {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getUserName().equals(userName)) {
					flag=false;
					break;
				}
			}
			}else {
				flag=false;
			}
			System.out.println(flag);
			ObjectMapper x = new ObjectMapper();
			String isExist = x.writeValueAsString(flag);
			return isExist;
		}
		
		@RequestMapping("/regist")
		public String userRegist(HttpServletRequest request, HttpServletResponse response){
			
			String userName = request.getParameter("UserName");
			String passWord = request.getParameter("PassWord");
//			List<UserLogin> list = this.userServiceImpl.allUserLogin();
			UserLogin userLogin = new UserLogin();
			userLogin.setUserName(userName);
			userLogin.setPassWord(passWord);
//			list.add(userLogin);
			System.out.println("user name : " +userLogin.getUserName()+"  user password :  "+userLogin.getPassWord() );
			
			this.userServiceImpl.addUserLogin(userLogin);
			return "user/personal";
			
			
		} 
		
		@RequestMapping("/login")
		public String userLogin(Model model,HttpServletRequest request,HttpServletResponse response)throws IOException{
			UserLogin userLogin2 = new UserLogin();
			String userName2;
			HttpSession session = request.getSession();
//<<<<<<< HEAD
//			//session.setMaxInactiveInterval(3600);//服务器端的3600秒
//=======
			session.setMaxInactiveInterval(3600);//服务器端的3600秒
//>>>>>>> refs/remotes/origin/sy
			if(session.getAttribute("userLogin")!=null) {
				session.removeAttribute("userLogin");
			}
			if(session.getAttribute("userLogin")==null) {
				String userName = request.getParameter("UserName");
				String passWord = request.getParameter("PassWord");
				UserLogin userLogin = this.userServiceImpl.login(userName,passWord);
				userLogin2 = userLogin;
				userName2 = userName;
			}else {
				String userName=(String)session.getAttribute("userLogin");
				UserLogin userLogin = this.userServiceImpl.findUserLogin(userName);
				userLogin2 = userLogin;
				userName2 = userName;
			}
			if(userLogin2!=null) {
				session.setAttribute("userLogin",userName2);
				session.setAttribute("userLogin2",userLogin2);
				model.addAttribute("admin",userName2);
				System.out.println("login执行成功");
				return "user/index";
			}else {
				model.addAttribute("errormsg","用户名或密码错误");
				return "user/login";
			}
			
		}
		
		//完善个人信息
		@RequestMapping(value="/updateitem",method= {RequestMethod.POST,RequestMethod.GET})
		public String updateItems(MultipartFile picture, String UserName,HttpServletRequest request,HttpServletResponse response) throws Exception {
			String userName = request.getParameter("UserName");
			List<UserLogin> list = this.userServiceImpl.allUserLogin();
			if(userName != null) {
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getUserName().equals(userName)) {
					String petName = request.getParameter("PetName");
					String sex = request.getParameter("Sex");
					String img = request.getParameter("Img");
					String tName = request.getParameter("TName");
					UserLogin userLogin = this.userServiceImpl.findUserLogin(userName);
					List<User> list1 = this.userServiceImpl.listAll();
					
					User user = new User();
					user.setPetName(petName);
					//user.setImg(img);
					user.setSex(sex);
					user.settName(tName);
					user.setUserLogin(userLogin);
					
					
					/*
					// 处理上传的单个图片    
				    String originalFileName = picture.getOriginalFilename();// 原始名称
				    // 上传图片
				    if (picture != null && originalFileName != null && originalFileName.length() > 0) {
				    	 System.out.println("get add imgs  success");
				    	// String pic_path = "E:\\temp\\images\\";
				    	 String pic_path = "fairyonline\\user\\images\\";
				    	 String newFileName = UUID.randomUUID()
				                 + originalFileName.substring(originalFileName
				                         .lastIndexOf("."));     
				         File newFile = new File(pic_path + newFileName);//新图片
				         picture.transferTo(newFile);// 将内存中的数据写入磁盘
				         user.setImg(newFileName);// 将新图片名称写到itemsCustom中
				    }else {
				    	System.out.println("else  success");
				    	//如果用户没有选择图片就上传了，还用原来的图片
				       // User user = this.userServiceImpl.findUserById(user.getID());
				       // user.setImg(user.getImg());
				    }
				    */
					
					if(picture != null) {
						String name = picture.getName();
						System.out.println(name);
						String originalFileName = picture.getOriginalFilename();
						System.out.println(originalFileName);
						String pictureName = originalFileName.substring(originalFileName.lastIndexOf("\\")+1);
						byte[] bytes = picture.getBytes();
						String realPath = request.getServletContext().getRealPath("/upload");
						File f = new File(realPath);
						FileOutputStream fo = new FileOutputStream(f);
						fo.write(bytes);
						fo.flush();
						fo.close();
						String imgurl = originalFileName;
						user.setImg(originalFileName);
					} 
					
					list1.add(user);
					this.userServiceImpl.addUser(user); 
				}
			  }
			
			   
		   }
			 return "user/index";
		}
      
		//检索用户
		@RequestMapping("/searchUser")
		public String userlist(Model model,String userName,HttpServletRequest request,HttpServletResponse response){
			userName = request.getParameter("found");
			List<UserLogin> list = this.userServiceImpl.getUserByPartName(userName);
		    model.addAttribute("list",list);
			return "user/searchUserResult";
		}  
		
		//用户主页
		@RequestMapping("/homePage")
		public String userlist1(Model model,String userName) {
			UserLogin user = this.userServiceImpl.findUser(userName);
			List<Teacher> list = user.getUser().getTeacherList();
			for(Teacher teacher : list) {
				System.out.println("teacher id ； "+teacher.getName());
			  /* for(Course course : teacher.getCourseList()) {
			    	System.out.println("course id ； "+course.getID()+"course name : "+course.getCName());
			    	model.addAttribute("list1",teacher.getCourseList());
			    } */
			}
			model.addAttribute("list",list);
			if(user != null) {
				model.addAttribute("user",user);
				return "user/homePage";
			}else {
				System.out.println("失败");
				return "user/index";
			}
		}
		
		//关注
		@RequestMapping("/addFollowUser")
		@ResponseBody
		public boolean addFollowUser(Model model,int id1,int id2) {
			//通过ID1  获取第一个 user1
			User user1 = userServiceImpl.findUserById(id1);
			//通过id2  获取第二个user2
			User user2 = userServiceImpl.findUserById(id2);
			//将user2 加入到 user1的关注列表（FollowUserList）
			List<User> list = user1.getFollowUserList();
			Boolean fow = true;
			for(User use : list) {
				if(use.getId() != user2.getId()) {
					fow = false;
				}
			}
			if(fow) {
				list.add(user2);
				user1.setFollowUserList(list);
				// user.getFollowUserList.add(user2)
				//更新user1
				userServiceImpl.updateUser(user1);
			}
			return true; 
		}
		
		//取消关注
		@RequestMapping("/deleteFollowUser")
		@ResponseBody
		public boolean deleteFollowUser(Model model,int id1,int id2) {
			//通过ID1  获取第一个 user1
			User user1 = userServiceImpl.findUserById(id1);
			//通过id2  获取第二个user2
			User user2 = userServiceImpl.findUserById(id2);
			List<User> list = user1.getFollowUserList();
			Boolean fow = true;
			for(User use : list) {
				if(use.getId() != user2.getId()) {
					fow = false;
				}
			}
			if(fow) {
				list.remove(user2);
				user1.setFollowUserList(list);
				// user.getFollowUserList.add(user2)
				//更新user1
				userServiceImpl.updateUser(user1);
			}
			return true;
		}
		//关注列表
		@RequestMapping("/followUser")
		public String followUser(Model model,int id) {
			User user = this.userServiceImpl.findUserById(id);
			for(User use : user.getFollowUserList()) {
				System.out.println("user id ； "+use.getId()+"user name : "+use.getUserLogin().getUserName());
			}
 			List<User> list = user.getFollowUserList();
			model.addAttribute("list",list);
			return "user/followUser";
		} 
		
		//教师主页
		@RequestMapping("/teacHomePage")
		public String teacherList(Model model,String Name) {
			Teacher teacher = this.userServiceImpl.findTeacher(Name);
			if(teacher != null) {
			model.addAttribute("teacher",teacher);
			return "user/teacHomePage";
			}else {
				System.out.println("失败");
				return "user/index";
			}
		}
		
		//举报用户
		@RequestMapping("/reportUser")
		public String reportUser(Model model,int id) {
			User reportUser = this.userServiceImpl.findUserById(id);
			model.addAttribute("reportUser",reportUser);
			return "user/report";
		}
		
		@RequestMapping("/report")
		public String report(HttpServletRequest request,HttpServletResponse response,Model model,int id1,int id2) {
			String reportReason = request.getParameter("reportReason");
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
			String str = df.format(now);
			User reportUser1 = this.userServiceImpl.findUserById(id1);
			User reportUser2 = this.userServiceImpl.findUserById(id2);
			List<RUser> reportList = this.userServiceImpl.listAllRUser();	
			RUser ruser = new RUser();
		    ruser.setReason(reportReason);
		    ruser.setDate(str); 
			ruser.setRid(reportUser2);
			ruser.setUid(reportUser1);
			reportList.add(ruser);
			this.userServiceImpl.addRUser(ruser); 
			return "user/index";
		}
		
		//举报视频
		@RequestMapping("/reportVideo")
		public String reportVideo(Model model,int id) {
			Video reportVideo = this.userServiceImpl.findVideoById(id);
			model.addAttribute("reportVideo",reportVideo);
			return "user/videoReport";
		}
		
		@RequestMapping("/report1")
		public String report1(HttpServletRequest request,HttpServletResponse response,Model model,int id1,int id2) {
			String reportReason = request.getParameter("reportReason");
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
			String str = df.format(now);
			User reportUser = this.userServiceImpl.findUserById(id1);
			Video reportVideo = this.userServiceImpl.findVideoById(id2);
			List<RCourse> reportList = this.userServiceImpl.listAllRCourse();
			RCourse rcourse = new RCourse();
			rcourse.setReason(reportReason);
			rcourse.setDate(str);
			rcourse.setUid(reportUser);
			rcourse.setRid(reportVideo);
			reportList.add(rcourse);
			this.userServiceImpl.addRCourse(rcourse); 
			return "user/index";
		}
		
		@RequestMapping("/reportList")
		public String reportList(Model model) {
			List<RUser> reportList = this.userServiceImpl.listAllRUser();
			model.addAttribute("a",reportList);
			return "user/userList1";
		}
}
