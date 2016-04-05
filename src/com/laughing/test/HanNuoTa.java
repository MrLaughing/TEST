package com.laughing.test;

import java.util.Scanner;
/**
 * 汉诺塔问题
 * 递归算法
 * @author Laughing
 * @time 2016年3月22日
 */
public class HanNuoTa {
	private static int i=0;//移动步数
	/**
	 * n个借助y移动到z上
	 * @param n n个
	 * @param x 起始点
	 * @param y 借助点
	 * @param z 落脚点
	 */
	public static int move(int n,String x,String y,String z){
		if(n == 1){
			System.out.println(x+"-->"+z);
			i++;
			return i;
		}else{
			move(n-1, x, z, y);//n-1个从x借助z移动到y上
			System.out.println(x+"-->"+z);
			move(n-1,y,x,z);//n-1个从y借助x移动到z上
			i++;
			return i;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入n值:");
		int n = in.nextInt();
		int i = move(n,"x","y","z");
		System.out.println("移动的步数总共为："+i);
	}
}
