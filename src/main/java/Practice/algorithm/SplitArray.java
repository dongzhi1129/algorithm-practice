package Practice.algorithm;

import java.util.Arrays;

public class SplitArray {

	public static int splitArray(int[] nums) {
		int start = 0, end = 0, count = 0, length = 0;
		if (nums == null || (length = nums.length) <= 0) {
			return 0;
		}
		while (start < length) {

			int i = start;
			int j = length - 1;
			while (i < j) {
				boolean isMaxDivLeagal = isMaxDivLeagal(nums[i], nums[j]);
				if (isMaxDivLeagal) {
					start = j + 1;
					count++;
					int[] nw = Arrays.copyOfRange(nums, i, j);
					System.out.println(Arrays.toString(nw));
					break;
				} else {
					j--;
				}

			}
			if (i == j) {
				start++;
				count++;
				System.out.println(nums[i]);
			}

		}
		return count;

	}

	private static int maxDiv(int x, int y) {
		if (x == 0 || y == 0) {
			return 0;
		}
		int max = Math.max(x, y);
		int min = Math.min(x, y);
		while (max % min != 0) {
			int temp = max - min;
			max = Math.max(temp, min);
			min = Math.min(temp, min);
		}
		return min;
	}

	private static boolean isMaxDivLeagal(int x, int y) {
		int src = maxDiv(x, y);
		if (src <= 1) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] nums = {782581,227,113147,13451,288053,684113,413579,917629,454021,827633,673787,514127,432001,507961,790051,164617,139759,315881,160681,235231,106627,135977,483811,570839,758699,549011,389227,21961,524347,24763,882247,932101,717559,124853,967919,968111,966439,967229,967739,968213,967171,966509,967397,967481,968111,967297,968311,967753,966677,968573,966527,966653,967319,967663,967931,968021,967961,968423,966727,967937,967699,966883,968017,968311,967781,966617,967937,967763,967459,966971,968567,968501,966991,966613,968557,966863,966619,966863,966727,967567,967061,966913,966631,968021,968003,968431,968291,969667,970667,971723,969011,972113,972373,969929,971491,970027,973031,982973,980491,985657};
		System.out.println(splitArray(nums));

	}

}
