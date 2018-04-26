<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>视频播放页</title>
	   <link rel="stylesheet" type="text/css" href="../css/css1.css">
	   <link rel="stylesheet" type="text/css" href="../css/css2.css">
	   <link rel="stylesheet" type="text/css" href="../css/videoList.css">
   
</head>
<body>
    <div id="head1">
            <!-- 导航栏 -->
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
                  <div id="img1">
                  </div>
		        </div>
    		 </div>
             <!-- 主体 -->
    		 <div id="head-body">
    		 <div> 
                <video width="1010" height="243" controls autoplay="autoplay">
                 	<source src="../Example/1第一章总结 (1).mp4" type="video/mp4">
                 	<source src="../Example/1第一章总结 (1).ogg" type="video/ogg" />
                 	Your browser does not support HTML5 video.
                 </video> 
              <div>
    		</div> 
    	</div>
        
    	<div id="body">
    	   <h1>评论</h1>
    	   <div id="comment">
    			<input type="text" name="comment" >
    		</div>
    		<button>发表评论</button>
    	</div>

</body>
</html>