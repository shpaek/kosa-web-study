class Share{
	private int i;
	
	public void push() {
		for(int i=0; i<100; i++) {
			synchronized(this) { //잠금장치
				this.notify(); //이 공유객체를 사용하는 wait된 스레드를 깨운다
				System.out.print("Before push:i = " + this.i);
				this.i++;
				System.out.println(", After push:i = "+ this.i);
			}

		}
	}
	
	public void pop() {
		for(int i=0; i<100; i++) {
			synchronized(this) { //잠금장치
				if(this.i == 0) {
					try {
						this.wait(); //이 공유객체를 사용하는 현재 스레드를 일시중지한다
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("Before pop:i = " + this.i);
				this.i--;
				System.out.println(", After pop:i = "+ this.i);
			}
		}
	}

}
class Push extends Thread{
	private Share s;
	Push(Share s){
		this.s = s;
	}
	@Override
	public void run() {
		this.s.push();
	}
	
}
class Pop extends Thread{
	private Share s;
	Pop(Share s){
		this.s = s;
	}
	@Override
	public void run() {
		this.s.pop();
	}
	
}


public class ThreadShareTest {

	public static void main(String[] args) {
		Share s = new Share();
		
		//Push push = new Push();
		//push.s = s;
		Push push = new Push(s);
		Pop pop = new Pop(s);
		
		push.start();
		pop.start();

	}

}
