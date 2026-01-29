package leetcode;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class ListNode {
      public int val;
      public ListNode next;
      public ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


      public static ListNode stringToListNode(String nodes) {
          JSONArray array = JSON.parseArray(nodes);
          ListNode flag = new ListNode();
          ListNode current = flag;
          for(int i=0;i<array.size();i++) {
              int val = array.getIntValue(i);
              ListNode node = new ListNode(val);
              current.next = node;
              current = node;
          }
          return flag.next;
      }
    public static String printListNodes(ListNode head) {
          if(head == null) {
              System.out.println("空链表--null");
              return "";
          }
        StringBuilder builder = new StringBuilder();
        ListNode current = head;
        while(current != null) {
            builder.append(current.val);
            builder.append(",");
            current = current.next;
        }
        System.out.println(builder);
        return builder.toString();
    }
    
//    @Override
//    public String toString() {
//    	return String.valueOf(this.val);
//    }

  }
