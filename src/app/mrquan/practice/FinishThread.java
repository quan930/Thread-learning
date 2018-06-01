package app.mrquan.practice;

import java.util.Scanner;

//结束线程的方法
//stop方法已经弃用，会导致线程非正常死亡
class RunRun implements Runnable{
	private volatile boolean isRunning = true;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			System.out.println("hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void finish() {
		isRunning = false;
	}
}

public class FinishThread {
	public static void main(String[] args) {
		RunRun run = new RunRun();
		Thread t = new Thread(run);
		t.start();
		Scanner in = new Scanner(System.in);
		in.nextLine();
		run.finish();
	}
}
