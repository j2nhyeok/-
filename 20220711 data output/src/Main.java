import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable { //직렬화 가능이라는 인터페이스 구현
	private String name;
	private int age;
	private transient double score; // 직렬화하는 대상에서 제
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	public Student(String name, int age, double score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		// 학생
		// 이름 : 문자열
		// 나이 : 정수
		// 학점 : 실수

		// 파싱하기
		BufferedReader bf = null;
		List<Student> list = new ArrayList<>();
		
		try {
			bf = new BufferedReader(new FileReader(new File("d:\\filetest\\students.txt")));

			while (true) {
				String name = bf.readLine();
				int age = Integer.valueOf(bf.readLine());
				double score = Double.valueOf(bf.readLine());

				Student s = new Student(name, age, score);
				list.add(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bf != null) {
				try {
					bf.close();		
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		System.out.println(list);
//		List<Student> list = new ArrayList<>(
//				Arrays.asList(new Student("홍길동", 22, 2.5), new Student("둘리", 33, 3.3), new Student("도우너", 44, 4.4)));
//
//		PrintWriter pw = null;
//
//		try {
//			pw = new PrintWriter(new File("d:\\filetest\\students.txt"));
//			for (int i = 0; i < list.size(); i++) {
//				Student s = list.get(i);
//				
//				pw.println(s.getName());
//				pw.println(s.getAge());
//				pw.println(s.getScore());
//				
//			}
//			pw.flush();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			pw.close();
//		}

	}

}
