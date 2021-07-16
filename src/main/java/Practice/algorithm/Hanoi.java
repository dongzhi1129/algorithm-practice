package Practice.algorithm;

public class Hanoi {

	public static void move(String a, String b) {
		System.out.println("Move" + a + " ----> " + b);

	}

	public static void hanoi(int n, String a, String b, String c) {
		if (n == 1) {
			move(a, c);
		} else {

			hanoi(n - 1, a, c, b);
			move(a, c);
			hanoi(n - 1, b, a, c);
		}

	}

	public static void hanoiPlus(int n, String a, String b, String c) {
		if (n == 1) {
			move(a, b);
			move(b, c);
		} else {
			hanoiPlus(n - 1, a, b, c);
			move(a, b);
			hanoiPlus(n - 1, c,b,a);
			move(b,c);
			hanoiPlus(n - 1, a, b, c);
		}

	}

	public static void main(String[] args) {
		hanoiPlus(3, "A", "B", "C");
	}

}
