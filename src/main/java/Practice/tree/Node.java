package Practice.tree;

public class Node {

	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}

	protected Node mockBalanceNode() {

		Node left6 = new Node(6, null, null, null);
		Node left7 = new Node(7, null, null, null);

		Node left4 = new Node(4, null, null, null);
		Node left5 = new Node(5, null, null, null);

		Node left2 = new Node(2, left4, left5, null);
		Node left3 = new Node(3, left6, left7, null);

		Node root = new Node(1, left2, left3, null);

		return root;

	}

}
