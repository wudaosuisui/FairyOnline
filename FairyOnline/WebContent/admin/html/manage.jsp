<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>管理用户/视频权限</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/admin/css/09.css" />
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
                <p>权限</p>
                <a href="login.html">
                    <button class="quit-btn">退出登录</button>
                </a>
            </div>
        </div>
    
        <!-- 表格部分 -->
        <div class="banner">
        <ul>
                <a href="manage.jsp"><li>管理用户/视频权限</li></a>
                <a href="exacourList.jsp"><li>审核课程</li></a>
                <a href="courcatList.jsp"><li>管理课程分类</li></a>
                <a href="teacherManage.jsp"><li>管理教师</li></a>
                <a href="dataManage.jsp"><li>管理数据</li></a>
                <a href="adminsManageAdmins.jsp"><li>管理管理账号</li></a>
        </ul>
        </div>
        <div class="left">
            <ul class="left-title">
                <li><a href="${ctx}/admin/reportUserList">被举报用户</a></li>
                <li>被澄清用户</li>
                <li><a href="${ctx}/admin/gagList">禁言用户</a></li>
                <li id="last"><a href="${ctx}/admin/titleList">封号用户</a></li>
                <li><a href="${ctx}/admin/reportVideoList">被举报课程</a></li>
            </ul>
        </div>
        
        
    </div>
</body>
</html>
