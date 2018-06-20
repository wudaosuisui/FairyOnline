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
    <title>举报详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx }/course-bk/css/06.css" />
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
                <li>待审核课程</li>
                <li>未通过课程</li>
                <li id="last">已通过课程</li>
            </ul>
        </div>
        <div class="right">
            <div class="right-top">
               <div class="fanhui">
                   <a href="${ctx }/course/auditlist"><button class="btn">返回</button></a>
               </div>
               <div class="time">
                    申请时间：
               </div>
            </div>
            <div class="right-middle">
                <div class="name">
                    <div class="name-1">${coursebk.CName }：</div>
                    <div class="name-2">${coursebk.tId.name }:</div>
                </div>
                <div class="gaishu">
                    课程概述：${coursebk.cIntroduction }
                </div>
            </div>
            <div class="right-bottom">
                <div class="xiangqing">
                    详情:
                </div>
                <div class="one">章节一:</div>
                <div class="two">章节二:</div>
                <div class="three">章节三:</div>
            </div>
            <div class="last">
                <div class="last-1">
                    <button class="btn-1">通过审核</button>
                </div>
                <div class="last-2">
                    <button class="btn-2">不予通过</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>