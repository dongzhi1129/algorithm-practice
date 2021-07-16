package Optimization;

import java.util.Arrays;

public class LengthOfLIS {

	public static int lengthOfLIS(int[] nums) {
		int numsLength = 0;
		if (nums == null || (numsLength = nums.length) <= 0) {
			return 0;
		}
		int[] dp = new int[numsLength];
		Arrays.fill(dp, 1);

		for (int i = 0; i < numsLength; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}

			}

		}
		int result = 0;
		for (int k = 0; k < numsLength; k++) {
			result = Math.max(result, dp[k]);
		}
		return result;

	}
	
	
	
	
	
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
	}

}
