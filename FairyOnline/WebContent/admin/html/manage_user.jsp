<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="../css/16.css" />
<title>管理用户</title>
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
                <a href="manage_user.jsp"><li>已有管理员账号</li></a>
                <a href="register.jsp"><li id="last">注册新账号</li></a>
            </ul>
        </div>
        <div class="right">
            <div class="right-top">
                <p class="right-top-title">管理与账号列表:</p>
            </div>
            <div class="right-middle">
                <ul>
                    <li>
                       <div class="right-middle-title">账号：</div>
                       <div class="right-middle-title">发放时间：</div>
                       <div class="right-middle-title">权限数：</div>
                       <div class="right-middle-title">
                           <a href="17.html"><button class="right-middle-btn">详情</button></a>
                       </div> 
                    </li>
                    <li>
                       <div class="right-middle-title">账号：</div>
                       <div class="right-middle-title">发放时间：</div>
                       <div class="right-middle-title">权限数：</div>
                       <div class="right-middle-title">
                           <a href="17.html"><button class="right-middle-btn">详情</button></a>
                       </div> 
                     </li>
                     <li>
                       <div class="right-middle-title">账号：</div>
                       <div class="right-middle-title">发放时间：</div>
                       <div class="right-middle-title">权限数：</div>
                       <div class="right-middle-title">
                           <a href="17.html"><button class="right-middle-btn">详情</button></a>
                       </div> 
                     </li>
                     <li>
                       <div class="right-middle-title">账号：</div>
                       <div class="right-middle-title">发放时间：</div>
                       <div class="right-middle-title">权限数：</div>
                       <div class="right-middle-title">
                           <a href="17.html"><button class="right-middle-btn">详情</button></a>
                       </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">账号：</div>
                       <div class="right-middle-title">发放时间：</div>
                       <div class="right-middle-title">权限数：</div>
                       <div class="right-middle-title">
                           <a href="17.html"><button class="right-middle-btn">详情</button></a>
                       </div> > 
                     </li>
                     <li>
                        <div class="right-middle-title">账号：</div>
                       <div class="right-middle-title">发放时间：</div>
                       <div class="right-middle-title">权限数：</div>
                       <div class="right-middle-title">
                           <a href="17.html"><button class="right-middle-btn">详情</button></a>
                       </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">账号：</div>
                       <div class="right-middle-title">发放时间：</div>
                       <div class="right-middle-title">权限数：</div>
                       <div class="right-middle-title">
                           <a href="17.html"><button class="right-middle-btn">详情</button></a>
                       </div> 
                     </li>
                     <li>
                        <div class="right-middle-title">账号：</div>
                       <div class="right-middle-title">发放时间：</div>
                       <div class="right-middle-title">权限数：</div>
                       <div class="right-middle-title">
                           <a href="17.html"><button class="right-middle-btn">详情</button></a>
                       </div>  
                     </li>
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