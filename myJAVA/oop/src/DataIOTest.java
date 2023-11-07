import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {
	public static void write() {
		/*
		 * 스트림: 바이트출력스트림
		 * 필터스트림: 데이터타입단위 출력스트림
		 * 목적지: 파일
		 */
		String fileName = "a.dat"; //상대경로: oop(현재 프로젝트의 경로 - java -cp bin DataIOTest)
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream(fileName);
			dos = new DataOutputStream(fos);
			dos.writeInt(1);
			dos.writeFloat(2.3F);
			dos.writeBoolean(false); //일반편집기로 열어볼 수 없기 때문에 보안상 좋음. 데이터 타입별로 읽어야 함.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void read() {
		/*
		 * 스트림: 바이트입력스트림
		 * 필터스트림: 데이터타입단위 입력스트림
		 * 자원: 파일
		 */
		String fileName = "a.dat";
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			int i = dis.readInt();
			float f = dis.readFloat();
			boolean b = dis.readBoolean();
			System.out.println(i + ":" + f + ":" + b);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dis != null) {
				try {
					dis.close(); //연결 해제시에는 나중에 생성된 걸 먼저. 둘 중 하나만 닫아도 무관.
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
