package ren.laughing.test.jingdongfang;

import java.util.ArrayList;
import java.util.List;

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
			notify();
			System.out.println("放入了一个苹果:" + apple);
		} else {
			System.out.println("超出篮子承载数目：5！");
		}
	}

	public synchronized void getApple() {
		if (apples.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Object apple = apples.get(0);
		// apples.clear();
		apples.remove(0);
		notify();
		System.out.println("拿到一个苹果:" + apple);
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
		new Thread(new Get(myPlate)).start();
		new Thread(new Add(myPlate)).start();
	}
}
