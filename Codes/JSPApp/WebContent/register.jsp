<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.dao.*,java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>Userid</td>
<td><input type="text" name="username"></td>
</tr>
<tr>
<td>Password</td>
<td><input type="text" name="pwd"></td>
</tr>
<tr>
<td>Hobbies</td>
<td>
<%
ArrayList<CommonDTO> commonList  = JDBC.getData("hobby");
if(commonList!=null && commonList.size()>0){
	for(CommonDTO commonDTO : commonList){
%>
<input type="checkbox" name="hobbycheckbox" value="<%=commonDTO.getValues() %>"><%=commonDTO.getDesc()  %>
<%		
	}
}
%>
</td>
</tr>
<tr>
<td>City</td>
<td>
<select name="cityselect">
<%
 commonList  = JDBC.getData("city");
if(commonList!=null && commonList.size()>0){
	for(CommonDTO commonDTO : commonList){
%>
<option value="<%=commonDTO.getValues() %>"><%=commonDTO.getDesc()  %></option>
<%		
	}
}
%>
</select>
</td>
</tr>
</table>

</body>
</html>