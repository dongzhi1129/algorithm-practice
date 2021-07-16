package Sort;

import java.util.Arrays;

public class MergeSort extends AbstractSort {

	public int[] mergeSort(int[] src) {
		split(src, 0, src.length - 1);
		return src;
	}

	public void split(int[] src, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2	;
		split(src, low, mid);
		split(src, mid + 1, high);
		merge(src, low, mid, high);
	}

	public void merge(int[] src, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int[] storage = new int[high - low + 1];
		int k = 0;
		while (i <= mid && j <= high) {
			if (src[i] <= src[j]) {
				storage[k++] = src[i++];
			} else if (src[i] < src[j]) {
				storage[k++] = src[j++];
			}
		}
		while (i <= mid) {
			storage[k++] = src[i++];
		}
		while (j <= high) {
			storage[k++] = src[j++];
		}
		for (int h = 0; h < k; h++) {
			src[low + h] = storage[h];
		}
		return;
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] src = mergeSort.mergeSort(mergeSort.generateTestData());
		System.out.println(Arrays.toString(src));
	}

}
