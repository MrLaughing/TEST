package com.laughing.test.thread;

public class Example2 extends Thread{
	private String name;

	public Example2() {
		super();
	}

	public Example2(String name) {
		this.name = name;
	}
	@Override //重写 父类和子类之间的多态性
	public void run() {
		for(int i = 0;i<5;i++){
			System.out.println("线程"+name+"执行："+i);
		}
	}
	
	
	
	
	public void test1(int i,String j){
		
	}
	//重载overload 单个类内的多态
	public void test1(int i){
		
	}
	
}
