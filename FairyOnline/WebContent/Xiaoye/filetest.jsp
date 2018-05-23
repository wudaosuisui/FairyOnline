<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>add sides by file</h2>
<form action="../file/test" method = "post"><!--  enctype="multipart/form-data" -->
<input type="file" name="file" > 
<input type="submit" value="submit">
</form>

<h2>get one node by name</h2>
<form action="../file/getNodeByName" method = "post">
<input typr="text" name="name" value="name1 name2 name3 ">
<input type="submit" value="submit">
</form>

<h2>get one node by id</h2>
<form action="../file/getbyid" method = "post">
<input typr="text" name="id" value="6">
<input type="submit" value="submit">
</form>

<h2>add nodes by file</h2>
<form action="../file/test" method = "post"><!--  enctype="multipart/form-data" -->
<input type="file" name="file" >
<input type="submit" value="submit">
</form>

<h2>add one node</h2>
<form action="../file/addone" method = "post"><!--  enctype="multipart/form-data" -->
<input type="submit" value="submit">
</form>


</body>
</html>