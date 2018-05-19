package 网络编程.多线程聊天;

import java.io.DataInputStream;
import java.net.Socket;

public class RecieveThread extends Thread{

	private Socket s;
	public RecieveThread(Socket s) {
		this.s = s;
	}
	@Override
	public void run() {
		try {
			DataInputStream dis = new DataInputStream(s.getInputStream());
			while (true) {
				String msg = dis.readUTF();
				System.out.println("收到的消息:"+msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
