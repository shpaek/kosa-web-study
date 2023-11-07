import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;


public class CollectionGenericTest {
	public static void test(Collection<String> c) { //컴파일러에 알리기 위해 generic 표현
		c.add("one");
		c.add("two");
		c.add("one");
		c.add("four");
		c.add("five");
		
		System.out.println("요소갯수:" + c.size());
		System.out.println(c); //c.toString() 자동호출됨.
		//Collection의 메서드가 아니라 하위 클래스가 오버라이딩한 메서드가 호출됨
		
		c.remove("one");
		System.out.println("one객체 삭제됨");
//		Iterator it = c.iterator();
//		while(it.hasNext()) { //방문할 요소가 있는가
//			Object e = it.next(); //요소 방문
//			System.out.println("저장된 요소:" + e);
//		}; 
		
		for(Object e: c) {
			System.out.println("저장된 요소:" + e);
		}
	}
	public static void main(String[] args) {
		Collection<String> c; //element generic
		//c = new Collection; //인터페이스는 new 키워드 사용 불가
		c = new ArrayList<>();
		test(c);
		System.out.println("------------------------");
		test(new HashSet<>());
		
	}

}
