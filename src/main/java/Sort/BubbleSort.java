package Sort;

import java.util.Arrays;

public class BubbleSort extends AbstractSort {

	public int[] bubbleSort(int[] src) {
		int length = 0;
		if (src == null || (length = src.length) <= 0) {
			return src;
		}
		boolean finished = false;
		for (int i = 0; i < length - 1 && !finished; i++) {
			finished = true;
			for (int j = length - 1; j > i; j--) {
				if (src[j] < src[j - 1]) {
					int temp = src[j - 1];
					src[j - 1] = src[j];
					src[j] = temp;
					finished = false;
				}
			}
		}
		return src;
	}

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		String result = Arrays.toString(bubbleSort.bubbleSort(bubbleSort.generateTestData()));
		System.out.println(result);
	}

}
