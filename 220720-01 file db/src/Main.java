import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.greenart.dbutil.DBUtil;

public class Main {

	public static void main(String[] args) {
		try(Connection conn = DBUtil.getConnection();                    //괄호 안에는 열고 닫을 수 있는 문장만 올 수 있음. (선언하고 초기화 하는 문장만 가능) auto closer? 
				PreparedStatement pstmt = conn.prepareStatement("")){
			pstmt.setString(1,     "");
			
			try(ResultSet rs = pstmt.executeQuery();){
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream("")){
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

}
