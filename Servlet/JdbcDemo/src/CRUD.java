import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CRUD {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver"); // Lazy Class Loading
		// Step -2 Create a Connection
		//jdbc:oracle:thin:@localhost:port:dbname
		//jdbc:mysql://hostname:port/dbname
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advjava12","root","root");
		PreparedStatement pstmt =  con.prepareStatement("insert into employee (id,name,salary) values(?,?,?)");
		pstmt.setInt(1, 1010);
		pstmt.setString(2, "Ram");
		pstmt.setDouble(3, 9090);
		int rowCount = pstmt.executeUpdate();
		if(rowCount>0){
			System.out.println("Insert Done...");
		}
		else
		{
			System.out.println("Error in Insertion");
		}
		pstmt.close();
		con.close();
		
	}

}
