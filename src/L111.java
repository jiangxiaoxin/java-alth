



import java.util.LinkedList;
import java.util.Queue;

public class L111 {

    public static void main(String[] args) {
        String s = "[3,9,20,null,null,15,7]";

//        String s = "[2,null,3,null,4,null,5,null,6]";

//        String s = "[1,2,3,4,5]";

        TreeNode root = Utils.stringToTreeNode(s);
        System.out.println(minDepth(root));
    }

    /**
     * 给定一个二叉树，找出其最小深度。
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 也可以一层一层往下走，只是走的时候，发现某一层的节点里有叶子节点，就可以结束了
     * 树中节点数的范围在 [0, 10^5] 内
     */
    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            level++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) {
                    // node的left和right都是空，找到个叶子节点，可以退出了
                    return level;
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return level;
    }
}
