

import java.util.List;

public class 训练计划V {

    /**
     * 给定两个链表，找出他们的相交部分构成的链表的头结点
     * 如果没有相交部分，则返回null
     * 这个实现不行，因为改变了原有链表的结构了
     */


    /**
     * 这里我的实现考虑过于复杂，是对于任意的两个链表进行判断
     * 但看题目的解法，提供的链表是有前提的：
     * 1。如果出现一个相同的数值后，那后面的都是相同的了。
     * 2。一个链表中，不会出现同样的值
     * 3。如果两个链表真的有重叠部分，那重叠部分的ListNode 都是同一个对象。
     * https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/811625/xiang-jiao-lian-biao-by-leetcode-solutio-a8jn/
     * 原题叫两条相交的链表，不是随便的链表。
     */


    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        headA = reverse(headA);
        headB = reverse(headB);
        ListNode same = null;
        while(headA != null && headB != null && headA.val == headB.val) {
            same = headA;
            headA = headA.next;
            headB = headB.next;
        }
        // 要么有分歧了。要么走完了，可能a走完了，可能b走完了，可能a和b都走完了
        return same;
    }

    public static void main(String[] args) {
//        String str1 = "[4,1,8,4,5]";
//        String str2 = "[5,0,1,8,4,5]";
        String str1 = "[0,9,1,2,4]";
        String str2 = "[3,2,4]";
        ListNode head1 = ListNode.stringToListNode(str1);
        ListNode head2 = ListNode.stringToListNode(str2);
//        ListNode head = reverse(null);
//        ListNode.printListNodes(head);
        ListNode node = getIntersectionNode(head1, head2);
        System.out.println(node != null ? node.val :"null");
    }
}
