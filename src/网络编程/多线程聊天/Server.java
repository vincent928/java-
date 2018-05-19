package 网络编程.多线程聊天;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("正在监听端口:8888");
			Socket s = ss.accept();
			
			//启动发送消息进程
			new SendThread(s).start();
			//启动接收消息进程
			new RecieveThread(s).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
