import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;
public class Main {
	public static void main(String[] args) {
		Statement stmt = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db","root","root");
			 
			 // table A : 컬럼 B VARCHAR(10) PK
			 String query = "CREATE TABLE A (B VARCHAR(10) PRIMARY KEY);";
			 stmt = conn.createStatement();
			 
			 String query1 = "DROP TABLE A";
			 
			 
			 stmt.executeUpdate(query); //명령어 날리기.
			 stmt.executeUpdate(query1);
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
