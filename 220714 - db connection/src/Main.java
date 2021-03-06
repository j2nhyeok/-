import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/world"; // 서버가 위치해있는 주소
		String id = "root";
		String password = "root";

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 적재 성공"); // 드라이버 매니저가 사용할 수 있게끔 클래스 등록 됨.

			conn = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결에 실패하였습니다.");
		} finally { // 썻으면 닫아줘야함.
			if (conn != null) {
				try {
					conn.close();
					System.out.println("연결을 닫았습니다.");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}