import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main4 {

	public static void main(String[] args) {
		DataInputStream dis = null;
		List<Student> list = new ArrayList<>();
	
		try {
			dis = new DataInputStream(new FileInputStream(new File("d:\\filetest\\student.dat")));

			while (true) {
				String name = dis.readUTF();
				int age = dis.readInt();
				double score = dis.readDouble();
				Student s = new Student(name, age, score);
				list.add(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			System.out.println("학생 정보 다 읽었음");
		}

		catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println(list);

	}

}
