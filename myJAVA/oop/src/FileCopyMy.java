import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMy {
	

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("복사할 원본파일명을 입력하세요:");
		String originFile = sc.nextLine();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(originFile);
		} catch (FileNotFoundException e) {
			System.out.println("복사할 원본파일이 없습니다");
			return;
		}
		

		System.out.println("붙여넣기할 파일명을 입력하세요:");
		String copyFile = sc.nextLine();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(copyFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		int readValue = -1;

		try {
			while( (readValue = fis.read()) != -1) {
				fos.write(readValue);
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
		System.out.println("복사되었습니다");
	}

}
