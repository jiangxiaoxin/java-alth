package leetcode;

import java.util.HashMap;
import java.util.Map;

public class 递归拷贝生成新链表 {

    /**
     * 既然可以递归生成新链表，那就可以递归翻转链表
     */

    public static void main(String[] args) {
        String str = "[1,2,3,3,4]";
        ListNode head = ListNode.stringToListNode(str);
//        ListNode head = null;
        ListNode newHead = copy(head);
        ListNode.printListNodes(newHead);

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        Map<ListNode,Integer> ma = new HashMap<>();
        ma.put(a, 1);
        ma.put(b, 200);
        System.out.println(ma.get(a));
        System.out.println(ma.get(b));
        System.out.println(ma.size());
        System.out.println(a.equals(b)); // false
        System.out.println(ma);
    }

    public static ListNode copy(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newHead = new ListNode(head.val);
        newHead.next = copy(head.next);
        return newHead;
    }
}
