package 集合;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * fail-fast迭代器快速失败demo
 * “快速失败”也就是fail-fast，它是Java集合的一种错误检测机制。
 * 当多个线程对集合进行结构上的改变的操作时，有可能会产生fail-fast机制。
 * 记住是有可能，而不是一定。例如：假设存在两个线程（线程1、线程2），
 * 线程1通过Iterator在遍历集合A中的元素，在某个时候线程2修改了集合A的结构（是结构上面的修改，而不是简单的修改集合元素的内容），
 * 那么这个时候程序就会抛出 ConcurrentModificationException 异常，从而产生fail-fast机制。
 * @Title:FailFastDemo
 * @Description:
 * @author sky
 * @date 2018年4月26日
 */
public class FailFastDemo {

	private static List<Integer> list = new ArrayList<>();
	
	
	/**
	 * 线程1迭代list集合
	 * @Title:Thread1
	 * @Description:
	 * @author sky
	 * @date 2018年4月26日
	 */
	public static class Thread1 extends Thread {
		public void run() {
			Iterator<Integer> iterator = list.iterator();
			while(iterator.hasNext()) {
				int i = iterator.next();
				System.out.println("Thread1遍历集合:"+i);
//				try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}
	}
	
	/**
	 * 线程2在i==3时，修改list
	 * @Title:Thread2
	 * @Description:
	 * @author sky
	 * @date 2018年4月26日
	 */
	public static class Thread2 extends Thread{
		public void run(){
			int i = 0;
			while (i<100) {
				System.out.println("Thread2 run:"+i);
				if (i == 80) {
					list.remove(i);
				}
				i++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		for(int i = 0; i < 100; i++) {
			list.add(i);
		}
		new Thread1().start();
		new Thread2().start();
		
	}
	
	
}
