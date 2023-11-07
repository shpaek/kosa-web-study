//제공자코드
/**(문서용주석)
 * TV용 클래스이다
 * @author 백서현
 * @version 1.0
 */
class TV{
	boolean power;	
	int channel;
	int volume;
	
	/**
	 * 전원을 켠다
	 */
	void powerOn() {
		power = true; //현재 사용중인 객체(this)의 power 호출
	}
	
	/**
	 * 전원상태를 반환한다
	 * @return 전원이 켜진 상태면 true를 반환, 꺼진 상태면 false를 반환한다
	 */
	boolean isPower() {
		return power;
	}
	
	/**
	 * 채널을 설정한다
	 * @param i 설정할 채널값
	 */
	void setChannel(int i){
		channel = i;
	}
	
	/**
	 * 현재 채널값을 반환한다
	 * @return 현재 채널값
	 */
	int getChannel() {
		return channel;
	}
	
	/**
	 * 채널값을 1 증가한다
	 */
	void channelUp() {
		channel++;
	}
	
	/**
	 * 음량을 1 증가한다
	 */
	void volumeUp() {
		volume++;
	}
	
	/**
	 * 음량을 1 감소한다
	 * 단, 최소 음량은 0이다
	 */
	void volumeDown() {
		if(volume == 0) {
			return;
		}
		volume--;
	}
	
	/**
	 * 현재음량을 반환한다
	 * @return 음량
	 */
	int getVolume() {
		return volume;
	}
	
}


//사용자코드
public class WatchTV {

	public static void main(String[] args) {
		TV tv; //참조형지역변수선언
		tv = new TV();
		System.out.println(tv.power); //false
		System.out.println(tv.channel); //0
		System.out.println(tv.volume); //0
		
		tv.powerOn();
		boolean flag = tv.isPower();
		if(flag) { //flag == true
			System.out.println("전원이 켜졌습니다");
			tv.setChannel(11); //채널설정한다
			int ch = tv.getChannel(); //현재채널을 반환한다
			System.out.println("현재 채널은 " + ch); //11
			
			tv.channelUp();
			System.out.println("현재 채널은 " + tv.getChannel()); //12
			
			//음량을 20 증가
			for(int i=0; i<20; i++) {
				tv.volumeUp();
			}
			
			//음량을 50 감소
			for(int i=0; i<50; i++) {
				tv.volumeDown();
			}
			System.out.println("현재 음량은 " + tv.getVolume());
			
			
			
		}else {
			System.out.println("전원이 꺼졌습니다");
		}
		
		TV tv1 = new TV();
		
		tv1.powerOn();
		
	}

}
