package Practice.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import Practice.algorithm.AbstractBaseTree;

public class HasPathSum extends AbstractBaseTree {

	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && (sum - root.val) == 0) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	public static boolean hasPathSumNoiter(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Deque<TreeNode> curntIteNode = new ArrayDeque<>();
		curntIteNode.push(root);
		Deque<Integer> currentSum = new ArrayDeque<Integer>();
		currentSum.add(sum - root.val);
		while (!curntIteNode.isEmpty()) {
			TreeNode currentNode = curntIteNode.pop();
			Integer cusum = currentSum.pop();
			if (currentNode.right != null) {
				curntIteNode.push(currentNode.right);
				currentSum.push(cusum - currentNode.right.val);
			}
			if (currentNode.left != null) {
				curntIteNode.push(currentNode.left);
				currentSum.push(cusum - currentNode.left.val);
			}
			if (currentNode.left == null && currentNode.right == null && cusum == 0) {
				return true;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(hasPathSumNoiter(getSamplee(), 10));

	}

}
