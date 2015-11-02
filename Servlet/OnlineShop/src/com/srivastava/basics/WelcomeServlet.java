package com.srivastava.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	
	int counter ;
	public void init(){
		counter = 0;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Enumeration<String> headers = request.getHeaderNames();
		response.addHeader("refresh", "2");
		while(headers.hasMoreElements()){
			String headerName = headers.nextElement();
			out.println("Header Name "+headerName+
					"Header Value "+request.getHeader(headerName));
			
		}
		counter++;
		
		out.println("Hello Client "+counter);
		out.close();
		
	}

}
