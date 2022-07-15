import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// 테이블에 있는 데이터들을 콘솔창에 출력하기
public class Main3 {
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

	public static void selectAllBook() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = makeConnection();
			stmt = conn.createStatement();
			
			//resultset을 반환하는 executeQuery 따로 공부할 것. (SELECT문을 날릴 떈 executeQuery사용)
			rs = stmt.executeQuery("SELECT * FROM books");
			
			
			while(rs.next()) {           //한 줄씩 가져옴
				int id = rs.getInt("bookId");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				
				System.out.println(id + ", " + title + ", " + price);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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

	public static int insertBook(String title, int price) {
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			conn = makeConnection();
			stmt = conn.createStatement();

			result = stmt
					.executeUpdate("INSERT INTO books (title, price) VALUES (" + "'" + title + "' , " + price + ");");

			System.out.println(result + "행이 추가되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally { // 사용한 커넥션 닫아주기
			if (stmt != null) {
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
		return result;
	}

	public static void main(String[] args) { // 만든 커넥션 사용
		selectAllBook();

	}
}