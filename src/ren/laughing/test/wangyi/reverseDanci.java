package ren.laughing.test.wangyi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 反转单词顺序，如I have a dream! 操作后： I evah a maerd!
 * 
 * @author Laughing_Lz
 * @time 2016年9月24日
 */
public class reverseDanci {
	public static String[] reverse(String str) {
		//考虑字符串为空的情况！
		if (str.equals("") || str.isEmpty()) {
			return new String[] { "-1" };
		}
		Stack s = new Stack();
		String[] strs = (String[]) str.split(" ");
		for (int i = 0; i < strs.length; i++) {
			int strlength = strs[i].length();
			String temp = "";// 临时存储标点符号
			for (int j = 0; j < strlength; j++) {
				if ((strs[i].charAt(j) >= 'a' && strs[i].charAt(j) <= 'z')
						|| (strs[i].charAt(j) >= 'A' && strs[i].charAt(j) <= 'Z')) {
					s.push(strs[i].charAt(j));
				} else {
					temp += strs[i].charAt(j);// 存放在temp中
				}
			}
			strs[i] = "";// 置空
			for (int k = 0; !s.isEmpty(); k++) {
				char cc = (char) s.pop();
				strs[i] += cc;
			}
			strs[i] += temp;
		}
		return strs;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] result = reverse(str);
		for (int i = 0; i < result.length; i++) {
			if (i == (result.length - 1)) {
				System.out.print(result[i]);
			} else {
				System.out.print(result[i] + " ");
			}
		}
	}
}
