package ren.laughing.test.problem;

/**
 * 1位格雷码有两个码字 (n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
 * (n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1 n+1位格雷码的集合 =
 * n位格雷码集合(顺序)加前缀0+n位格雷码集合(逆序)加前缀1
 * 
 * @author Laughing_Lz
 * @time 2016年9月11日
 */
public class Gray {
	public static String[] getGray(int n) {
		String[] result = new String[1 << n];// 1<<n 1左移n位，得到的数即为2^n
		if (n == 1) {
			String[] firstGray = { "0", "1" };
			return firstGray;
		}
		String[] preResult = getGray(n - 1);
		for (int i = 0; i < (1 << n - 1); i++) {
			result[i] = "0" + preResult[i];// 顺序
		}
		for (int i =(1<<n-1); i < (1<<n);i++) {
			result[i] = "1" + preResult[(1<<n)- i - 1];// 逆序
		}
		return result;
	}

	public static void main(String[] args) {
		String[] result = getGray(3);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
