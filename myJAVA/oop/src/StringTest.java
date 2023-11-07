import java.util.StringTokenizer;

public class StringTest {
	public static void main(String[] args) {
		String s = "안녕하세요";
		char c = s.charAt(0); //'안'
		int size = s.length(); //5
		
		//팰린드롬 문자열
		s = "가나다라다나가";
		
//		if(s.charAt(0) != s.charAt(size-1)) {
//			System.out.println("Palindrome 문자열이 아닙니다");
//		}else if(s.charAt(1) != s.charAt(size-1-1)) {
//			System.out.println("Palindrome 문자열이 아닙니다");
//		}else if(s.charAt(2) != s.charAt(size-1-2)) {
//			System.out.println("Palindrome 문자열이 아닙니다");
//		}else {
//			System.out.println("Palindrome 문자열이 아닙니다");
//		}
		
		size = s.length();
		int i=0;
		for(; i<size/2; i++){
			if(s.charAt(i) != s.charAt(size-1-i)) {
				break;
			}
		}
		if(i == size/2) {
			System.out.println("Palindrome문자열입니다");
		}else {
			System.out.println("Palindrome문자열이 아닙니다");
		}
		
		s = "100:70:65"; //국어 수학 영어
		s = "100::65"; //수학은 응시안함
		String delim = ":";
		String[] arr = s.split(delim);
		for(String str : arr) { //"100", "", "65"
			if(str.equals("")) {
				System.out.println("미응시");
			}else {
				System.out.println(Integer.parseInt(str));
			}
		}
		
		System.out.println("----------------------------");
		StringTokenizer st = new StringTokenizer(s, delim); //빈문자열을 구문해내지 않음
		while(st.hasMoreTokens()) { //Token은 의미있는 문자열
			String str = st.nextToken();
			System.out.println(str);
		}
		
	}
		

}
