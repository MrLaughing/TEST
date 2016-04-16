package com.laughing.test.thread;

public class Example1 implements Runnable{
	private String name;
	private int count;
	public Example1() {
		super();
	}

	public Example1(String str) {
		this.name = str;
	}

	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			synchronized (this) {//同步代码/同步块
				if(count>0){
					try {
						Thread.sleep(500);//线程休眠0.5秒
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("线程"+name+"执行："+count--);
				}
			}
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
