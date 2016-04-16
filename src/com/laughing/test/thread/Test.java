package com.laughing.test.thread;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		Example1 example1 = new Example1("example1");
		Example1 example2 = new Example1("example2");
		example1.setCount(5);
		Thread thread1 = new Thread(example1);
		Thread thread2 = new Thread(example1);
		thread1.setPriority(8);//优先级
		thread2.setPriority(2);
		thread1.start();//线程的调用需要用到操作系统的支持，线程获取CPU资源非顺序，所以多线程执行顺序并非顺序执行
		thread2.start();
//		thread1.wait();//final静态方法
//		thread1.yield();//final静态方法
		System.out.println("主线程");//主线程的优先级是5,是程序的入口
	}
}
