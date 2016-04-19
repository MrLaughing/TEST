package com.laughing.test.thread;

public class MutiThread implements Runnable{
	public void test() throws InterruptedException{
		wait(200);
	}
	
	@Override
	public void run() {
		try {
			wait(500);//线程等待500ms
			notify();//唤醒线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Thread类其实也implements实现了Runnable类
	class MutiThread1 extends Thread{
		@Override
		public void run() {
			super.run();
		}
	}
	class Test{
		public void test1MutiThread(){
			MutiThread thread = new MutiThread();
			Thread newThread = new Thread(thread);//若类只能实现Runnable接口，需要将实现Runnable的类放在新建的Thread线程中
			newThread.start();
			newThread.run();
			MutiThread1 thread1 = new MutiThread1();
			thread1.setDaemon(true);//守护线程，是jvm执行最后退出前的唯一线程
			thread1.isDaemon();//判断是否是守护线程
			thread1.start();
			thread1.getState();//返回线程状态
			thread1.run();
		}
	}
	
}
