package Practice.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeLevelOrderTraversal extends AbstractBaseTree {

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> flags = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0; i < size; ++i) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left != null) {
					queue.add(head.left);
				}
				if (head.right != null) {
					queue.add(head.right);
				}
			}
			flags.add(level);
		}
		return flags;

	}

	public static List<List<Integer>> levelOrderzigZag(TreeNode root) {
		List<List<Integer>> flags = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean isReverse = false;
		while (queue.size() > 0) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			if (!isReverse) {
				for (int i = 0; i < size; ++i) {
					TreeNode head = queue.poll();
					level.add(head.val);
					if (head.left != null) {
						queue.add(head.left);
					}
					if (head.right != null) {
						queue.add(head.right);
					}
				}
			} else {
				Stack<TreeNode> stack = new Stack<AbstractBaseTree.TreeNode>();
				for(int i = 0; i < size && !queue.isEmpty(); ++i) {
					TreeNode head = queue.poll();
					stack.push(head);
					if (head.left != null) {
						queue.add(head.left);
					}
					if (head.right != null) {
						queue.add(head.right);
					}
				}
				while(!stack.isEmpty()) {
					TreeNode head = stack.pop();
					level.add(head.val);
					
				}
			}
			isReverse = !isReverse;
			flags.add(level);
		}
		return flags;

	}

	public static void main(String[] args) {
		System.out.println(levelOrderzigZag(getSamplee()));
	}

}
