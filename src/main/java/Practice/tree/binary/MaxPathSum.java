package Practice.tree.binary;

import Practice.algorithm.AbstractBaseTree;

public class MaxPathSum extends AbstractBaseTree {
	
	
	public static int maxPathSum(TreeNode root) {
		int result = Integer.MIN_VALUE;
		return maxPath(root, result);
	}
	
	public static int maxPath(TreeNode root,int maxPathSum) {
		if(root == null) {
			return 0;
		}
		int leftPathSum = Math.max(0, maxPath(root.left,maxPathSum));
		int rightPathSum = Math.max(0, maxPath(root.right, maxPathSum));
		maxPathSum = Math.max(maxPathSum, leftPathSum + rightPathSum + root.val);
		return Math.max(leftPathSum, rightPathSum) + root.val;
	}

}
