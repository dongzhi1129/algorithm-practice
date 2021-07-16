package Optimization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaxForm {

	public static int findMaxForm(String[] strs, int m, int n) {

		if (strs == null || strs.length <= 0 || m <= 0 || n <= 0) {
			return 0;
		}

		int[][][] dp = new int[strs.length + 1][m + 1][n + 1];

		for (int i = 1; i <= strs.length; i++) {
			int zeroQuantiy = 0, oneQuantity = 0;
			String currentStr = strs[i-1];
			int currentStrength = currentStr.length();
			for (int ii = 0; ii < currentStrength; ii++) {
				char currentChar = currentStr.charAt(ii);
				if ('0' == currentChar) {
					zeroQuantiy++;
				} else {
					oneQuantity++;
				}
			}

			for (int j = 0; j <= m; j++) {
				for (int k = 0; k <= n; k++) {
					if (j >= zeroQuantiy && k >= oneQuantity) {
						dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zeroQuantiy][k - oneQuantity] + 1);
					} else {
						dp[i][j][k] = dp[i - 1][j][k];
					}

				}

			}

		}
		return dp[strs.length][m][n];
	}

	public static void main(String[] args) {
		String[] strs = { "10", "0001", "111001", "1", "0" };
		int m = 5, n = 3;
		System.out.println(findMaxForm(strs,m,n));

	}

}
