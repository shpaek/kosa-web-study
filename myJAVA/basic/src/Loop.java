public class Loop{
    public static void main(String[] args){
        /*
        System.out.println("JAVA");
        System.out.println("JAVA");
        System.out.println("JAVA");
        System.out.println("JAVA");
        System.out.println("JAVA");
        */
//        int i = 0;
//        while( i < 5 ){
//            System.out.println("JAVA" + i);
//            i++; //1, 2, 3, 4, 5
//        }
    	
    	int i;
    	for(i=0; i<5; i++) {
    		System.out.println("JAVA" + i);
    	}


        int sum = 0;

        /*
        sum += 1; //sum=sum+1;
        sum += 2; //sum=sum+2; 
        sum += 3; //sum=sum+3;
        sum += 4; //sum=sum+4;
        sum += 5; //sum=sum+5;
        sum += 6; //sum=sum+6;
        sum += 7; //sum=sum+7;
        sum += 8; //sum=sum+8;
        sum += 9; //sum=sum+9;
        sum += 10; //sum=sum+10;
        */

//        i=1;
//        while( i <= 10 ){
//            sum += i;
//            i++;
//        }
        
        for(i=1; i<=10; i++) {
        	sum += i;
        }
        System.out.println( "1~10합:" + sum );


//        i=1;
//        sum=0;
//        //1~100합
//        while( i <= 100 ){
//            sum += i;
//            i++;
//        }
        for(i=1, sum=0; i<=100; i++) {
        	sum += i;
        }
        System.out.println( "1~100합:" + sum );

        
        System.out.println("1~100의 홀수합, 짝수합 계산하여 출력하시오");
        i=1;
        int oddSum = 0; //홀수합
        int evenSum = 0; //짝수합
        
//        while( i <= 100 ){
//            if( i%2 == 1 ){
//                oddSum += i;
//            }else{
//                evenSum += i;
//            }
//            i++;
//        }
        
        for( ; i<=100; i++) {
        	if( i%2 == 1 ){
              oddSum += i;
        	}else{
              evenSum += i;
        	}
        }
        System.out.println( "1~100홀수합:" + oddSum + ", 짝수합:" + evenSum );


        System.out.println("1~100의 숫자를 출력하시오");
//        i=1;
//        while( i <= 100 ){
//            if ( i > 1){
//                System.out.print(",");
//            }
//            System.out.print(i);
//            i++;
//        }
        for(i=1; i<=100; i++) {
        	if ( i > 1){
        		System.out.print(",");
        	}
        	System.out.print(i);
        }
        System.out.println();

        //값치환
        int a, b, temp;
        a=10;
        b=20;
        
        temp = a;
        a = b;
        b = temp;
        System.out.println("a=" + a + ", b=" + b);
        
        char ch = 'A';
//        System.out.println(ch); //A
//        ch++; //ch=ch+1;
//        
//        System.out.println(ch); //B
//        ch++;
//        
//        System.out.println(ch); //c
//        ch++;
//        
//        System.out.println(ch); //D
//        ch++;
//        
//        System.out.println(ch); //E
//        ch++;
        
//        while( ch <= 'Z') {
//        	System.out.print(ch);
//        	System.out.print(',');
////        	ch++;
////        	ch = ch + 1;는 실행되지 않음. ch+1을 하면, ch가 int로 자동 변환되어 계산이 되는데, ch는 char형식이기 때문
//        	ch = (char)(ch+1);
//        }
        
        for( ; ch<='Z'; ch++) {
        	System.out.print(ch);
        	System.out.print(',');
        }
        System.out.println();

        System.out.println("피보나치 수열 20개의 숫자를 출력하시오");
        //1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ......
        
        int bbNum = 1; //전전수
        int bNum = 0; //전수
        
//        int cNum = bbNum + bNum; //현재수
//        System.out.println(cNum);
//        bbNum = bNum; //전수를 전전수에 대입 전전수:0
//        bNum = cNum; //현재수를 전수에 대입 전수:1
//        
//        cNum = bbNum + bNum; //현재수:1
//        System.out.println(cNum);
//        bbNum = bNum; //전수를 전전수에 대입 전전수:1
//        bNum = cNum; //현재수를 전수에 대입 전수:1
//        
//        cNum = bbNum + bNum; //현재수:2
//        System.out.println(cNum);
//        bbNum = bNum; //전수를 전전수에 대입 전전수:1
//        bNum = cNum; //현재수를 전수에 대입 전수:2
//        
//        cNum = bbNum + bNum; //현재수:3
//        System.out.println(cNum);
        
        int cNum;
//        i=0;
//        while(i<20) {
//        	cNum = bbNum + bNum;
//        	System.out.print("[i=" + i + "]" + cNum + ",");
//        	bbNum = bNum;
//        	bNum = cNum;
//        	i++;
//  
//        }
        for(i=0; i<20; i++) {
        	cNum = bbNum + bNum;
        	System.out.print("[i=" + i + "]" + cNum + ",");
        	bbNum = bNum;
        	bNum = cNum;
        }
        System.out.println();
        
        System.out.println("1~10까지 출력하시오");
//        System.out.println(1);
//        System.out.println(2);
//        System.out.println(3);
//        System.out.println(4);
//        System.out.println(5);
//        System.out.println(6);
//        System.out.println(7);
//        System.out.println(8);
//        System.out.println(9);
//        System.out.println(10);
        
        i=0;
        while(i < 10) {
        	i++;
        	System.out.print(i + ",");
        }
//        for(i=0; i<10; ) {
//        	i++;
//        	System.out.print(i + ",");
//        }
        System.out.println();

        java.util.Scanner sc = new java.util.Scanner(System.in);
        
//        System.out.println("메시지를 입력하세요. 작업을 중단하려면 exit를 입력하세요:");
//        String line = sc.nextLine();
//        System.out.println("입력한 메시지:" + line);
//        System.out.println("메시지를 입력하세요. 작업을 중단하려면 exit를 입력하세요:");
//        line = sc.nextLine();
//        System.out.println("입력한 메시지:" + line);
//        System.out.println("메시지를 입력하세요. 작업을 중단하려면 exit를 입력하세요:");
//        line = sc.nextLine();
        
        //while() {}
        //for(; ;) {}
        String line;
        do {
          System.out.println("메시지를 입력하세요. 작업을 중단하려면 exit를 입력하세요:");
          line = sc.nextLine();
          System.out.println("입력한 메시지:" + line);
        }while(!line.equals("exit"));
        
        
        

        
        
        


    }
}