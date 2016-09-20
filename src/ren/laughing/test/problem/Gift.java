package ren.laughing.test.problem;

import java.util.*;

/**
 * 微信红包，某金额的红包占总数一半以上，查找该红包
 * 
 * @author Laughing_Lz
 * @time 2016年9月11日
 */
public class Gift {
	public static int getValue(int[] gifts, int n) {
		int m = 0;// 计数
		int result = gifts[0];// 记录某红包
		for (int i = 0; i < gifts.length; i++) {
			int gift = gifts[i];
			for (int j = 0; j < gifts.length; j++) {
				if (gift == gifts[j]) {
					m++;
				}
			}
			if (m > n / 2) {
				result = gift;
				break;
			}
			m = 0;// 清除计数
		}
		if (m < n / 2) {
			return 0;
		}
		return result;
	}

	public static int getValue1(int[] gifts, int n) {
		Arrays.sort(gifts);// 对红包数组按大小重新排序
		int m = 0;// 计数
		for (int i = 0; i < gifts.length; i++) {
			if (gifts[i] == gifts[gifts.length / 2]) {
				m++;
			}
		}
		if (m > gifts.length / 2) {
			return gifts[gifts.length / 2];
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		int[] gifts = new int[] { 2, 2, 2, 3, 4, 5, 3, 2, 2 };
		int n = gifts.length;
		int result = getValue1(gifts, n);
		System.out.println(result);
	}
}