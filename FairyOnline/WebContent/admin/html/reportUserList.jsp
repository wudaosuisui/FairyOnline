<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>被举报用户</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="${ctx}/admin/css/09.css" />
	<script type="text/javascript">
     function before(){
    	window.location.href="${ctx}/admin/reportUserList?pages=${(pages<1)?pages:(pages-1)}";
    }
     function next(){
     	window.location.href="${ctx}/admin/reportUserList?pages=${(pages>=totalPages)?pages:(pages+1)}";
     }
     function detail(){
      	window.location.href="${ctx}/admin/reportDetail?id=${reportUser.id}";
      }
	</script>
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
                <li>被举报用户</li>
                <li>被澄清用户</li>
                <li>禁言用户</li>
                <li id="last">封号用户</li>
                <li>被举报课程</li>
            </ul>
        </div>
        <div class="right">
            <div class="right-top">
                <p class="right-top-title">举报列表:</p>
            </div>
            <div class="right-middle">
                <ul>
                    <c:forEach items="${reportUserList}" var="reportUser">
                    <li>
                       <div class="right-middle-title">用户名:${reportUser.rid.userLogin.userName}</div>
                       <div class="right-middle-title">被举报时间:${reportUser.date}</div>
                       <div class="right-middle-title">
                       <!--  <button class="right-middle-btn" onclick="detail()">举报详情</button> -->
                       <a href="${ctx}/admin/reportDetail?id=${reportUser.id}">举报</a>
                       </div> 
                    </li>
                    </c:forEach>
               </ul>
            </div>
            <div class="right-bottom">
                <div class="right-bottom-page">
                    <div class="page-left">
                        <button class="page-btn" onclick="before()">上一页</button>
                    </div>
                    <div class="page-middle">
                        <ul>
                            <li>共${totalPages}页|</li>
                            <li>第${pages}页</li>
                        </ul>
                        
                    </div>
                    <div class="page-left">
                        <button class="page-btn" onclick="next()">下一页</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
