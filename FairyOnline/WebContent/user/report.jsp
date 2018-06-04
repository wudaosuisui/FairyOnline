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
  		function report(){
    		window.location.href="${ctx}/user/report?id1=${userLogin2.user.id}&id2=${user.user.id}";
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
		          <div id="img1">
                     
                   </div>
		         </div>
    		 </div>

    	</div>
    	<div id="body1">
    		<h1>举报理由：</h1> ${reportUser.id}
    		<form action="${ctx}/user/report?id1=${userLogin2.user.id}&id2=${reportUser.id}" enctype="multipart/form-data" method="post">
    		<input id="body2" type="text" name="reportReason"/>
    		<button>提交</button>
    		</form>

		</div>
  </body>
  </html>