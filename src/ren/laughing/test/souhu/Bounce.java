package ren.laughing.test.souhu;

import java.util.Scanner;

public class Bounce {
	public static int getCount(int n, int[] arr) {
		int sum = 0;
		int i = 0;
		int count = 0;
		while (sum <= n) {
			int temp = arr[i];
			if (i + temp >= n) {
				break;
			} else if (arr[i + temp] == 0) {
				int temp1 = i;
				int j;
				for (j = temp; j > 0; j--) {
					i = (i + j - 1);
					if (arr[i] != 0) {
						break;
					}
				}
				if (i == temp1) {
					return -1;
				}
				temp -= j;
			}
			sum += temp;
			i += temp;
			count++;
			if (i >= n) {
				break;
			}
		}
		return count + 1;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = input.nextInt();
		}
		// int n = 6;
		// int[] arr = new int[] { 2, 5, 0, 4, 1, 1 };
		int result = getCount(n, arr);
		System.out.println(result);
	}
}
