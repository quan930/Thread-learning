package app.mrquan.practice;

//线程同步
//synchronized关键字
//给一个方法增加synchronized修饰符之后就可以使它成为同步方法

//线程在执行同步方法时是具有排它性的。
//当任意一个线程进入到一个对象的任意一个同步方法时，这个对象的所有同步方法都被锁定了，
//在此期间，其他任何线程都不能访问这个对象的任意一个同步方法，直到这个线程执行完它所调用的同步方法并从中退出，从而导致它释放了该对象的同步锁之后。
//在一个对象被某个线程锁定之后，其他线程是可以访问这个对象的所有非同步方法的

public class Synchronized {
	private int count = 0;
	
	public static void main(String[] args) {
		Synchronized s = new Synchronized();
		s.dowork();
	}
	
	public synchronized void increment() {
		count++;
	}
	
	public void dowork() {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0;i < 10000;i++) {
					increment();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0;i < 10000;i++) {
					increment();
				}
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println(count);
	}
}
