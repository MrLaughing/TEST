package ren.laughing.test.problem;

/**
 * 关于单例模式，考虑延迟加载lazy loading
 * 
 * @author Laughing
 * @time 2015年12月20日
 */
// 饿汉式
public class Singleton {
	private static final Singleton singleton = new Singleton();

	private Singleton() {

	}

	public Singleton getSingleton() {
		return singleton;
	}
}

// 懒汉式，安全，效率低，每次都要检查同步
class Singleton2 {
	private static Singleton2 singleton2;

	private Singleton2() {
	}

	public synchronized static Singleton2 getSingleton2() {
		if (singleton2 == null) {
			singleton2 = new Singleton2();
		}
		return singleton2;
	}
}

// 内部类
class Singleton3 {
	private Singleton3() {

	}

	private static class HanderSingleton3 {
		private static final Singleton3 singleton3 = new Singleton3();
	}

	public static Singleton3 getSingleton3() {
		// 外围类能直接访问内部类（不管是否是静态的）的私有变量
		return HanderSingleton3.singleton3;
	}
}

// 枚举 能防止反序列化重新创建对象
enum Singleton4 {
	INSTANCE;
	public void getSingleton4() {

	}
}

// 双重检锁 只在第一次创建对象时同步。
class Singleton5 {
	private volatile static Singleton5 singleton5;

	private Singleton5() {

	}

	public static Singleton5 getSingleton5() {
		if (singleton5 == null) {
			synchronized (Singleton5.class) {
				if (singleton5 == null) {
					singleton5 = new Singleton5();
				}
			}
		}
		return singleton5;
	}

}
