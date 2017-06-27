package _2_Add_Two_Numbers;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {

	ListNode addTwoNode(ListNode n1, ListNode n2, int flag) {
		int v1 = n1.val;
		int v2 = n2.val;
		int sum = v1 + v2 + flag;
		if (sum >= 10) {
			sum = sum - 10;
			flag = 1;
		} else {
			flag = 0;
		}
		ListNode listNode = new ListNode(sum);
		if (n1.next != null && n2.next != null) {
			listNode.next = addTwoNode(n1.next, n2.next, flag);
		} else if (n1.next == null && n2.next != null) {
			if (flag == 1) {
				ListNode temp = new ListNode(1);
				listNode.next = addTwoNode(temp, n2.next, 0);
			} else {
				listNode.next = n2.next;
			}
		} else if (n1.next != null && n2.next == null) {
			if (flag == 1) {
				ListNode temp = new ListNode(1);
				listNode.next = addTwoNode(temp, n1.next, 0);
			} else {
				listNode.next = n1.next;
			}
		} else {
			if (flag == 1) {
				ListNode end = new ListNode(1);
				listNode.next = end;
			}
		}
		return listNode;
	}

	/**
	 * given
	 * loop，get judge condition
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode prev = new ListNode(0);
		ListNode head = prev;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			ListNode cur = new ListNode(0);
			int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
			cur.val = sum % 10;
			carry = sum / 10;
			prev.next = cur;
			prev = cur;

			l1 = (l1 == null) ? l1 : l1.next;
			l2 = (l2 == null) ? l2 : l2.next;
		}
		return head.next;
	}

}
