package com.my.tcp.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientTest {

	public static void main(String[] args) {
		Socket s = null;
		String serverIP = "127.0.0.1"; //"127.0.0.1" localhost; 네트워크가 연결되어있지 않아도 사용할 수 있는 자기 IP
		int serverPort = 5432;
		OutputStream oos = null;
		DataOutputStream dos = null;
		InputStream is = null;
		DataInputStream dis = null;
		Scanner sc = new Scanner(System.in);
		try {
			s = new Socket(serverIP, serverPort);
			System.out.println("서버와 연결 성공");
			oos = s.getOutputStream();
//			oos.write(65);
			dos = new DataOutputStream(oos);
//			dos.writeUTF("안녕하세요. 백서현입니다.");
			is = s.getInputStream();
			dis = new DataInputStream(is);
			
			String sendMsg;
			do {
				System.out.print("서버로 보낼 메시지(종료하려면 quit을 입력하세요):");
				sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);
				String receiveMsg = dis.readUTF();
				System.out.println("서버가 되돌려준 메시지:" + receiveMsg);
			}while(!sendMsg.equals("quit"));

			
		} catch (EOFException e) {
		} catch (UnknownHostException e) {
//			e.printStackTrace();
			System.out.println(serverIP + "서버는 존재하지 않습니다. 서버IP를 확인하세요");
		} catch (ConnectException e) { //자식예외
			System.out.println("서버가 실행되지 않았습니다. 서버실행을 확인하세요");
		} catch (SocketException e) { //부모예외
			System.out.println("서버가 강제종료되었습니다. 서버를 확인하세요");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//dos.close(); -> oos.close(); -> s.close(); => 생성한 순서와 반대로 닫아주기
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
				}
			}
		}
		
		
	}

}
