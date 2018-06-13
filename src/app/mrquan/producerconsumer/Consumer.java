package app.mrquan.producerconsumer;

import java.util.Random;

public class Consumer implements Runnable{//线程消费者类
	private Cargo cargo;
	@Override
	public void run() {
		while(true) {
			cargo.consume(Thread.currentThread().getName());
			try {
				Thread.sleep((new Random().nextInt(4)+1)*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Consumer(Cargo cargo) {
		this.cargo = cargo;
	}
}
