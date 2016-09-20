package ren.laughing.test.wanmei;

import java.util.Scanner;

public class Main1 {

	public static void main(String ss[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入数组，以空格分开:");
		String arr = sc.nextLine();
		String[] strings = new String[arr.length()];
		// strings数组：用于记录数字
		int i, k = 0, count = 0;
		for (i = 0; i < arr.length(); i++) {
			// 如果是数字则将其记录到strings数组中
			if (arr.charAt(i) != ' ') {
				if (strings[k] == null) // 如果是第一个计数的数字则直接赋值
					strings[k] = String.valueOf(arr.charAt(i));
				else // 否则直接添加到其后面
					strings[k] = strings[k] + arr.charAt(i);
			} else { // 如果是第一次出现的空格，则k+1，这一次空格（可能有多个连续空格）后面出现的数字存储到strings的下一个元素中
				if (arr.charAt(i - 1) != ' ')
					k++;
			}
		}
		for (i = 0; i < arr.length(); i++) { // 得到strings中存储了数字（不是null）的元素个数
			if (strings[i] != null)
				count++;
		}
		int[] a = new int[count];
		for (i = 0; i < count; i++) { // 将strings中存储了数字的元素赋值给a中的元素
			a[i] = Integer.parseInt(strings[i]);
		}
		int[] data = a;
		System.out.println("最大长度  " + get2(data));
	}

	public static int binsearch(int[] data, int low, int high, int key) {
		int mid = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (data[mid] <= key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public static int get2(int[] data) {
		int maxindex[] = new int[data.length];
		int[] Max = new int[data.length];
		int len = 1;
		Max[0] = data[0];
		int i;
		for (i = 1; i < data.length; i++) {
			if (data[i] > Max[len - 1]) {
				Max[len] = data[i];
				maxindex[len] = i;
				len++;
			} else {
				int pos = binsearch(Max, 0, len - 1, data[i]);
				Max[pos] = data[i];
			}
		}
		// 输出最长递增子序列
		for (int j = 0; j < len; j++) {
			System.out.print(data[maxindex[j]] + " ");
		}
		System.out.println();
		return len;
	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}
}
