package leetcode;

import java.util.List;

public class 训练计划V160 {

	/**
	 * 给定两个链表，找出他们的相交部分构成的链表的头结点 如果没有相交部分，则返回null 这个实现不行，因为改变了原有链表的结构了
	 */

	public static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		/**
		 * 这里我的实现考虑过于复杂，是对于任意的两个链表进行判断 但看题目的解法，提供的链表是有前提的： 
		 * 1。如果出现一个相同的数值后，那后面的都是相同的了。
		 * 2。一个链表中，不会出现同样的值 
		 * 3。如果两个链表真的有重叠部分，那重叠部分的ListNode 都是同一个对象。
		 * https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/811625/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
		 * 原题叫两条相交的链表，不是随便的链表。
		 */
		headA = reverse(headA);
		headB = reverse(headB);
		ListNode same = null;
		while (headA != null && headB != null && headA.val == headB.val) {
			same = headA;
			headA = headA.next;
			headB = headB.next;
		}
		// 要么有分歧了。要么走完了，可能a走完了，可能b走完了，可能a和b都走完了
		return same;
	}

//	public static void main(String[] args) {
////        String str1 = "[4,1,8,4,5]";
////        String str2 = "[5,0,1,8,4,5]";
//		String str1 = "[0,9,1,2,4]";
//		String str2 = "[3,2,4]";
//		ListNode head1 = ListNode.stringToListNode(str1);
//		ListNode head2 = ListNode.stringToListNode(str2);
////        ListNode head = reverse(null);
////        ListNode.printListNodes(head);
//		ListNode node = getIntersectionNode(head1, head2);
//		System.out.println(node != null ? node.val : "null");
//		System.out.println(node);
//	}
	
	
	public static void main(String[] args) {
		ListNode a1 = new ListNode(0);
		ListNode a2 = new ListNode(9);
		ListNode a3 = new ListNode(1);
		ListNode a4 = new ListNode(2);
		ListNode a5 = new ListNode(4);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		ListNode b1 = new ListNode(3);
//		b1.next = a4;
		ListNode result = getIntersectionNode2(a1, b1);
		System.out.println(result);
		if(result!=null) {
			System.out.println(result.val);
		}
		
	}
	
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		/**
		 * 假设a的长度是a,b的长度是b,共同部分的长度是c,那a和b同时走,走到头以后就从对方开始走,那么走到共同部分
		 * a走了a+b-c,b走了b+a-c,两者走到距离相同,这就可以同时到达一个点.
		 * 只要往前走,一直到两者当前的节点是同一个,那就是共同部分的起点
		 * 如果他们之间有重叠的，那一定是a走到b的第一次就发现了，不能没完的走
		 */
		if(headA == null || headB ==null) {
			return null;
		}
		ListNode currA = headA;
		ListNode currB = headB;
		
		boolean a2b = false;
		boolean b2a = false;
		while(currA != currB) {
			currA = currA.next;
			if(currA == null) {
				if(a2b) {
					break;
				}
				currA = headB;
				a2b = true;
			}
			currB = currB.next;
			if(currB == null) {
				if(b2a) {
					break;
				}
				currB = headA;
				b2a = true;
			}
		}
		return currA;
	}
}
