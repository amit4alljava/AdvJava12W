package com.srivastava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.srivastava.dto.EmpDTO;

public class EmpDAO {
	private Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		Class.forName(rb.getString("drivername"));
		Connection con = DriverManager.
				getConnection(rb.getString("dburl"),
						rb.getString("userid"),rb.getString("password"));
		return con;
	}
	public ArrayList<EmpDTO> getEmployeeData(EmpDTO empDTO) throws SQLException, ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpDTO empObject = null;
		ArrayList<EmpDTO> empList = new ArrayList<>();
		try
		{
			con = this.getConnection();
			pstmt = con.prepareStatement("select id, name,salary from employee where salary>?");
			pstmt.setDouble(1, empDTO.getSalary());
			rs = pstmt.executeQuery();
			while(rs.next()){
				empObject = new EmpDTO();
				empObject.setId(rs.getInt("id"));
				empObject.setName(rs.getString("name"));
				empObject.setSalary(rs.getDouble("salary"));
				empList.add(empObject);
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return empList;
	}
}
