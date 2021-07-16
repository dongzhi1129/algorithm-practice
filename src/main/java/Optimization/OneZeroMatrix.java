package Optimization;

public class OneZeroMatrix {

	public static int max(int[][] src) {

		if (src == null || src.length <= 0) {
			return 0;
		}
		int maxResult = 0;
		for (int i = 0; i < src.length; i++) {

			for (int j = 0; j < src[0].length; j++) {
				int ShuiPing = findShuiPing(src, i, j);
				int chuizhi = findChuiZhi(src, i, j);
				int xiexian = findXieXian(src, i, j);
				int fanxiexian = findFanXieXian(src, i, j);
				int result = Math.max(Math.max(ShuiPing, chuizhi), Math.max(xiexian, fanxiexian));
				maxResult = Math.max(result, maxResult);
			}

		}
		return maxResult;

	}

	private static int findShuiPing(int[][] src, int i, int j) {
		if (j < 0 || j >= src[0].length || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findLeftShuiPing(src, i, j - 1) + findRightShuiPing(src, i, j + 1);
	}

	private static int findLeftShuiPing(int[][] src, int i, int j) {
		if (j < 0 || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findLeftShuiPing(src, i, j - 1) ;
	}

	private static int findRightShuiPing(int[][] src, int i, int j) {
		if (j >= src[0].length || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] +  findRightShuiPing(src, i, j + 1);
	}

	private static int findUpChuiZhi(int[][] src, int i, int j) {
		if (i < 0 || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findUpChuiZhi(src, i - 1, j);
	}

	private static int findDownChuiZhi(int[][] src, int i, int j) {
		if (i >= src.length || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findDownChuiZhi(src, i + 1, j);
	}

	private static int findChuiZhi(int[][] src, int i, int j) {
		if (i < 0 || i >= src.length || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findUpChuiZhi(src, i - 1, j) + findDownChuiZhi(src, i + 1, j);
	}

	private static int findXieXian(int[][] src, int i, int j) {
		if (i < 0 || i >= src.length || j < 0 || j >= src[0].length || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findLeftDownXieXian(src, i + 1, j - 1) + findRightUpXieXian(src, i - 1, j + 1);
	}

	private static int findLeftDownXieXian(int[][] src, int i, int j) {
		if (i >= src.length || j < 0 || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findLeftDownXieXian(src, i + 1, j - 1);
	}

	private static int findRightUpXieXian(int[][] src, int i, int j) {
		if (i < 0 || j >= src[0].length || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findRightUpXieXian(src, i - 1, j + 1);
	}

	private static int findFanXieXian(int[][] src, int i, int j) {
		if (i < 0 || i >= src.length || j < 0 || j >= src[0].length || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findLeftUpFanXieXian(src, i - 1, j - 1) + findRightDownFanXieXian(src, i + 1, j + 1);
	}

	private static int findLeftUpFanXieXian(int[][] src, int i, int j) {
		if (i < 0 || j < 0 || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findLeftUpFanXieXian(src, i - 1, j - 1);
	}

	private static int findRightDownFanXieXian(int[][] src, int i, int j) {
		if (i >= src.length || j >= src[0].length || src[i][j] == 0) {
			return 0;
		}
		return src[i][j] + findRightDownFanXieXian(src, i + 1, j + 1);
	}

	public static void main(String[] args) {
		int[][] src = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		System.out.println(max(src));
	}
}
