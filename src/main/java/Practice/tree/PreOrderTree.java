package Practice.tree;

import java.util.Stack;

import Practice.algorithm.AbstractBaseTree;

public class PreOrderTree extends AbstractBaseTree {

	public static void preOrderTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> nodes = new Stack<AbstractBaseTree.TreeNode>();
		nodes.add(root);
		while (nodes.size() > 0) {
			TreeNode node = nodes.pop();
			System.out.println(node.val);
			if (node.right != null) {
				nodes.add(node.right);
			}
			if (node.left != null) {
				nodes.add(node.left);
			}
		}

	}

	public static void middleOrderTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> nodes = new Stack<AbstractBaseTree.TreeNode>();
		while (nodes.size() > 0 || root != null) {
			if (root != null) {
				nodes.add(root);
				root = root.left;
			} else {
				root = nodes.pop();
				System.out.println(root.val);
				root = root.right;
			}
			
		}

	}

	public static void main(String[] args) {
		TreeNode node = getSamplee();

//		preOrderTree(node);
		middleOrderTree(getSamplee());
	}

}
