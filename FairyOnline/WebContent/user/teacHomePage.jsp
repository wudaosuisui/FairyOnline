<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE>
<html>
    <head>
	<title>教师主页</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="../css/css1.css">
    <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
    <link rel="stylesheet" type="text/css" href="../css/homePage.css"> 
    <link rel="stylesheet" type="text/css" href="../css/teacHomePage.css"> 

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
    		     <div id="img">
    		     </div>
    		     <p>关注|粉丝</p>
    		  </div> 

    	    </div>
    	</div>


    	<div id="body">
    	    <div id="body1">
    		<button><a href="">已发布课程</a></button>
    		<button><a href="">待审核课程</a></button>
    		<button><a href="">上传</a></button>
    		<button><a href="">资料管理</a></button>
    		<button><a href="">举报</a></button>
    		</div>

    		
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
    		   
                
    		
    		

    	</div>
     </body>
</html>