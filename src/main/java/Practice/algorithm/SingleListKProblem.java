package Practice.algorithm;

public class SingleListKProblem extends AbstractBaseObject {

	public static void getElemntOfK(Node src, int k) {

		if (src == null || k <= 0) {
			return;
		}
		Node forwardKite = src;
		while (k > -1 && forwardKite != null) {
			forwardKite = forwardKite.next;
			k--;
		}
		if (k != -1) {
			return;
		}
		Node nextIte = src;
		while (forwardKite != null) {
			nextIte = nextIte.next;
			forwardKite = forwardKite.next;
		}
		System.out.println(nextIte.element);
	}
	
	public static void main(String[] args) {
		Node node = AbstractBaseObject.getSampleNode();
		getElemntOfK(node,2);
	}

}
