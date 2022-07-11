import java.io.File;

public class Main {

	public static void main(String[] args) {
//		File file = new File("d:\\test\\test.txt"); //외부에 파일 자원을 가리킴
//		System.out.println(file.getName());
//		System.out.println(file.getPath());
//		System.out.println(file.exists());// 파일이 존재하고 있는가.
//		
//		File f2 = new File("d:\\test\\asdf.txt"); //실제 파일이 아닌 외부 파일과 소통할 수 있는 객체	
//		
//		System.out.println(f2.getName());
//		System.out.println(f2.getPath());
//		System.out.println(f2.exists());// 파일이 존재하고 있는가.
		
		File dir = new File("d:\\test");  //폴더 디렉토리 가리킴
		System.out.println(dir.getName());
		System.out.println(dir.getPath());
		System.out.println(dir.exists());// 파일이 존재하고 있는가.
		
		System.out.println("파일인가요 ?  " + dir.isFile()); //파일인지 확인
		System.out.println("디렉토리인가요 ? " + dir.isDirectory()); //디렉토리인지 확인
	}
	
	

}
		