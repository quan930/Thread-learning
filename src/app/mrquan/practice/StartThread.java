package app.mrquan.practice;

/*
.--,       .--,
( ( \.---./  ) )
'.__/o   o\__.'
   {=  ^  =}
    >  -  <
   /       \
  //       \\
 //|   .   |\\
 "'\       /'"_.-~^`'-.
    \  _  /--'         `
  ___)( )(___
 (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
*/

//开启线程的两种常见方法
class RunThread extends Thread{
	//方法一继承Thread类创建线程
	@Override
	public void run() {
		for(int i = 0;i < 10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class RunRunnable implements Runnable{
//实现Runnable接口创建线程
	@Override
	public void run() {
		for(int i = 0;i < 100;i++) {
			System.out.println("\t"+i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class StartThread {
	public static void main(String[] args) {
		RunThread thread1 = new RunThread();
		thread1.start();
		Thread thread2 = new Thread(new RunRunnable());
		thread2.start();
	}
}
