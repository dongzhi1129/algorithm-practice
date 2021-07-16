package Practice.algorithm;

import java.util.Arrays;

public class Candy {

	public static int candy(int[] ratings) {
		int candyQuantity = 0, childrenQuantity = 0;
		if (ratings == null || (childrenQuantity = ratings.length) <= 0) {
			return candyQuantity;
		}
		int[] childrenCandies = new int[childrenQuantity];
		for (int i = 0; i < childrenQuantity; i++) {
			childrenCandies[i] = 1;
		}
		for (int i = 1; i < childrenQuantity; i++) {
			int currentChildScores = ratings[i];
			int priorChildScores = ratings[i - 1];
			if (currentChildScores > priorChildScores) {
				childrenCandies[i] = childrenCandies[i - 1] + 1;
			}

		}
		for (int j = childrenQuantity - 1; j > 0; j--) {
			int currentChildScores = ratings[j];
			int priorChildScores = ratings[j - 1];
			if (priorChildScores > currentChildScores && childrenCandies[j - 1] <= childrenCandies[j]) {
				childrenCandies[j - 1] = childrenCandies[j] + 1;
			}

		}
		for (int k = 0; k < childrenQuantity; k++) {
			candyQuantity += childrenCandies[k];
		}
		return candyQuantity;

	}

	public static void main(String[] args) {
		int[] ratings = { 1, 0, 2, 2 };
		System.out.println(candy(ratings));
	}

}
