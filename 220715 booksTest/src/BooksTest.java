

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import kr.go.greenart.booksmanager.BooksManager;

import java.sql.SQLException;
public class BooksTest {
	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;

	public BooksTest() {
		run();
	}

	public void run() {
		int selectNum = 0;
		while (true) {
			System.out.println("---------------------");
			System.out.println("1. 도서 추가 ");
			System.out.println("2. 전체 목록 ");
			System.out.println("3. 도서 삭제 ");
			System.out.println("4. 도서 수정 ");
			System.out.println("5. 시스템 종료");
			System.out.println("----------------------");

			selectNum = Integer.parseInt(getData("번호를 선택하세요 : "));

			switch (selectNum) {
			case 1:
				register();
				break;
			case 2:
				show();
				break;
			case 3:
				delete();
				break;
			case 4:
				update();
				break;
			case 5:
				System.exit(0);
				break;
			}

		}
	}


	public static void register() {
		String title = getData("추가할 책 제목 입력하세요 : ");
		int price = Integer.parseInt(getData("추가할 책의 가격을 입력하세요 : "));
		
		try {
			conn = BooksManager.getConnection();
			stmt = conn.createStatement();
			
			int result = stmt.executeUpdate("INSERT INTO books(title, price) VALUES ('" + title + "', " + price + ");");
			System.out.println(result + "행이 추가되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {   // 사용한 커넥션 닫아주기
			BooksManager.closeStmt(stmt);
			BooksManager.closeConn(conn);
		}
		
	}
	
	public static void show() {
		try {
			conn = BooksManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM books");
			
			while(rs.next()) {
				int id = rs.getInt("bookId");
				String title = rs.getString("title");
				int price = rs.getInt("price");
				
				System.out.println(id + ", " + title + ", " + price);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BooksManager.closeRS(rs);
			BooksManager.closeStmt(stmt);
			BooksManager.closeConn(conn);
		}
	}
	public static void delete() {
		String title = getData("삭제할 책 제목 입력하세요 : ");

		try {
			conn = BooksManager.getConnection();
			stmt = conn.createStatement();
			

			int result = stmt.executeUpdate("DELETE FROM books WHERE title = '" + title + "';");
			System.out.println(result + "개의 행이 삭제 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BooksManager.closeStmt(stmt);			
			BooksManager.closeConn(conn);
		}
		
	}
	
	public static void update() {
		
		try {
			conn = BooksManager.getConnection();
			stmt = conn.createStatement();

			String selectBooks = getData("수정할 책의 제목을 입력하세요.  \n");
			int temp = Integer.parseInt(getData("1. 책 제목 수정   2. 책 가격 수정 \n"));
			
			if(temp == 1) {
				String afterTitle = getData("어떤 제목으로 바꾸시겠습니까? : ");
				int result = stmt.executeUpdate("UPDATE books SET title = '" + afterTitle + "'"
						+"WHERE title = '"+ selectBooks +"';");
				
				System.out.println(result + "행이 수정 되었습니다 \n" 
									+ "( " + selectBooks + " -> " + afterTitle + ")");
			}
			else {
				int afterPrice = Integer.parseInt(getData("어떤 가격으로 바꾸시겠습니까? : "));
				int result = stmt.executeUpdate("UPDATE books SET price = " + afterPrice + " WHERE title = '" + selectBooks + "';");
				
				System.out.println(result + "행이 수정 되었습니다 \n" );
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	
			BooksManager.closeStmt(stmt);
			BooksManager.closeConn(conn);
		}
		
	
		
	}
	public static String getData(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.next();
	}
	


	public static void main(String[] args) {

		new BooksTest();
	}

}
