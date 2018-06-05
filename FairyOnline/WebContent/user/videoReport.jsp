<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE>
<html>
    <head>
	<title>举报</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="../css/css1.css">
    <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
    <link rel="stylesheet" type="text/css" href="../css/report.css"> 
 	<script type="text/javascript">
  		function history(){
    		window.location.href="location.href='javascript:history.go(-1);'";
    }
	</script>

     </head>
     <body>
     	<div id="head1">
    		<div id="head-line">
    			<div id="logo">
			    <img src="../images/logo.jpeg" height="60px">
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
		          <a href="${ctx}/user/followUser?id=${userLogin2.user.id}" ><img  id="img1" name="img1" src="${ctx}/images/userImages/${userLogin2.user.img}">
                  </a>
		         </div>
    		 </div>

    	</div>
    	<div id="body1">
    		<h1>举报理由：</h1> 
    		<form action="${ctx}/user/report1?id1=${userLogin2.user.id}&id2=${reportVideo.ID}" enctype="multipart/form-data" method="post">
    		<input id="body2" type="text" name="reportReason"/>
    		<button onclick="history()">提交</button>
    		</form>

		</div>
  </body>
  </html>