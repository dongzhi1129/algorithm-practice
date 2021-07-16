package Optimization;

import java.util.Arrays;

//找零钱问题
public class Exchange {

	public static int countWays(int[] penny, int aim) {
		if (penny == null || penny.length <= 0 || aim <= 0) {
			return 0;
		}
		int[] dp = new int[aim + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		int minimumCount = Integer.MAX_VALUE;
		for (int i = 0; i < penny.length; i++) {
			// 子问题
			int result = countWays(penny,aim - penny[i]);
			if (result == -1) {
				continue;
			}
			minimumCount = Math.min(minimumCount, result + 1);
		}
		return dp[aim];
	}

	public static int countWaysDp(int[] penny, int n, int[] dp) {
		if (n == 0) {
			return 0;
		}
		if (n < 0) {
			return -1;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int minimumCount = Integer.MAX_VALUE;
		for (int i = 0; i < penny.length; i++) {
			// 子问题
			int result = countWaysDp(penny, n - penny[i], dp);
			if (result == -1) {
				continue;
			}
			minimumCount = Math.min(minimumCount, result + 1);
		}
		int finalResult = -1;
		if (minimumCount != Integer.MAX_VALUE) {
			finalResult = minimumCount;
		}
		dp[n] = finalResult;
		return finalResult;

	}

//	public static int exchangeAmount(int[] penny, int aim) {
//		if (penny == null || penny.length <= 0 || aim <= 0) {
//			return 0;
//		}
//		int maxCoinValue = penny[penny.length - 1];
//		int[][] dp = new int[aim + 1][maxCoinValue + 1];
//
//		for (int i = 1; i <= aim; i++) {
//			for (int j = 1; j <= maxCoinValue; j++) {
//				if (j > i) {
//					dp[i][j] = dp[i - 1][j - 1];
//				} else {
//					dp[i][j] = dp[i - 1][j - 1] + dp[i-j][];
//				}
//			}
//
//		}
//		System.out.println(Arrays.deepToString(dp));
//		return dp[aim][penny[penny.length - 1]];
//
//	}

	public static void main(String[] args) {
		int[] penny = { 1, 2, 5, 10 };
		int aim = 3;
		System.out.println(countWays(penny, aim));
	}
}
