package Practice.tree;

import Practice.algorithm.AbstractBaseTree;

public class ConvertToBiNode extends AbstractBaseTree {

//	public static TreeNode convertBiNode(TreeNode root) {
//
//	}

	private static TreeNode transformTree(TreeNode root) {

		if (root.left == null || root.right == null) {
			return root;
		}
		// transform left
		TreeNode newNode = transformTree(root.left);
		if (root.right != null) {
			newNode.right = transformTree(root.right);
		} else {
			newNode.right = null;
		}
		newNode.left = null;
		return newNode;
	}

}
