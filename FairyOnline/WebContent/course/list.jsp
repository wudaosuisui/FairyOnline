<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频详情页面</title>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="../css/css1.css">
        <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
	    <link rel="stylesheet" type="text/css" href="../css/list.css">
</head>
<body>
     <!--导航栏-->
	    <div id="head1">
	       <div id="head-line">
	    	<div id="logo">
			<img src="../images/logo.jpeg" height="60px">
			<img src="../images/logo2.jpeg" height="40px">
		    </div>
		    <div id="found">
			    <form action="post" method="1.html">
				     <input type="text" name="found" height="20px" width="100px" placeholder="搜索框"/>
				     <button >搜索</button>
			      </form>
		    </div>
		    <div id="shop">
		          <button id="button1"><a href="shoppingCart.html">购物车</a></button>
		          <img src="../images/a1.png" height="30px">
		         <div id="img1">
                     
                   </div>
		         </div>
		   </div>
	    </div>
	    <!--主体内容-->
	    <div id="content">
	       <!--主体上半部-->
	       <div id="context_up">
	       	<p>课程&nbsp&nbsp&nbsp后端\大数据\java\</p></br>
	       	<h1>${course.CName}</h1>
	       	<div id="context_up_study">
	       		<p class="s1"><a href="videoList.html">开始学习|</a></p>
	       		<p class="s2">学习人数&nbsp|&nbsp难度级别&nbsp|&nbsp课程时长&nbsp|&nbsp综合评分</p>
	       		<p class="s3">9986&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp初级&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp3.5小时&nbsp&nbsp&nbsp&nbsp|&nbsp&nbsp&nbsp&nbsp9.8</p>
	       	</div>
	       </div>
	       <!--主体下半部-->
	       <div id="context_lower">
	           <div id="l0">
	           	   <h2>课程目录：</h2>
	           </div>
	         
	       	   <div id="l1">
	       	        <c:forEach items="${list}" var="l1">  
	       	        ${fn:length(list)}
	       	   	    <h3>${l1.ID } &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp章节名字</h3>
	       	   	          <c:forEach items="${list}" var="l">  
	       	   	              <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第一节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   	           </c:forEach>
	       	   	    </c:forEach>
	       	   </div>
	       	  <!--  <div id="l2">
	       	        <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第二节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   	    <h3>第二章&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp章节名字</h3>
	       	   	    <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第一节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   	    <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第二节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   	    <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第三节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   	    <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第四节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   </div>
	       	   <div id="l3">
	       	   	    <h3>第三章&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp章节名字</h3>
	       	   	    <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第一节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   	    <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第二节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   	    <p><a href="videoList.html">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp第三节&nbsp&nbsp&nbsp课程名字&nbsp&nbsp（课程时间）</a></p>
	       	   </div> -->
	       </div>
	    	
	    </div>
	    <div id="foot">
	    	
	    </div>
    

</body>
</html>