package com.fairyonline.course.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fairyonline.course.entity.Cart;
import com.fairyonline.course.entity.Category;
import com.fairyonline.course.entity.Chapters;
import com.fairyonline.course.entity.Course;
import com.fairyonline.course.entity.Coursebk;
import com.fairyonline.course.entity.FollowCourse;
import com.fairyonline.course.entity.Orders;
import com.fairyonline.course.entity.OrdersList;
import com.fairyonline.course.entity.Video;
import com.fairyonline.course.service.CourseServiceImpl;
import com.fairyonline.user.entity.User;
import com.fairyonline.user.entity.UserLogin;
import com.fairyonline.user.service.UserServiceImpl;


@Controller
@Repository
@RequestMapping("course")
public class CourseControllerImpl {
	
	@Resource
	private UserServiceImpl usi;
	@Resource
	private CourseServiceImpl csi;
	@Resource
	private SessionFactory sessionFactory;
	
	//添加
	
		@RequestMapping(value="/Add")/*方法对应地址*/
		public String Add() {/*驼峰式命名*/
			System.out.println("get add");
			Date now = null;
			
			Course course = new Course("courseName",1,now);
			csi.Add(course);
			return "Example/Example";
		}
		
		//课程查询
		@RequestMapping("/list")
		public String getList(Model model) {
			List<Course> list = this.csi.getList();
			model.addAttribute("list", list);
			System.out.println("****************");
			System.out.println(list.size());
			return "course/CurriculumSpecial";
		}
		//由ID获取课程详情
		@RequestMapping("/crousedetail")
		public String selectById(Model model,int id) {
			Course course =csi.selectById(id);	
			//List<Course> list = this.csi.getList();
			//List<Chapters> chapterlist = course.getChaptersList();
			model.addAttribute("course", course);
			Chapters chapter = csi.selectBycId(id);	
			model.addAttribute("chapter",chapter);
			return "course/list";
		}
		//观看视频
		@RequestMapping("/watching")
		public String videoview(Model model,int id) {
			Video video =csi.videoview(id);	
			//List<Course> list = this.csi.getList();
			//List<Chapters> chapterlist = course.getChaptersList();
			model.addAttribute("video", video);
//			Chapters chapter = csi.selectBycId(id);	
//			model.addAttribute("chapter",chapter);
			return "course/videoList";
		}
		//收藏课程
		@RequestMapping("/collection")
		public String collection(int id,int ID) {
			csi.collection(id, ID);
			return "course/CurriculumSpecial";
		}
		//取消收藏
		@RequestMapping("/uncollection")
		public String unCollection(int id,int uid) {
			csi.unCollection(id,uid);
			return "course/followcourse";
		}
		
		//查询收藏的课程
		@RequestMapping("/selectfc")
		public String selectfc(Model model,int id) {
//			List<FollowCourse> list = this.csi.selectfc();
//			model.addAttribute("list", list);
//			System.out.println("****************");
//			System.out.println(list.size());
			User user = usi.findUserById(id);
			model.addAttribute("user",user);
			return "course/followcourse";
		}
		
		
		
		@RequestMapping("/test")
		public String test(Model model) {
			System.out.println("test");
//			Chapters  ch=csi.selectBycId(1);
//			List<Video> videoList = ch.getVideoList();
//			for(Video v : videoList) {
//				System.out.println(v.getID()+v.getName());
//			}
			Course course =csi.selectById(1);
			System.out.println(course.getChaptersList().toString());
			model.addAttribute("course",course);
			List<Chapters> chapterlist = course.getChaptersList();
			System.out.println(chapterlist.iterator());
			for(Chapters ch : chapterlist  ) {
				System.out.println(course.getcName()+ch.getChapterNum()+ch.getChapterName());
				List<Video> videoList = ch.getVideoList();
				for(Video v : videoList) {
					System.out.println(v.getID()+v.getName());
				}
				
			}
			return "course/test";
		}
		//购物车
		@RequestMapping("/cartlist")
		public String selectAll(Model model,int id) {
//			List<Cart> list = csi.selectAll();
//			model.addAttribute("cartlist",list);
//			System.out.println(list.size());
			User user = usi.findUserById(id);
			model.addAttribute("user",user);
			return "course/shoppingCart";
		}
		@RequestMapping("/addcart")
		public String addCart(int id,int ID) {
			System.out.println(ID);
			csi.addCart(id, ID);
			return "course/CurriculumSpecial";
		}
		@RequestMapping("/carttoorders")
		public String toOrdersCourse(Model model,HttpServletRequest request) {
			System.out.println("cartcartcart");
			String[] c = request.getParameterValues("cart");
			List<Cart> list = csi.selectById(c);	
			int sum = 0;
			for(int i = 0; i < list.size(); i ++) {
				sum+= list.get(i).getCourseId().getPrice();//* list.get(i).getCount();
			}
			model.addAttribute("toorders", list);
			model.addAttribute("sum", sum);
			System.out.println("cartcartcart1");
			return "course/order";
		}
		//删除购物车列表信息
		@RequestMapping("/deletecart")
		public String deleteCrouse(int cartId,int uid) {
			System.out.println("delete");
			csi.deleteCart(cartId);
			return "redirect:cart";
		}
		//后台购物车列表
		@RequestMapping("/cartlist1")
		public String selectAll1(Model model) {
			List<Cart> list = csi.selectAll();
			model.addAttribute("cartlist",list);
			return "backstage/cartlist";
		}
		
