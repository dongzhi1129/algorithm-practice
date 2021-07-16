package Practice.algorithm;

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 0) {
			return 0;
		}
		int minValue = Integer.MAX_VALUE;
		int length = prices.length;
		int maxValue = 0;

		for (int i = 0; i < length; i++) {
			int currentPrice = prices[i];
			if (currentPrice < minValue) {
				minValue = currentPrice;
			} else {
				maxValue = (currentPrice - minValue) > maxValue ? currentPrice - minValue : maxValue;
			}
		}
		return maxValue;

	}

	public int maxProfitPlus(int[] prices) {
		if (prices == null || prices.length <= 0) {
			return 0;
		}
		int minStart = Integer.MAX_VALUE;
		int maxStart = 0;
		int maxValue = 0;
		int length = prices.length;
		for (int i = 0; i < length; i++) {
			int currentPrice = prices[i];
			if (currentPrice <= minStart) {
				maxStart = minStart = currentPrice;
			} else if (currentPrice > maxStart) {
				maxStart = currentPrice;
			}
			if (currentPrice <= maxStart) {
				maxValue += maxStart - minStart;
				minStart = maxStart = currentPrice;
			}
		}
		return maxValue;
	}

	public static int maxProfitPlusTowTransaction(int[] prices) {
		if (prices == null || prices.length <= 0) {
			return 0;
		}
		int minStart = prices[0];
		int maxStart = prices[0];
		int maxValue = 0;
		int length = prices.length;
		int firstTransctionValue = 0, secondTransctionValue = 0;
		for (int i = 1; i < length; i++) {
			int currentPrice = prices[i];
			if (currentPrice >= maxStart) {
				maxStart = currentPrice;
				continue;
			}
			maxValue = maxStart - minStart;
			minStart = maxStart = currentPrice;
			if (firstTransctionValue == 0) {
				firstTransctionValue = maxValue;
			} else if (secondTransctionValue == 0) {
				secondTransctionValue = maxValue;
			} else if (firstTransctionValue > secondTransctionValue) {
				int temp = firstTransctionValue;
				firstTransctionValue = secondTransctionValue;
				secondTransctionValue = temp;
			}
			if (maxValue > firstTransctionValue && maxValue < secondTransctionValue) {
				firstTransctionValue = maxValue;
			} else if (maxValue > secondTransctionValue) {
				firstTransctionValue = secondTransctionValue;
				secondTransctionValue = maxValue;
			}
		}
		if (firstTransctionValue == 0 && firstTransctionValue == 0) {
			return maxStart - minStart;
		}
		return firstTransctionValue + secondTransctionValue;
	}

	public static void main(String[] args) {
		int[] src = { 3, 3, 5, 0, 0, 3, 1, 4 };
		System.out.println(maxProfitPlusTowTransaction(src));

	}
}
