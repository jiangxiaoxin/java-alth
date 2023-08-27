package tree;

import common.Utils;

public class L100 {

    public static void main(String[] args) {

//        String a = "[1,2,3]";
//        String b = "[1,2,3]";

        String a = "[1,2]";
        String b = "[1,null,2]";

        TreeNode roota = Utils.stringToTreeNode(a);
        TreeNode rootb = Utils.stringToTreeNode(b);
        System.out.println(isSameTree(roota, rootb));
    }
//    两棵树上的节点数目都在范围 [0, 100] 内
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // ?? 两颗树都是空树，这算不算相同。应该算吧
        if(p == null && q == null) {
            return true;
        }
        if(p != null && q == null) {
            return false;
        }
        if(p == null && q != null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
