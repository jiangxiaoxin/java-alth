package leetcode;




/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 树中节点数目范围是 [1, 3 * 104]
 * -1000 <= Node.val <= 1000
 */
public class L124 {
    public static void main(String[] args) {
//        String s = "[1,2,3]";

//        String s = "[-3]";
//        String s = "[-10,9,20,null,null,15,7]";

        String s = "[5,4,8,11,null,13,4,7,2,null,null,null,1]";

        TreeNode root = Utils.stringToTreeNode(s);
        System.out.println(maxPathSum(root));
    }


    private static int maxVal = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxVal;
    }

    public static int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int a = Math.max(dfs(node.left), 0);
        int b = Math.max(dfs(node.right), 0);
        maxVal = Math.max(maxVal, node.val+a+b);
        return node.val + Math.max(a, b);
    }
}
