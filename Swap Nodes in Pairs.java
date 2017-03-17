/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution{
	public ListNode swapPairs(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		if(head == null)
		    return null;
		ListNode cur = head.next;
		ListNode pre = dummy;
		while(cur != null){
			ListNode tmp = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur.next.next = tmp;
			pre = cur.next;
			if(tmp == null)
				break;
			cur = tmp.next;
		}
		return dummy.next;
	}
}

//Another way, used recursion
public class Solution{
	public ListNode swapPairs(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}
}













