<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>精灵支付页面</title>
		<link rel="stylesheet" type="text/css" href="../css/css1.css">
        <link rel="stylesheet" type="text/css" href="../css/css2.css"> 
	    <link rel="stylesheet" type="text/css" href="../css/payment.css">
</head>
<body>
    <!--导航栏-->
		<div id="head">
		    <div id="logo">
			    <img src="../images/logo.jpeg" height="60px">
			    <img src="../images/logo2.jpeg" height="40px">
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
		<!--主体-->
		<div id="contend">
			<p><a href="">返回</a></p>
			<form action="../course/cartlist">
		    <h1>总计金额：**元</h1>
		    <h2>请输入6位密码</h2>
		    <input style="height:30px;width:200px;" type="password" placeholder="单行输入"/>
		    <input type="submit" value="确认" style="height:32px;width:65px;" />
		    </form>
		</div>
		<!--底部-->
		<div></div>

</body>
</html>