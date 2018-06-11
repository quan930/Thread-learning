package app.mrquan.practice;
//同步代码块

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SyncBlock {
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	
	
	public void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(new Random().nextInt(100));
		}
	}
	
	public void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(new Random().nextInt(100));
		}
	}
	
	public void process() {
		for(int i = 0;i < 1000;i++) {
			stageOne();
			stageTwo();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Strting......");
		SyncBlock s = new SyncBlock();
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				s.process();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				s.process();
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
		long end = System.currentTimeMillis();
		System.out.println("Time take	"+(end-start));
		System.out.println("list1:"+s.list1.size()+"\nlist2:"+s.list2.size());
	}
}
