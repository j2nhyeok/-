import java.io.File;
import java.io.IOException;

public class Main3 {

	public static void main(String[] args) {
//		File file = new File("d:\\filetest"); //d드라이브 안에 filetest라는 디렉토리를 가리키는 객체
//		System.out.println("있긴 있냐 ? " + file.exists()); //아직 없기에 둘다 false   -> 밑에서 디렉토르가 만들어지므로 true
//		System.out.println("폴더임? " + file.isDirectory()); //false  => 밑에서 디렉토리가 만들어지므로 true로 변경됨
//		System.out.println("파일임? " + file.isFile()); //false
//		
//		boolean result = file.mkdir(); // mkdir은 make directory
//		System.out.println("디렉토리 생성여부 : " + result); // true    -> 재실행하면 이미 만들었으므로 false로 변경됨.
//		
//
//		//d드라이브에 filetest 폴더(디렉토리) 안에 abc 폴더를 생성해보세용.....!!
//		File abc = new File("d:\\filetest\\abc");
//		abc.mkdir(); // mkdir은 make directory
//		
//		
//		File file2 = new File("d:\\filetest\\abc\\..\\def"); // file2.getAbsolutePath()와 동일함
////		file2.mkdir();
//		
//		File file3 = file2.getCanonicalFile(); // 파일 객체를 반환.

		
		File textFile = new File("d:\\filetest\\mytext.txt");
		try {
			boolean result = textFile.createNewFile(); // 이미 같은 이름을 가진 파일이 있으면 생성이 안됨.
			System.out.println("생성됨?" + result);
		} catch (IOException e) {
			e.printStackTrace();
		} // 해당 경로에 파일을 생성.
		
		
		

	}

}
