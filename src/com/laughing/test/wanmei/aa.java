package com.laughing.test.wanmei;

public class aa {
	public static void main(String[] args) {
		String s = "1 2 3 4 5 6   7 8 9 10";
		String[] strings = new String[s.length()];
		// strings数组：用于记录数字
		int i, k = 0, count = 0;
		for (i = 0; i < s.length(); i++) {
			// 如果是数字则将其记录到strings数组中
			if (s.charAt(i) != ' ') {
				if (strings[k] == null) // 如果是第一个计数的数字则直接赋值
					strings[k] = String.valueOf(s.charAt(i));
				else // 否则直接添加到其后面
					strings[k] = strings[k] + s.charAt(i);
			} else { // 如果是第一次出现的空格，则k+1，这一次空格（可能有多个连续空格）后面出现的数字存储到strings的下一个元素中
				if (s.charAt(i - 1) != ' ')
					k++;
			}
		}
		for (i = 0; i < s.length(); i++) { // 得到strings中存储了数字（不是null）的元素个数
			if (strings[i] != null)
				count++;
		}
		int[] a = new int[count];
		for (i = 0; i < count; i++) { // 将strings中存储了数字的元素赋值给a中的元素
			a[i] = Integer.parseInt(strings[i]);
			System.out.print(a[i] + ",");
		}
	}
}