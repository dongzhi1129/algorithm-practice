package Practice.algorithm;

public class ReverseSingleLink extends AbstractBaseObject {

	public static Node reverseLinkList(Node node) {
		if (node == null) {
			return null;
		}

		Node forward = null, current = node, next = null;
		while (current != null) {
			next = current.next;
			current.next = forward;
			forward = current;
			current = next;
		}
		return forward;

	}

	public static Node reverseLinkListIte(Node node) {
		if (node.next == null) {
			return node;
		} 
		Node reverseNode = reverseLinkListIte(node.next);
		node.next.next = node;
		node.next = null;
		return reverseNode;

	}

	public static void main(String[] args) {

		Node node = reverseLinkListIte(getSampleNode());
		printLink(node);

	}

}
