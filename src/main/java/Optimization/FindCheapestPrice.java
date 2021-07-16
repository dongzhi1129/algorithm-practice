package Optimization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class FindCheapestPrice {

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

		if (n <= 0 || flights.length <= 0 || src < 0 || dst < 0 || K < 0) {
			return -1;
		}
		LinkedList<String> path = new LinkedList<>();
		LinkedList<LinkedList<String>> paths = new LinkedList<LinkedList<String>>();
		trace(path, paths, K, flights, src, dst, src);
		System.out.println(paths);
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < paths.size(); i++) {
			LinkedList<String> pathT = paths.get(i);
			int value = 0;
			for (int j = 0; j < pathT.size(); j++) {
				value += Integer.valueOf(pathT.get(j).substring(pathT.get(j).lastIndexOf(":")+ 1));
			}
			minValue = Math.min(value, minValue);

		}

		return minValue;

	}

	public static void trace(LinkedList<String> path, LinkedList<LinkedList<String>> paths, int K, int[][] flights,
			int src, int dst, int SRC) {
		if (!path.isEmpty() && path.size()- 1 <= K ) {
			String start = path.getFirst();
			int startSplitIndex = start.indexOf(":");
			if (startSplitIndex == -1) {
				return;
			}
			if (!String.valueOf(SRC).equals(start.substring(0, startSplitIndex))) {
				return;
			}
			String destination = path.getLast();
			int splitStartIndex = destination.indexOf(":");
			;
			int splitIndex = destination.lastIndexOf(":");
			if (splitStartIndex == -1 || splitIndex == -1) {
				return;
			}
			destination = destination.substring(splitStartIndex + 1, splitIndex);
			if (destination.equals(String.valueOf(dst))) {
				paths.add(new LinkedList<>(path));
			}
		}
		// 查找所有起点
		LinkedList<String> alternativeStart = new LinkedList<>();
		for (int i = 0; i < flights.length; i++) {
			if (flights[i][0] == src && !alternativeStart.contains(i)) {
				alternativeStart.add(String.format("%s:%s:%s", flights[i][0], flights[i][1], flights[i][2]));
			}
		}
		for (int ii = 0; ii < alternativeStart.size(); ii++) {
			String altePath = alternativeStart.get(ii);
			if (path.contains(altePath)) {
				continue;
			}
			path.add(altePath);
			int splitFirstIndex = altePath.indexOf(":");
			int splitLastIndex = altePath.lastIndexOf(":");
			trace(path, paths, K, flights, Integer.valueOf(altePath.substring(splitFirstIndex + 1, splitLastIndex)),
					dst, SRC);
			path.removeLast();
		}
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		int src = 0, dst = 2, K = 0, n = 3;
		int a = findCheapestPrice(n, edges, src, dst, K);
		System.out.println(a);
	}

}
