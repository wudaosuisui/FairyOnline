<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%@ page import="java.util.*"%> <!--  获取系统时间必须导入的 -->
<%@ page import="java.text.*"%> <!--获取系统时间必须导入的 -->
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>添加分类</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx }/course-bk/css/10.css" />
</head>
<body>
    <div class="container">
        <!-- 顶部标题栏 -->
        <div class="header">
            <!-- 标题栏左半部分 -->
            <div class="header-left-part">
                <h2>欢迎登陆FairyOline后台界面</h2>
            </div>
            <!-- 标题栏右半部分 -->
            <div class="header-right-part">
                <p>账号</p>
                <p>权限</p>删除
                <a href="login.html">
                    <button class="quit-btn">退出登录</button>
                </a>
            </div>
        </div>
    
        <!-- 表格部分 -->
        <div class="banner">
        <ul>
            
                <a href="03.html"><li>管理用户权限</li></a>
                <a href="${ctx }/course/auditlist"><li>审核课程</li></a>
                <a href="${ctx }/course/categorylist"><li>管理课程分类</li></a>
                <a href="11.html"><li>管理教师</li></a>
                <a href="15.html"><li>管理数据</li></a>
                <a href="16.html"><li >管理管理账号</li></a>
        </ul>
        </div>
        <div class="left">
            <ul class="left-title">
                <a href="${ctx }/course/categorylist"><li>已有分类</li></a>
                <a href="09.html"><li>用户申请分类</li></a>
                <a href="10.html"><li id="last">添加分类</li></a>
            </ul>
        </div>
        <form action="../course/addcategory">
        <div class="right">
            <div class="right-top">
                <a href="${ctx }/course/categorylist"><button class="fanhui">返回</button></a>
            </div>
            <div class="right-middle">
                <div class="title">
                    <p class="p">课程分类名称：<input type="text" name="username"></p>
                    <p class="p"><% java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
                                    java.util.Date currentTime = new java.util.Date();    
                                    String time = simpleDateFormat.format(currentTime).toString();  
                                    out.println("当前时间为："+time);%></p>
                    <p class="p">添加人：<!-- ${admin.name} --></p>
                </div>
            </div>
            <div class="right-bottom">
                <div class="text">
                    <p class="gaishu">类别概述：</p>
                </div>
                <div class="leibiegaishu">
                    <textarea rows="20" cols="80" name="introduce">
                        这里是类别概述
                    </textarea>
                </div>
            </div> 
            <div class="queren">
                <button class="xinjian" >确认新建此课程</button>
            </div>
        </div>
        </form>
    </div>

</body>
</html>