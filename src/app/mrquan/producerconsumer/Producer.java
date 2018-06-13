package app.mrquan.producerconsumer;

public class Producer implements Runnable{//线程生产者类
	private Cargo cargo;
	@Override
	public void run() {
		while(true) {
			cargo.produce(Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Producer(Cargo cargo) {
		this.cargo = cargo;
	}
}
