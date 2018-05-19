package 网络编程;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		String host = inetAddress.getHostAddress();
		System.out.println(host);
	}
}
