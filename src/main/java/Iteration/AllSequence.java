package Iteration;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AllSequence {

	public static List<List<Integer>> getAllPath(int[] nums) {
		LinkedList<Integer> track = new LinkedList<>();
		LinkedList<List<Integer>> allPaths = new LinkedList<>();
		trackPath(nums, track, allPaths);
		return allPaths;
	}

	private static void trackPath(int[] nums, LinkedList<Integer> track, LinkedList<List<Integer>> allPaths) {
		if (track.size() == nums.length) {
			allPaths.add(new LinkedList<>(track));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (track.contains(nums[i])) {
				continue;
			}
			track.add(nums[i]);
			trackPath(nums, track, allPaths);
			track.removeLast();
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		List<List<Integer>> result = getAllPath(nums);
		System.out.println(result);

	}

}
