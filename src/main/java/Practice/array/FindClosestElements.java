package Practice.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindClosestElements {

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		LinkedList<Integer> resultFinal = new LinkedList<Integer>();
		if (arr == null || arr.length <= 0 || k <= 0) {
			return resultFinal;
		}
		int minimuElemIndex = Integer.MIN_VALUE, arrLength = arr.length;
		int minusResult = Integer.MAX_VALUE;
		for (int i = 0; i < arrLength; i++) {
			int result = Math.abs(arr[i] - x);
			if (minusResult > result) {
				minusResult = result;
				minimuElemIndex = i;
			}
		}
		int leftIndex = minimuElemIndex, rightIndex = minimuElemIndex;
		while ((leftIndex >= 0 || rightIndex < arrLength) && resultFinal.size() < k) {
			if (minimuElemIndex == leftIndex && minimuElemIndex == rightIndex) {
				resultFinal.add(arr[minimuElemIndex]);
				leftIndex--;
				rightIndex++;
				continue;
			}
			if (leftIndex >= 0 && rightIndex < arrLength) {

				int leftVal = Math.abs(arr[leftIndex] - x);
				int rightVal = Math.abs(arr[rightIndex] - x);
				if (leftVal <= rightVal) {
					resultFinal.offerFirst(arr[leftIndex--]);
				} else if (leftVal > rightVal) {
					resultFinal.offerLast(arr[rightIndex++]);
				}
				
			} else if (leftIndex < 0) {
				resultFinal.offerLast(arr[rightIndex++]);
			} else if (rightIndex >= arrLength) {
				resultFinal.offerFirst(arr[leftIndex--]);
			}
		}
		return resultFinal;

	}

	public static void main(String[] args) {
		int[] arr = { 0,1,2,2,2,3,6,8,8,9};
		int k = 5;
		int x = 9;
		System.out.println(findClosestElements(arr, k, x));
	}

}
