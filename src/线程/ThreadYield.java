package 线程;

/**
 * Thread.yieId():
 * 1、该方法是静态方法
 * 2、作用：让位给同优先级的线程执行，不能指定暂停多长时间
 * 3、和sleep方法相同，yieId时间不固定 
 * @Title:ThreadYield
 * @Description:
 * @author sky
 */
public class ThreadYield {

	public static void main(String[] args) {
		
		Thread t1 = new Processor5();
		t1.setName("t1");
		t1.start();
		//主线程中
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
}

class Processor5 extends Thread{

	@Override
	public void run() {
		
		for(int i=0;i<100;i++) {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
			if(i % 20 == 0) {
				Thread.yield();
			}
		}
	}
	
}