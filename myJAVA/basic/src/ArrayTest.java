
public class ArrayTest {

	public static void main(String[] args) {
		int[] arr;
		arr = new int[4];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 33;
		arr[3] = 40;
		System.out.println(arr.length); //4
		
		int totalScore = 0;
//		totalScore += arr[0];
//		totalScore += arr[1];
//		totalScore += arr[2];
		
		int length = arr.length; //과목수
//		for(int i=0; i<length; i++) {
//			totalScore += arr[i];
//		}
		for(int score: arr) {
			totalScore += score;
		}
		float avg = (float)totalScore / length;
		System.out.println("totalScore=" + totalScore + ", avg=" + avg);
		
		int[][] arrTwo = new int[3][2];
		int num = 1;
//		arrTwo[0][0] = 1;
//		arrTwo[0][1] = 2;
//		for(int col=0;  col<2;  col++, num++) {
//			arrTwo[0][col] = num;
//		}
		
//		arrTwo[1][0] = 3;
//		arrTwo[1][1] = 4;
//		for(int col=0;  col<2;  col++, num++) {
//			arrTwo[1][col] = num;
//		}
//		
//		arrTwo[2][0] = 5;
//		arrTwo[2][1] = 6;
//		for(int col=0;  col<2;  col++, num++) {
//			arrTwo[2][col] = num;
//		}
		int rowLength = arrTwo.length;
		for(int row=0; row<rowLength; row++) {
			int colLength = arrTwo[row].length; //2
			for(int col=0; col<colLength; col++, num++) {
				arrTwo[row][col] = num;
			}
		}
		
		System.out.println(arrTwo);
		for(int row=0; row<rowLength; row++) {
			int colLength = arrTwo[row].length; //2
			for(int col=0; col<colLength; col++) {
				System.out.print(arrTwo[row][col] + ",");
			}
			System.out.println();
		}	
		
		
		int[][] arrTwo2 = new int[3][]; //행별 열수 다르게 하기
		arrTwo2[0] = new int[1];
		arrTwo2[1] = new int[2];
		arrTwo2[2] = new int[3];
		System.out.println(arrTwo2.length); //3
		System.out.println(arrTwo2[0].length); //1
		System.out.println(arrTwo2[1].length); //2
		System.out.println(arrTwo2[2].length); //3
		
		
//		arrTwo2[0][0] = 1;
//		
//		arrTwo2[1][0] = 2;
//		arrTwo2[1][1] = 3;
//		
//		arrTwo2[2][0] = 4;
//		arrTwo2[2][1] = 5;
//		arrTwo2[2][2] = 6;
		
		
		
		num = 1;
		rowLength = arrTwo2.length;
		for(int row=0; row<rowLength; row++) {
			int colLength = arrTwo2[row].length; //2
			for(int col=0; col<colLength; col++, num++) {
				arrTwo2[row][col] = num;
			}
		}
		
		for(int row=0; row<rowLength; row++) {
			int colLength = arrTwo2[row].length; //2
			for(int col=0; col<colLength; col++) {
				System.out.print(arrTwo2[row][col] + ",");
			}
			System.out.println();
		}
		
		
		int[] arr1 = {1, 10, 5, 3, 4, 5, 3, 2, 6, 8, 6, 3};
		int[] arr2 = new int[10]; //[0]는 1의 출현횟수 누적공간
		
		System.out.println("숫자의 출현횟수를 출력하시오");
//		arr2[arr1[0]-1]++;
//		arr2[arr1[1]-1]++;
//		arr2[arr1[2]-1]++;
		
//		for(int i=0; i<arr1.length; i++) {
//			arr2[arr1[i]-1]++;
//		}
		
		for(int value : arr1) {
			arr2[value-1]++;
		}
		
		for(int i=0; i<arr2.length; i++) {
			System.out.println((i+1)+"의 출현횟수-" + arr2[i] + "회");
		}
		
		
		/* ex)
		 * 1의 출현횟수-1회
		 * 2의 출현횟수-1회
		 * 3의 출현횟수-3회
		 * 4의 출현횟수-1회
		 * 5의 출현횟수-2회
		 * 6의 출현횟수-2회
		 * ...
		 */
		
		int[] arr3 = {5, 4, 7, 1, 2};
		System.out.println("최대값을 계산하시오");
		int max = arr3[0];
		for(int i=0; i<arr3.length; i++) {
			if(arr3[i] > max) {
				max = arr3[i];
			}
		}System.out.println(max);
		
		int[] arr4 = {5, 4, 7, 1, 2};
		//정렬하기
//		int temp = 0;
//		for(int i=1; i<arr4.length; i++) {
//			for(int j=0; j<arr4.length-i; j++) {
//				if(arr4[j] > arr[j+1]) {
//					temp = arr4[j];
//					arr4[j] = arr4[j+1];
//					arr4[j+1] = temp;
//				}
//
//			}
//		}
		
		for(int i=0; i<arr4.length; i++) {
			System.out.println(arr4[i]);
		}
		
		
		int[] lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45+1); //1<= <46
			for(int j=0; j<i; j++) { //중복확인
				if(lotto[i] == lotto[j]) { //중복된 경우
//					continue;
					i--;
					break;
				}
//				System.out.println("중복안됨");
			}
		}
		
		for(int value: lotto) {
			System.out.print(value+",");
		}
		System.out.println();
		
		int[][] arrTwo3; //선언
		arrTwo3 = new int[5][]; //생성
		//행별 열생성
