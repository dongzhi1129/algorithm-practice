package Optimization;

public class MaxTurbulenceSize {

	public static int maxTurbulenceSize(int[] A) {
		int ALength = 0;
		int size = 1;
		if (A == null || (ALength = A.length) <= 0) {
			return 0;
		}
		if (ALength == 1) {
			return size;
		}
		int[] raise = new int[ALength];
		for (int i = 1; i < ALength; i++) {
			int minus = A[i] - A[i - 1];
			if (minus < 0) {
				raise[i] = -1;

			} else if (minus == 0) {
				raise[i] = 0;
			} else {
				raise[i] = 1;
			}
		}

		int startIndex = 1, endIndex = 1;
		int maxSize = size;
		while (startIndex <= endIndex && endIndex < ALength) {
			if (raise[startIndex] == -raise[endIndex]) {
				if (raise[startIndex] == 0) {
					startIndex = endIndex;
					maxSize = Math.max(maxSize, size);
					size = 1;
				} else {
					size++;
					startIndex = endIndex;
				}
			} else {
				startIndex = endIndex;
				maxSize = Math.max(maxSize, size);
				size = 2;
			}
			endIndex++;
		}
		return Math.max(maxSize, size);

	}

	public static void main(String[] args) {
		int[] A = { 0,8,45,88,48,68,28,55,17,24};
		System.out.println(maxTurbulenceSize(A));
	}

}
