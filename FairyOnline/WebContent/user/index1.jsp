
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${ctx}/user/userList1">商品</a> 
	<form action="${ctx}/user/updateitem" enctype="multipart/form-data" method="post">
		<div class="form-group"  >
									UserName：<input type="text" class="form-control" onblur="checkIsExist()" placeholder="Your Name *"  name="username" id="userName" >
									<span id="showResult"></span>
									<p class="help-block text-danger"></p>
								</div>
								<div class="form-group"  >
									Password：<input type="password"  class="form-control" onblur="passWord()"  placeholder="Your Password *"   name="password" id="passw" >
									<span id="pass"></span>
									 <p class="help-block text-danger"></p>
								</div>
								<div class="form-group"  >
									Password Again：<input type="password" class="form-control" onblur="EqualPass()" placeholder="Your Password *"name="password2" id="repassw">
									<span id="rep"></span>
									<p class="help-block text-danger"></p>
								</div>
								<div>
								<input value="提交" type="submit" id="submit" style="margin-right:20px; margin-top:20px;">
								</div>
	</form>
	
</body>
</html>