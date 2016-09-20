package ren.laughing.test.huayu;

import java.util.Scanner;

/**
 * 题目为计算从某点垂直松开小球，小球弹跳落地后经过的总距离和下次弹跳可达到的高度，假设每次弹跳返回上次高度的1/2
 * 
 * @author Laughing_Lz
 * @time 2016年9月20日
 */
public class Bounce {
	/**
	 * 
	 * @param height
	 *            最高点
	 * @param n
	 *            弹跳次数
	 */
	public void GetBounce(double height, int n) {
		double sum = height;
		for (int i = 1; i < n; i++) {
			height = height / 2;
			sum += height*2;
		}
		System.out.println("弹跳高度为：" + height / 2);
		System.out.println("弹跳总距离为" + sum);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int n = input.nextInt();
			new Bounce().GetBounce(10, n);
		}
		input.close();
	}
}
