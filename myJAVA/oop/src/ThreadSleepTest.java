import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSleepTest {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		
		new Thread(()->{
			for(int i=0; i<10; i++) {
				Date dt = new Date();
				System.out.println(sdf.format(dt));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
	}

}
