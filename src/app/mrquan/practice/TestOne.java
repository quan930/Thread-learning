package app.mrquan.practice;
class MyThread implements Runnable{
	private int num;
	@Override
	public void run() {
		for(int i = 0;i < 3;i++) {
			//同步代码块
			synchronized (this) {
				num--;
				System.out.println(num);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public MyThread(int num) {
		this.num = num;
	}
}

public class TestOne {
	public static void main(String[] args) {
		int num = 30;
		MyThread r1 = new MyThread(num);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		Thread t3 = new Thread(r1);
		t1.start();
		t2.start();
		t3.start();
	}

}
