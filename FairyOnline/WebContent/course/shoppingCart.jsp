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
    <script>
     function doDelete(id){
      var b = window.confirm("您确定删除吗??");
      if(b){
       window.location.href="${pageContext.request.contextPath }/servlet/DeleteBookServlet?id="+id;
      }
     }
     
     function clearCart(){
      var b = window.confirm("您确定清空吗??");
      if(b){
       window.location.href="${pageContext.request.contextPath }/servlet/ClearCartServlet";
      }
     }
     
     function updateCart(input,bookid,oldvalue){
      var b = window.confirm("您确定修改吗??");
      if(b){
        var quantity = input.value;
        if(quantity==""){
         alert("请输入数字！！");
         input.value=oldvalue;
         return;
        }
        if(!quantity.match("\\d+")){
         alert("请输入数字!!");
         input.value=oldvalue;
         return;
        }
        if(quantity<1){
         alert("请输入有效数字!!");
         input.value=oldvalue;
         return;
        }
        
        
        
       window.location.href='${pageContext.request.contextPath}/servlet/UpdateCartServlet?bookid='+bookid+'&quantity='+quantity;
      }else{
       input.value=oldvalue;
      }
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
    		<a href="${ctx }/course/selectfc"><button>收藏的课程</button></a>
    		<button><a href="">学习的课程</a></button>
    		<button><a href="">购物车</a></button>
    		<button><a href="">教师（申请）</a></button>
    		<button><a href="">教师（主页）</a></button>
    		</div>
    		<form action="../course/carttoorders">
             <c:forEach  var="c" items="${user.cartSet}">
    		<div id="body2">
    		    <div id="body2-checkbox">
    		         <input name="cart" id="save" type="checkbox" value="${c.cartId }" />
    		    </div> 
    		    <div id="body2-img">
                <img src="../images/5.png">
                </div>   
                <div id="body2-text">
                <p></p>
                <p>${c.courseId.categoryID.categoryName}&nbsp;&nbsp;&nbsp;讲师：${c.courseId.tId.name }&nbsp;&nbsp;&nbsp;&nbsp;等级&nbsp;&nbsp;&nbsp;观看人数</p>
                <p>课程简介：${c.courseId.cIntroduction }</p>
                购买人：${c.userId.petName}
                </div>
    		</div>
               </c:forEach>
            <input type="submit" value="删除选中项"/>
            <input type="submit" value="生成订单"/>
            </form>        
    		
    	</div>

</body>
</html>