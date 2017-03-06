/*1.遍历反转法，从前往后反转各个结点的指针域的指向。
思路：讲当前节点cur的下一个结点cur.getNext()缓存到temp后，然后更改当前节点指针指向上一节点pre。
在反转当前节点指针指向前，先把当前节点的指针域用temp临时保存*/
public class reverseLink{
	public static Node reverse(Node head)
	{
		if(head == null)
			return head;
		Node pre = head;
		Node cur = head.getNext();
		Node tmp;
		while(cur != null){
			tmp = cur.getNext();
			cur.setNext(pre);//反转指针域的朝向
			pre = cur;//指针向下移动
			cur = tmp;
		}
		head.setNext(null);
		return pre；
	}

	class Node{
		private int Data;
		private Node Next;

		public Node(int Data){
			this.Data = Data;
		}
		public int getData(){
			return Data;
		}
		public void setData(int Data){
			this.Data = Data;
		}
		public Node getNext(){
			return Next;
		}
		public void setNext(Node Next){
			this.Next = Next;
		}
	}
}


//递归反转,利用递归走到链表的末端，然后在倒数第二句中更新每一个node的next值
//reverseRest的值没有改变，为该链表的最后一个node
public Node reverse(Node current)
{
	if(current == null || current.next == null) return current;
	Node nextNode = current.next;
	current.next = null;
	Node reverseRest = reverse(nextNode);
	nextNode.next = current;
	return reverseRest;
}








