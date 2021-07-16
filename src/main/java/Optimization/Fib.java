package Optimization;

import java.util.List;

public class Fib {

	public static int fib(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static int fibT(int n) {
		if (n < 0) {
			return 0;
		}
		int[] helps = new int[n + 1];
		return help(helps, n);

	}

	public static int help(int[] helps, int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		if (helps[n] != 0) {
			return helps[n];
		}
		helps[n] = help(helps, n - 1) + help(helps, n - 2);
		return helps[n];
	}

	public static void main(String[] args) {
		System.out.println(fibT(3));
	}
}
