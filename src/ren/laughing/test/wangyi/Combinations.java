package ren.laughing.test.wangyi;

import java.util.Scanner;

/**
 * M种颜色小球，每种小球4个，从中取N个，有多少种组合。
 * 
 * @author Laughing_Lz
 * @time 2016年9月24日
 */
public class Combinations {
	/**
	 * 计算组合数
	 * @param n
	 * @param m
	 * @return
	 */
	public static int getCount(int n, int m) {
		int result = 0;
		if (n > m) {
			if (m <= 4) {
				result = n + getCombinations(m, n);
			} else if (m > 4) {

			}
		}
		return 0;
	}

	/**
	 * 计算C(m,n)
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int getCombinations(int m, int n) {
		if (m < n || n < 0 || m < 0) {
			return -1;
		}
		int denominator = m;// 分母
		int molecule = 1;// 分子
		if (n == 0) {
			n = m;// 转换计算
		}
		for (int i = denominator - 1; i > (m - n); i--) {
			denominator *= i;
		}
		for (int j = 1; j <= n; j++) {
			molecule *= j;
		}
		int result = denominator / molecule;
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int m = input.nextInt();
		int result = getCount(n, m);
		System.out.println(result);
	}
}