		@RequestMapping("/usershopping")
		public String selectByUserId(Model model,int userId) {
			List<Cart> list = csi.selectByUserId(userId);
			model.addAttribute("usershopping",list);
			return "user/user_shopping";
		}	
		
		
		@RequestMapping("/addcount")
		public String addCount(int id,HttpServletRequest request) {
			User user = csi.addCount(id);
			HttpSession session = request.getSession();
			session.setAttribute("login_user",user);
			return "user/main";
		}
		
		@RequestMapping("/miscount")
		public String misCount(int id) {
			csi.misCount(id);
			return "user/user_shopping";
		}
		//订单
		/*生成订单*/
		@RequestMapping("/produceorders")
		public String produceOrders(
//				@RequestParam("i") int[] iList,
				@RequestParam(value = "i", required = false) int[] iList,
				@RequestParam("sub") String sub,
				HttpSession session,
				HttpServletRequest request ) {
			if(sub.equals("支付选中商品")) {//只支付部分商品
//				if(session.getAttribute("ItemList")!=null)
//					session.removeAttribute("ItemList");
				List<OrdersList> ItemS = new ArrayList<OrdersList>();
				List<OrdersList> ItemList  = (List<OrdersList>)session.getAttribute("ItemList");
				for(int i : iList) 
					ItemS.add(ItemList.get(i));
				session.setAttribute("ItemList", ItemS);
			}
			List<OrdersList> ItemList  = (List<OrdersList>)session.getAttribute("ItemList");
			Orders orders = new Orders(new Date(),ItemList,(User)session.getAttribute("userInfo"));
		//	orders.setPrice();//自动计算总价格
			this.csi.save(orders,session);//将建立好的orders 和session交给 service进行后续处理
			return "Shop/Orders";
		}
//		/*添加一本书*/
//		@RequestMapping("/addone")
//		public String addOne(
//				@RequestParam("i")int i ,
//				@RequestParam("bookId")int bookId,
//				HttpSession session) {
//			this.csi.addOne(bookId,i,session);
//			return "Shop/Cart";
//		}
//		/*减少一本书*/
//		@RequestMapping("/cutone")
//		public String cutOne(
//				@RequestParam("i")int i ,
//				@RequestParam("bookId")int bookId,
//				HttpSession session) {
//			this.ordersServiceImpl.cutOne(bookId,i,session);
//			return "Shop/Cart";
//		}
		/*支付*/
		@RequestMapping("/gotopay")
		public String	goToPay(HttpSession session) {
			return "Shop/payPage";
		}
		/*输入密码后的处理*/
		@RequestMapping("/havepay")
		public String	havePay(HttpSession session) {
			this.csi.havePay(session);
			return "Shop/paySuccess";
		}
		//保存订单
		
//		//往购物车中 添加商品（子订单）
//		@RequestMapping("/addItem")
//		public String addItem(@RequestParam("book") Book book,
//				HttpServletRequest request) {
//			HttpSession session = request.getSession();
//			UserInfo userInfo = (UserInfo)session.getAttribute("UserInfo");
//			return "";
//		}
	
