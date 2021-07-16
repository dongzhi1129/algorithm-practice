package Practice.tree.binary;

import java.util.LinkedList;
import Practice.algorithm.AbstractBaseTree;
import Practice.algorithm.AbstractBaseTree.TreeNode;

public class OwestCommonAncestor {

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (p == null && q != null) {
			return q;
		}
		if (q == null && p != null) {
			return p;
		}
		if (p == null && q == null) {
			return null;
		}

		LinkedList<TreeNode> pParent = new LinkedList();
		LinkedList<TreeNode> qParent = new LinkedList();
		LinkedList<TreeNode> pVisited = new LinkedList();
		LinkedList<TreeNode> qVisited = new LinkedList();
		findAncestor(root, p, pVisited, pParent);
		findAncestor(root, q, qVisited, qParent);
		TreeNode commonAncestor = root;
		while (!pParent.isEmpty() && !qParent.isEmpty()) {
			TreeNode pAncestor = pParent.pollFirst();
			TreeNode qAncestor = qParent.pollFirst();
			if (pAncestor == qAncestor) {
				commonAncestor = pAncestor;
			} else {
				break;
			}

		}
		return commonAncestor;

	}

	public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if (p == root || q == root) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if(left == null && right == null) {
			return null;
		}
		return left == null?right:left;

	}

	public static void findAncestor(TreeNode root, TreeNode p, LinkedList<TreeNode> visited,
			LinkedList<TreeNode> trace) {
		if (root == null) {
			return;
		}
		if (root == p) {
			visited.add(p);
			trace.addAll(new LinkedList<>(visited));
		}
		if (!visited.contains(root.left)) {
			visited.add(root.left);
			findAncestor(root.left, p, visited, trace);
			visited.removeLast();
		}
		if (!visited.contains(root.right)) {
			visited.add(root.right);
			findAncestor(root.right, p, visited, trace);
			visited.removeLast();
		}
	}

	public static void main(String[] args) {
		TreeNode root = AbstractBaseTree.getSamplee2();
		TreeNode pa = lowestCommonAncestor(root, root.right.left, root.right);
		System.out.println(pa.val);
	}

}
