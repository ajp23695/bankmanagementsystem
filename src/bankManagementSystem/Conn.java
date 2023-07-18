package bankManagementSystem;
import java.sql.*;

public class Conn {
	Connection con;
	Statement query;
	public Conn() {
		
		String dbUrl = "jdbc:mysql://localhost/bankmanagementsystem";
		String userName = "root";
		String password = "Prachu@1810";
		
		
		try {
	
			con = DriverManager.getConnection(dbUrl, userName, password);
			query = con.createStatement();
			
		} catch (Exception e) {
			
		}
		
	}
}
