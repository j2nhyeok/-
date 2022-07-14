import kr.co.greenart.MyMath;
import kr.co.greenart.Person;

public class Main {

	public static void main(String[] args) {
		Person p = new Person("이름", 15);
		
		System.out.println(p);
		System.out.println(MyMath.getZero());
		System.out.println(MyMath.sum(10, 20));
	}

}


