<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精灵课堂订单页面</title>
		<link rel="stylesheet" type="text/css" href="../css/css1.css">
        <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
	    <link rel="stylesheet" type="text/css" href="../css/order.css">
</head>
<body>
 <!--导航栏-->
		<div id="head1">
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
		 <!--主体-->
		<div id="content">
		    <div id="page">
		    	<form action="../course/produceorders">
		    	<input type="hidden" name="uid" value="${userLogin2.user.id }">
		    	    <div id="o1">
		    	     	<h2>订单号：</h2>
		    	        <p>*********************</p>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		    	        <span><a href="../course/cartlist">返回</a></span><!-- 返回到购物车界面 -->
		    	    </div>
		    	    <div id="o2">
		    	        <table>
		    	    	    <tr>
		    	    		    <th>课程名</th>
		    	    		    <th>价格</th>
		    	    	    </tr>
		    	         <c:forEach var="o" items="${toorders }">
		    	               <tr>
		    	               	<input type="hidden" name="cid" value="${o.cartId }">
		    	    	     	<td style="vertical-align:middle; text-align:center;">${o.courseId.cName }</td>
		    	    	    	<td style="vertical-align:middle; text-align:center;">${o.courseId.price }元</td>
		    	    	    </tr>
		    	         
		    	         </c:forEach>
		    	        </table>
		    	    </div>	
		    	    <div id="sum">
		    	    	<h2>合计：${sum }元</h2>
		    	    </div>
		    	    <div id="submit">
		    	    	<input name="sub" type="button" value="取消订单"/>
		    	    	<input name="sub" type="submit" value="提交订单"/>
		    	    </div>
		    	</form>
		    </div>
			
		</div>
		 <!--底部-->
		<div id="foot"></div>

</body>
</html>

<!--  	    <tr>
		    	    		    <td style="vertical-align:middle; text-align:center;">课程一</td>
		    	    		    <td style="vertical-align:middle; text-align:center;">**元</td>
		    	    	    </tr>
		    	    	    <tr>
		    	    	     	<td style="vertical-align:middle; text-align:center;">课程一</td>
		    	    	    	<td style="vertical-align:middle; text-align:center;">**元</td>
		    	    	    </tr>
		    	    	    <tr>
		    	    	    	<td style="vertical-align:middle; text-align:center;">课程一</td>
		    	    	    	<td style="vertical-align:middle; text-align:center;">**元</td>
		    	    	    </tr>
		    	    	    <tr>
		    	    	    	<td style="vertical-align:middle; text-align:center;">课程一</td>
		    	    	    	<td style="vertical-align:middle; text-align:center;">**元</td>
		    	    	    </tr> -->