//		arrTwo3[0] = new int[1];
//		arrTwo3[1] = new int[2];
//		arrTwo3[2] = new int[3];
//		arrTwo3[3] = new int[4];
//		arrTwo3[4] = new int[5];
		
		rowLength = arrTwo3.length; //5
		for(int i=0; i<arrTwo3.length; i++) {
			arrTwo3[i] = new int[i+1];
		}
		
		
//		arrTwo3[0][arrTwo3[0].length-1] = 1;
//		
//		arrTwo3[1][0] = 1;
//		arrTwo3[1][arrTwo3[1].length-1] = 1;
//		
//		arrTwo3[2][0] = 1;
//		arrTwo3[2][arrTwo3[2].length-1] = 1;
//		
//		arrTwo3[3][0] = 1;
//		arrTwo3[3][arrTwo3[3].length-1] = 1;
//		
//		arrTwo3[4][0] = 1;
//		arrTwo3[4][arrTwo3[4].length-1] = 1;
		
		
		for(int i=0; i<rowLength; i++) {
			arrTwo3[i][0] = 1;
			int colLength = arrTwo3[i].length;
			for(int j=1; j<colLength-1; j++) {
				arrTwo3[i][j] = arrTwo3[i-1][j-1] + arrTwo3[i-1][j];
			}
			arrTwo3[i][colLength-1] = 1;
		}
		
		for(int[] valueArr: arrTwo3) {
			for(int value: valueArr) {
				System.out.print(value+",");
			}
			System.out.println();
		}
		
		String[] subject = {"국어", "수학", "영어"};
		int subjectLength = subject.length;
		
		int[][] arrTwo4 = new int[10][subjectLength]; //최대 10명의 학생 점수(국어, 수학, 영어)
		
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int no = 0;
		
		while(no<10) {
//		while(true){
//			//학생수가 11인 경우에는 반복을 빠져나오기
//			if(no==10) {
//				break;
//			}
			
			System.out.print("점수입력을 진행하시겠습니까?[y/n]");
			String yn = sc.next();
			if(yn.equals("n")) {
				break;
			}else if(!yn.equals("y")) {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
				continue;
			}
			
			for(int i=0; i<subjectLength; i++) {
				System.out.print((no+1) + "번 학생의 "+ subject[i] + "점수:");
				arrTwo4[no][i] = sc.nextInt();
			}
			no++;
			
		}
//			System.out.print((no+1) + "번 학생의 국어점수:");
//			int k = sc.nextInt();
//			arrTwo4[no][0] = k;
//
//			System.out.print((no+1) + "번 학생의 수학점수:");
//			int m = sc.nextInt();
//			arrTwo4[no][1] = m;
//
//			System.out.print((no+1) + "번 학생의 영어점수:");
//			int e = sc.nextInt();
//			arrTwo4[no][2] = e;
			
		
		//학생들의 점수를 출력하기
		//1번 학생점수: 국어- , 수학- , 영어- , 총점- , 평균-
		//2번 학생점수: 국어- , 수학- , 영어- , 총점- , 평균-
		int[] totalScoreSubject = new int[subjectLength]; //과목별 총점
		System.out.println("학생들의 점수를 출력하기");
		for(int i=0; i<no; i++) {
			System.out.print((i+1)+"번 학생점수:");
			totalScore = 0; //학생별 총점
			for(int j=0; j<subjectLength; j++) {
				totalScore += arrTwo4[i][j];
			}
			
			for(int j=0; j<subjectLength; j++) {
				System.out.print(subject[j] + "-");
				System.out.print(arrTwo4[i][j] + ", ");
			}
			System.out.println("총점-" + totalScore + ", 평균-" + (float)totalScore/3 );
			
			
			//과목별 총점 누적하기
			
			for(int j=0; j<subjectLength; j++) {
				totalScoreSubject[j] += arrTwo4[i][j];
			}
		}
		for(int j=0; j<subjectLength; j++) {
			System.out.println(subject[j] + "과목평균:" + (float)totalScoreSubject[j]/no);
		}
		


		
		
	}

}
