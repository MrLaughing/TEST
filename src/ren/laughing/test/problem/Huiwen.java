package ren.laughing.test.problem;

import java.util.Scanner;
/**
 * 给定一个字符串s，你可以从中删除一些字符，使得剩下的串是一个回文串。如何删除才能使得回文串最长呢？
输出需要删除的字符个数。
 * @author Laughing_Lz
 * @time 2016年9月11日
 */
public class Huiwen {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String string = in.nextLine();
			char[] chars = string.toCharArray();
			int length = string.length();
			int dp[][] = new int[length + 1][length + 1];
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (chars[i] == chars[length - j - 1]) {
						dp[i + 1][j + 1] = dp[i][j] + 1;
					} else {
						dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]) > dp[i][j]
								? Math.max(dp[i][j + 1], dp[i + 1][j]) : dp[i][j];
					}
				}
			}
			System.out.println(length - dp[length][length]);
		}
	}
}