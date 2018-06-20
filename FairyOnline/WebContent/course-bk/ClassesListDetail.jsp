<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>课程分类详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" type="text/css" media="screen" href="${ctx }/course-bk/css/08.css" />
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
                <a href="05.html"><li>审核课程</li></a>
                <a href="07.html"><li>管理课程分类</li></a>
                <a href="11.html"><li>管理教师</li></a>
                <a href="15.html"><li>管理数据</li></a>
                <a href="16.html"><li >管理管理账号</li></a>
        </ul>
        </div>
        <div class="left">
            <ul class="left-title">
                <a href="07.html"><li>已有分类</li></a>
                <a href="09.html"><li>用户申请分类</li></a>
                <a href="10.html"><li id="last">添加分类</li></a>
            </ul>
        </div>
        <div class="right">
            <div class="right-top">
               <div class="fanhui">
                   <a href="07.html"><button class="btn">返回</button></a>
               </div>
                <div class="title">
                    <p class="p">类别名称：${category.categoryName }：</p>
                    <p class="p">上传时间：${category.uptime }</p>
                    <p class="p">添加人：${category.adminId.userName }：</p>
                </div>
            </div>
            <div class="right-middle">
                <div class="text">
                    <p class="gaishu">类别概述：</p>
                </div>
                <div class="leibiegaishu">
                    <textarea rows="30"cols="80">
                        ${category.introduce}
                    </textarea>
                </div>
            </div>
        </div>
    </div>

</body>
</html>