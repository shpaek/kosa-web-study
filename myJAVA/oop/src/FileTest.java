import java.io.File; //디렉토리에 대한 정보를 알아내는 라이브러리
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {

	public static void main(String[] args) {
		File f;
		f = new File("D:\\");
		if(f.isDirectory()) {//if(f.isDirectory()==true){
//			String[] list = f.list();
//			for(String sub: list) {
//				System.out.println(sub);
//			} //리스트의 이름 반환
			File[] files = f.listFiles(); //하위 디렉토리에 대한 정보, 파일에 대한 정보 반환
			for(File file: files) {
				String name = file.getName();
				if(file.isFile()) { //d:\\의 하위파일
					long fileSize = file.length();
					long lastModifiedTime = file.lastModified();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
					String formatStr = sdf.format(new Date(lastModifiedTime));
					System.out.println(name + "\t" + formatStr + "\t" + fileSize);
				}else { //d:\\의 하위폴더
					System.out.println("[" + name + "]");
				}
			}
		}
		
		String folder = "D:\\attache";
		File file = new File(folder);
		if(!file.exists()) { //if(file.exist() == false)
			boolean result = file.mkdir();
			if(result) {
				System.out.println(folder + "폴더가 생성되었습니다");
			}else {
				System.out.println(folder + "폴더가 생성 안되었습니다");
			}
		}else {
			System.out.println(folder + "폴더가 이미 존재합니다");
		}
		
		String fileName = "a.txt";
		File file1 = new File(file, fileName);
		try {
			if(!file1.exists()) {
				file1.createNewFile();
				System.out.println(fileName + "파일이 생성되었습니다");
			} else {
				System.out.println(fileName + "파일이 이미 존재합니다");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
