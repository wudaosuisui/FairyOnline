<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE>
<html>
    <head>
	<title>个人主页</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="../css/css1.css">
    <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
    <link rel="stylesheet" type="text/css" href="../css/homePage.css"> 


     </head>
     <body>
     	<div id="head1">
    		<div id="head-line">
    			<div id="logo">
			    <img src="../images/logo.jpeg" height="60px">
		        </div>
		        <div id="found">
			      <form action="${ctx}/user/searchUser">
				     <input type="text" name="found" height="20px" width="100px" placeholder="搜索框"/>
				     <button >搜索</button>
			      </form>
		        </div>
		        
		         <div id="shop">
		          <button id="button1"><a href="shoppingCart.html">购物车</a></button>
		          <img src="../images/a1.png" height="30px">
		          <a href="${ctx}/user/personal?id=${userLogin2.user.id}" ><img  id="img1" name="img1" src="${ctx}/images/userImages/${userLogin2.user.img}">
                  </a>
		         </div>
    		 </div>

    		 <div id="head-text">
    		     <div>
    		      	<img  id="img" src="${ctx}/images/userImages/${user.user.img}">
    		     </div>
    		     <p><a href="${ctx}/user/followUser?id=${user.user.id}">关注</a>|<a href="${ctx}/user/followUser1?">粉丝</p>
    		  </div> 

    	    </div>
    	</div>


    	<div id="body">
    	    <div id="body1">
    		<button><a href="">收藏的课程</a></button>
    		<button><a href="">学习的课程</a></button>
    		<button><a href="">购物车</a></button>
    		<button><a href="">教师（申请）</a></button>
    		<button><a href="">教师（主页）</a></button>
    		<a href="${ctx}/user/addFollowUser?id=${user.user.id}"><button>关注</button></a>
    		</div>
    		
    		  <c:forEach items="${list}" var="teacher">
    		  <c:forEach items="${teacher.getCourseList()}" var="course">
    		     <div id="body2">
    		     <div id="body2-img">
    		     <img src="../images/5.png">
    		     </div>
    		      <div id="body2-text">
                
                <p>${course.CName}</p>
                <p>${course.categoryID.categoryName}&nbsp;&nbsp;&nbsp;讲师：<a href="${ctx}/user/teacHomePage?Name=${teacher.name}">${teacher.name}</a>&nbsp;&nbsp;&nbsp;&nbsp;等级&nbsp;&nbsp;&nbsp;观看人数</p>
                <p>课程简介：简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容</p>
                </div>
                </div>
    		    </c:forEach>
             </c:forEach>
			<!--  
    		<div id="body2">
    		    
    		    <div id="body2-img">
                <img src="../images/5.png">
                </div>

                <div id="body2-text">
                <p>课程名称</p>
                <p>种类&nbsp;&nbsp;&nbsp;讲师：讲师姓名&nbsp;&nbsp;&nbsp;&nbsp;等级&nbsp;&nbsp;&nbsp;观看人数</p>
                <p>课程简介：简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容</p>
                </div>
    		</div>

    		<div id="body2">
    		    
    		    <div id="body2-img">
                <img src="../images/5.png">
                </div>

                <div id="body2-text">
                <p>课程名称</p>
                <p>种类&nbsp;&nbsp;&nbsp;讲师：讲师姓名&nbsp;&nbsp;&nbsp;&nbsp;等级&nbsp;&nbsp;&nbsp;观看人数</p>
                <p>课程简介：简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容</p>
                </div>
    		</div>
    		<div id="body2">
    		    
    		    <div id="body2-img">
                <img src="../images/5.png">
                </div>

                <div id="body2-text">
                <p>课程名称</p>
                <p>种类&nbsp;&nbsp;&nbsp;讲师：讲师姓名&nbsp;&nbsp;&nbsp;&nbsp;等级&nbsp;&nbsp;&nbsp;观看人数</p>
                <p>课程简介：简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容简介内容</p>
                </div>
    		</div>
    		 -->

    	</div>
     </body>
</html>