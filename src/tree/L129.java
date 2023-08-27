package tree;

import common.Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 * 树中节点的数目在范围 [1, 1000] 内,不会是空树
 */
public class L129 {
    public static void main(String[] args) {
        String s = "[4,9,0,5,1]";
        TreeNode root = Utils.stringToTreeNode(s);
        sumNumbers2(root);
    }


    public static int sumNumbers2(TreeNode root) {

        int res = dfs(root, 0);
        System.out.println(res);
        return res;
    }

//    从node这个节点开始到它下面所有的叶子节点的路径和
    public static int dfs(TreeNode node, int prevSum) {
        int sum = 10*prevSum + node.val;
        if(node.left == null && node.right == null) {
            return sum;
        } else {
            int temp = 0;
            if(node.left != null) {
                temp = dfs(node.left, sum);
            }
            if(node.right != null) {
                temp += dfs(node.right, sum);
            }
            return temp;
        }
    }

    public static int sumNumbers(TreeNode root) {
        int sum = 0;
        List<Integer> nums = new LinkedList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> valQueue = new LinkedList<>();
        nodeQueue.offer(root);
        valQueue.offer(String.valueOf(root.val));
        while(nodeQueue.isEmpty() == false) {
            TreeNode node = nodeQueue.poll();
            String val = valQueue.poll();
            if(node.left == null && node.right == null) {
//                到了一个叶子节点了,可以增加新的路径和了
                sum += Integer.valueOf(val);
            } else {
                if(node.left != null) {
                    nodeQueue.offer(node.left);
                    valQueue.offer(val+String.valueOf(node.left.val));
                }
                if(node.right != null) {
                    nodeQueue.offer(node.right);
                    valQueue.offer(val+String.valueOf(node.right.val));
                }
            }
        }
        return sum;
    }
}
