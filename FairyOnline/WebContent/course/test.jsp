<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
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
<!-- <form action="../course/test">
   <input type="submit"/>
    
</form> -->

 <h2>您购买了如下商品</h2>
    <table border="1" width="80%">
      <tr>
        <td>编号</td>
        <td>书名</td>
        <td>价格</td>
        <td>数量</td>
        <td>小计</td>
        <td>操作</td>
      </tr>
      
      <c:forEach  var="me" items="${cart.map}">
      <tr>
        <td>${me.key}</td>
        <td>${me.value.book.name}</td>
        <td>${me.value.book.price}</td>
        <td>
     <input type="text" value="${me.value.quantity}" onchange="updateCart(this,${me.key },${me.value.quantity})" style="width:35px;">
     </td>
        <td>${me.value.price}</td>
        <td>
          <a href="javascript:void(0)" onclick="doDelete(${me.key })">删除</a>
        </td>
      </tr>
      </c:forEach>
       <tr>
      <td><a href="javascript:void(0)" onclick="clearCart()">清空购物车</a></td>
      <td><a href="servlet/ListBookServlet">继续选书</a></td>
      <td colspan="2">总价</td>
      <td colspan="2">${cart.price }元</td>
     </tr>      
    </table>

</body>
</html>