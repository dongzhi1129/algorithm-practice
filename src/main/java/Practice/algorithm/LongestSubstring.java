package Practice.algorithm;

import java.util.Arrays;

public class LongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		int length;
		if (s == null || (length = s.length()) <= 0) {
			return 0;
		}

		int leftIndex = 0, rightIndex = leftIndex + 1;
		Integer maxSubStringLength = Integer.MIN_VALUE;
		while (leftIndex < length && rightIndex < length) {
			String currentSubStr = s.substring(leftIndex, rightIndex);
			char currentChar = s.charAt(rightIndex);
			if (currentSubStr.contains(String.valueOf(currentChar))) {
				maxSubStringLength = maxSubStringLength >= currentSubStr.length() ? maxSubStringLength
						: currentSubStr.length();
				leftIndex++;
			} else {
				rightIndex++;
			}

		}
		maxSubStringLength = rightIndex - leftIndex > maxSubStringLength ? rightIndex - leftIndex : maxSubStringLength;
		return maxSubStringLength;

	}

	public static String longestPalindromic(String s) {
		int length = s.length();
		int[][] flags = new int[length][length];

		int maxLength = -1, leftIndex = -1, rightIndex = -1;
		for (int i = 0; i < length - 1; i++) {

			for (int j = length - 1; j >= i; j--) {
				if (i == j) {
					flags[i][j] = 1;
					continue;
				}
				if (j - i == 1 && s.charAt(i) == s.charAt(j)) {
					flags[i][j] = 1;
					continue;
				}
				if (flags[i + 1][j - 1] == 1 && s.charAt(i) == s.charAt(j)) {
					maxLength = maxLength > (j - i + 1) ? maxLength : j - i + 1;
					leftIndex = i;
					rightIndex = j;
					continue;
				}
				flags[i][j] = 0;
			}

		}
		System.out.println(leftIndex + " " + rightIndex);
		return s.substring(leftIndex, rightIndex + 1);

	}

	public static int lengthOfLongestSubstringV2(String s) {
		int longestSubStrLength = 0;
		if (s == null || s.trim().length() <= 0) {
			return longestSubStrLength;
		}
		int[] flagIndexStorage = new int[128];
		Arrays.fill(flagIndexStorage, -1);
		int leftIndex = 0, rightIndex = 0, strLength = s.length();
		while (leftIndex <= rightIndex && rightIndex < strLength) {
			if (leftIndex == rightIndex) {
				longestSubStrLength = Math.max(1, longestSubStrLength);
				flagIndexStorage[s.charAt(rightIndex)] = rightIndex;
				rightIndex++;
				continue;
			}
			int rightWindowStr = s.charAt(rightIndex);
			int leftWindowStrIndex = flagIndexStorage[rightWindowStr];
			if(leftWindowStrIndex != -1) {
				longestSubStrLength = Math.max(rightIndex - leftIndex, longestSubStrLength);
				leftIndex = leftWindowStrIndex + 1;
			}
			flagIndexStorage[rightWindowStr] = rightIndex;
			rightIndex++;

		}
		longestSubStrLength = Math.max(rightIndex - leftIndex, longestSubStrLength);
		return longestSubStrLength;

	}

	public static void main(String[] args) {
		String str = "abba";
		System.out.println(LongestSubstring.lengthOfLongestSubstringV2(str));
//		System.out.println(LongestSubstring.longestPalindromic(str));

	}

}
