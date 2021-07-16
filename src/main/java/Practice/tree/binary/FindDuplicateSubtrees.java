package Practice.tree.binary;

import java.util.ArrayList;
import java.util.List;

import Practice.algorithm.AbstractBaseTree;

public class FindDuplicateSubtrees extends AbstractBaseTree {

	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<TreeNode> list = new ArrayList<TreeNode>();
		findDuplicateSubtrees(root.left, root.right, list);
		return list;

	}

	public static void findDuplicateSubtrees(TreeNode root1, TreeNode root2, List<TreeNode> nodes) {
		if (root1 == null || root2 == null) {
			return;
		}
		findDuplicateSubtrees(root1.left, root2.left, nodes);
		findDuplicateSubtrees(root1.right, root2.right, nodes);

		if (root1.left == null && root1.left == root2.left) {
			nodes.add(root1);
		}
		if (root1.right == null && root1.right == root2.right) {
			nodes.add(root1);
		}
		if(root1.left != null && root2.left != null && root1.left.val == root2.left.val) {
			nodes.add(root1);
		}
		if(root1.right != null && root2.right != null && root1.right.val == root2.right.val) {
			nodes.add(root1);
		}
	}

	public static void main(String[] args) {
		System.out.println(findDuplicateSubtrees(getSamplee2()));
	}

}
