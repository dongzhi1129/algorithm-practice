package Iteration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class nQueue {

	public static List<List<Integer>> allPaths(int[] nums, int S) {
		LinkedList<Integer> route = new LinkedList<>();
		List<List<Integer>> allRoutes = new LinkedList<>();
		getPath(route, nums, 0, allRoutes, S);
		return allRoutes;
	}

	private static void getPath(LinkedList<Integer> route, int[] nums, int index, List<List<Integer>> allRoutes,
			int S) {
		if (nums.length == route.size()) {
			int sum = 0;
			for (int i = 0; i < route.size(); i++) {
				sum += route.get(i);
			}
			if (sum == S) {
				allRoutes.add(new LinkedList<>(route));
			}
			return;
		}
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				route.add(nums[index]);
			} else {
				route.add(-nums[index]);
			}
			getPath(route, nums, index + 1, allRoutes, S);
			route.removeLast();
		}

	}

	

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1 };
		int S = 3;
		List<List<Integer>> all = allPaths(nums, S);
		System.out.println(all);
	}

}
