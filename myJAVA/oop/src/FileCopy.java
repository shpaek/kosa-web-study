import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("원본파일명:");
		String originFileName = sc.nextLine();
		
		System.out.println("복제본파일명:");
		String copyFileName = sc.nextLine();
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(originFileName);
		} catch (FileNotFoundException e) {
			System.out.println("원본파일이 없습니다");
//			e.printStackTrace();
			return;

		}
		
		try {
			fos = new FileOutputStream(copyFileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
//		int readValue;
		int readCnt; //읽어온 바이트수
		byte[] bArr = new byte[1024];
		try {
//			while( (readValue = fis.read()) != -1) {
//				fos.write(readValue);
//			}
			while((readCnt = fis.read(bArr)) != -1) {
				fos.write(bArr, 0, readCnt);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
