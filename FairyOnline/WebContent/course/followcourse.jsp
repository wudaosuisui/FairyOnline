<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的收藏</title>
    <link rel="stylesheet" type="text/css" href="../css/css1.css">
    <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
    <link rel="stylesheet" type="text/css" href="../css/followcourse.css">
   <!--  <link rel="stylesheet" type="text/css" href="../css/moukecheng.css"> -->
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
	         <h1>我的课程收藏：</h1>
	         <div id="specific">
            <div id="bord">
         
                <c:forEach var="l" items="${userLogin2.user.fcSet}">
                <div class="lessen">
	        			<div class="lepic">
							<a href="#">
								<img src="../images/lepic.jpg">
							</a>
						</div>
						<div class="line6"><a href="crousedetail.do?id=${l.fcid.ID }">${l.fcid.CName } </a></div>
						<div class="line6">
							<a href="#">${l.fcid.categoryID.categoryName}</a>
							<a href="${ctx }/course/addcart.do?id=${userLogin2.user.id }&&ID=${l.fcid.ID}">加入购物车</a>
							<a href="">取消收藏</a>
						</div>
						<div class="line6"><a href="#">价格</a></div>
	        	</div>
	        	</c:forEach>
          
            </div>
        
        	
        </div>
	       
	    	
	    </div>
	    <div id="foot">
	    	
	    </div>

</body>
</html>