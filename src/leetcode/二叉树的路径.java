package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;



public class 二叉树的路径 {

	public static void main(String[] args) {

//		String str = "[2,2,5,null,null,5,7]";
		String str = "[1,2,3,4,null,5,6,null,7]";
		TreeNode tree = Utils.stringToTreeNode(str);
		List<ArrayList<Number>> allPaths = getAllPath(tree);
		System.out.println("树的所有路径："+ allPaths);
		
		Optional<Integer> maxLength = allPaths.stream().map(List::size).reduce((size1, size2) -> Math.max(size1, size2));
		
		maxLength.ifPresent(System.out::println);
		
	}
	
	public static List<ArrayList<Number>> getAllPath(TreeNode root) {
		List<ArrayList<Number>> path = new ArrayList<ArrayList<Number>>();
		if(root.left == null && root.right == null) {
			
			path.add(new ArrayList<Number>(Arrays.asList(root.val)));
			return path;
		}
		if(root.left != null) {
			List<ArrayList<Number>> left = getAllPath(root.left);
			left.forEach((item) -> {
				item.add(0, root.val);
			});
			path.addAll(left);
		}
		if(root.right != null) {
			List<ArrayList<Number>> right = getAllPath(root.right);
			right.forEach((item) -> {
				item.add(0, root.val);
			});
			path.addAll(right);
		}
		return path;
		
	}

}
