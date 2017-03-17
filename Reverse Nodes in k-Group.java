/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/
public class Solution{
	public ListNode reverseKGroup(ListNode head, int k){
		if(head == null || head.next == null || k < 2) 
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode tail = dummy, pre = dummy, tmp;
		int count;
		while(true){
			count = k;
			while(count > 0 && tail != null){
				count--;
				tail = tail.next;
			}
			if(tail == null) break;

			head = pre.next;//for next cycle 下一个循环的时候，tail已经转过来变成头结点了，此时的head是尾节点
			while(pre.next != tail){
				tmp = pre.next;//Assign
				pre.next = tmp.next;//Delete
				tmp.next = tail.next;
				tail.next = tmp;//Insert
			}
			tail = head;
			pre = head;
		}
		return dummy.next;
	}
}

/**
     * Reverse a link list between begin and end exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |   
     * begin       end
     * after call begin = reverse(begin, end)
     * 
     * 0->3->2->1->4->5->6
     *          |  |
     *      begin end
     * @return the reversed list's 'begin' node, which is the precedence of node end
     */

public ListNode reverseKGroup(ListNode head, int k){
	ListNode begin;
	if(head == null || head.next == null || k == 1)
		return head;
	ListNode dummyhead = new ListNode(-1);
	dummyhead.next = head;
	begin = dummyhead;
	int i = 0;
	while(head != null){
		i++;
		if(i % k == 0){
			begin = reverse(begin, head.next);
			head = begin.next;
		}else head = head.next;
	}
	return dummyhead.next;
}











