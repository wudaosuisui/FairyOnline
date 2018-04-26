
 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>personal</title>

<link rel="stylesheet" href="../css/style.css">

<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="../js/easyform.js"></script>

</head>
<body>
<br>
<div class="form-div">
    <form id="reg-form" action="${ctx}/user/updateitem" enctype="multipart/form-data" method="post">
		<input type="hidden" name="id" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 修改用户个人信息：
        <table>
        	  <tr>
                <td>昵称</td>
                <td><input name="userName"  type="text" id="userName" easyform="length:2-16" message="昵称必须为2—16位" easytip="disappear:lost-focus;theme:blue;"></td>
            </tr>
           <tr>
                <td>昵称</td>
                <td><input name="passWord"  type="password" id="passWord" easyform="length:2-16" message="昵称必须为2—16位" easytip="disappear:lost-focus;theme:blue;"></td>
            </tr>
            <tr>
                <td>昵称</td>
                <td><input name="petName"  type="text" id="petName" easyform="length:2-16" message="昵称必须为2—16位" easytip="disappear:lost-focus;theme:blue;"></td>
            </tr> 
            <tr>
                <td>用户头像</td>
                <td>
                	<c:if test="$item.img != null">
                    <img src="/pic/" width="140px" height="140px"/>
                    <hr/>
                    </c:if>
                    <input type="file" name="picture"/>
                </td>
            </tr> 
            <tr>
                <td>真实姓名</td>
                <td><input name="Tname" value="" type="text" id="Tname" easyform="length:2-16" message="真实姓名必须为2—16位" easytip="disappear:lost-focus;theme:blue;"></td>
            </tr> 
               <tr>
                <td>性别</td>
                <td><input name="Sex" value="" type="text" id="Sex"></td>
            </tr> 
            
                      
        </table>
			<div class="buttons">
             <input value="提交" type="submit" id="submit" style="margin-right:20px; margin-top:20px;">
             </div>
		
			
			
        
		
        <br class="clear">
    </form>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$('#reg-form').easyform();
});
</script>
</body>
</html>


