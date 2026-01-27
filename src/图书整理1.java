

import java.util.ArrayList;

/**
 * 书店店员有一张链表形式的书单，每个节点代表一本书，节点中的值表示书的编号。
 * 为更方便整理书架，店员需要将书单倒过来排列，就可以从最后一本书开始整理，
 * 逐一将书放回到书架上。请倒序返回这个书单链表。
 *
 * 反转链表
 */
public class 图书整理1 {

//    public static ListNode reverseBookList(ListNode head) {
//        if(head == null) {
//            return null;
//        }
//        ListNode prev = null;
//        ListNode curr = head;
//        while(curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }

//    public static int[] reverseBookList(ListNode head) {
//        if(head == null) {
//            return new int[0];
//        }
//        LinkedList<Integer> list = new LinkedList<>();
//        ListNode prev = null;
//        ListNode curr = head;
//        while(curr != null) {
//            list.addFirst(curr.val);
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();
//    }

    private static ArrayList<Integer> tempList = new ArrayList<>();
    private static void reverse(ListNode head) {
        if(head == null) {
            return;
        }
        reverse(head.next);
        tempList.add(head.val);
    }
    public static int[] reverseBookList(ListNode head) {
//        递归的过程中，先翻转，再把自己放入arraylist，这样就是整体翻转了。
        reverse(head);
        return new int[0];
    }

    public static void main(String[] args) {
//        String str = "[]";
        String str = "[1,2,3,4,5,6]";
        ListNode head = Utils.stringToListNode(str);
//        printListNodes(head);
////        ListNode newHead = reverseBookList(head);
////        printListNodes(newHead);
//
//        int[] nums = reverseBookList(head);
//        for(var num : nums) {
//            System.out.println(num);
//        }

        reverseBookList(head);
        System.out.println(tempList);

    }
}
