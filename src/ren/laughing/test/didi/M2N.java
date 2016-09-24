package ren.laughing.test.didi;

import java.util.Scanner;

public class M2N {
	/**
	 * 
	 * @param m
	 *            十进制数m
	 * @param n
	 *            转换为n进制
	 * @return
	 */
	public static String getN(int m, int n) {
		if (n > 16 || n < 2) {
			return "-1";
		}
		String str = Integer.toString(m, n);
		return str;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		System.out.println(getN(m, n));
	}
}
