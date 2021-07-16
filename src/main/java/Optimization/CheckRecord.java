package Optimization;

import java.util.LinkedList;

public class CheckRecord {

	public static int checkRecord(int n) {
		if (n <= 0) {
			return 0;
		}
		LinkedList<String> road = new LinkedList<>();
		LinkedList<LinkedList<String>> allRoad = new LinkedList<>();
		trace(road, allRoad, n);
		System.out.println(allRoad);
		return (int) (allRoad.size());

	}

	public static void trace(LinkedList<String> road, LinkedList<LinkedList<String>> allRoad, int n) {
		if (road.size() == n) {
			// 如果满足条件
			allRoad.add(new LinkedList<>(road));
			return;
		}
		String[] choice = { "P", "L", "A" };
		for (int i = 0; i < choice.length; i++) {
			if (!road.contains(choice[i])) {
				road.add(choice[i]);
			} else if (choice[i].equals("A")) {
				continue;
			} else {
				road.add(choice[i]);
			}
			trace(road, allRoad, n);
			road.removeLast();
		}

	}

	public static void main(String[] args) {
		System.out.println(checkRecord(3));
	}

}
