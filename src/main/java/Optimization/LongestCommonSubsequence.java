package Optimization;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static int longestCommonSubsequence(String str1, String str2) {
		int str1Length = 0, str2Length = 0;
		if (str1 == null || (str1Length = str1.length()) <= 0 || str2 == null || (str2Length = str2.length()) <= 0) {
			return 0;
		}
		int[][] dp = new int[str1Length + 1][str2Length + 1];

		for (int i = 1; i <= str1Length; i++) {
			for (int j = 1; j <= str2Length; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}

		}
		System.out.println(Arrays.deepToString(dp));
		return dp[str1Length][str2Length];
	}

	public static void main(String[] args) {
		String str1 = "abc", str2 = "abbc";
		System.out.println(longestCommonSubsequence(str1, str2));
	}

}
