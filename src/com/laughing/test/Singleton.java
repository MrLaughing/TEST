package com.laughing.test;
/**
 * 单例模式
 * @author Laughing
 * @time 2015年12月20日
 */
//饿汉式
public class Singleton {
	//私有静态变量，
	private static final Singleton singleton=new Singleton();
	//私有构造器
	private Singleton(){
		
	}
	//公共方法，以供调用
	public Singleton getSingleton(){
		return singleton;
	}
}
//懒汉式1:未考虑线程同步，不安全  synchronized
class Singleton1{
	private static Singleton1 singleton1=null;
	private Singleton1(){
		//私有构造器
	}
	public Singleton1 getSingleton1(){
		if(singleton1==null){
			singleton1=new Singleton1();
		}
		return singleton1;
		
	}
}
