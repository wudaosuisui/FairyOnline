<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <img  id="img1" src="${ctx}/images/userImages/${userLogin2.user.img}"> --%>
<table width="800" >
<tr>
<td>
<img alt="小叶" src="E:\Program Files\JavaEE\eclipseWork\FairyOnline\img\xy.jpg" height="600px">
</td><td>
<p>${say }</p>
<embed  height="50"width="200" src="${url }" /><!-- height="100" -->
</td>
</tr>
<tr>
<td colspan="2">
<form  action="../tuling/saytest" method = "post">
<!-- <input type="hidden" name="name" value="userId"> -->
<input type="text" name="name" value=""><br>
<textarea name="say" rows="2" cols="30"></textarea>

<input type="submit">
</form>
</td>
</tr>
</table>
</body>
</html>