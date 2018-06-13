package app.mrquan.producerconsumer;

import java.util.Random;

public class Cargo {//货物类
	private int cargo;//货物件数
	private int max = 30;//最大值
	private boolean full = false;
	
	synchronized public void produce(String name) {//生产
		if(cargo==max) {
			System.out.println(name+":仓库已满不必生产");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			cargo++;
			System.out.println(name+":生产了1个产品\t仓库储量为:"+cargo);
			notifyAll();
		}
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	synchronized public void consume(String name) {//消费
		if(cargo==0) {
			System.out.println(name+":仓库以空");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			int num = new Random().nextInt(2)+1;
			if((cargo-num)<0) {
				num = cargo;
			}
			cargo-=num;
			System.out.println(name+":消费了"+num+"个产品\t仓库储量为:"+cargo);
			notifyAll();
		}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
