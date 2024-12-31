
//import java.sql package 
import java.sql.*;

public class JDBCProject1 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/project1db";
		String username = "root";
		String password = "root123";
		String query1 = "CREATE TABLE STUDENT(ROLL INT, NAME VARCHAR(15))";
		
		try {
//			load the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded Successfully!!!");
			
//			establish the connection
			Connection con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection established!");
			
			Statement stmt = con.createStatement();
			stmt.execute(query1);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
