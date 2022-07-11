import java.io.File;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) {
		File file = new File(".\\"); // .\\은 현재 경로를 의미함. == 프로젝트 경로

		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.exists());

		System.out.println(file.getAbsolutePath());
		try {
			System.out.println(file.getCanonicalPath()); // 예외가 발생함. 이 예외는 무조건 처리해야하는 checked
		} catch (IOException e) {

			e.printStackTrace();
		}

		File fileParent = new File("..\\"); // ..\\은 상위 경로
		System.out.println(fileParent.getAbsolutePath());
		try {
			System.out.println(fileParent.getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			File file3 = file.getCanonicalFile().getParentFile(); // getCanonicalFile()현재 경로를 나타내는 파일의 객체를 반환  
																  // getParentFile() 상위파일 객체를 반환
			System.out.println(file3.getAbsolutePath());
			System.out.println(file3.getCanonicalPath());
			System.out.println(fileParent.equals(file3)); //표현 방식이 다르기 때문에 false가 나옴 -> 같은 표현 방식으로 만들어주면 됨
			System.out.println(fileParent.compareTo(file3));
			System.out.println(fileParent.getCanonicalFile().equals(file3));
			System.out.println(fileParent.getCanonicalFile().compareTo(file3));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
