



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class L173 {

    public static void main(String[] args) {
        String s = "[7, 3, 15, null, null, 9, 20]";

        TreeNode root = Utils.stringToTreeNode(s);

        BSTIterator bSTIterator = new BSTIterator(root);
        System.out.println(bSTIterator.next());    // 返回 3
        System.out.println(bSTIterator.next());    // 返回 7
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 9
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 15
        System.out.println(bSTIterator.hasNext()); // 返回 True
        System.out.println(bSTIterator.next());    // 返回 20
        System.out.println(bSTIterator.hasNext()); // 返回 False
    }
}

class BSTIterator {

    public TreeNode root;
   public List<TreeNode> nodeList;
   public Deque<TreeNode> stack;
   public int currIndex = 0;
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new ArrayDeque<>();
        nodeList = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            nodeList.add(node);
            if(node.right != null) {
                root = node.right;
            }
        }
    }

    public int next() {
        TreeNode node = nodeList.get(currIndex);
        currIndex++;
        return node.val;
    }

    public boolean hasNext() {
       return currIndex < nodeList.size();
    }
}
