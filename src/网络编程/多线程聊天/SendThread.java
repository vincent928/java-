package 网络编程.多线程聊天;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{

	private Socket s;
	public SendThread(Socket s) {
		this.s = s;
	}
	
	//线程方法
	@Override
	public void run() {
		try {
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			while (true) {
				Scanner sc =new Scanner(System.in);
				String str=sc.nextLine();
				dos.writeUTF(str);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
