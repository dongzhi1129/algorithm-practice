package Practice.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class AbstractBaseTree {

	public static class TreeNode implements Cloneable {

		public Integer val;

		public TreeNode left;

		public TreeNode right;

		public TreeNode() {
			super();
		}

		public TreeNode(Integer val, TreeNode left, TreeNode right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}

	}

	/**
	 * 5 / \ 4 3 \ / 1 2
	 * 
	 * @return
	 */
	public static TreeNode getSamplee() {
		TreeNode treeNode1 = new TreeNode(1, null, null);
		TreeNode treeNode2 = new TreeNode(2, null, null);
		TreeNode treeNode3 = new TreeNode(3, treeNode2, null);
		TreeNode treeNode4 = new TreeNode(4, null, treeNode1);
		TreeNode treeNode = new TreeNode(-10, treeNode4, treeNode3);
		return treeNode;
	}

	public static TreeNode getSamplee2() {
		TreeNode treeNode1 = new TreeNode(1, null, null);
		TreeNode treeNode2 = new TreeNode(2, null, null);
		TreeNode treeNode3 = new TreeNode(3, treeNode2, null);
		TreeNode treeNode4 = new TreeNode(4, treeNode1, null);
		TreeNode treeNode = new TreeNode(5, treeNode4, treeNode3);

		return treeNode;
	}

	public static TreeNode getSamplee3() {
		TreeNode treeNode1 = new TreeNode(3, null, null);
		TreeNode treeNode2 = new TreeNode(2, null, null);
		TreeNode treeNode3 = new TreeNode(6, treeNode2, null);
		TreeNode treeNode4 = new TreeNode(4, treeNode1, null);
		TreeNode treeNode = new TreeNode(5, treeNode4, treeNode3);

		return treeNode;
	}

	public static void FirstRootNavigate(TreeNode treeNode) {
		if (treeNode != null) {
			System.out.println(treeNode.val);
			FirstRootNavigate(treeNode.left);
			FirstRootNavigate(treeNode.right);
		}
	}

	public static void firstRootNavigatePlus(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<>();
		if (treeNode != null) {
			stack.push(treeNode);
		}
		while (!stack.isEmpty()) {
			TreeNode root = stack.pop();
			System.out.println(root.val);
			TreeNode rightTreeNode = root.right;
			if (rightTreeNode != null) {
				stack.push(rightTreeNode);
			}
			TreeNode leftTreeNode = root.left;
			if (leftTreeNode != null) {
				stack.push(leftTreeNode);
			}
		}
	}

	public static void middleeRootNavigate(TreeNode treeNode) {
		if (treeNode != null) {
			middleeRootNavigate(treeNode.left);
			System.out.println(treeNode.val);
			middleeRootNavigate(treeNode.right);
		}
	}

	public static void middleeRootNavigatePlus(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<>();
		if (treeNode != null) {
			stack.push(treeNode);
		}
		while (stack.isEmpty() || treeNode != null) {

		}

	}

	public static void lastRootNavigate(TreeNode treeNode) {
		if (treeNode != null) {
			lastRootNavigate(treeNode.left);
			lastRootNavigate(treeNode.right);
			System.out.println(treeNode.val);
		}
	}

//	public static TreeNode getTestTree(int... cases) {
//		int depth = 0;
//		int srcIte = 0;
//		int caseLength = cases.length;
//		LinkedList<TreeNode> lastedLayerTreeNode = new LinkedList<>();
//		lastedLayerTreeNode.add(new TreeNode(cases[0], null, null));
//		while (!lastedLayerTreeNode.isEmpty()) {
//			int size = lastedLayerTreeNode.size();
//			for (int i = 0; i < size && srcIte < caseLength; i++) {
//				TreeNode node = lastedLayerTreeNode.poll();
//				int currentCases = cases[srcIte];
//				node.left = new TreeNode(currentCases, null, null);
//
//			}
//
//		}
//		return null;
//
//	}

	public static TreeNode generateTree(Integer... vals) {
		int length = 0;
		if ((length = vals.length) <= 0)
			return null;
		Map<Integer, TreeNode> pool = new HashMap<>();
		for (int i = 0; i < length / 2; i++) {
			int leftChildIndex = 2 * i + 1;
			TreeNode leftChild = null;
			if (leftChildIndex <length && vals[leftChildIndex] != null) {
				leftChild = new TreeNode(vals[leftChildIndex], null, null);
				pool.put(leftChildIndex, leftChild);
			}
			int rightChildIndex = 2 * i + 2;
			TreeNode rightChild = null;
			if (rightChildIndex < length && vals[rightChildIndex] != null) {
				rightChild = new TreeNode(vals[rightChildIndex], null, null);
				pool.put(rightChildIndex, rightChild);
			}
			TreeNode currentNode = null;
			if (!pool.containsKey(i)) {
				currentNode = new TreeNode(vals[i], leftChild, rightChild);
			} else {
				currentNode = pool.get(i);
				currentNode.left = leftChild;
				currentNode.right = rightChild;
			}
			pool.put(i, currentNode);
		}
		return pool.get(0);

	}

	public static void treeBFS(TreeNode root) {
		if (root == null) {
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode topElem = queue.poll();
				System.out.print(topElem == null ? "NULL" : topElem.val + " ");
				if(topElem.left != null) {
					queue.add(topElem.left);
				}
				if(topElem.right != null) {
					queue.add(topElem.right);
				}
			}
			System.out.println("----------------");

		}

	}

	public static void main(String[] args) {
//		middleeRootNavigatePlus(getSamplee());
		TreeNode node = generateTree(1,2,3,3,4,5,null);
		treeBFS(node);
	}

}
