import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Member implements Serializable {
	private int number;
	private String name;
	private String phone;
	private String email;

	public Member(int number, String name, String phone, String email) {
		super();

		this.number = number;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Member [number=" + number + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

public class Main8 {

	public static List<Member> list = new ArrayList<>();
	public static List<Integer> numbers = new ArrayList<>();
	public static BufferedReader bf;
	public static BufferedWriter bw;

	public static void main(String[] args) throws NumberFormatException, IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		int selectNumber = 0;
		while (true) {
			System.out.println("\n ######################################");
			System.out.println("1. 회원 입력");
			System.out.println("2. 번호입력 후 해당하는 회원의 전화번호 출력하기");
			System.out.println("3. 프로그램 종료");
			System.out.println("4. 저장된 회원 보기");
			System.out.println("\n ######################################");

			selectNumber = Integer.parseInt(getData("번호를 입력하세요"));

			switch (selectNumber) {
			case 1:
				register();
				break;
			case 2:
				find();
				break;
			case 3:
				System.exit(0);
			case 4:
				System.out.println(list);
				break;
			default:
				System.out.println("1,2,3,4 중에 선택하세요.");
				break;
			}
		}

	}

	public static void register() {
		

		try {
			bw = new BufferedWriter(new FileWriter(new File("d:\\filetest\\clients.txt"), true));

			System.out.println("회원 등록을 시작합니다.");

			int number = Integer.parseInt(getData("번호를 입력하세요 : "));
			if (!numbers.contains(number)) {
				numbers.add(number);

				String name = getData("이름을 입력하세요 : ");
				String phone = getData("전화번호를 입력하세요 : ");
				String email = getData("이메일 주소를 입력하세요 : ");

				Member s = new Member(number, name, phone, email);

				list.add(s);

				bw.write(s.toString() + "\n");
			} else {
				System.out.println("중복된 아이디입니다");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void find() {
		int number = Integer.parseInt(getData("번호를 입력하세요. 해당 번호의 전화번호를 리턴합니다."));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNumber() == number) {

				System.out.print("찾으시는 번호의 전화번호는 : " + list.get(i).getPhone());
			}
		}
	}

	public static String getData(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);

		return sc.nextLine();
	}

}
