package ren.laughing.test.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 列举数组中任意元素和为定值的组合
 */
public class SolveProb {
	static int num;// 计数
	static int realLength;// 实际长度
	/**
	 * 复杂度太高，求更改！
	 * @param arr
	 * @param start
	 * @param length
	 * @param sum
	 */
	public static void numGroup(int[] arr, int start, int length, int sum) {
		if (sum == 0) {
			num++;
		} else {
			for (int i = start; i < realLength; i++) {
				SolveProb.numGroup(arr, i + 1, length - 1, sum - arr[i]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int length = input.nextInt();
		realLength = length;// 实际长度
		int sum = input.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = input.nextInt();
		}
		Arrays.sort(arr);// 数组重排
		SolveProb.numGroup(arr, 0, length, sum);
		System.out.println(num);
	}
}