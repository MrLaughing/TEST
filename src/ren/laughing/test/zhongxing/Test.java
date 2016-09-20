package ren.laughing.test.zhongxing;

public class Test {

	public static void main(String[] args) {
		answer();
		String arr[] = { "abc", "cde", "fgh" };
		System.out.println(canArrangeWords(arr));
	}

	public static void answer() {
		String str = "abcde";
		System.out.println(str.charAt(0));
	}

	public static int canArrangeWords(String arr[]) {
		int a = arr.length;
		int flag = 1;
		for (int i = 0; i < a - 1; i++) {
			int b = arr[i].length();
			if (arr[i].charAt(b - 1) == arr[i + 1].charAt(0)) {
				// 如果相等继续循环
			} else {
				flag = -1;
				break;// 否则跳出循环
			}
		}
		return flag;
	}
}
