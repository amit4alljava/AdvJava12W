<%@page import="com.srivastava.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Ctrl">
Salary<input type="text" name="salaryTxt">
<input type="submit" value="Search">
</form>
<c:if test="${empdata.size() ge 0 }">
<table border="1">
<tr>

<th>S.no</th><th>Id</th><th>Name</th><th>Salary</th>
</tr>
<c:forEach items="${empdata}" var="empObj" varStatus="x">
<c:if test="${x.count mod 2 eq 0 }">
<tr style="background-color: red;">
</c:if>
<c:if test="${x.count mod 2 ne 0 }">
<tr style="background-color: green;">
</c:if>
<td>${x.count}</td>
<td>${empObj.id }</td>
<td>${empObj.name }</td>
<td>${empObj.salary }</td>
</tr>

</c:forEach>

</table>
</c:if>

</body>
</html>