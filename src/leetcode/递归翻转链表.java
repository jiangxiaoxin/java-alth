package leetcode;

public class 递归翻转链表 {

    public static ListNode newHead = null;
    public static void main(String[] args) {
        ListNode head = Utils.stringToListNode("[1,2,3,4,5,6]");
//        ListNode newEnd = reverse(head); // 1

        ListNode newHead = reverse2(head);
        System.out.println(newHead.val);

//        ListNode head = new ListNode(1);
//        ListNode newEnd = reverse(head);
//        System.out.println(newEnd.val);
//        System.out.println(newEnd.next);
//        ListNode.printListNodes(newHead);
    }

    public static ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            //已经是最后一个了
            // 这个实现缺点是要在外面创建个newHead，而不是内部自包含的
            newHead = head;
            return head;
        }
        ListNode newEnd = reverse(head.next);
        if(newEnd!= null) {
            newEnd.next = head;
            head.next = null;
        }
        return head;
    }

    public static ListNode reverse2(ListNode head) {
        /**
         * 这个方法好处是内聚。
         * 关键在于返回新的newHead，每次递归处理返回的都是新链表的头部，只要一直保持这个语义，那
         * 递归的回溯过程就是一直返回原来最后的节点，也就是现在的新的头节点。
         */
        if(head == null ||head.next == null) {
            return head;
        }
        ListNode newHead = reverse2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
