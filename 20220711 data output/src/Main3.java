import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main3 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>(
				Arrays.asList(new Student("홍길동", 22, 2.5), new Student("둘리", 33, 3.3), new Student("도우너", 44, 4.4)));

		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(new File("d:\\filetest\\student.dat")));
			
			for(int i = 0; i < list.size(); i++) {
			Student s = list.get(i);
			
			dos.writeUTF(s.getName());
			dos.writeInt(s.getAge());
			dos.writeDouble(s.getScore());
			}
			dos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
