<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="custom.css" rel="stylesheet">
</head>
<body>
<%
String userid = request.getParameter("username");
String password = request.getParameter("pwd");
if(userid!=null && password!=null){
	if(userid.trim().length()>0 && password.trim().length()>0){
if(userid.equals(password)){
	response.sendRedirect("welcome.jsp");
}
else{
%>
<h2>Invalid Userid or Password</h2>
<% 
}
}
}
%>
<div>
<form action="login.jsp" method="post">
	<table>
		<tr>
		<td>Userid</td>
		<td><input type="text" name="username"></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" class="right" value="Login"></td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>