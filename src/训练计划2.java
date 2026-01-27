

import java.util.ArrayList;
import java.util.List;

public class 训练计划2 {

//    给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号
    public static ListNode trainingPlan(ListNode head, int cnt) {
//        让快的先走那几步，然后快的和慢的一起走，快的走到末尾的时候，慢的也就到了预期位置了
        int count = 0;
        ListNode fast = head;
        while(count < cnt && fast != null) {
            fast = fast.next;
            count++;
        }
        if(count != cnt) {
            // fast 指向null，那这个链表长度不够
            return null;
        }
        // 长度够了，可以让slow 从head 开始走了
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static Integer trainingPlan2(ListNode head, int cnt) {
        // 缺点就是另外的arraylist，占用内存多。优点就是简单易用
        // 双指针方式，额外就只是两个指针，两个方法遍历都是O（n）
        List<Integer> nums = new ArrayList<>();
        while(head != null) {
            nums.add(head.val);
            head = head.next;
        }
        if(cnt > nums.size()) {
            return null;
        }
        return nums.get(nums.size() - cnt);
    }

    public static void main(String[] args) {
        String nodes  = "[1,2,3,4,5]";
//        String nodes = "[1]";
//        String nodes = "[1,2]";
//        String nodes = "[]";
        ListNode head = ListNode.stringToListNode(nodes);
//        ListNode target = trainingPlan(head, 2); //倒数第2个
//        System.out.println(target);

        Integer res = trainingPlan2(head, 2);
        System.out.println(res); // 数 或者 null

    }
}
