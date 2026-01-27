

import java.util.ArrayList;
import java.util.List;



public class 遍历二叉树 {

	public static void main(String[] args) {
		System.out.println("1111");

//		String str = "[2,2,5,null,null,5,7]";
		String str = "[1,2,3,4,null,5,6,null,7]";
		TreeNode tree = Utils.stringToTreeNode(str);
		遍历二叉树.printTree(tree);
				
	}
	
	/**
	 * 使用栈模拟递归，先序遍历二叉树
	 * @param tree
	 */
	public static void printTree(TreeNode tree) {
		List<TreeNode> stack = new ArrayList<TreeNode>();
		stack.add(tree);
		while(!stack.isEmpty()) {
			TreeNode top = stack.remove(stack.size()-1);
			System.out.println("node:"+top.val);
			if(top.right != null) {
				stack.add(top.right);
			}
			if(top.left != null) {
				stack.add(top.left);
			}
		}
	}

}
