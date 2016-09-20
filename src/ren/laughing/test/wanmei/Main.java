package ren.laughing.test.wanmei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//求数组中最长递增子序列
public class Main {
	public static void main(String[] args) {
		int a[] = { 1, 5, 8, 3, 6, 7, 2, 9 };
		find1(a);
	}

	public static void find1(int[] a) {
		int length = a.length;
		int[] list = new int[length];// 存储第i个元素之前的最长递增序列值
		List<Integer> result = new ArrayList<Integer>(); // 存储最长递增序列
		for (int i = 0; i < length; i++) {
			list[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && list[j] + 1 > list[i]) {
					list[i] = list[j] + 1;
//					if (result.isEmpty()) {
//						result.add(a[j]);
//					}
					if (!result.contains(a[i])) {
						result.add(a[i]);
					}
				}
			}
		}
		System.out.println("第i个元素时最长递增序列：" + Arrays.toString(list));
		// 寻找list中最大值
		int max = list[0];
		for (int i = 0; i < length; i++) {
			if (list[i] > max) {
				max = list[i];
			}
		}
		System.out.println("最长递增序列长度：" + max);
		System.out.println("最长递增序列：" + result);
	}
}