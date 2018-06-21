<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="../css/css1.css">
    <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
    <link rel="stylesheet" type="text/css" href="../css/homePage.css"> 
    <link rel="stylesheet" type="text/css" href="../css/shoppingCart.css">
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
		          <button id="button1">购物车</button>
		          <img src="../images/a1.png" height="30px">
		          <div id="img1">
                     ${userLogin2.user.petName}
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


    	<div id="bodya">
    	    <div id="body1">
    		<a href="${ctx }/course/selectfc?id=${userLogin2.user.id }"><button>收藏的课程</button></a>
    		<button><a href="">学习的课程</a></button>
    		<button><a href="">购物车</a></button>
    		<button><a href="">教师（申请）</a></button>
    		<button><a href="">教师（主页）</a></button>
    		</div>
    		<form action="../course/carttoorders" id="userForm">
    		<input type="hidden" name="uid" value="${user.id}">
    		<div id="body3">
    	
    		   <div id="body2-checkbox">
    		         <input name="cartIds" type="checkbox" id="all" class="whole_check" value="${c.cartId }" />
    		    </div> 
    		   <div id="l"><p>全选<p></div> 
    		</div>
    		  
    		 
             <c:forEach  var="c" items="${user.cartSet}">
    		<div id="body2" class="cartBox">
    		    <div id="body2-checkbox">
    		         <input name="cartId" id="save" type="checkbox" class="son_check" value="${c.cartId }" />
    		    </div> 
    		    <div id="body2-img">
                <img src="../images/5.png">
                </div>   
                <div id="body2-text">
                <p></p>
                <p>${c.courseId.cName}&nbsp;&nbsp;&nbsp;讲师：${c.courseId.tId.name }&nbsp;&nbsp;&nbsp;&nbsp;等级&nbsp;&nbsp;&nbsp;观看人数</p>
                <p>课程简介：${c.courseId.cIntroduction }</p>
                购买人：${c.userId.petName}
                </div>
    		</div>
               </c:forEach>
            <input type="button" value="删除选中项" name="btn" onclick="delet()"/>
            <input type="submit" value="生成订单"/>
            </form>        
    		
    	</div>
    	<script src="../js/jquery.min.js"></script>
        <script src="../js/carts.js"></script>

</body>
</html>