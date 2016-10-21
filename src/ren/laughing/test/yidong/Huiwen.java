package ren.laughing.test.yidong;

public class Huiwen {

	public static void main(String[] args) {
		System.out.println(new Solution().isPalindrome(1234321));
	}
}

class Solution {
	public boolean isPalindrome(int x) {
		String str = Integer.toString(x);
		// String str = x + "";
		int length = str.length();
		int i = 0;
		while (i <= length / 2) {
			if (str.charAt(i) == str.charAt(length - i - 1)) {
				i++;
			} else {
				return false;
			}
		}
		return true;
	}
}