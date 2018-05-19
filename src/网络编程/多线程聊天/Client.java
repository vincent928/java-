package 网络编程.多线程聊天;

import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			Socket socket =new Socket("127.0.0.1", 8888);
			new SendThread(socket).start();
			new RecieveThread(socket).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
