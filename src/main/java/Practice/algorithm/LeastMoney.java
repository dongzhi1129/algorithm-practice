package Practice.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 得到的最少硬币数
 * 货币系统包括1、4、16、64元共计4种硬币，以及面值为1024的纸币。现在使用1024的纸币购买一件价值为N(0<N<=1024)的商品，问最少收到多少硬币
 * 
 * @author weidong
 *
 */
public class LeastMoney {

	public static int leaseMonney(int goodValue) {
		if (goodValue > 1024) {
			throw new IllegalArgumentException("");
		}
		int remainMonney = 1024 - goodValue;
		int coinQuality = 0;
		while (remainMonney > 0) {
			if (remainMonney >= 64) {
				remainMonney -= 64;
				coinQuality++;
			} else if (remainMonney >= 16) {
				remainMonney -= 16;
				coinQuality++;
			} else if (remainMonney >= 4) {
				remainMonney -= 4;
				coinQuality++;
			} else if (remainMonney >= 1) {
				remainMonney -= 1;
				coinQuality++;
			}
		}
		return coinQuality;
	}

//	有N个人参加比赛，每个人比赛结束后都会得到一个分数，现在将N个人排成一圈领取奖品，要求：
//	如果某个人的分数比左右的人稿，那么奖品书一定要比左右人的多。
//	每个人至少得到一个奖品。
//	问最少应该准备多少奖品？

	public static int leastGifts(int[] scores) {
		int personQuantity = 0;
		if (scores == null || (personQuantity = scores.length) <= 0) {
			return 0;
		}
		// find the minimum point
		List<Integer> minimumPoints = new ArrayList<Integer>();
		int[] gifts = new int[personQuantity];
		for (int i = 0; i < personQuantity; i++) {
			int priorPerson = 0, nextPerson = 0;
			if (i == 0) {
				nextPerson = (i + 1 >= personQuantity ? i : i + 1);
				priorPerson = personQuantity - 1;
			} else if (i == personQuantity - 1) {
				nextPerson = 0;
				priorPerson = (i - 1 <= 0 ? 0 : i - 1);
			} else {
				nextPerson = i + 1;
				priorPerson = i - 1;
			}
			if (scores[i] <= scores[nextPerson] && scores[i] <= scores[priorPerson]) {
				minimumPoints.add(i);
			}
		}
		int minimumPointsSize = minimumPoints.size();
		for (int j = 0; j < minimumPointsSize; j++) {
			int priorPointIndex = 0, nextPointIndex = 0;
			if (j == 0) {
				priorPointIndex = minimumPointsSize - 1;
				nextPointIndex = (j + 1 >= minimumPointsSize ? j : j + 1);
			} else if (j == minimumPointsSize - 1) {
				priorPointIndex = (j - 1 <= 0 ? 0 : j - 1);
				nextPointIndex = 0;
			} else {
				priorPointIndex = j - 1;
				nextPointIndex = j + 1;
			}
			int beginIndex = minimumPoints.get(priorPointIndex);
			int endIndex = minimumPoints.get(nextPointIndex);
			int currentIndex = minimumPoints.get(j);
			int leftPointer = currentIndex, rightPointer = currentIndex;
			int currentLeftGiftQuantity = 0, currentRightGiftQuantity = 0;
			int pointScore = scores[currentIndex];
			int priorLeftScore = pointScore,nextPointScore = pointScore;
			while (leftPointer != beginIndex) {
				if (leftPointer < 0) {
					leftPointer = personQuantity - 1;
				}
				int currentPointerScore = scores[];
				gifts[leftPointer] = Math.max(++currentLeftGiftQuantity, gifts[leftPointer]);
				leftPointer--;
			}
			while (rightPointer != endIndex) {
				if (rightPointer >= personQuantity) {
					rightPointer = 0;
				}
				gifts[rightPointer] = Math.max(++currentRightGiftQuantity, gifts[rightPointer]);
				rightPointer++;
			}

		}
		int sumGift = 0;
		for (int i = 0; i < gifts.length; i++) {
			sumGift += gifts[i];
		}
		return sumGift;
	}

	public static void main(String[] args) {
		// System.out.println(leaseMonney(1023));
		int[] personScores = { 5, 3, 4, 7, 6, 8 };
		System.out.println(leastGifts(personScores));
	}

}
