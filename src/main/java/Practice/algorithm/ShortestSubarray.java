package Practice.algorithm;

import java.util.Map;
import java.util.TreeMap;

public class ShortestSubarray {

	public static int shortestSubarray(int[] A, int K) {
		if (A == null || A.length <= 0) {
			return -1;
		}
		Map<Integer, Integer> cache = new TreeMap<>();
		cache.put(0, -1);
		int length = -1, sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
			int diff = sum - K;
			if (!cache.containsKey(diff)) {
				cache.put(sum, i);
			} else {
				length = Math.min(length, i - cache.get(diff));
			}

		}
		return length;

	}
	public static void main(String[] args) {
		int[] A = {48,99,37,4,-31};
		System.out.println(shortestSubarray(A,140));
	}

}
