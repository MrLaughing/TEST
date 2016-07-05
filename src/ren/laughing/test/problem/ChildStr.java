package ren.laughing.test.problem;

import java.util.Scanner;

/**
 * 功能：判断一个数字中是否包含两个相同的子串(字串长度至少大于等于2)，并输出（仅输出第一次相同的子串）
 * 
 * @author Laughing_Lz
 * @time 2016年7月4日
 */
public class ChildStr {
	private String str;

	/**
	 * 判断输入字符串是否合法
	 */
	public void input() {
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		sc.close();
		if (str.isEmpty()) {// 如果输入为空
			str = null;
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (str.isEmpty() || !((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {// 限制条件
				str = null;
				return;
			}
		}
	}

	/**
	 * 查找算法
	 */
	public void search() {
		if (str == null) {
			System.out.println("输入字符串错误！");
			return;
		}
		int j = 1;// 此处将index定义在两个循环外，可实现在一次循环中j始终和i同步递进★
		int number = 0;// 记录相同子串长度
		int index = 0;// 记录字串起始位置
		for (int i = 0; i < str.length() - 1; i++) {
			char numi = str.charAt(i);// 当前位置数字
			if (i == str.length() - 2 || j == str.length()) {
				number = 0;// 将number归0
				j = i + 1;// 一次循环后，将j移回i+1起始点，再次遍历
			}
			for (; j < str.length(); j++) {
				char numj = str.charAt(j);
				if (numi == numj) {
					number++;
					if (j < str.length() - 1) {
						j++;// 判断下个数字前将j++
					}
					break;
				} else {
					if (number >= 2) {
						break;
					} else {
						number = 0;// 若仅遇到1位数字相同，在遇到不同数字时，将number置0
					}
				}
			}
			if (number >= 2 && str.charAt(i + 1) != str.charAt(j)) {// 当相同数字已大于2后，遇到不同数字立即退出循环，打印子串
				index = i + 1;
				break;
			}
		}
		if (number >= 2) {
			System.out.println("存在,字串为：" + str.substring(index - number, index));
		}
	}

	public static void main(String arg[]) {
		ChildStr cs = new ChildStr();
		cs.input();
		cs.search();
	}
}