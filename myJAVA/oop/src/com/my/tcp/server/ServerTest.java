package com.my.tcp.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) {
		int port = 5432;
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		DataInputStream dis = null;
		OutputStream oos = null;
		DataOutputStream dos = null;
		try {
			ss = new ServerSocket(port);
			System.out.println("클라이언트 접속을 기다리기");
			s = ss.accept();
			is = s.getInputStream();
			dis = new DataInputStream(is);
			oos = s.getOutputStream();
			dos = new DataOutputStream(oos);
			String receiveMsg;
			while(!(receiveMsg = dis.readUTF()).equals("quit")) {
				System.out.println("클라이언트가 보낸 메시지:" + receiveMsg);
				dos.writeUTF(receiveMsg);
			}

			
//			int readValue = is.read();
//			System.out.println("클라이언트가 보낸 메시지:" + (char)readValue);
//			String readValue = dis.readUTF();
//			System.out.println("클라이언트가 보낸 메시지:" + readValue);
		} catch (EOFException e) {
		} catch (BindException e) {
			System.out.println(port + "포트가 이미 사용중입니다");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("클라이언트와의 연결이 종료되었습니다");
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
				}
			}
		}
		
		
	}

}
