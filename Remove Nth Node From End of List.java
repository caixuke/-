/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
*/
// There are at least three solution:

// get the length of list in the first pass, remove the element in the second pass
// use two pointers. keep the distance equal to n (stupid, no performance benefit, hard to program)
// use recursion. remove the element when exiting from the recursion (very stupid, linear space usage)
public ListNode removeNthFromEnd(ListNode head, int n){
	ListNode start = new ListNode(0);
	ListNode slow = start, fast = start;
	slow.next = head;
	//Move fast in front so that the gap between slow and fast becomes n.
	for(int i = 1; i <= n + 1; i++){
		fast = fast.next;
	}
	//Move fast to the end, maintaining the gap.
	while(fast != null){
		slow = slow.next;
		fast = fast.next;
	}
	//skip the desired node 
	slow.next = slow.next.next;
	return start.next;
}

//My answer
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        if(head.next == null && n == 1)
            return null;
        ListNode tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
            length++;
        }
        if(n == length) return head.next;
        tmp = head;
        for(int i = 0; i < length - n - 1; i++){
            tmp = tmp.next;
        }
        if(tmp.next != null)
            tmp.next = tmp.next.next;
        else tmp.next = null;
        return head;
    }
}