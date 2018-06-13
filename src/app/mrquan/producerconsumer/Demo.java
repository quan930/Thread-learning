package app.mrquan.producerconsumer;

public class Demo {

	public static void main(String[] args) {
		Cargo cargo = new Cargo();
		new Thread(new Producer(cargo),"生产者A").start();
		new Thread(new Producer(cargo),"生产者B").start();
		new Thread(new Consumer(cargo),"消费者A").start();
		new Thread(new Consumer(cargo),"消费者B").start();
		new Thread(new Consumer(cargo),"消费者C").start();
		new Thread(new Consumer(cargo),"消费者D").start();
	}
}
