package Practice.tree;

import Practice.algorithm.AbstractBaseTree;

public class BinarySearchTree extends AbstractBaseTree {

	public static int leftDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = leftDepth(root.left) + 1;

		return leftDepth;
	}

	public static int rightDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = rightDepth(root.right) + 1;

		return leftDepth;
	}


	public static void main(String[] args) {
		System.out.println(leftDepth(getSamplee()));
	}

}
