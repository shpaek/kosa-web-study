package com.my.tcp.server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
class ServerThread extends Thread{
	private Socket s;
	private InputStream is = null;
	private DataInputStream dis =null;
	private OutputStream oos = null;
	private DataOutputStream dos = null;
	private List<ServerThread> list;
	private String clientIP;
	ServerThread(Socket s,
				List<ServerThread> list	) throws IOException{
		this.s = s;
		this.list = list;
		is = s.getInputStream();
		dis = new DataInputStream(is);		
		oos = s.getOutputStream();
		dos = new DataOutputStream(oos);
		InetAddress ip = s.getInetAddress(); //클라이언트IP정보
		clientIP = ip.getHostAddress();
		System.out.println(clientIP+"클라이언트가 접속했습니다");
		broadcast(clientIP + "님이 접속했습니다");
	}
	
	@Override
	public void run() {
		try {
			String receiveMsg;
			while(  !(receiveMsg = dis.readUTF()).equals("quit")           ) {
				broadcast(clientIP + ">" + receiveMsg);
			}
		} catch(EOFException e) {
		}catch(IOException e) {
			e.printStackTrace();
		}finally {			
			list.remove(this);
			System.out.println("클라이언트와의 연결이 종료되었습니다");
			broadcast(clientIP + "님이 나갔습니다");
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	private void broadcast(String msg) {
		for(ServerThread t: list) {
			try {
				t.dos.writeUTF(msg);
			}catch(IOException e) {
			}
		}
	}
}
public class ServerMultiThread {
	public static void main(String[] args) {
		int port = 5432;
		ServerSocket ss = null;
		Socket s = null;
		List<ServerThread>list = new Vector<>();//new ArrayList<>(); //일반화된 인터페이스타입
		//ArrayList<ServerThread> list = new ArrayList<>();//구체화된 클래스타입
		//Vector<ServerThread> list = new Vector<>();
		try {
			//while(){
			ss = new ServerSocket(port);
			System.out.println("클라이언트 접속을 기다리기");
			while(true){
				s = ss.accept();
				ServerThread t = new ServerThread(s, list);
				list.add(t);
				t.start();
			}	
		} catch(BindException e) {
			System.out.println(port +"포트가 이미 사용중입니다");
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}