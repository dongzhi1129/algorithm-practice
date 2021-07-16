package Practice.algorithm;

public class ShareLinkList extends AbstractBaseObject {

	public static void getSharedContent(Node l1, Node l2) {
		if (l1 == null || l2 == null) {
			return;
		}
		Node l1Pointer = l1, l2Pointer = l2;
		while (l1 != null && l2 != null) {
			if (l1.element < l2.element) {
				l1 = l1.next;
			} else if (l1.element > l2.element) {
				l2 = l2.next;
			} else {
				System.out.println(l1.element);
				l1 = l1.next;
				l2 = l2.next;
			}
		}

	}
	public static void main(String[] args) {
		
		Node node1 = AbstractBaseObject.getSampleNode();
		Node node2 = AbstractBaseObject.getSample2Node();
		getSharedContent(node1,node2);
		
	}

}
