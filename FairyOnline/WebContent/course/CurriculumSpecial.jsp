<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">  
    <meta http-equiv="cache-control" content="no-cache">  
    <meta http-equiv="expires" content="0">      
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">  
    <meta http-equiv="description" content="This is my page">  
<title>某种课程专项页面</title>
<link rel="stylesheet" type="text/css" href="../css/moukecheng.css">
</head>
 <%--   
  <c:redirect <c:if test="${list==null}">url="/StudentsAdd"</c:if>></c:redirect> 
  --%>  
<body>
    <!-- 导航栏 -->
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
				          <!-- <button id="button1"></button> -->
				          <a href="../course/cartlist?id=${userLogin2.user.id }">购物车</a>
				          <img src="../images/a1.png" height="30px">
		                  <div id="img1">${userLogin2.user.petName}</div>
			        </div>
    		</div>
    	</div>	
        <!-- 页面主体 -->
        <div id="classify">
        	<div id="line1">
        		<a href="#">方向：</a>
        		<a href="#">全部</a>
        		<a href="#">前端开发</a>
        		<a href="#">后端开发</a>
        		<a href="#">移动设备开发</a>
        	</div>           
        	<div id="line2">—————————————————————————————————————————————————————</div>
        	<div id="line3">
        		<a href="#">分类：</a>
        		<a href="#">全部</a>
        		<a href="#">PHP</a>
        		<a href="#">Java</a>
        		<a href="#">SpringBoot</a>
				<a href="#">Python</a>
        		<a href="#">C</a>
        		<a href="#">C++</a>
        		<a href="#">Go</a>
        		<a href="#">C#</a>
        		<a href="#">Ruby</a>
        	</div>
        	<div id="line4">—————————————————————————————————————————————————————</div>
        	<div id="line5">
        		<a href="#">类型：</a>
        		<a href="#">全部</a>
        		<a href="#">基础</a>
        		<a href="#">案例</a>
        		<a href="#">框架</a>
				<a href="#">工具</a>
        	</div>
        </div>
        <form action="../course/list">
            <input type="submit">
        </form>
        <div id="specific">
            <div id="bord">
         
                <c:forEach var="l" items="${list}">
                <div class="lessen">
	        			<div class="lepic">
							<a href="#">
								<img src="../images/lepic.jpg">
							</a>
						</div>
						<div class="line6"><a href="crousedetail.do?id=${l.ID }">${l.CName } </a></div>
						<div class="line6">
							<a href="#">${l.categoryID.categoryName}</a>
							<a href="${ctx }/course/addcart.do?id=${userLogin2.user.id }&&ID=${l.ID}">加入购物车</a>
							<a href="${ctx }/course/collection.do?id=${userLogin2.user.id }&&ID=${l.ID}">收藏课程</a>
							<a href="#">观看人数</a>
							<a href="#">等级</a>
						</div>
						<div class="line6"><a href="#">价格</a></div>
	        	</div>
	        	</c:forEach>
          
            </div>
        
        	
        </div>

</body>
</html>
<!-- 
<div id="bord">
	        	<div class="lessen">
	        			<div class="lepic">
							<a href="#">
								<img src="images/lepic.jpg">
							</a>
						</div>
						<div class="line6"><a href="#">课程名称</a></div>
						<div class="line6">
							<a href="#">类型</a>
							<a href="#">观看人数</a>
							<a href="#">等级</a>
						</div>
						<div class="line6"><a href="#">价格</a></div>
	        	</div>
	        </div>

 -->