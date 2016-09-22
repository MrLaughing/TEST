package ren.laughing.test.problem;

/**
 * 排序算法总结
 * 
 * @author Laughing_Lz
 * @time 2016年9月20日
 */
public class Sort {
	/**
	 * 直接插入排序
	 * 
	 * @param arr
	 * @return
	 */
	public static int[] insertSort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			if (arr[j] < arr[j - 1]) {// 和前一个比较，此比较从j=1开始，保证了j-1之前的为有序数组★
				int temp = arr[j];// 保存临时值
				int i;// 插入位置
				for (i = j - 1; i >= 0 && arr[i] > temp; i--) {
					arr[i + 1] = arr[i];// 后移
				}
				arr[i + 1] = temp;// 插入
			}
		}
		return arr;
	}
	/**
	 * 二分插入排序，仅减少了元素的比较次数，没有减少元素的移动次数。时间复杂度仍为O(n^2)
	 * @param arr
	 * @return
	 */
	public static int[] BinarySort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			if (arr[i] < arr[i - 1]) {
				int arrstart = 0;
				int arrend = i - 1;
				while (arrstart <= arrend) {
					int arrmid = (arrstart + arrend) / 2;
					if (arr[arrmid] < temp) {// <=即可
						arrstart = arrmid+1;
					} else {
						arrend = arrmid-1;
					}
				}
				for(int j = i-1;j>arrend;j--){
					arr[j+1] = arr[j];
				}
				arr[arrstart] = temp;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 5, 2, 1, 3, 6,7,10,8,4 };
		// insertSort(arr);
		BinarySort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
