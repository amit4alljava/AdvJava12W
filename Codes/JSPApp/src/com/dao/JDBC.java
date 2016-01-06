package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JDBC {
	public static ArrayList<CommonDTO> getData(String category) throws ClassNotFoundException, SQLException{
		ArrayList<CommonDTO> commonList = new ArrayList<>();
		String sql = "select * from common_generic_params where category=? and status='A'";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CommonDTO commonDTO = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_example","root","root");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,category);
			rs = pstmt.executeQuery();
			while(rs.next()){
				commonDTO = new CommonDTO();
				commonDTO.setCategory(rs.getString("category"));
				commonDTO.setDesc(rs.getString("descr"));
				commonDTO.setValues(rs.getString("value"));
				commonDTO.setStatus(rs.getString("status"));
				commonList.add(commonDTO);
			}
		}
		finally{
			if(rs!= null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
			
		}
		return commonList;
	}
}
