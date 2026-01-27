

public class 删除链表节点 {
//已经保证了链表里没有重复的数字
    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        ListNode flag = new ListNode();
        flag.next = head;
        ListNode prev = flag;
        ListNode curr = head;
        while(curr != null && curr.val != val) {
            prev = curr;
            curr = curr.next;
        }
        // curr 要么是null ，要么是 val 对应的节点
        if(curr == null) {
            // curr 是null ，那这个链表里就没有val
            return flag.next;
        }
        // curr 不是null，那就只能是 val了
        prev.next = curr.next;
        return flag.next;
    }

    public static void main(String[] args) {
        String nodes = "[4,5,1,9]";
//        String nodes = "[]";
//        String nodes = "[5]";
//        String nodes = "[1,2]";
//        String nodes = "[5,1,2]";
        ListNode head = ListNode.stringToListNode(nodes);
        head = deleteNode(head, 5);
        System.out.println(head);
        ListNode.printListNodes(head);
    }
}
