<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="java.util.Date" info="Author Name" isELIgnored="true" isThreadSafe="true" session="true" trimDirectiveWhitespaces="false"
    pageEncoding="ISO-8859-1" autoFlush="true" buffer="8kb" errorPage="error.jsp" isErrorPage="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- this is html comment -->
<%-- Scriptlet --%>
<%
//int a = 100/0;
int a = 10;
int b =20;
int c = a + b;
out.println("Sum is "+c);
%>

Sum is <%=c %>
Current Date is <%=new Date() %>
</body>
</html>