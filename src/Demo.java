import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Demo {

    public static void main(String[] args) {

        Integer a = 10;
        changeInteger(a);
        System.out.println(a);

//        String s = "[1,2,3,4,5,null,null,null,6]";
//        TreeNode root = Utils.stringToTreeNode(s);
////        System.out.println(root);
//        TreeNode node = root;
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        while(node != null || stack.isEmpty() == false) {
//            while(node != null) {
//                stack.push(node);
//                node = node.left;
//            }
//            node = stack.pop();
//            System.out.println("---" + node.val);
//            node = node.right;
//        }
    }

    public static void changeInteger(Integer a) {
        a = a+100;
    }
}
