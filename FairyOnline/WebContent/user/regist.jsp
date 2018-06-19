<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>精灵课堂注册页面</title>
		<!-- <meta charset="utf-8"> -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" type="text/css" href="../css/regist.css">
	    <script type="text/javascript">
function checkIsExist(){
	var userName=$("#userName").val();
	$.ajax({
		type:"POST",
		url:"${ctx}/user/regist1",
		data:{UserName:UserName},
		datatype:'json',
		async:false,
		success:function(data){
			var json= eval("("+data+")");
			if(json){
				$("#showResult").html("<font color='green'>用户合法</font>");
			}else{
				$("#showResult").html("<font color='red'>用户名已存在或为空！</font>");
			}
		}
	})
}
function passWord(){
		var password=$("#passw").val();
		
		
		if(password.length<6){
			$("#pass").html("<font color='green'>密码长度小于6</font>");
		}else{
			$("#pass").html("<font color='red'></font>");
		}
	}
function EqualPass(){
	var repassw=$("#repassw").val();
	var password=$("#passw").val();
	
	if(repassw!=password){
		$("#rep").html("<font color='green'>两次密码不一样</font>")
	}else{
		$("#rep").html("<font color='green'></font>")
	}
}
</script>
	</head>
	<body>
		<div id="content">
		    <div id="page">
		    	<h1>注册</h1>
		    	<form action="${ctx}/user/regist">
		    		<p>用户账户</p>
		    		<input id="userName" type="text" onblur="checkIsExist()" placeholder="请输入您的账户" name="UserName"/>
		    		<span id="showResult"></span>
		    		<p>用户密码</p>
		    		<input id="passw" type="password" onblur="passWord()" placeholder="请输入您的密码" name="PassWord"/>
		    		<span id="pass"></span>
		    		<p>再次输入用户密码</p>
		    		<input id="repassw" type="password" onblur="EqualPass()" placeholder="请再次输入密码确认" name="PassWord2"/>
		    		<span id="rep"></span>
		    		</br>
		    		<a href="login.jsp"><input id="login" type="button" value="前往登录"></a>
		    		<input id="regist" type="submit" value="注册">
		    	</form>
		    </div>
			
		</div>
	</body>
</html>