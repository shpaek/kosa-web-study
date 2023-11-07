class A{
	static int si;
	int i;
	
	static void sm() {
//		System.out.println(this.i); //static 메서드 안에서 this 예약어 사용 불가
		//static메서드는 인스턴스를 생성하거나 생성하지 않아도 사용 가능하기 때문에...
		System.out.println(si); //static 변수는 사용 가능
	}
	void m() {
		System.out.println(this.i);
	}
}

public class StaticTest {

	public static void main(String[] args) {
		System.out.println(A.si);
//		System.out.println(A.i);
		
		A a1, a2;
		a1 = new A();
		a2 = new A();
		
		System.out.println(a1.i); //0
		System.out.println(a2.i); //0
		System.out.println(a1.si); //권장하지 않음. 클래스로 직접 접근하기
		System.out.println(a2.si);
		
		a1.i++;
		a1.si++;
		
		System.out.println(a1.i); //1
		System.out.println(a1.si); //1
		System.out.println(A.si); //1
		
		System.out.println(a2.i); //0
		System.out.println(a2.si); //1
		
		a1.m();
//		A.m();
		
		a1.sm();
		A.sm();
		
	}

}
