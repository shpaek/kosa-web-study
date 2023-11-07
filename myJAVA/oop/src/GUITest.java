import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 * GUI프로그램순서
 * 1. 이벤트소스(bt)와 이벤트종류(ActionEvent)를 결정한다
 * 2. 이벤트처리용 클래스(이벤트핸들러)를 작성한다
 * class MyHandler implements ActionListener {
 * }
 * 3. 이벤트소스와 이벤트핸들러를 연결한다
 * 	  bt.addActionListener(new MyHandler());
 */
//class MyHandler implements ActionListener {
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		System.out.println("클릭되었습니다");
//		
//	}
//	
//}


public class GUITest {
	private JFrame f;
	private JButton bt;
	private JTextField t;

//	class MyHandler implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			t.setText("클릭되었습니다");
//		}
//	}
	
	
	
	
	public GUITest() {
		f = new JFrame("프레임"); //창
		bt = new JButton("클릭"); //버튼
		t = new JTextField("입력하세요"); //한줄입력란

		Container c = f.getContentPane(); //프레임뒷판
		c.setLayout(new FlowLayout());
		c.add(bt);
		c.add(t);
//		bt.addActionListener(new MyHandler()); //이벤트소스와 이벤트핸들러 연결
//		bt.addActionListener(new MyHandler(t));
//		bt.addActionListener(new ActionListener() { //익명 클래스 형태로 객체 생성(인터페이스 아님)
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				t.setText("클릭되었습니다");
//			}
//		});
		
		bt.addActionListener( (e)->{t.setText("클릭되었습니다");} );
		
		
		f.setSize(300, 200);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new GUITest();
	}

}