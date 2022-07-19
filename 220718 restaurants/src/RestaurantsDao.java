import java.sql.SQLException;
import java.util.List;

public interface RestaurantsDao {
	int create (String name, String phoneNumber, String address) throws SQLException;
	
	List<Restaurant> read() throws SQLException; //전체를 다 읽어서 목록을 만듦
	Restaurant read(int id) throws SQLException;  // 하나만 읽어옴 (id열)
	
	int update(int id, String name, String phoneNumber, String address) throws SQLException;
	
	int delete(int id) throws SQLException;
	
}
