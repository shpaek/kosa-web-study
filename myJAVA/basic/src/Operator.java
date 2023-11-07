
public class Operator{
    public static void main(String[] args){
        //���������
        int a, b, c;
        a = 2;
        b = 3;
        c = a + b; //������� �� ���Կ����: ������ �켱������ ����
        System.out.println(c); //5

        System.out.println( c + "1" ); //int+String 5 + "1"
        System.out.println( c + 1 + "2" ); //int+int+String 5 + 1 + "2" => "62"
        System.out.println( "2" + c + 1 ); //String+int+int "2" + 5 + 1 => "251"
        System.out.println( "2" + (c + 1) ); //=> "26"

        System.out.println( a / b ); //���� ������ ���� ����� ���� 0
        //System.out.println( a / 0 ); //������ 0���� ���� ����� ArithmeticException ���� �߻� �� ���α׷� �����
        System.out.println( c % a ); //������ ���� 1

        float f1, f2;
        f1 = 2F;
        f2 = 0F;
        System.out.println( f1 / f2 ); //�Ǽ��� 0���� ���� ����� Infinity

        //���Կ�����
        a = 2;
        a += 2; //a = a + 2;�� ����
        System.out.println( a );  //4
        a *= 3; //a = a * 3;
        System.out.println( a );  //12

        //���׿�����
        a = 2;
        a++; //a = a + 1; �Ǵ� a += 1;�� ����
        System.out.println( a );  //3

        a = 2;
        b = a++; //b = a; a++;
        System.out.println( a );  //3 
        System.out.println( b );  //2          

        a = 2;
        b = ++a; //++a; b = a;
        System.out.println( a );  //3 
        System.out.println( b );  //3

        byte by = 127;
        by++;
        System.out.println( by );  //-128(�ִ밪�� �Ѿ�� �ּҰ����� ���ư�)

        //�񱳿�����
        System.out.println( 1 > 0 );  //true
        System.out.println( 1 < 0 );  //false
        System.out.println( a%2==1 );  //true
        System.out.println( a%2!=1 );  //false    

        //��������
        System.out.println( 1 > 0 && a%2==1 );  //true
        System.out.println( 1 > 0 && a%2!=1 );  //false
        System.out.println( 1 < 0 && a%2==1 );  //false
        System.out.println( 1 < 0 && a%2!=1 );  //false

        System.out.println( 1 > 0 || a%2==1 );  //true
        System.out.println( 1 > 0 || a%2!=1 );  //true
        System.out.println( 1 < 0 || a%2==1 );  //true
        System.out.println( 1 < 0 || a%2!=1 );  //false    

        System.out.println( 1 & 2 );  //��Ʈ������
        System.out.println( true & false );  //��������

        System.out.println( !(a%2 ==1) );  //false

        //���׿�����
        System.out.println( a%2==1? "Ȧ��" : "¦��" );  //Ȧ��

        //����켱����
        System.out.println( 1+2*3/4 );  //2*3, 6/4, 1+1 ==>2
        System.out.println( (1+2)/3*4 );  //1+2, 3/3, 1*4 ==>4

    }
}