		//提交订单
		
		
		//审核课程列表
		@RequestMapping("/auditlist")
		public String AuditCourseList(Model model) {
			System.out.println("select success");
			List<Coursebk> list = this.csi.getcbkList();
			model.addAttribute("list", list);
			System.out.println("select success");
			return "course-bk/AuditCourse";
		}
		//审查课程详情
		@RequestMapping("/AuditCoursedetail")
		public String selectAuditCourse(Model model,int id) {
			Coursebk coursebk =csi.selectBycbkId(id);	
			//List<Course> list = this.csi.getList();
			//List<Chapters> chapterlist = course.getChaptersList();
			model.addAttribute("coursebk", coursebk);
			return "course-bk/ReportDetails";
		}
		//课程分类列表
		@RequestMapping("/categorylist")
		public String selectcategoryList1(Model model) {
			System.out.println("get collu");
			List<Category> list = this.csi.getcList();
			model.addAttribute("list", list);
			System.out.println("out collu");
			return "course-bk/ClassesList";
		}
		@RequestMapping("/categorylist1")
		public String selectcategoryList2(Model model) {
			System.out.println("get collu");
			List<Category> list = this.csi.getcList();
			model.addAttribute("list", list);
			System.out.println("o");
			return "course-bk/ApplicationClass";
		}
		//课程分类详情
		@RequestMapping("/classesdetail")
		public String classesDetail(Model model,int id) {
			Category category =csi.classesDetail(id);	
     		model.addAttribute("category", category);
			return "course-bk/ClassesListDetail";
		}
		//添加分类
		@RequestMapping("addcategory")
		public String addcategory(Model model,HttpServletRequest request, HttpServletResponse response){
			String name=request.getParameter("username");
			Date now = new Date();
		      Calendar cal = Calendar.getInstance();     
		      DateFormat d1 = DateFormat.getDateInstance(); 
		      String str1 = d1.format(now);
		      DateFormat d2 = DateFormat.getDateTimeInstance();
		      String str2 = d2.format(now);
		      DateFormat d3 = DateFormat.getTimeInstance();
		      String str3 = d3.format(now);
		      DateFormat d4 = DateFormat.getInstance(); //使用SHORT风格显示日期和时间
		      String str4 = d4.format(now);
		      DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，时间（精确到秒）
		      String str5 = d5.format(now);
		      DateFormat d6 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期。时间（精确到秒）
		      String str6 = d6.format(now);
		      DateFormat d7 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); //显示日期，时间（精确到分）
		      String str7 = d7.format(now);
		      DateFormat d8 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //显示日期，时间（精确到分）
		      String str8 = d8.format(now);//与SHORT风格相比，这种方式最好用
//		    HttpSession session=request.getSession();
//		    String user_name=(String)session.gerAttribute("user");
		    String adminId = "admin";  
		    String introduce =request.getParameter("introduce");
		    boolean c = csi.addcategory(name, now, adminId, introduce);
		      return "course-bk/AddClass";	
		} 
		
		//删除分类
		@RequestMapping("/deleteCategory")
		public String deleteCategory(int categoryId,Model model) {
			System.out.println("delete");
			csi.deleteCategory(categoryId);
			
			return this.selectcategoryList1(model);
		}
		public CourseServiceImpl getCartServiceImpl() {
			return csi;
		}

		public void setCartServiceImpl(CourseServiceImpl csi) {
			this.csi =csi;
		}		
		
//		@RequestMapping("/buyCourse")
//		public String buyCourse(int id,HttpServletRequest request, HttpServletResponse response) {
//			
//			Course course =csi.selectById(id);
//			Cart cart = (Cart)request.getAttribute("cart");
//			if(cart==null){
//		        cart = new Cart();
//			    request.getSession().setAttribute("cart",cart);
//			}
//			csi.buyCourse(id, cart);
//			return "";
//		}
//		@RequestMapping("/cleraCart")
//	    public String cleraCart(HttpServletRequest request, HttpServletResponse response) {
//			Cart cart = (Cart) request.getSession().getAttribute("cart");
//			System.out.println("cartsize"+cart);
//			csi.clearCart(cart);
//			System.out.println("cartsize:"+cart);
//			return "";
//		}
//		@RequestMapping("/deleteCourse")
//	    public String deleteCourse(HttpServletRequest request, HttpServletResponse response,int id,String CName) {
//			Course course =csi.selectById(id);
//			Cart cart = (Cart) request.getSession().getAttribute("cart");
//		    csi.deleteCartItem(cart, CName);
//			return "";
//		}
//		@RequestMapping("/updateCart")
//	    public String updateCart(HttpServletRequest request, HttpServletResponse response) {
//		
//			 String CName = request.getParameter("CName");
//			 String quantity = request.getParameter("quantity");
//			 Cart cart = (Cart) request.getSession().getAttribute("cart");
//			 csi.updateCart(cart, CName, quantity);
//			return "";
//		}
		//课程模糊查询
//		@RequestMapping("/list")
//		public String getCourseByPartName(Model model,String courseName) {
//			Course list = this.csi.getCourseByPartName(courseName);
//			model.addAttribute("list", list);
//			System.out.println(list.);
//			return "";
//		}
	    
		
		

}
