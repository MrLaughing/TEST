package ren.laughing.test.problem;

import java.util.*;
/**
 * 给定数字，找出相加可为该数的两个质数，找出这样的质数对数。如10为3+7，5+5，所以为2对
 * @author Laughing_Lz
 * @time 2016年9月12日
 */
public class Prime {
	public static int getCount(int n) {
		int m = 0;// m计数
		for (int i = 1; i <= n / 2; i++) {
			if (isZhishu(i)) {
				if (isZhishu(n - i)) {
					m++;
				}
			}
		}
		return m;
	}

	public static boolean isZhishu(int n) {
		if (n == 1 || n == 2) {
			return true;
		}
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			int result = getCount(n);
			System.out.println(result);
		}
	}
}
