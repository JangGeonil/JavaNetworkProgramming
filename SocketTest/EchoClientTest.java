package SocketTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClientTest {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String ip = "183.99.6.38";
		int port = 7080;
		
		Socket sk = new Socket(ip,port);
		System.out.println("서버와 접속이 되었습니다.");
		
		
		//서버로 부터 데이터를 입력받는 스트림.
		InputStream ins = sk.getInputStream();
		InputStreamReader isr = new InputStreamReader(ins);
		BufferedReader bff = new BufferedReader(isr); 
		
		OutputStream ous = sk.getOutputStream();
		PrintWriter pout = new PrintWriter(ous, true);
		//키보드로 부터 데이터를 입력받는다.
		InputStreamReader inR = new InputStreamReader(System.in);
		BufferedReader bffKey = new BufferedReader(inR);
		
		
		
		String servermsg = "",sendMsg="";
		servermsg = bff.readLine();
		
		
		
		System.out.println("서버메세지 : "+servermsg);
		while((sendMsg = bffKey.readLine()) != null) {
			pout.println(sendMsg);
			servermsg = bff.readLine();
			System.out.println(servermsg);
		}
		
		inR.close();
		bffKey.close();
		bff.close();
		sk.close();
		
	}
}
