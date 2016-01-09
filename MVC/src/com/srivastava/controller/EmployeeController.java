package com.srivastava.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.srivastava.dao.EmpDAO;
import com.srivastava.dto.EmpDTO;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/Ctrl")
public class EmployeeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double salary = Double.parseDouble(request.getParameter("salaryTxt"));
		EmpDTO empDTO = new EmpDTO();
		empDTO.setSalary(salary);
		EmpDAO empDAO = new EmpDAO();
		try {
			ArrayList<EmpDTO> empList = empDAO.getEmployeeData(empDTO);
			request.setAttribute("empdata", empList);
			RequestDispatcher rd = request.getRequestDispatcher("gudemployeesearch.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
		
	}

}
