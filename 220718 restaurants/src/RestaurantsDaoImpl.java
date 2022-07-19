import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.greenart.dbutil.DBUtil;

public class RestaurantsDaoImpl implements RestaurantsDao {
	private Restaurant resultMapping(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String phoneNumber = rs.getString("phoneNumber");
		String address = rs.getString("address");

		return new Restaurant(id, name, phoneNumber, address);
	}
   // 오버로드
	public int[] create(List<Restaurant> list) throws SQLException { // 여러개의 음식점 한 번에 넣기 // 같은 작업을 몰아서 한 방에 하는거 = 배치 작업
		String query = "INSERT INTO restaurant (name, phoneNumber, address) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);

			for (Restaurant r : list) {
				pstmt.setString(1, r.getName());
				pstmt.setString(2, r.getPhoneNumber());
				pstmt.setString(3, r.getAddress());
				pstmt.addBatch(); // batch = 일괄
			}

			return pstmt.executeBatch(); // int 배열을 반환함 전부 잘 반환하면 {1,1,1,1,...} 을 반환함
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}

	}

	@Override
	public int create(String name, String phoneNumber, String address) throws SQLException {
		String query = "INSERT INTO restaurant (name, phoneNumber, address) VALUES (?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			pstmt.setString(3, address);

			return pstmt.executeUpdate();
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);

		}

	}

	@Override
	public List<Restaurant> read() throws SQLException {
		String query = "SELECT * FROM restaurant";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Restaurant> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(resultMapping(rs));
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
		return list;
	}

	@Override
	public Restaurant read(int id) throws SQLException {
		String query = "SELECT * FROM restaurant WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return resultMapping(rs);
			}
		} finally {
			DBUtil.closeRS(rs);
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}

		return null;
	}

	@Override
	public int update(int id, String name, String phoneNumber, String address) throws SQLException {
		String query = "UPDATE restaurant SET name = ?, phoneNumber = ?, address = ? WHERE id = ? ";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNumber);
			pstmt.setString(3, address);
			pstmt.setInt(4, id);

			return pstmt.executeUpdate();
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);
		}
	}

	@Override
	public int delete(int id) throws SQLException {
		String query = "DELETE FROM restaurant WHERE ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, id);

			return pstmt.executeUpdate();
		} finally {
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);

		}
	}

}
