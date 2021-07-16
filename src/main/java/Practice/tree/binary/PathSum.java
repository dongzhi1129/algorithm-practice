package Practice.tree.binary;

import Practice.algorithm.AbstractBaseTree;

public class PathSum extends AbstractBaseTree {
	static int count = 0;

	public static int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		pathSum(root, sum, count);
		pathSum(root.left, sum, count);
		pathSum(root.right, sum, count);
		return count;
	}

	public static void pathSum(TreeNode root, int sum, int count) {
		if (root == null) {
			return;
		}
		sum -= root.val;
		if (sum == 0) {
			count++;
		}
		pathSum(root.left, sum, count);
		pathSum(root.right, sum, count);
	}
	
	public static void main(String[] args) {
		TreeNode root = generateTree(1,1,1,1,null,null,null);
		int sum = 2;
		System.out.println(pathSum(root, 2));
	}

}
