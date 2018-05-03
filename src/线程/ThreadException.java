package 线程;

/**
 *  
 * @Title:ThreadException
 * @Description:
 * @author sky
 */
public class ThreadException {

	public static void main(String[] args) throws InterruptedException{
		
		Thread t1 = new Processor();
		t1.setName("t1");
		t1.start();
		
		//阻塞主线程 
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"--->"+i);
			Thread.sleep(500);
		}
		
	}
}


class Processor extends Thread{
	
	//Thread中的run方法不抛出异常，所以重写run方法之后，在run方法
	//声明位置上不能使用throws，所以只能用try..catch..
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"--->"+i);
			try {
				Thread.sleep(1000);  //让当前线程阻塞1s
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
}
