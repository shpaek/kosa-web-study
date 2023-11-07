import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.my.customer.dto.Customer;

public class ObjectIOTest {
	public static void write() {
		/*
		 * 스트림: 바이트 출력스트림
		 * 필터스트림: 객체단위출력스트림
		 * 목적지: 파일
		 */
		String fileName = "a.ser";
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			oos.writeObject(new Date()); //Serializable Interface 이미 구현되어 있음
			Customer c = new Customer("id1", "p1", "n1", "a1"); //부모의 멤버변수는 직렬화되지 않으므로 부모에 인터페이스 구현
			oos.writeObject(c);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void read() {
		String fileName = "a.ser";
		ObjectInputStream ois = null;
//		ois = new ObjectInputStream(fileName); //직접 자원과 만날 수 없음
		try {
			ois = new ObjectInputStream(new FileInputStream(fileName));
			Object obj1 = ois.readObject();
			System.out.println(obj1.toString());
			
			Object obj2 = ois.readObject();
			System.out.println(obj2); //obj2.toString()자동호출됨
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

	public static void main(String[] args) {
		write();
		read();
	}

}
