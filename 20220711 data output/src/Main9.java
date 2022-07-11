import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class Main9 {

	public static void main(String[] args) {
		HashMap<Character, Character> decryption = new HashMap<>(); //복호화
		HashMap<Character, Character> encryption = new HashMap<>(); //암호화
		
		for (int i = 97; i <= 119; i++) {
			encryption.put((char) i, (char) (i - 29));
			decryption.put((char) (i - 29), (char) i);
		}
		
		int temp = 120;
		while(temp != 123) {
			encryption.put((char) temp, (char) (temp - 56));
			decryption.put((char) (temp - 56), (char) temp);
			temp++;
		}
		
		decryption.put(' ', ' ');
		encryption.put(' ', ' ');
		
		
		

		FileReader inputStream = null; 
		try {
			inputStream = new FileReader("d:\\filetest\\secret.txt"); // 경로 지정

			int c;
			while ((c = inputStream.read()) != -1) { // 문자 하나를 읽어오는데 int형으로 반환 -> 더이상 읽을 것이 없다면 -1 을 리턴
				System.out.print(encryption.get((char) c)); // 문자형으로 반환하여 콘솔에 출력

			}
		} catch (FileNotFoundException e) { // 파일이 없을 경우 예외처리
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 파일이 없던 있던 무조건 수행해야함
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println();
		FileReader inputStream2 = null; 
		try {
			inputStream2 = new FileReader("d:\\filetest\\secret2.txt"); // 경로 지정

			int c;
			while ((c = inputStream2.read()) != -1) { // 문자 하나를 읽어오는데 int형으로 반환 -> 더이상 읽을 것이 없다면 -1 을 리턴
				System.out.print(decryption.get((char) c)); // 문자형으로 반환하여 콘솔에 출력

			}
		} catch (FileNotFoundException e) { // 파일이 없을 경우 예외처리
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally { // 파일이 없던 있던 무조건 수행해야함
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		
		
		
		

	}

}
