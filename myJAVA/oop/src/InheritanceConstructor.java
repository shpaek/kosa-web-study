
class ParentConstructor {
	ParentConstructor() {
		System.out.println("ParentConstructor()생성자 호출");
	}
	
	ParentConstructor(String name) {
		System.out.println("ParentConstructor("+name+")생성자 호출");
	}
}

class ChildConstructor extends ParentConstructor {
	ChildConstructor() {
		//super();가 생략됨
		System.out.println("ChildConstructor()생성자 호출");
	}
	
	ChildConstructor(int age) {
		super("권순영");
		System.out.println("ChildConstructor("+age+")생성자 호출");
	}
}

public class InheritanceConstructor {

	public static void main(String[] args) {
		ParentConstructor p=new ParentConstructor();
		ChildConstructor c=new ChildConstructor();
		
		ChildConstructor c1=new ChildConstructor(10);
		
	}

}
