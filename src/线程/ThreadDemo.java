package 线程;

/**
 * 
 * @Title:ThreadDemo
 * @Description:线程的实现方式有2种，继承Thread类或者实现Runnable接口
 * @author sky
 * @date 2018年4月27日
 */
public class ThreadDemo {

	// 主线程，只有调用start()方法，才会分配线程栈空间，然后自动调用run()方法
	public static void main(String[] args) {
		 Thread t1 = new Processor1();
		 t1.setName("t1");
		 t1.setPriority(Thread.MAX_PRIORITY); //优先级10
		 t1.start();
		 Thread t2 = new Thread(new Processor2());
		 t2.setPriority(Thread.MIN_PRIORITY); //优先级1
		 t2.setName("t2");
		 t2.start();
		for(int i=0;i<10;i++) { 
			Thread.currentThread().setPriority(Thread.NORM_PRIORITY);//默认5 
		  System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
}

//继承Thread 
class Processor1 extends Thread{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}
	}
	
}

//实现接口(推荐使用),让该类可以继承 
class Processor2 implements Runnable{

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"-->"+i);
		}	
	}
	
}
