package com.srivastava.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private String doDesign(boolean isLogin){
		String msg = "";
		if(isLogin){
			msg = "<p class='error'>Invalid Userid and Password</p>";
		}
		String design="<!DOCTYPE html> "+
				"<html>"+
				"<head>"+
				" <style> .error{ color:red; } </style>"+
				"<meta charset='ISO-8859-1'>"+
				"<title>Login Page</title>"+
				"</head> "+
				"<body> "+msg;
		
			design= design +	"<form method='post' action='login' >"+
				"Userid<input type='text' name='userid'/> "+
				"<br> "+
				"Password<input type='password' name='pwd'/>"+
				"<br> "+
				"<input type='submit'/>"+
				"</form>"+
				"</body> </html>";
		return design;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println(doDesign(false));
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userid= request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		if(userid.equals(pwd)){
			RequestDispatcher rd = request.getRequestDispatcher("userwelcome");
			rd.forward(request, response);
			//response.sendRedirect("userwelcome?uid="+userid);
			//response.sendRedirect("welcome.html");
			//out.println("Welcome "+userid);
		}
		else
		{
			//out.println("Invalid Userid and password");
			out.println(doDesign(true));
			
		}
		out.close();
	}

}
