//1) ReflectionTest.class 찾기
//2) JVM으로 로딩: Load time Dynamic Load ->
//				ReflectionTest, Object, String, ClassNotFoundException, Class 5개
//3) 바이트코드 검색
//4) 0과 1로 재해석, Method영역에 기억
//5) static 변수 자동 초기화
//6) main()호출

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionTest {
	public static void test(String className) throws ClassNotFoundException {
		Class c = Class.forName(className);
		Field[] fields = c.getDeclaredFields();
		for(Field f: fields) {
			System.out.println(f.getName());
		}
		System.out.println("-------------");
		Method[] methods = c.getDeclaredMethods();
		for(Method m: methods) {
			System.out.println(m.getName());
		}
		

		try {
			Object obj = c.getDeclaredConstructor().newInstance();
			System.out.println(obj); //obj.toString() 자동 호출됨
			
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("클래스이름을 입력하세요 ex)java.util.Date:");
		String className = sc.nextLine();
		test(className);
	}

}
