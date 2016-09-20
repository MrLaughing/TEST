package ren.laughing.test.huayu;

import java.util.Scanner;

/**
 * 打印某个有规律的图形
 * 
 * @author Laughing_Lz
 * @time 2016年9月20日
 */
public class PrintGraph {
	/**
	 * 
	 * @param n
	 *            层数(>=2)
	 * @throws Exception
	 *             n起始值错误
	 */
	public void GetGraph(int n) throws Exception {
		if (n < 2) {
			throw new Exception("n应大于1！");
		}
		int a = n - 2;
		/********* 打印第一行 **********/
		for (int i = 0; i < a; i++) {
			System.out.print(" ");
		}
		System.out.print("/\\");// 对\转义，使用\\表示一个\
		for (int i = 0; i < a; i++) {
			System.out.print(" ");
		}
		System.out.println();// 换行
		/********* 打印中间图形 **********/
		int b = 2;
		while (b < n) {
			int c = n - b - 1;
			int d = b - 1;
			for (int i = 0; i < c; i++) {// 先打印空格
				System.out.print(" ");
			}
			System.out.print("/");// 打印/
			for (int i = 0; i < d; i++) {// 再打印*
				System.out.print("**");
			}
			System.out.print("\\");// 打印\
			for (int i = 0; i < c; i++) {// 再打印空格
				System.out.print(" ");
			}
			System.out.println();// 换行
			b++;
		}
		/********* 打印最后一行 ***********/
		int c = (n - 1) * 2;
		for (int i = 0; i < c; i++) {
			System.out.print("+");
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			try {
				new PrintGraph().GetGraph(input.nextInt());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		input.close();
	}
}
