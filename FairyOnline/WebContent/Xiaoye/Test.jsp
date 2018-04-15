<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>
<!-- table -->
<table border="1">
<tr>
<td>
<h1>====&nbsp;&nbsp;Get&nbsp;&nbsp;===</h1>
</td>
<td>
<h1>====&nbsp;&nbsp;Add&nbsp;&nbsp;===</h1>
</td>
<td>
<h1>====&nbsp;&nbsp;red&nbsp;&nbsp;===</h1>
</td>
</tr>
<tr>
<!-- get -->
<td>
<h2>get Vertex List</h2>
	<form action="../vertex/getList" method = "post"> 
	<input type="text" name="id" value="1">
	<input  type="submit" value="test"/>
	</form>
	
	<h2>get Vertex By Id</h2>
	<form action="../vertex/getVertexById" method = "post"> 
	<input type="text" name="id" value="19">
	<input  type="submit" value="test"/>
	</form>

</td>
<!-- add -->
<td>
	<h2>only Add Side</h2>
	<form action="../vertex/AddSide" method = "post"> 
	<!-- <input type="text" name="name" value="name"> -->
	<input  type="submit" value="test"/>
	</form>
	
	<h2>only Add Vertex</h2>
	<form action="../vertex/AddVertex" method = "post"> 
	<!-- <input type="text" name="name" value="name"> -->
	<input  type="submit" value="test"/>
	</form>
	
	<h2>jump to success.jsp</h2>
	<form action="success.jsp" method = "post"> 
	<input type="text" name="name" value="name">
	<input  type="submit" value="test"/>
	</form>
</td>
<td>

	<h2>red File test</h2>
	<form action="../File/redFile" method = "post" enctype="multipart/form-data" > 
	<input  type="submit" value="test"/>
	</form>
	
	<h2>write File test</h2>
	<form action="../File/writeFile" method = "post" enctype="multipart/form-data" > 
	<textarea rows="10" cols="30" name="textarea" value="  write test"></textarea>
	<input  type="submit" value="test"/>
	</form>

	<h2>save File test</h2>
	<form action="../File/saveFile" method = "post" enctype="multipart/form-data" value="F:\Documents\File\mldn\test.txt"> 
	<input type="file" name="file" >
	<input  type="submit" value="test"/>
	</form>
</td>
</tr>
</table>





</body>
</html>