package ren.laughing.test.jingdongfang;

import java.util.ArrayList;
import java.util.List;
/**
 * 用wait-notify实现的生产者消费者模型
 * @author Laughing_Lz
 * @time 2016年9月24日
 */
class Plate {
	private List<Object> apples = new ArrayList<Object>();

	public synchronized void putApple(Object apple) {
		if (apples.size() < 5) {
//			if (apples.size() > 0) {//放苹果不等待
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			apples.add(apple);
			System.out.println("放入了一个苹果:" + apple);
			notify();//唤醒另一线程
		} else {
			System.out.println("超出篮子承载数目：5！");
		}
	}

	public synchronized void getApple() {
		if (apples.size() == 0) {
			try {
				System.out.println("篮子空了！该线程等待放入苹果后再拿出···");
				wait();//等待生产线程
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Object apple = apples.get(0);
		// apples.clear();
		apples.remove(0);
		System.out.println("拿到一个苹果:" + apple);
		notify();
	}
}

class Add implements Runnable {
	private Plate applePlate;
	private String apple = "苹果";

	public Add(Plate applePlate) {
		this.applePlate = applePlate;
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			applePlate.putApple(apple + i);
		}
	}
}

class Get implements Runnable {
	private Plate applePlate;

	public Get(Plate applePlate) {
		this.applePlate = applePlate;
	}

	@Override
	public void run() {
		for (int i = 0; i < 6; i++) {
			applePlate.getApple();
		}
	}
}

public class SynchroTest {
	public static void main(String args[]) {
		Plate myPlate = new Plate();
		new Thread(new Add(myPlate)).start();
		new Thread(new Get(myPlate)).start();
	}
}
