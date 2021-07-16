package Practice.algorithm;

public class AddTwoNumbers extends AbstractBaseObject {

	public static Node addTwoNumbers(Node l1, Node l2) {
		if (l1 == null || l2 == null) {
			return null;
		}
		int forwardBit = 0;
		Node l1Ite = l1, l2Ite = l2, result = null, resultIte = null;
		while (l1Ite != null || l2Ite != null) {
			int l1IteBit = 0, l2IteBit = 0;
			if (l1Ite != null) {
				l1IteBit = l1Ite.element;
				l1Ite = l1Ite.next;
			}
			if (l2Ite != null) {
				l2IteBit = l2Ite.element;
				l2Ite = l2Ite.next;
			}
			int currentBit = (forwardBit + l1IteBit + l2IteBit) % 10;
			if (result == null) {
				result = resultIte = new Node(currentBit, null);
			} else {
				resultIte.next = new Node(currentBit, null);
				resultIte = resultIte.next;
			}
			forwardBit = (forwardBit + l1IteBit + l2IteBit) / 10;
		}
		if(forwardBit != 0) {
            resultIte.next = new Node(forwardBit, null);
        }
		return result;

	}
	
	public static void main(String[] args) {
		Node node1 = getSampleNode();
		Node node2 = getSample2Node();
		Node result = addTwoNumbers(node1,node2);
		printLink(result);
	}

}
