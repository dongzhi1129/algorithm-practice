package Practice.tree;

import Practice.algorithm.AbstractBaseTree;

public class BinaryTreeMaximumPathSum extends AbstractBaseTree {

	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sumLeftChild = sumPath(root.left);
		int sumRightChild = sumPath(root.right);
		int summary = sumLeftChild + sumRightChild;
		if(sumLeftChild + root.val < root.val && sumRightChild + root.val < root.val) {
			return root.val;
		}
		if (summary + root.val < summary) {
			return Math.max(maxPathSum(root.left), maxPathSum(root.right));
		}

		return sumLeftChild + sumRightChild + root.val;
	}

	public static int sumPath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sumPath(root.left) + sumPath(root.right) + root.val;
	}

	public static void main(String[] args) {
		System.out.println(maxPathSum(getSamplee()));
	}

}
