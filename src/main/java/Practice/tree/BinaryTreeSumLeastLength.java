package Practice.tree;

import Practice.algorithm.AbstractBaseTree;

public class BinaryTreeSumLeastLength extends AbstractBaseTree {

	public static int binaryTreeSumLeastLength(TreeNode root, int sum) {
		//root
		int rootLength = searchNodeSumEqual(root,0,0,sum);
		//left
		int leftLength = 0,rightLength = 0;
		if(rootLength != 0) {
			leftLength = searchNodeSumEqual(root.left,rootLength + 1,root.val,sum);
		} else {
			leftLength = searchNodeSumEqual(root.left,rootLength,sum,sum);
		}
		if(rootLength != 0) {
			rightLength = searchNodeSumEqual(root.right,rootLength + 1,root.val,sum);
		} else {
			rightLength = searchNodeSumEqual(root.right,rootLength,sum,sum);
		}
		
		
		return sum;
	}

	public static int searchNodeSumEqual(TreeNode node, int step, int result, int sum) {
		if (node == null && result != sum) {
			return 0;
		}
		if (node == null && result == sum) {
			return step;
		}
		int tempResult = node.val + result;
		int leftResult = searchNodeSumEqual(node.left, step + 1, tempResult, result);
		int rightResult = searchNodeSumEqual(node.right, step + 1, tempResult, result);
		int rootResult = 0;
		if (tempResult == result) {
			rootResult = step + 1;
		}
		int tempMax = rootResult > leftResult ? rootResult : leftResult;
		return tempMax > rightResult ? tempMax : rightResult;

	}

}
