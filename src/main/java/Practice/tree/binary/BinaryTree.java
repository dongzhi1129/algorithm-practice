package Practice.tree.binary;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Practice.algorithm.AbstractBaseTree;

public class BinaryTree extends AbstractBaseTree {

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> storage = new LinkedList<Integer>();
		traversal(root, storage);
		return storage;
	}

	// 递归实现
	private static void traversal(TreeNode root, List<Integer> storage) {
		if (root == null) {
			return;
		}
		traversal(root.left, storage);
		storage.add(root.val);
		traversal(root.right, storage);
	}

	// 非递归实现
	private static List<Integer> traversal(TreeNode root) {
		List<Integer> storage = new LinkedList<Integer>();
		if (root == null) {
			return storage;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = root;
		do {
			if (currentNode != null) {
				stack.add(currentNode);
				currentNode = currentNode.left;
			} else {
				TreeNode operatedNode = stack.pop();
				storage.add(operatedNode.val);
				currentNode = operatedNode.right;
			}

		} while (!stack.isEmpty() || currentNode != null);
		return storage;
	}

	private static List<Integer> traversalPre(TreeNode root) {
		List<Integer> storage = new LinkedList<Integer>();
		if (root == null) {
			return storage;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode currentNode = root;
		do {
			if (currentNode != null) {
				stack.push(currentNode);
				storage.add(currentNode.val);
				currentNode = currentNode.left;
			} else {
				TreeNode operatedNode = stack.pop();
				currentNode = operatedNode.right;
			}

		} while (!stack.isEmpty() || currentNode != null);
		return storage;
	}

	private static List<Integer> traversalBackend(TreeNode root) {
		List<Integer> storage = new LinkedList<Integer>();
		if (root == null) {
			return storage;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		Stack<TreeNode> tempStack = new Stack<>();
		TreeNode currentNode = root;
		while (!stack.isEmpty()) {
			currentNode = stack.pop();
			tempStack.push(currentNode);
			if (currentNode.left != null) {
				stack.add(currentNode.left);
			}
			if (currentNode.right != null) {
				stack.add(currentNode.right);
			}
		}
		while(!tempStack.isEmpty()) {
			storage.add(tempStack.pop().val);
		}

		return storage;
	}

	public static void main(String[] args) {
		System.out.println(traversalBackend(getSamplee()));

	}

}
