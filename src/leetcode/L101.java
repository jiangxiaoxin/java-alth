package leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class L101 {

    public static void main(String[] args) {
//        String s = "[1,2,2,3,4,4,3]";

        String s = "[1,2,2,null,3,null,3]";

        TreeNode root = Utils.stringToTreeNode(s);
        System.out.println(isSymmetric(root));
    }

//    树中节点数目在范围 [1, 1000] 内
//    是否是对称树
    public static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        boolean is = true;
        while (queue.isEmpty() == false) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1 == null && node2 == null) {

            } else if(node1 == null || node2 == null) {
                is = false;
                break;
            } else {
                if(node1.val != node2.val) {
                    is = false;
                    break;
                }
                queue.offer(node1.left);
                queue.offer(node2.right);
                queue.offer(node1.right);
                queue.offer(node2.left);
            }
        }
        return is;
    }
}
