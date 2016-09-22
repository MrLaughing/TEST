package ren.laughing.test.problem;

/**
 * 查找算法总结
 * 
 * @author Laughing_Lz
 * @time 2016年9月20日
 */
class BinaryNode {
	public BinaryNode left;
	public BinaryNode right;
	public int value;
}

public class Search {
	/**
	 * 顺序查找，查找表为线性表，平均时间复杂度为0(n)
	 * 
	 * @param arr
	 *            查找表
	 * @param n
	 *            要查找的元素
	 * @return
	 */
	public static int OrderSearch(int[] arr, int n) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == n) {
				return i;// 返回元素所在位置
			}
		}
		return -1;// 没找到，返回-1
	}

	/**
	 * 二分查找1循环，前提查找表为顺序存储结构，且大小有序排列
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	public static int BinarySearch1(int[] arr, int n) {
		int arrstart = 0;// 起点
		int arrend = arr.length;// 终点
		while (arrstart < arrend) {// 循环结束条件
			int arrmid = (arrend - arrstart) / 2;
			if (arr[arrmid] == n) {
				return arrmid;// 找到，返回元素所在位置
			} else if (arr[arrmid] < n) {
				arrstart = arrmid;
			} else if (arr[arrmid] > n) {
				arrend = arrmid;
			}
		}
		return -1;// 没找到，返回-1
	}

	/**
	 * 二分查找2递归，前提查找表为顺序存储结构，且大小有序排列
	 * 
	 * @param arr
	 * @param arrstart
	 * @param arrend
	 * @param n
	 * @return
	 */
	public static int BinarySearch2(int[] arr, int arrstart, int arrend, int n) {
		int arrmid = (arrstart + arrend) / 2;
		if (arrstart < arrend) {// 结束条件
			return -1;
		} else {
			if (arr[arrmid] == n) {
				return arrmid;// 结束条件
			} else if (arr[arrmid] < n) {
				return BinarySearch2(arr, arrmid, arrend, n);
			} else {
				return BinarySearch2(arr, arrstart, arrmid, n);
			}
		}
	}

	/**
	 * 二叉查找树，返回元素所在结点,中序遍历二叉查找树为从小到大的顺序
	 * 
	 * @param root
	 * @param n
	 * @return
	 */
	public static BinaryNode BinaryTreeSearch(BinaryNode root, int n) {
		if (root == null) {
			return null;// 不存在，查找失败
		}
		if (root.value == n) {
			return root;// 返回元素所在结点
		} else if (root.value < n) {
			return BinaryTreeSearch(root.right, n);
		} else {
			return BinaryTreeSearch(root.left, n);
		}

	}
}
