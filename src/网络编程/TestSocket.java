package 网络编程;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 	判断本网段共有多少可用ip
 */
public class TestSocket {

	//获取本网段
	public static String getIPGate() throws UnknownHostException {
		InetAddress host = InetAddress.getLocalHost();
		String address = host.getHostAddress();
		String gate = address.substring(0, address.lastIndexOf("."));
		System.out.println("本机ip为:"+address);
		System.out.println("本机网段为:"+gate);
		return gate;
	}
	
	//判断ip地址是否可用
	private static boolean isReachable(String ip) {
		try {
			boolean reachable = false;
			//ping发送数据包1次
			Process exec = Runtime.getRuntime().exec("ping -n 1 "+ip);
			BufferedReader bf = new BufferedReader(new InputStreamReader(exec.getInputStream(), "gbk"));
			String line = null;
			StringBuffer sb = new StringBuffer();
			while((line = bf.readLine()) !=null) {
				if (line.length() != 0) {
					sb.append(line + "\r\n");
				}
			}
			//当出现TTL时候，说明ping成功
			reachable = sb.toString().contains("TTL");
			bf.close();
			return reachable;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, InterruptedException {
		String ipGate = getIPGate();
		List<String> list = Collections.synchronizedList(new ArrayList<>());
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		AtomicInteger number = new AtomicInteger();
		for(int i=0;i<255;i++) {
			String testIP = ipGate + "." + (i+1);
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					//判断ip是否可用
					boolean reachable = isReachable(testIP);
					if (reachable) {
						list.add(testIP);
					}
					synchronized (number) {
						System.out.println("已经完成:"+number.incrementAndGet()+"个ip测试");
					}
				}
			});
		}
		//等待所有线程结束，关闭线程池
		threadPool.shutdown();
		//等待线程池关闭，但是最多等待1个小时
		if (threadPool.awaitTermination(1, TimeUnit.HOURS)) {
			System.out.println("以下ip地址可以连接");
			for(String ip:list) {
				System.out.println(ip);
			}
			System.out.println("总共有："+list.size()+"个ip地址");
		}
	}
	
	
}
