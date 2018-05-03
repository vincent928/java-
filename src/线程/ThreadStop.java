package 线程;

/**
 * 正确的终止一个正在执行的线程
 * 不能调用stop方法，可以加入一个判断条件，或者等run方法结束
 * @Title:ThreadStop
 * @Description:
 * @author sky
 */
public class ThreadStop {

	public static void main(String[] args) throws InterruptedException {
		//线程启动5s之后终止
		Processor4 p4 = new Processor4();
		Thread t1 =new Thread(p4);
		t1.setName("t1");
		t1.start();
		//5s之后终止
		Thread.sleep(5000);
		//终止
		p4.run = false;
	}
}
class Processor4 implements Runnable{

	boolean run = true;
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			if(run) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"-->"+i);
				
			}else {
				return;
			}
		}
	}
	
}
