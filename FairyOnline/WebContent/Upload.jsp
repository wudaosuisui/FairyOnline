<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
    <head>
	<title>上传</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/css1.css">
    <link rel="stylesheet" type="text/css" href="css/css2.css"> 
    <link rel="stylesheet" type="text/css" href="css/homePage.css"> 
    <link rel="stylesheet" type="text/css" href="css/uploading.css">
      <script type="text/javascript">  
        <!-- 添加-->  
        function addOne(){  
            document.getElementById("addDiv").innerHTML+="<div class='add'> <input type='file' name='file'/><a href="video/drop?Id=${video.ID}"><input type='button' value='删掉' onclick='delOne(this)' ></a></div>";  
        }  
        <!-- 删除按钮-->  
        function delOne(btn){  
            var div=btn.parentNode;  
            div.parentNode.removeChild(div);  
        }  
    </script>  
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

    		 <div id="head-text">
    		     <div id="img">
    		     </div>
    		     <p>关注|粉丝</p>
    		  </div> 

    	    </div>
    	</div>


    	<div id="bodya1">
    	    <div id="body1">
    		<button><a href="">已发布课程</a></button>
    		<button><a href="">待审核课程</a></button>
    		<button><a href="">上传</a></button>
    		<button><a href="">资料管理</a></button>
    		
    		</div>

            
            <p>上传视频</p>
             <div id="body2-top">
                     <img src="images/5.png"/>
                     <img src="images/5.png"/>
                     <img src="images/5.png"/>
                     <img src="images/5.png"/>
                     <input type="submit" value="继续添加"/>
                     <input type="submit" value="开始上传"/>
            </div>
            

            <p>上传资料</p>
             <div id="body2-bottom">
	      <c:forEach items="${jpgList}" var="URL">
				<img alt="暂无图片" src="${URL}" />	
	      </c:forEach>

	     <form action="${pageContext.request.contextPath}/servlet/UploadServlet" 	     	      method="post" enctype="multipart/form-data" >
                     
      <c:forEach items="${videoList}" var="video">
	    <div id="addDiv"></div>	
       </c:forEach>    
	     <input class="input2" type="button" value="添加" onclick="addOne()">  
	      <input class="input2" type="submit" value="上传">  
    	    </form>   
            </div>
           
        </div>
     </body>
</html>