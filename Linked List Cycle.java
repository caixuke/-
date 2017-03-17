//Given a linked list, determine if it has a cycle in it.
//To detect if a list is cyclic, we can check whether a node had been visited before. A natural way is to use a hash table.
//Time complexity:O(n), Space complexity:O(n)
public boolean hasCycle(ListNode head){
	Set<ListNode> nodesSeen = new HashSet<>();
	while(head != null){
		if(nodesSeen.contains(head))
			return true;
		else nodesSeen.add(head);
		head = head.next;
	}
	return false;
}

//The space complexity can be reduced to O(1) by considering two pointers at different speed - a slow pointer and a fast pointer. The slow pointer moves one step at a time while the fast pointer moves two steps at a time.
public boolean hasCycle(ListNode head){
	if(head == null || head.next == null)
		return false;
	ListNode fast = head.next;
	ListNode slow = head;
	while(slow != fast){
		if(fast == null || fast.next == null)
			return false;
		slow = slow.next;
		fast = fast.next.next;
	}
	return true;
}