

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class L112 {


    /**
     * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
     */

//    树中节点的数目在范围 [0, 5000] 内
//    树节点可能是0，空树，从题目上看，空树时并不认为路径和是0
    public static boolean hasPathSum(TreeNode root, int targetSum) {
//    问题的关键就是计算每一条路径和
        if(root == null) {
            return false;
        }
//        nodeQueue 遍历每个节点
//        sumQueue 同样遍历每个节点，记录从根节点到每个节点路径和。在遍历的过程中看看有没有符合条件的节点，提前推出循环
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        while (nodeQueue.isEmpty() == false && sumQueue.isEmpty() == false) {
            TreeNode node = nodeQueue.poll();
            Integer sum = sumQueue.poll();
            if(node.left == null && node.right == null && sum == targetSum) {
                //找到一个叶子节点node，且他的路径和等于targetSum。满足条件
                return true;
            }
            if(node.left != null) {
                nodeQueue.offer(node.left);
                sumQueue.offer(sum + node.left.val);
            }
            if(node.right != null) {
                nodeQueue.offer(node.right);
                sumQueue.offer(sum+node.right.val);
            }
        }
        return false;
    }
}
