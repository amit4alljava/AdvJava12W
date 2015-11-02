package com.srivastava.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class JDBC {
	
	private Connection createConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava12w","root","root");
		return con;
	}
	
	public boolean regUser(UserDTO userDTO)throws SQLException,ClassNotFoundException{
		boolean isRegister = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			 con = this.createConnection();
			 pstmt = con.prepareStatement("insert into reg (userid,password, country)values(?,?,?)");
			 pstmt.setString(1, userDTO.getUserid());
			 pstmt.setString(2, userDTO.getPassword());
			 pstmt.setInt(3, userDTO.getCountryId());
			 int recordCount = pstmt.executeUpdate();
			 if(recordCount>0){
				 isRegister = true;
			 }
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return isRegister;
	}
	public Map<Integer,String> fetchCountry() throws SQLException,ClassNotFoundException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<Integer,String> map = new TreeMap<>();	
		try
		{
			con = createConnection();
			pstmt = con.prepareStatement("select id,name from country");
			rs = pstmt.executeQuery();
			while(rs.next()){
				map.put(rs.getInt("id"),rs.getString("name"));
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
		return map;
	}

}
