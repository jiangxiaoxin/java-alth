package leetcode;


import java.util.HashMap;
import java.util.Map;

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


    static Map<Node,Node> meo = new HashMap<>();
    public static Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        if(meo.containsKey(head) == false) {
            Node newNode = new Node(head.val);
            meo.put(head, newNode);
            // 光沿着next 走是不会出现重复的
            // 但还要沿着random 走，那就可能出现重复
            // 一次copy 就已经完整的走完剩下的节点了
            // 先完整的走完next 的copy，再回溯的时候又去走random，而此时所有的点都应该已经复制过了【因为next 先要完整走完】
            newNode.next = copyRandomList(head.next);
            // random 复制是并没有走进来这里，而是直接跳过了if，从meo里去获取节点了
            newNode.random = copyRandomList(head.random);
        }
        return meo.get(head);
    }

    public static void main(String[] args) {
        Node n7 = new Node(7);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10);
        Node n1 = new Node(1);
        n7.next = n13;
        n7.random = null;
        n13.next = n11;
        n13.random = n7;
        n11.next = n10;
        n11.random = n1;
        n10.next = n1;
        n10.random = n11;
        n1.next = null;
        n1.random = n7;
        Node newHead = copyRandomList2(n7);
        System.out.println(newHead.val);
    }

    public static Node copyRandomList2(Node head) {
        // 这个方法跟上面的循环和内存差不多，但是不用同时维持递归栈，所以应该能好点吧
        if(head == null) {
            return null;
        }
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            if(prev != null) {
                prev.next = newNode;
            }
            meo.put(curr, newNode);
            prev = newNode;
            curr = curr.next;
        } // 到这里，按照next 创建了一遍新的链表，所有的节点都复制了
        curr = head;
        while(curr != null) {
            meo.get(curr).random = meo.get(curr.random);
            curr = curr.next;
        }// 再遍历一遍所有的节点，设置对应的random
        return meo.get(head);
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

}
