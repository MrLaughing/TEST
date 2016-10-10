package ren.laughing.test.thread;

import java.util.ArrayList;
import java.util.List;
/**
 * 再写生产者消费者模式！
 * @author Laughing_Lz
 * @time 2016年10月10日
 */
class Consumer implements Runnable {
	private Basket basket;
	// 构造器将basket注入

	public Consumer(Basket basket) {
		super();
		this.basket = basket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.basket.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 取苹果
		}
	}

}

class Producter implements Runnable {
	private Basket basket;
	private static int count = 0;
	// 构造器将basket注入

	public Producter(Basket basket) {
		super();
		this.basket = basket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.basket.put(count++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 放苹果
		}
	}

}

public class Basket {
	private List<String> list = new ArrayList<String>();// 放苹果

	public synchronized void put(int count) throws InterruptedException {
		// 先判断篮子是否满了
		if (list.size() >= 5) {
			try {
				System.out.println("篮子里已经满了！该线程等待取出苹果后再放入···");
				this.wait();// 等待拿苹果
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("放苹果：" + count);
		list.add("苹果:" + count);
		Thread.sleep(100);// 等待1秒
		this.notify();
	}

	public synchronized void get() throws InterruptedException {
		// 先判断篮子是否为空
		if (list.isEmpty()) {
			try {
				System.out.println("篮子里已经空了！该线程等待放入苹果后再取出	···");
				this.wait();// 等待放苹果
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("取出了" + list.get(0));
		list.remove(0);
		Thread.sleep(100);// 等待1秒
		this.notify();
	}

	public static void main(String[] args) {
		Basket basket = new Basket();
		new Thread(new Producter(basket)).start();
		new Thread(new Consumer(basket)).start();
	}
}
