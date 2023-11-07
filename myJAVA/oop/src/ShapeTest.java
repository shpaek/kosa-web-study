
class Shape { //컴파일 시 class Shape extends Object
	protected double area;
	
	void makeArea() {}
	
	double getArea() {
		return area;
	}
	
	public String toString() {
		return "도형의 면적은 "+area+"입니다";
	}
}

class Circle extends Shape {
	private int radius;

	Circle(int r) {
		radius=r;
	}

	int getRadius() {
		return radius;
	}
	
	void makeArea() {
		area=radius*radius*3.14;
	}
	
	public String toString() {
		return "반지름이 "+radius+"인 원 "+super.toString();
	}
}

class Rectangle extends Shape {
	private int width;
	private int height;
	
	Rectangle(int w, int h) {
		width=w;
		height=h;
	}
	
	void makeArea() {
		area=width*height;
	}
	
	public String toString() {
		return "가로"+width+", 세로"+height+"인 사각형 "+super.toString();
	}
}

class Triangle extends Shape {
	
}

public class ShapeTest { //컴파일 시 class ShapeTest extends Object

	public static void main(String[] args) {
//		Circle c=new Circle(5); //반지름이 5인 원 객체
//		System.out.println(c.getRadius()); //5
//		c.makeArea(); //원의 면적 계산
//		System.out.println(c.getArea()); //78.5
//		
//		Rectangle r=new Rectangle(3, 4); //가로3, 세로4인 사각형 객체
//		r.makeArea(); //사각형의 면적 계산
//		System.out.println(r.getArea()); //12.0
		
		Shape[] shapes=new Shape[5];
		shapes[0]=new Circle(5); //Upcasting
		shapes[1]=new Rectangle(3, 4); //Upcasting
		
		for(int i=0;i<2;i++) {
			shapes[i].makeArea();
			//System.out.println(shapes[i].getArea());
			System.out.println(shapes[i]); //shapes[i].toString()가 자동호출
			/* instanceof
			if(shapes[i] instanceof Circle) {
				Circle c=(Circle)shapes[i]; //Downcasting
				c.makeArea();
				System.out.println(c.getArea());
			} else if(shapes[i] instanceof Rectangle) {
				Rectangle r=(Rectangle)shapes[i]; //Downcasting
				r.makeArea();
				System.out.println(r.getArea());
			}
			*/
		}
	}

}
