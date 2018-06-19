<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<title>精灵课堂登录页面</title>
		<meta charset="utf-8">
	    <link rel="stylesheet" type="text/css" href="../css/login.css">
	    <script type="text/javascript">
$(function (){
	$("#txtName").focus();
	$("#txtName").keydown(function(event){
		if(event.which=="13"){
			$("#txtPass").focus();
		}
	});
	$("txtPass").keydown(function (event){
		if(event.which=="13"){
			$("#btnLogin").trigger("click");
		}
	});
	$("#btnLogin").click(function(){
		var strTxtName=encodeURI($("#txtName").val());
		var strTxtPass=encodeURI($("#txtPass").val());
		$.ajax
		({
			url:"{ctx}/user/login",
			dataType:"html",
			data:{txtName:strTxtName,txtPass:strPass},
			success:function(strValue){
				if(strValue=="True"){
					$(".clsShow").html("操作成功"+strValue);
				}
				else{
					$("#divError").show().html("用户名或密码错误"+strValue);
				}
			}
		})
	})
})
</script>
	</head>
	<body>
		<div id="content">
		    <div id="page">
		    	<h1>登录</h1>
		    	<form action="${ctx}/user/login">
		    		<p>用户账户</p><input id="txtName" type="text" placeholder="请输入您的账户" name="UserName" required data-validation-required-message="Please enter your UserName."/>
		    		<p>用户密码</p><input id="txtPass" type="password" placeholder="请输入您的密码" name="PassWord"  required data-validation-required-message="Please enter your PassWord."/>
		    		</br>
		    		<input id="login" type="submit" value="登录">
		    		<a href="regist.html"><input id="regist" type="button" value="前往注册"></a>
		    	</form>
		    </div>
			
		</div>
	</body>
</html>