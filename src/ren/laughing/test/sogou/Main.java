package ren.laughing.test.sogou;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	/* 递归 */
	public static int iteratorArr(int[] arr, int step) {
		int length = arr.length;
		if (step > length) {
			return arr[length / 2];
		} else if (step <= 0) {
			return -1;
		} else {
			int[] temp1 = new int[length];// 存储一次MED后的数组
			int[] temp2 = new int[step];// 临时数组
			for (int i = 0; i < length; i++) {
				/* 内循环获取一个step长度排序后的临时数组 */
				for (int j = 0; j < step; j++) {
					temp2[j] = arr[(i + j) % length];
				}
				Arrays.sort(temp2);
				/* 获取每一个MED值 */
				temp1[i] = temp2[step / 2];
			}
			step++;
			return iteratorArr(temp1, step);
		}
	}

	/* 循环 */
	public static int iteratorArr1(int[] arr, int step) {
		int length = arr.length;
		if (step > length) {
			return arr[length / 2];
		} else if (step <= 0) {
			return -1;
		} else {
			int[] temp1 = new int[length];// 存储一次MED后的数组
			for (; step <= length; step++) {
				int[] temp2 = new int[step];// 临时数组
				for (int i = 0; i < length; i++) {
					/* 内循环获取一个step长度排序后的临时数组 */
					for (int j = 0; j < step; j++) {
						temp2[j] = arr[(i + j) % length];
					}
					Arrays.sort(temp2);
					/* 获取每一个MED值 */
					temp1[i] = temp2[step / 2];
				}
				arr = temp1;
			}
			return arr[length / 2];
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int r = input.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		int result = iteratorArr(arr, r);
		System.out.println(result);
	}
}
