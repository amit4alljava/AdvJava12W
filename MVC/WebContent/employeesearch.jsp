<%@page import="com.srivastava.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
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
<%
boolean isRed = true;
String rowColor = "red";
ArrayList<EmpDTO> empList = (ArrayList<EmpDTO>)request.getAttribute("empdata");
if(empList!=null && empList.size()>0){
%>
<table border="1">
<tr>
<th>Id</th><th>Name</th><th>Salary</th>
</tr>
<% for(EmpDTO empDTO : empList){ %>
<%
if(isRed){
	rowColor="red";
}
else{
	rowColor = "green";
}
isRed = !isRed;
%>
<tr style="background-color: <%=rowColor%>;">
<td><%=empDTO.getId() %></td>
<td><%=empDTO.getName() %></td>
<td><%=empDTO.getSalary() %></td>
</tr>
<%} %>
</table>
<%
}
%>

</body>
</html>