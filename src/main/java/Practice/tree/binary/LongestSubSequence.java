package Practice.tree.binary;

import Practice.algorithm.AbstractBaseTree;
import Practice.algorithm.AbstractBaseTree.TreeNode;

public class LongestSubSequence {

	public static int longestSubSequence(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int leftChildCount = longestSubSequence(node.left);
		int rightChildCount = longestSubSequence(node.right);
		if (leftChildCount == 0 && rightChildCount == 0) {
			return 1;
		}
		if (leftChildCount != 0 && rightChildCount != 0) {
			if (node.val - node.right.val == node.left.val - node.val) {
				if (Math.abs(node.left.val - node.val) == 1) {
					return leftChildCount + rightChildCount + 1;
				} else {
					return Math.max(leftChildCount, rightChildCount);
				}
			} else {
				if (Math.abs(node.left.val - node.val) == 1) {
					return Math.max(leftChildCount + 1, rightChildCount);
				}
				if (Math.abs(node.val - node.right.val) == 1) {
					return Math.max(leftChildCount, rightChildCount + 1);
				}
				return Math.max(leftChildCount, rightChildCount);
			}

		} else {
			if (leftChildCount == 0) {
				if (Math.abs(node.val - node.right.val) == 1) {
					return 1 + rightChildCount;
				} else {
					return rightChildCount;
				}
			}
			if (rightChildCount == 0) {
				if (Math.abs(node.left.val - node.val) == 1) {
					return 1 + leftChildCount;
				} else {
					return leftChildCount;
				}
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		System.out.println(longestSubSequence(AbstractBaseTree.getSamplee3()));
	}

}
