import java.io.File;
import java.io.IOException;

public class Main4 {

	public static void main(String[] args) {
		//d:\filetest\한글이름.txt
		
//		File fileKor = new File("d:\\filetest\\한글이름.txt");		
////		try {
////			System.out.println("생성됨? " + fileKor.createNewFile());
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
//		fileKor.renameTo(new File("d:\\filetest\\newname.txt")); //파일 이름 변경.
//		
		File mytext = new File("d:\\filetest\\mytext.txt"); //mytext를 가리키는 객체 생성
		mytext.delete(); // 삭제
		
	}

}
