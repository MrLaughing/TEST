package ren.laughing.test.baidu;
/**
 * 第一题：查找()括号对数，返回对数或-1
 * @author Laughing_Lz
 * @time 2016年9月20日
 */
public class Parentheses {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public static int balancedParentheses(String str) {
		int length = str.length();
		int a = 0;
		int b = 0;
		int n = 0;
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == '(') {
				n++;
				a++;
			} else if (str.charAt(i) == ')') {
				a--;
				b++;
			}
			if(a < 0){
				break;
			}
		}
		if (a < 0 || a > 0) {
			return -1;
		} else if (a == 0) {
			return n;
		}
		return n;
	}
	public static void main(String[] args) {
		int n = balancedParentheses("()()(())()()");
		System.out.println(n);
	}
}