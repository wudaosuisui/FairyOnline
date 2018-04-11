<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/main.css" rel="stylesheet" type="text/css" />

<title>Insert title here</title>
</head>
<body>
<div class="login">
    <div class="box png">
		<div class="logo png"></div>
		<div class="input">
			<div class="log">
			<form action="../../login"method="post">
				<div class="name">
					<label>用户名</label><input type="text" class="text"  placeholder="用户名" name="name" tabindex="1">
				</div>
				<div class="pwd">
					<label>密　码</label><input type="password" class="text"placeholder="密码" name="password" tabindex="2">
					<a href="index.html"><input type="button" name="login"tabindex="3" value="登录"></a><!-- 不知道是什么原因，先让它跳转，时候再一起讨论 -->
					<div class="check"></div>
				</div>
				<div class="tip"></div>
			</form>
			</div>
		</div>
	</div>
    <div class="air-balloon ab-2 png"></div>
	<div class="air-balloon ab-2 png"></div>
	<div class="air-balloon ab-2 png"></div>
	<div class="air-balloon ab-2 png"></div>
	<div class="air-balloon ab-2 png"></div>
	<div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>
<script type="text/javascript" src="../js/jQuery.js"></script>
<script type="text/javascript" src="../js/fun.base.js"></script>
<script type="text/javascript" src="../js/script.js"></script>

</body>
</html>