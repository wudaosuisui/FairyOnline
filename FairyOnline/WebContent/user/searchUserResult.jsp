<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE>
<html>
    <head>
	<title>搜索用户结果</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="../css/css1.css">
    <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
    <link rel="stylesheet" type="text/css" href="../css/searchResult.css"> 
    <link rel="stylesheet" type="text/css" href="../css/searchUserResult.css"> 

     </head>
   <body>
         <div id="head1">
    		<div id="head-line">
    			<div id="logo">
			    <img src="images/logo.jpeg" height="60px">
		        </div>
		        <div id="found">
			      <form action="post" method="1.html">
				     <input type="text" name="found" height="20px" width="100px" placeholder="搜索框"/>
				     <button >搜索</button>
			      </form>
		        </div>
		        
		         <div id="shop">
		          <button id="button1"><a href="shoppingCart.html">购物车</a></button>
		          <img src="images/a1.png" height="30px">
		         <div id="img1">
                     
                   </div>
		        </div>
    		 </div>
    	</div>
    	<div id="body">
    	    <div id="body1">
    		<input type="text" name="found" placeholder="搜索框"/>
    		<button>搜索</button>
    		</div>
            <div id="body-bottom">
            	<table border="1" color="#cbc7c6">
            	    <tr>
	                  <td>姓名</td>
	                  <td>昵称</td>
	                  <td>性别</td>
	                  <td>头像</td>
	                  <td><a href="">是否关注</a></td>
	                  </tr>
            		<c:forEach items="${list}" var="user">
	                  <tr>
	                  <td><a href="">${user.userName}</a></td>
	                  <td><a href="">${user.user.petName}</a></td>
	                  <td>${user.user.sex}</td>
	                  <td><a href=""><img src="E:\temp\images\${user.user.img}" width="50px" height="50px" /></a></td>
	                  <td><a href="">是</a></td>
	                  </tr>
	                </c:forEach>
            	</table>
            </div>
    	</div>
   </body> 
</html>