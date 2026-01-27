





public class L671 {
	
	public static void main(String[] args) {
//		String nodes = "[2,2,5,null,null,5,7]"; //5
//		String nodes = "[2,2,2]"; // -1
//		String nodes = "[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]"; // 2
		String nodes = "[2]"; // -1
		TreeNode root = Utils.stringToTreeNode(nodes);
		int result = findSecondMinimumValue(root);
		System.out.println(result);
		
//		nodes = "[2,2,2]";
//		root = Utils.stringToTreeNode(nodes);
//		result = findSecondMinimumValue(root);
//		System.out.println(result);
		
		
	}
	
	
	public static int findSecondMinimumValue(TreeNode root) {
		/**
		 * 树的格式是特殊的：
		 * 节点的子节点要么是0个，要么是2个
		 * 节点值都是正数
		 * 
		 */
        if(root.left == null && root.right == null) {
        	return -1;
        }
        // 到这，root左右节点都有了
        int leftSecondMin = findSecondMinimumValue(root.left);
        int rightSecondMin = findSecondMinimumValue(root.right);
        
        if(leftSecondMin == -1 && rightSecondMin == -1) {
        	// 两边子树都找不到第2小
        	if(root.left.val == root.right.val) {
        		return -1;
        	}
        	return Math.max(root.left.val, root.right.val);
        }
        // 只有一边能找到
        if(leftSecondMin == -1) {
        	// 左边没有第2小，右边有
        	if(root.left.val == root.right.val) {
        		return rightSecondMin;
        	}
        	
        	if(root.val == root.left.val) {
        		return root.right.val;
        	}
        	if(root.val == root.right.val) {
        		return Math.min(root.left.val, rightSecondMin);
        	}
        }
        if(rightSecondMin == -1) {
        	// 右边没有第2小，左边有
        	if(root.left.val == root.right.val) {
        		return leftSecondMin;
        	}
        	if(root.val == root.left.val) {
        		return Math.min(leftSecondMin, root.right.val);
        	}
        	if(root.val == root.right.val) {
        		return root.left.val;
        	}
        }
        // 两边都有第2小
        if(root.left.val == root.right.val) {
        	return Math.min(leftSecondMin, rightSecondMin);
        }
        if(root.val == root.left.val) {
        	return Math.min(leftSecondMin, root.right.val);
        }
        if(root.val == root.right.val) {
        	return Math.min(root.left.val, rightSecondMin);
        }
//        System.out.println("走到这里了，那就不对了");
        return -1;
    }
}