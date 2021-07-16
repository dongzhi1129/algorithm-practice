package Optimization;

import java.util.Arrays;

public class KeyBoard {

	public static int maxKeyWords(int n) {
		if (n <= 0) {
			return 0;
		}

		int[] dp = new int[n + 1];
		for (int i = 1; i < dp.length; i++) {
			if (i - 3 < 0) {
				dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
			} else if (i - 3 == 0 && dp[i] == 0) {
				dp[i] = Math.max(dp[i - 1] + 1, dp[i]);
			} else {
				dp[i] = Math.max(dp[i-1] + 1, dp[i - 3] * 2);
			}

		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 0;
		System.out.println(maxKeyWords(7));
	}

}
