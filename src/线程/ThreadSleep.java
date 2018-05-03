package 线程;

/**
 * 打断线程睡眠，利用异常处理机制
 * @Title:ThreadSleep
 * @Description:
 * @author sky
 * @date 2018年5月3日
 */
public class ThreadSleep {

	public static void main(String[] args) throws InterruptedException {
		//在线程启动5s后，打断线程的休眠
		Thread t1 = new Thread(new Processor3());
		t1.setName("t1");
		t1.start();
		//5s之后
		Thread.sleep(5000);
		//打断线程休眠
		t1.interrupt();
	}
}


class Processor3 implements Runnable{

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			Thread.sleep(1000000000); //interrupt()利用的是异常处理机制，发生异常
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
	
}
