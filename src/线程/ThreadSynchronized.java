package 线程;

/**
 * 线程的同步机制
 * @Title:ThreadSynchronized
 * @Description:
 * 什么时候要同步？为什么要引入线程同步？
 * 1、为了数据的安全，尽管应用程序的使用率降低，但是为了保证数据总是安全的，必须加入线程同步机制。
 * 线程同步机制使程序编程了(等同)单线程
 * 2、什么条件下要使用线程同步？
 * 		第一：必须是多线程环境
 * 		第二：多线程环境共享同一个数据
 * 		第三：共享的数据涉及到修改操作
 * @author sky
 */
public class ThreadSynchronized {

	public static void main(String[] args) {
		
		//创建一个公共的账户
		Account account = new Account("actno-001",5000.0);
		//创建线程对同一个账户取款
		Processor7 pro =new Processor7(account);
		Thread t1 = new Thread(pro);
		t1.setName("t1");
		Thread t2 = new Thread(pro);
		t2.setName("t2");
		t1.start();
		t2.start();
	}
}

//取款线程
class Processor7 implements Runnable{

	//账户 
	Account act;
	public Processor7(Account act) {
		this.act = act;
	}
	@Override
	public void run() {
		act.withdraw(1000.0);
		System.out.println(Thread.currentThread().getName()+"取款1000元成功,余额:"+act.getBalance());
	}
	
}
//账户
class Account{
	private String actno;
	private double balance;
	public Account() {}
	public Account(String actno, double balance) {
		this.actno = actno;
		this.balance = balance;
	}
	
	public String getActno() {
		return actno;
	}
	public void setActno(String actno) {
		this.actno = actno;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	//对外提供一个取款方法
	public void withdraw(double money) {
		
		//把需要同步的代码，放到同步语句块中.this为共享对象
		/*
		 * 原理：t1线程和t2线程
		 * t1线程执行到此处，遇到了synchronized关键字，就会去找this的对象锁(内部标记对象有1和0两种状态)
		 * 如果找到this对象锁，则进入同步语句块中执行程序。当同步语句块中的代码
		 * 执行结束之后，t1线程归还this的对象锁
		 * 
		 * 在t1线程执行同步语句块的过程中，如果t2线程也过来执行以下代码，也遇到
		 * synchronized关键字，所以也去this的对象锁，但是该对象锁被t1线程持有。
		 * 只能在这等待this对象的归还。
		 */
		synchronized (this) {
			double after = balance - money;
			System.out.println(Thread.currentThread().getName()+"当前余额:"+after);
			//更新
			this.setBalance(after);
		}
		
	}
}











