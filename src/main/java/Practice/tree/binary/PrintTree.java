package Practice.tree.binary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Practice.algorithm.AbstractBaseTree;
import Practice.algorithm.AbstractBaseTree.TreeNode;

public class PrintTree {

	public static List<List<String>> printTree(TreeNode root) {
		List<List<String>> result = new LinkedList<List<String>>();
		if (root == null) {
			return result;
		}
		int depth = depthOfTree(root);
		int cols = (int) Math.pow(2, depth) - 1;
		for (int i = 0; i < depth; i++) {
			String[] row = new String[cols];
			Arrays.fill(row, "");
			result.add(Arrays.asList(row));
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.push(root);
		int currentDepth = 0;
		while (!queue.isEmpty() && currentDepth < depth) {
			int currntRowCapacity = (int) Math.pow(2, currentDepth + 1) - 1;
			int startIndex = ((int) Math.pow(2, depth - currentDepth) - 1) / 2;
			int offset = (cols - currntRowCapacity) / 2;
			List<String> currentRow = result.get(currentDepth);
			// 左子树填充
			int lefCount = 0;
			while (lefCount < currntRowCapacity) {
				// 左子树
				TreeNode currentNode = null;
				if (lefCount <= currntRowCapacity / 2) {
					currentNode = queue.poll();
					String settedValue = currentNode == null ? "" : String.valueOf(currentNode.val);
					currentRow.set(startIndex + lefCount, settedValue);
				} else {
					currentNode = queue.poll();
					String settedValue = currentNode == null ? "" : String.valueOf(currentNode.val);
					currentRow.set(startIndex + lefCount + offset, settedValue);
				}
				lefCount += 2;
				if (currentNode != null) {
					queue.add(currentNode.left);
					queue.add(currentNode.right);
				} else {
					queue.add(null);
					queue.add(null);
				}
			}
			currentDepth++;

		}
		return result;

	}

	public static int depthOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = depthOfTree(root.left);
		int rightDepth = depthOfTree(root.right);
		return 1 + Math.max(leftDepth, rightDepth);
	}

	public static void main(String[] args) {
		System.out.println(printTree(AbstractBaseTree.getSamplee()));
	}

}
