package tree;

import java.util.LinkedList;
import java.util.Queue;

public class L226 {

//    树中节点数目范围在 [0, 100] 内
//    public TreeNode invertTree(TreeNode root) {
//        if(root == null) {
//            return null;
//        }
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
//    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
}
