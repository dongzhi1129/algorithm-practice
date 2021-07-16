package Practice.tree.binary;

import Practice.algorithm.AbstractBaseTree;

public class onstructMaximumBinaryTree extends AbstractBaseTree {

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return constructTree(nums, 0, nums.length - 1);

	}

	public TreeNode constructTree(int[] nums, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return null;
		}
		int maxElemIndex = maxIndexOfArray(nums, startIndex, endIndex);
		int rootValue = nums[maxElemIndex];
		TreeNode rootNode = new TreeNode(rootValue, null, null);
		rootNode.left = constructTree(nums, startIndex, maxElemIndex - 1);
		rootNode.right = constructTree(nums, maxElemIndex + 1, endIndex);
		return rootNode;
	}

	public int maxIndexOfArray(int[] nums, int startIndex, int endIndex) {
		int index = -1, maxElem = Integer.MIN_VALUE;
		for (int i = startIndex; i <= endIndex; i++) {
			if (nums[i] > maxElem) {
				index = i;
				maxElem = nums[i];
			}
		}
		return index;
	}

}
