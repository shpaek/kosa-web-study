class Single{
	static private Single s = new Single(); //static변수로 클래스 내에 생성자 만들기
	private Single() { //생성자를 외부에서 막아두기
		
	}
	
	static Single getInstance() { //메서드로 생성자 return
//		return null;
//		return new Single();
		return s;
	}

}
public class SingletonTest {

	public static void main(String[] args) {
		Single s1, s2;
//		s1 = new Single(); //ERROR
		s1 = Single.getInstance(); //OK
		s2 = Single.getInstance(); //OK
		System.out.println(s1 == s2);
	}

}
