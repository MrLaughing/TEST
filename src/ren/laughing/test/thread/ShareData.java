package ren.laughing.test.thread;

/**
 * 目的是对count进行加一操作，执行1000次，不过这里
 * 是通过10个线程来实现的，每个线程执行100次，正常
 * 情况下，应该输出1000。不过，如果你运行上面的程序，
 * 你会发现结果却不是这样。可以看出，对共享变量操作，
 * 在多线程环境下很容易出现各种意想不到的的结果。
 * 
 * @author Laughing_Lz
 * @time 2016年5月11日
 */
public class ShareData {
	public static int count = 0;

	public void addCount() {
		count++;
	}

	public static void main(String[] args) {
		final ShareData shareData = new ShareData();// 为什么是final？
		for (int i = 0; i < 10; i++) {// 十个线程
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {// 进入的时候暂停1毫秒，增加并发问题出现的几率
						Thread.sleep(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
					for (int j = 0; j < 100; j++) {
						shareData.addCount();
					}
					System.out.print(count + " ");
				}
			}).start();
		}
		try {// 主程序暂停3秒，以保证上面的程序执行完成
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("count=" + count);
	}
}
