import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main6 {

	public static void main(String[] args) {
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(new FileInputStream("d:\\filetest\\s1.ser"));
			
			
			Student s = (Student)ois.readObject();// 오브젝트 형태로 알려주기 떄문에 다운 캐스팅 필요
			
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	
	}

}
