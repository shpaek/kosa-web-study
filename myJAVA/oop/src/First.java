
public class First {
	static int smf; //static 필드
	int mf; //non-static 필드, 인스턴스변수
	public static void main(String[] args) {
		int lv; //local variable 지역변수
//		System.out.println(lv); //자동초기화가 안 되었기 때문에 컴파일 오류
//		System.out.println(smf); //자동초기화됨 0
		
//		System.out.println(mf); //Cannot make a static reference to the non-static field mf
		
		
		First one; //참조형 지역변수
		one = new First(); //인스턴스화 (객체만들기) 객체가 생성될 때 멤버변수인 mf가 자동초기화 됨
		System.out.println(one.mf); //0
		
	}

}
