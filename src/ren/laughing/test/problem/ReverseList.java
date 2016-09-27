package ren.laughing.test.problem;

/**
 * 单链表的逆置
 * 
 * @author Laughing_Lz
 * @time 2016年9月27日
 */
class ListNode {
	ListNode next;
	int value;

	// 构造方法
	public ListNode(ListNode next, int value) {
		super();
		this.next = next;
		this.value = value;
	}
}

public class ReverseList {

	public static ListNode reverse(ListNode root) {
		ListNode p = root;
		ListNode current = p.next;
		p.next = null;// 先把尾结点的next结点置空
		ListNode q = null;
		while (current != null) {
			q = current.next;
			current.next = p;
			p = current;
			current = q;
		}
		return p;
	}

	public static void main(String[] args) {
		ListNode listNode6 = new ListNode(null, 6);
		ListNode listNode5 = new ListNode(listNode6, 5);
		ListNode listNode4 = new ListNode(listNode5, 4);
		ListNode listNode3 = new ListNode(listNode4, 3);
		ListNode listNode2 = new ListNode(listNode3, 2);
		ListNode listNode1 = new ListNode(listNode2, 1);
		ListNode result = reverse(listNode1);
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
