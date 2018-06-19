<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE>
<html>
	<head>
	   <title>视频播放页</title>
	   <meta charset="utf-8">
	   <link rel="stylesheet" type="text/css" href="../css/css1.css">
	   <link rel="stylesheet" type="text/css" href="../css/css2.css">
	   <link rel="stylesheet" type="text/css" href="../css/videoList.css">
	   <script type="text/javascript">
			function reportUser(){
    			window.location.href="${ctx}/user/reportVideo?id=${video.ID}";
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
				     <input type="text" name="found" height="20px" width="100px">
				     <button >搜索</button>
			      </form>
		        </div>
		        
		         <div id="shop">
		          <button id="button1"><a href="shoppingCart.html">购物车</a></button>
		          <img src="../images/a1.png" height="30px">
		          <!--<button id="button1">头像</button>-->
                  <a href="${ctx}/user/followUser?id=${userLogin2.user.id}" ><img  id="img1" name="img1" src="${ctx}/images/userImages/${userLogin2.user.img}">
                  </a>
		        </div>
    		 </div>
            
    		 <div id="head-body">
    		 <div> 
                 <video width="1010" height="243" controls>
                 	<source src="" type="">
                 </video>
              <div>
    		</div> 
    	</div>

    	<div id="body">
    	   <h1>评论</h1>
    	   <div id="comment">
    			<input type="text" name="comment" >
    		</div>
    		<button><a href="">发表评论</a></button>
            <button onclick="reportVideo()">举报</button>
    	</div>
    </body>
</html>