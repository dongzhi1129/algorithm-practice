package Practice.tree;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import Practice.algorithm.AbstractBaseTree;

public class GenerateTrees extends AbstractBaseTree {

	public List<TreeNode> generateTrees(int n) throws CloneNotSupportedException {
		TreeNode road = null;
		LinkedList<TreeNode> roads = new LinkedList<>();
		Set<Integer> visited = new LinkedHashSet<>(n);
		travers( roads, n, visited);
		return roads;

	}

	public void travers(LinkedList<TreeNode> roads, int n, Set<Integer> visited) throws CloneNotSupportedException {
		if (visited.size() == n) {
			TreeNode node = null;
			for (Integer integer : visited) {
				node = insertbinarySearchTree(node, integer);
			}
			roads.add(node);
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (visited.contains(i)) {
				continue;
			}
			visited.add(i);
			travers(roads, n, visited);
			visited.remove(i);
		}

	}

	public static TreeNode insertbinarySearchTree(TreeNode root, int elem) {
		if (root == null) {
			root = new TreeNode(elem, null, null);
			return root;
		}
		if (elem < root.val) {
			root.left = insertbinarySearchTree(root.left, elem);
		} else {
			root.right = insertbinarySearchTree(root.right, elem);
		}
		return root;
	}

	public static void deleteSearchTree(TreeNode root, TreeNode newNode) {
		// 引用当前节点，从根节点开始
		TreeNode current = root;
		// 应用当前节点的父节点
		TreeNode parent = root;
		// 是否为左节点
		boolean isleft = true;

		while (current.val != newNode.val) {
			parent = current;
			// 进行比较，比较查找值和当前节点的大小
			if (current.val > newNode.val) {
				current = current.left;
				isleft = true;
			} else {
				current = current.right;
				isleft = false;
			}
		}
		// 删除叶子节点，也就是该节点没有子节点
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			} else if (isleft) {// 如果它是父节点的左子节点
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isleft) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
		} else if (current.left == null) {
			if (current == root) {
				root = current.right;
			} else if (isleft) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
		} else {
			TreeNode successor = getSuccessor(current);
			if (current == root) {
				root = successor;
			} else if (isleft) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
		}

	}

	public static TreeNode getSuccessor(TreeNode delNode) {
		TreeNode successor = delNode;
		TreeNode successorParent = delNode;
		TreeNode current = delNode.right;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if (successor != delNode.right) {
			//
			successorParent.left = successor.right;
			// 将删除的节点的整个右子树挂载到中继节点的右子树上
			successor.right = delNode.right;
		}
		return successor;
	}

	public static void printTree(TreeNode root) {
		if (root == null) {
			System.out.print(" null ");
			return;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.push(root);
		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.pop();
			System.out.print(String.format(" %s ", currentNode.val));
			if (currentNode.left != null) {
				queue.push(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.push(currentNode.right);
			}
		}

	}

	public static void main(String[] args) {
		GenerateTrees t = new GenerateTrees();
		try {
			List<TreeNode> treeNode = t.generateTrees(3);
			ListIterator<TreeNode> node = treeNode.listIterator();
			while (node.hasNext()) {
				printTree(node.next());
				System.out.println();
			}

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
