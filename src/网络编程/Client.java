package 网络编程;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	/*public static void main(String[] args) {
		try {
			//连接到本机8888端口
			Socket s = new Socket("127.0.0.1", 8888);
			System.out.println(s);
			//打开输出流
			OutputStream os = s.getOutputStream();
			//把输出流封装在DataOutputStream中
			DataOutputStream ds = new DataOutputStream(os);
			//使用writeUTF发送字符串
			ds.writeUTF("Legendary");
			ds.close();
			System.out.println("发送到服务端信息：Legendary");
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	//使用Scanner接收输入
/*	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			//使用Scanner读取控制台的输入，并发送到服务端
			Scanner scanner = new Scanner(System.in);
			String str = scanner.next();
			dos.writeUTF(str);
			dos.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * 与服务端进行互动
	 */
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			while(true) {
				Scanner sc=new Scanner(System.in);
				String str =sc.next();
				dos.writeUTF(str);
				String msg =dis.readUTF();
				System.out.println("收到服务端信息为："+msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
