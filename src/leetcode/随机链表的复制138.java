package leetcode;


class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

// 给定一个链表，然后完整的复制一遍出来
// 如果是普通的单向或者双向都好办
public class 随机链表的复制138 {



    public static Node copyRandomList(Node head) {
        return null;
    }

//    // 单纯复制链表
//    public static Node copyList(Node head) {
//        Node dummy = new Node();
//        Node prev = dummy;
//        while(head != null) {
//            prev.next = new Node(head.val);
//            prev = prev.next;
//            head = head.next;
//        }
//        return dummy.next;
//    }

    public static void main(String[] args) {
//    	Node a = new Node(1);
//    	Node b = new Node(2);
//    	Node c = new Node(3);
//    	a.next = b;
//    	b.next = c;
//    	Node newNode = copyList(a);
    	
    }
}
