import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class JDBC {

	public static ArrayList<EmployeeDTO> dynamicSQL(EmployeeDTO empDTO) throws SQLException, ClassNotFoundException{
		ArrayList<EmployeeDTO> empList = new ArrayList<>();
		boolean isWhere = false;
		Class.forName("com.mysql.jdbc.Driver"); // Lazy Class Loading
		// Step -2 Create a Connection
		//jdbc:oracle:thin:@localhost:port:dbname
		//jdbc:mysql://hostname:port/dbname
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava12","root","root");
		StringBuilder sb = new StringBuilder("select id,name,salary from employee");
		if(empDTO.getSalary()>0){
			isWhere = true;
			sb.append(" where salary>"+empDTO.getSalary());
		}
		if(empDTO.getId()>0  ){
			if(isWhere){
			sb.append(" and id="+empDTO.getId());
			}
			else
			{
				sb.append(" where id="+empDTO.getId());
				isWhere = true;
			}
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			EmployeeDTO empObject = new EmployeeDTO();
			empObject.setId(rs.getInt("id"));
			empObject.setName(rs.getString("name"));
			empObject.setSalary(rs.getDouble("salary"));
			empList.add(empObject);
		}
		rs.close();
		pstmt.close();
		con.close();
		return empList;
	}
	
	public static ArrayList<EmployeeDTO> getEmployeeData(String sal) throws ClassNotFoundException,SQLException {
		ArrayList<EmployeeDTO> empList = new ArrayList<>();
		// Step - 1 Load the Driver
		//oracle.jdbc.driver.OracleDriver
		Class.forName("com.mysql.jdbc.Driver"); // Lazy Class Loading
		// Step -2 Create a Connection
		//jdbc:oracle:thin:@localhost:port:dbname
		//jdbc:mysql://hostname:port/dbname
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava12","root","root");
		// Step -3 Do Query
		//Statement stmt = con.createStatement();
		PreparedStatement pstmt = con.prepareStatement("select id,name,salary from employee where salary>?");
		pstmt.setDouble(1, Double.parseDouble(sal));
		// ResultSet stores all the rows
		//ResultSet rs = stmt.executeQuery("select id,name,salary from employee where salary>"+sal);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){
			EmployeeDTO empDTO = new EmployeeDTO();
			empDTO.setId(rs.getInt("id"));
			empDTO.setName(rs.getString("name"));
			empDTO.setSalary(rs.getDouble("salary"));
			empList.add(empDTO);
			//System.out.println(+" "+rs.getString("name")+" "+rs.getDouble("salary"));
		}
		rs.close();
		pstmt.close();
		con.close();
		return empList;
	}

}
