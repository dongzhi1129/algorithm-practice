package Optimization;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class MaxDotProduct {

	public int maxDotProduct(int[] nums1, int[] nums2) {
		int nums1Length = 0, nums2Length = 0;
		if (nums1 == null || (nums1Length = nums1.length) <= 0 || nums2 == null || (nums2Length = nums2.length) <= 0) {
			return 0;
		}
		int[][] dp = new int[nums1Length + 1][nums2Length + 1];

		return 0;
	}

	private void trace(LinkedHashMap<String, Integer> maxValues, LinkedList<Integer> visitedNums1,
			LinkedList<Integer> visitedNums2, int[] nums1, int[] nums2) {
		if (!visitedNums1.isEmpty() && !visitedNums2.isEmpty() && visitedNums1.size() == visitedNums2.size()) {
			String key = "";
			int sum = 0;
			Iterator<Integer> ite1 = visitedNums1.iterator();
			Iterator<Integer> ite2 = visitedNums2.iterator();
			while (ite1.hasNext() && ite2.hasNext()) {
				Integer num1Index = ite1.next();
				Integer num2Index = ite2.next();
				key = String.format("%s:%s", num1Index, num2Index);
				key += ite1.hasNext() ? "_" : "";
				sum += (nums1[num1Index] * nums2[num2Index]);
			}
			maxValues.put(key, sum);

		}
		for (int i = 0; i < nums1.length; i++) {
			if (visitedNums1.contains(i)) {
				continue;
			}
			if (visitedNums1.isEmpty()) {
				visitedNums1.add(i);
			} else if (visitedNums1.getLast() < i) {
				visitedNums1.add(i);
			} else {
				continue;
			}

			for (int j = 0; j < nums2.length; j++) {
				if (visitedNums2.contains(j)) {
					continue;
				}
				if (visitedNums2.isEmpty()) {
					visitedNums2.add(j);
				} else if (visitedNums2.getLast() < j) {
					visitedNums2.add(j);
				} else {
					continue;
				}
				
			}
			trace
		}

	}

}
