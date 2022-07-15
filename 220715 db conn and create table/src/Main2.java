import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
	public static Connection makeConnection() { // CONNECTION 만들어줌
		String url = "jdbc:mysql://localhost:3306/my_db";
		String id = "root";
		String password = "root";

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void main(String[] args) { // 만든 커넥션 사용
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate("INSERT INTO books (title, price) VALUES ('SQL 연습2', 17000);");
			
			System.out.println(result + "행이 추가되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {   // 사용한 커넥션 닫아주기
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
