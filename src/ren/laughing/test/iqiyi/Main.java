package ren.laughing.test.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求出数组中任意元素和为某定值的组合中对应位置的另一组合中和为最大值的一组
 */
public class Main {
	// Arrays.sort(arr);
	static int[] flag = new int[100];
	static int index = 0;// 记录当前
	static int sum2[] = new int[100];// 记录和
	static int m = 0;

	public static void numGroup(int[] arr, int start, int length, int sum, int[] arr1, int[] arr3) {
		if (sum == 0) {
			for (int j = 0; j < index; j++) {
				for (int k = 0; k < arr3.length; k++) {
					if (arr3[k] == flag[j]) {
						sum2[m] += arr1[k];
					}
				}
			}
			m++;
		} else {
			for (int i = start; i < length; i++) {
				flag[index++] = arr[i];
				Main.numGroup(arr, i + 1, length, sum - arr[i], arr1, arr3);
			}
		}
		index--;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int[] arr = new int[m];
		int[] arr1 = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = input.nextInt();
			arr1[i] = input.nextInt();
		}
		int[] arr3 = new int[m];
		for (int i = 0; i < m; i++) {
			arr3[i] = arr[i];
		}
		Arrays.sort(arr);
		int sum = n;
		Main.numGroup(arr, 0, arr.length, sum, arr1, arr3);
		int max = 0;
		for (int i = 0; i < sum2.length; i++) {
			if (max <= sum2[i]) {
				max = sum2[i];
			}
		}
		System.out.println(max);

	}
}