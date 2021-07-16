package Practice.algorithm;

public class AbstractBaseObject {

	protected static class Node {

		public int element;

		public Node next;

		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Node(int element, Node next) {
			super();
			this.element = element;
			this.next = next;
		}

	}

	public static Node getSampleNode() {
		Node head = new Node();
		head.element = 0;
		Node node1 = new Node();
		node1.element = 1;
		Node node2 = new Node();
		node2.element = 2;
		Node node3 = new Node();
		node3.element = 3;
		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		return head;
	}

	public static Node getSample2Node() {
		Node head = new Node();
		head.element = 1;
		Node node1 = new Node();
		node1.element = 2;
		Node node2 = new Node();
		node2.element = 3;
		head.next = node1;
		node1.next = node2;
		node2.next = null;
		return head;
	}
	
	public static void printLink(Node node) {
		while(node != null) {
			System.out.print(node.element + "----->");
			node = node.next;
		}
		System.out.println("NULL");
		
	}

}
