<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>审核课程</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx }/course-bk/css/05.css" />
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
                <li>待审核课程</li>
                <li>未通过课程</li>
                <li id="last">已通过课程</li>
            </ul>
        </div>
        <div class="right">
            <div class="right-top">
                <p class="right-top-title">课程列表:</p>
            </div>
            <div class="right-middle">
                <ul>
                    <c:forEach var="a" items="${list }">
                         <li>
                        <div class="right-middle-title">${a.CName}</div>
                        <div class="right-middle-title">${a.UPTime }</div>
                        <div class="right-middle-title">
                            <a href="06.html"><button class="right-middle-btn">详情</button></a>
                        </div> 
                     </li>
                    
                    </c:forEach>
                    
                </ul>
            </div>
            <div class="right-bottom">
                <div class="right-bottom-page">
                    <div class="page-left">
                        <button class="page-btn">上一页</button>
                    </div>
                    <div class="page-middle">
                        <ul>
                            <li>1&nbsp;|</li>
                            <li>2&nbsp;|</li>
                            <li>3&nbsp;|</li>
                            <li>4&nbsp;|</li>
                            <li>5&nbsp;|</li>
                            <li>..&nbsp;|</li>
                            <li>9</li>
                        </ul>
                    </div>
                    <div class="page-left">
                        <button class="page-btn">下一页</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
<!-- <li>
                       <div class="right-middle-title">课程名称</div>
                       <div class="right-middle-title">申请时间</div>
                       <div class="right-middle-title">
                           <a href="06.html"><button class="right-middle-btn">详情</button></a>
                       </div> 
                    </li>
                    <li>
                        <div class="right-middle-title">课程名称</div>
                        <div class="right-middle-title">申请时间</div>
                        <div class="right-middle-title">
                            <a href="06.html"><button class="right-middle-btn">详情</button></a>
                        </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">课程名称</div>
                        <div class="right-middle-title">申请时间</div>
                        <div class="right-middle-title">
                            <a href="06.html"><button class="right-middle-btn">详情</button></a>
                        </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">课程名称</div>
                        <div class="right-middle-title">申请时间</div>
                        <div class="right-middle-title">
                            <a href="06.html"><button class="right-middle-btn">详情</button></a>
                        </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">课程名称</div>
                        <div class="right-middle-title">申请时间</div>
                        <div class="right-middle-title">
                            <a href="06.html"><button class="right-middle-btn">详情</button></a>
                        </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">课程名称</div>
                        <div class="right-middle-title">申请时间</div>
                        <div class="right-middle-title">
                            <a href="06.html"><button class="right-middle-btn">详情</button></a>
                        </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">课程名称</div>
                        <div class="right-middle-title">申请时间</div>
                        <div class="right-middle-title">
                            <a href="06.html"><button class="right-middle-btn">详情</button></a>
                        </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">课程名称</div>
                        <div class="right-middle-title">申请时间</div>
                        <div class="right-middle-title">
                            <a href="06.html"><button class="right-middle-btn">详情</button></a>
                        </div> 
                     </li> -->