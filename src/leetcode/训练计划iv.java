package leetcode;


import java.util.List;

public class 训练计划iv {

    // 这里造的是全新的链表，同时不影响原来的l1和 l2
    // 如果不考虑改变，那就可以复用l1和l2上的节点，省去新建的内存和时间消耗
    public static ListNode trainningPlan(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        // 两个都不是空链表
        ListNode flag = new ListNode();
        ListNode cur = flag;
        ListNode h1 = l1;
        ListNode h2 = l2;
        while(h1 != null && h2 != null) {
            if(h1.val > h2.val) {
                cur.next =  new ListNode(h2.val);
                h2 = h2.next;
            } else {
                cur.next = new ListNode(h1.val);
                h1 = h1.next;
            }
            cur = cur.next;
        }
        if(h1 != null) {
            while(h1 != null) {
                cur.next = new ListNode(h1.val);
                cur = cur.next;
                h1 = h1.next;
            }
        } else {
            while(h2 != null) {
                cur.next = new ListNode(h2.val);
                cur = cur.next;
                h2 = h2.next;
            }
        }
        return flag.next;
    }

    public static void main(String[] args) {
//        String str1 = "[1,2,4]";
//        String str2 = "[1,3,4]";
        String str1 = "[1]";
        String str2 = "[]";
        ListNode head1 = ListNode.stringToListNode(str1);
        ListNode head2 = ListNode.stringToListNode(str2);
        ListNode head = trainningPlan(head1, head2);
        ListNode.printListNodes(head);
    }
}
