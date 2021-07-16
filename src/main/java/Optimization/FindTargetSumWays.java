package Optimization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTargetSumWays {

	public static int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		List<Integer> result = getResult(nums, nums.length);
		int count = 0;
		for (int i = 0; i < result.size(); i++) {
			int currentVal = result.get(i);
			if (currentVal == S) {
				count++;
			}
		}
		return count;

	}

	public static int findTargetSumWaysDp(int[] nums, int S) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int length = nums.length;
		int[][] dp = new int[length][S];
		for (int i = 0; i < length; i++) {
			
		}

		return count;

	}

	public static List<Integer> getResult(int[] nums, int depth) {
		if (depth == 0) {
			return Arrays.asList(0);
		}
		int positiveNumber = nums[depth - 1];
		int negitiveNumber = -nums[depth - 1];
		List<Integer> getLastedResult = getResult(nums, depth - 1);
		List<Integer> result = new ArrayList<Integer>(2 * getLastedResult.size());
		for (int i = 0; i < getLastedResult.size(); i++) {
			int currentVal = getLastedResult.get(i);
			result.add(currentVal + positiveNumber);
			result.add(currentVal + negitiveNumber);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int S = 3;
		System.out.println(findTargetSumWays(nums, S));
	}
}
