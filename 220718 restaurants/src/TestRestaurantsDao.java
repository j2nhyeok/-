import java.sql.SQLException;
import java.util.Arrays;

public class TestRestaurantsDao {

	public static void main(String[] args) {
		RestaurantsDao dao = new RestaurantsDaoImpl();

		try {
			// int result = dao.create("테스트중1", "1234-5555", "부산 어딘가2");
			// System.out.println(result == 1);

			// int result = dao.update(1, "때ㅐ대대보목ㄹ", "3243-1353","부산 구석" );
			// System.out.println(result == 1); // 수정 성공할 시
			// System.out.println(dao.read(1)); // 입력한 id열만 가져오기

//			int result = dao.delete(4); //id가 4인거 삭제
//			System.out.println(result == 1);
//			System.out.println(dao.read()); // 테이블 전체 목록 가져오기
			
			RestaurantsDaoImpl impl = (RestaurantsDaoImpl) dao;;  //다운캐스팅
			int [] result = impl.create(Arrays.asList(
					new Restaurant(0, "배치1", "0102-1234", "배치주소1")
					,new Restaurant(0, "배치2", "1202-1634", "배치주소2")
					,new Restaurant(0, "배치3", "042-4574", "배치주소3")
					,new Restaurant(0, "배치4", "202-1234", "배치주소4")
					));
			
			System.out.println(Arrays.toString(result));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
