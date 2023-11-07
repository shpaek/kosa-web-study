//제공자코드
class Employee{
	String no;
	String name;
	int salary;
	
	void setNo(String no) {
		this.no = no; //this를 붙이지 않으면 왼쪽의 no는 매개변수를 의미. 멤버변수 아님
		//메서드 내에서 멤버변수와 매개변수의 이름이 같을 경우, 매개변수를 의미 (자기자신우선)
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setSalary(int salary) {
		this.salary = salary;
	}
	
	String getNo() {
		return no;
	}
	
	String getName() {
		return name;
	}
	
	int getSalary() {
		return salary;
	}
	
	void print() {
		System.out.println("사번:" + no + ", 사원명:" + name + ", 기본급:" + salary);
	}
	
	
}



//사용자코드
public class HR {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		String no = e1.no;
		System.out.println(no);	//null
		
		e1.setNo("2301"); //사번 설정한다
		e1.setName("백서현"); //사원명 설정한다
		e1.setSalary(1000); //기본급 설정한다
		System.out.println("사원의 사번-" + e1.getNo() + ", 사원명-" + e1.getName() + ", 기본급-" + e1.getSalary());
		e1.print(); //"사번:사번값, 사원명:사원명값, 기본급:기본급값"이 출력되도록 한다
		
		Employee eTemp; //참조형 변수에는 null값을 대입 또는 새로운 객체 생성 또는 이미 생성된 객체를 대입할 수도 있다
//		eTemp = null;
//		eTemp = new Employee();
		eTemp = e1; //같은 메모리를 참조. HEAP영역에 저장된 같은 Employee 객체의 주소값에 대입됨
		System.out.println(e1 == eTemp); //true
		eTemp.setSalary(2000);
		System.out.println(e1.getSalary());
		
		eTemp = null; //메모리 연결을 끊음
		System.out.println(eTemp); //null
		System.out.println(e1.getSalary()); //2000
//		System.out.println(eTemp.getSalary()); //NullPointerException 발생 후 프로그램 종료됨
		
		Employee[] employees; //선언. 지역변수는 자동초기화되지 않음
		//최대 20명의 사원이 저장될 수 있는 배열 생성
		employees = new Employee[20];
		employees[0] = e1;
		
		for(int i=2; i<=5; i++) {
			Employee e2 = new Employee();
			e2.setNo("230"+i); e2.setName("name"+i); e2.setSalary(1000);
			employees[i-1] = e2;
		}
		
		for(int i=0; i<5; i++) {
//		for(int i=0; i<employees.length; i++) { //NullPointerException 발생
			employees[i].print();
		}
		
//		Employee e2 = new Employee();
//		e2.setNo("2302"); e2.setName("name2"); e2.setSalary(1000);
//		employees[1] = e2;
//		
//		Employee e3 = new Employee();
//		e2.setNo("2303"); e2.setName("name3"); e2.setSalary(1000);
//		employees[2] = e3;
//		
//		Employee e4 = new Employee();
//		e2.setNo("2304"); e2.setName("name4"); e2.setSalary(1000);
//		employees[3] = e4;
//		
//		Employee e5 = new Employee();
//		e2.setNo("2305"); e2.setName("name5"); e2.setSalary(1000);
//		employees[4] = e5;
		
		
	}

}
