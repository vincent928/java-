package 线程;

/**
 * 线程的合并
 * @Title:ThreadJoin
 * @Description:
 * @author sky
 */
public class ThreadJoin {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new Processor6());
		t1.setName("t1");
		t1.start();
		//合并线程
		t1.join(); //t1和主线程合并,最后变为1个栈空间
		//主线程
		for (int i = 0;i < 10;i++) {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
	
}

class Processor6  implements Runnable{
	public void run() {
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
}