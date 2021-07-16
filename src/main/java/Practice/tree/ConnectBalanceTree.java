package Practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectBalanceTree extends Node {

	public Node connect(Node root) {
		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {

			int levelSize = queue.size();
			Node priorNode = null;
			for (int i = 0; i < levelSize; i++) {
				Node node = queue.poll();
				if (node.right != null) {
					queue.add(node.right);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				node.next = priorNode;
				priorNode = node;

			}
		}
		return root;

	}

}
