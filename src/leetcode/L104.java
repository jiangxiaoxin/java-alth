package leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class L104 {
    /**
     * 给定一个二叉树 root ，返回其最大深度。
     *
     * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
     * 问题也就是找最长路径。把路径都找出来，然后找长度最长的。
     * 还是层序遍历，每走一层就层数加1，最后的层数就是最大深度
     *
     *
     */

    public static void main(String[] args) {
        String s = "[3,9,20,null,null,15,7]";
        TreeNode root = Utils.stringToTreeNode(s);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
//树中节点的数量在 [0, 104] 区间内。所以要判断是否有root
        if(root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.isEmpty() == false) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        return level;
    }
}
