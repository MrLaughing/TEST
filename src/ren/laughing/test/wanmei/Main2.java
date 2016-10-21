package ren.laughing.test.wanmei;

public class Main2 {
	private static int RED = 0, GREEN = 1, BLUE = 2, YELLOW = 3, PURPLE = 4;
	private static int p[][] = { { RED, RED, BLUE, BLUE, GREEN, YELLOW, BLUE, YELLOW, RED, PURPLE },
			{ GREEN, GREEN, GREEN, BLUE, RED, PURPLE, RED, YELLOW, YELLOW, BLUE },
			{ BLUE, RED, RED, YELLOW, YELLOW, PURPLE, BLUE, GREEN, GREEN, BLUE },
			{ YELLOW, RED, BLUE, YELLOW, BLUE, RED, PURPLE, GREEN, GREEN, RED },
			{ YELLOW, RED, BLUE, BLUE, PURPLE, GREEN, PURPLE, RED, YELLOW, BLUE },
			{ PURPLE, YELLOW, RED, RED, YELLOW, RED, PURPLE, YELLOW, RED, RED },
			{ YELLOW, YELLOW, GREEN, PURPLE, GREEN, RED, BLUE, YELLOW, BLUE, GREEN },
			{ RED, YELLOW, BLUE, BLUE, YELLOW, GREEN, PURPLE, RED, BLUE, GREEN },
			{ GREEN, GREEN, YELLOW, YELLOW, RED, RED, PURPLE, BLUE, BLUE, GREEN },
			{ PURPLE, BLUE, RED, RED, PURPLE, YELLOW, BLUE, RED, RED, GREEN } };

	public static int[][] removeBlock(int i, int j) {
		if (i > 0) {
			if (p[i - 1][j] == p[i][j]) {
				p[i - 1][j] = p[i][j] = 5;
			}
		}
		if (i < 99) {
			if (p[i + 1][j] == p[i][j]) {
				p[i + 1][j] = p[i][j] = 5;// 标记
			}
		}
		if (j > 0) {
			if (p[i][j - 1] == p[i][j - 1]) {
				p[i][j - 1] = p[i][j] = 5;// 标记
			}
		}
		if (j < 99) {
			if (p[i][j + 1] == p[i][j]) {
				p[i][j + 1] = p[i][j] = 5;// 标记
			}
		}
		return removeBlock(j, j);
	}

	public static void moveBlock() {

	}

	public static void main(String[] args) {
		int n = 0;
		n = n - 1;
		int i = n / 10;
		int j = n % 10;
	}
}
