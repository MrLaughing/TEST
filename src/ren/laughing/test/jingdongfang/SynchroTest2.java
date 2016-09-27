package ren.laughing.test.jingdongfang;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用阻塞队列实现生产者消费者模式
 * 
 * @author Laughing_Lz
 * @time 2016年9月24日
 */
class Producer implements Runnable {
	private final BlockingQueue<Object> sharedQueue;

	public Producer(BlockingQueue<Object> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Producer:" + i);
				sharedQueue.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class Consumer implements Runnable {
	private final BlockingQueue<Object> sharedQueue;

	public Consumer(BlockingQueue<Object> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumer:" + sharedQueue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

public class SynchroTest2 {
	public static void main(String args[]) {
		List<Object> linkedlist = Collections.synchronizedList(new LinkedList<Object>());//创建一个线程安全的linkedlist
		BlockingQueue<Object> sharedQueue = new LinkedBlockingQueue<Object>();
		new Thread(new Producer(sharedQueue)).start();
		new Thread(new Consumer(sharedQueue)).start();

	}
}
