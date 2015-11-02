package com.srivastava.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private Map<Integer,String> map = null;
	@Override
	public void init(){
		JDBC jdbc = new JDBC();
		try {
			map = jdbc.fetchCountry();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String design(){
		Locale locale = new Locale("fr","FR");
		String options = "";
		ResourceBundle rb = ResourceBundle.getBundle("messages",locale);
		String design= "<html><body><form action='RegServlet' method='post'>"+
				"Userid<input type='text' name='userid'/><br>"+
				"Password<input type='password' name='password'/><br>"+
				"Country <select name='country'>";
				if(map!=null && map.size()>0){
					for(Map.Entry<Integer, String> m : map.entrySet()){
						options = options + 
								"<option value='"+m.getKey()+"'>"+rb.getString(m.getValue())+"</option>";
					}
				}
				
				/*+ "<option value='1001'>"+rb.getString("indiakey")+"</option>"+
				"<option value='1002'>"+rb.getString("usakey")+"</option>"+*/
				design = design + options + "</select><br>"+
				"<input type='submit'></form></body></html>";
		return design;
				
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html; charset=UTF-8");
		
		out.println(this.design());
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		int country = Integer.parseInt(request.getParameter("country"));
		JDBC jdbc = new JDBC();
		UserDTO userDTO = new UserDTO();
		userDTO.setUserid(userid);
		userDTO.setPassword(password);
		userDTO.setCountryId(country);
		try {
			boolean isRegister = jdbc.regUser(userDTO);
			if(isRegister){
				out.println("Reg SuccessFully");
			}
			else
			{
				out.println("Not Able to register , try again");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
