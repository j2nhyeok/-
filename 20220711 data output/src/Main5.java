import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main5 {

	public static void main(String[] args) {
		ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("d:\\filetest\\s1.ser")));
		
			oos.writeObject(new Student("학생1", 33, 3.0));
			oos.flush();
		
			
			
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("출력완료");
		
	}

}
