



import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 这次是找路径了
 * 树中节点总数在范围 [0, 5000] 内，root可能是null的
 */
public class L113 {

    public static void main(String[] args) {
//        String s = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
//        int targetSum = 22;

        String s = "[1,2]";
        int targetSum = 3;

        TreeNode root = Utils.stringToTreeNode(s);
        List<List<Integer>> paths = pathSum(root, targetSum);
        System.out.println(paths);
    }


    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return null;
        }
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, path, 0, targetSum, paths);
        return paths;
    }

    public static void dfs(TreeNode node, List<Integer> prevPath, int prevSum, int targetSum, List<List<Integer>> paths) {
        int currSum = prevSum + node.val;
        if(node.left == null && node.right == null) {
            if(currSum == targetSum) {
                // 找到个符合条件的叶子节点
                List<Integer> p = new ArrayList<>(prevPath);
                p.add(node.val);
                paths.add(p);
            }
        } else {
//            还没到叶子节点
            prevPath.add(node.val);
            if (node.left != null) {
                dfs(node.left, prevPath, currSum, targetSum, paths);
            }
            if(node.right != null) {
                dfs(node.right, prevPath, currSum, targetSum, paths);
            }
            prevPath.remove(prevPath.size()-1);
        }
    }
}
