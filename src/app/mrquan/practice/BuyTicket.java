package app.mrquan.practice;

class MyThreadT implements Runnable{
	private int ticket = 50;
	@Override
	public void run() {
		for(int i = 0;i < 20;i++) {
			sale();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public synchronized void sale() {//同步方法
		if(this.ticket > 0) {
			System.out.println(Thread.currentThread().getName()+"卖票，ticket = "+ticket--);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class BuyTicket {
	public static void main(String[] args) {
		MyThreadT mt = new MyThreadT();
		new Thread(mt,"票贩子A").start();
		new Thread(mt,"票贩子B").start();
		new Thread(mt,"票贩子C").start();
	}

}
