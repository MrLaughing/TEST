package ren.laughing.test.shumashixun;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个线程，交换取出5个元素，直到list为空
 * 
 * @author Laughing_Lz
 * @time 2016年9月29日
 */
class SynList {
	public List list = new ArrayList();

	public synchronized void get5Counts1() {
		if (list.size() == 0) {
			System.out.println("list已为空，无法取出！");
		} else {
			System.out.println("执行线程1");
			for (int i = 0; i < 5; i++) {
				System.out.println(list.get(0));
				list.remove(0);
			}
			System.out.println("已取出5个");
			try {
				wait();// wait写在前面
				if (list.size() == 0) {
					System.out.println("list已为空，无法取出！");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notify();
		}
	}

	public synchronized void get5Counts2() {
		if (list.size() == 0) {
			System.out.println("list已为空，无法取出！");
		} else {
			System.out.println("执行线程2");
			for (int i = 0; i < 5; i++) {
				System.out.println(list.get(0));
				list.remove(0);
			}
			System.out.println("已取出5个");
			notify();// notify写在前面
			try {
				wait();
				if (list.size() == 0) {
					System.out.println("list已为空，无法取出！");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void set100Counts() {
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}
	}
}

class SynQueue1 implements Runnable {
	private SynList synList;

	public SynQueue1(SynList synList) {
		super();
		this.synList = synList;
	}

	@Override
	public void run() {
		while (synList.list.size() >= 5) {
			synList.get5Counts1();
		}
	}
}

class SynQueue2 implements Runnable {
	private SynList synList;

	public SynQueue2(SynList synList) {
		super();
		this.synList = synList;
	}

	@Override
	public void run() {
		while (synList.list.size() >= 5) {
			synList.get5Counts2();
		}
	}
}

public class SynQueue {
	public static void main(String[] args) {
		SynList synList = new SynList();
		synList.set100Counts();
		new Thread(new SynQueue1(synList)).start();
		new Thread(new SynQueue2(synList)).start();
		;
	}
}
