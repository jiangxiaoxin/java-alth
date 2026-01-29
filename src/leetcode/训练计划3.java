package leetcode;


public class 训练计划3 {
    public static ListNode trainningPlan(ListNode head) {
        ListNode prev =  null;
        ListNode curr = head;
        ListNode next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
//        String nodes = "[1,2,3,4,5]";
        String nodes = "[]";
        ListNode head = ListNode.stringToListNode(nodes);
        head = trainningPlan(head);
        System.out.println(head);
        ListNode.printListNodes(head);

    }
}
