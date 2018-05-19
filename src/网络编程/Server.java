package 网络编程;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	/*public static void main(String[] args) {
		try {
			//服务端上打开8888端口进行监听
			ServerSocket serverSocket = new ServerSocket(8888);
			//8888端口监听，看是否有请求连接
			System.out.println("正在监听端口号:8888");
			Socket s = serverSocket.accept();
			System.out.println("有连接过来"+s);
			
			//打开输入流(接收客户端信息)
			InputStream is = s.getInputStream();
			//把输入流封装到DataInputStram中
			DataInputStream ds = new DataInputStream(is);
			//使用readUTF读取字符串
			String msg = ds.readUTF();
			//读取客户端发送的数据
			System.out.println("接收到来自Clinet的信息："+msg);
			ds.close();
			s.close();
			serverSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}*/
	/**
	 * 接收客户端消息 ，完成接收与发送
	 */
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("正在监听端口号:8888");
			Socket s = serverSocket.accept();
			
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			DataInputStream dis = new DataInputStream(s.getInputStream());
			
			while (true) {
				String msg = dis.readUTF();
				System.out.println("收到客户端信息为："+msg);
				Scanner sc = new Scanner(System.in);
				String str = sc.next();
				dos.writeUTF(str);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
