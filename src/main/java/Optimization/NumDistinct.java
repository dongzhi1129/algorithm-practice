package Optimization;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class NumDistinct {

	public static int numDistinct(String s, String t) {
		if (s == null || s == null || s.length() <= 0 || t.length() <= 0) {
			return 0;
		}
		String trace = "";
		LinkedList<String> allTraces = new LinkedList<>();
		LinkedList<Integer> visited = new LinkedList<>();
		allTrace(trace, allTraces, visited, s, t);
		System.out.println(allTraces);
		return allTraces.size();

	}

	public static int numDistinctAnother(String s, String t) {
		if (s == null || s == null || s.length() <= 0 || t.length() <= 0) {
			return 0;
		}
		int sLength = s.length(), tLength = t.length();
		while() {
			
		}

	}

	public static void allTrace(String trace, LinkedList<String> allTrace, LinkedList<Integer> visited, String s,
			String t) {
		if (trace.equals(t)) {
			allTrace.add(new String(trace));
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (visited.isEmpty()) {
				visited.add(i);
			} else if (visited.getLast() >= i) {
				continue;
			} else {
				visited.add(i);
			}
			if (visited.size() < t.length()) {

			}
			trace += s.charAt(i);
			allTrace(trace, allTrace, visited, s, t);
			visited.removeLast();
			trace = trace.substring(0, trace.length() - 1);
		}
	}

	public static void main(String[] args) {
		String s = "babgbag", t = "bag";
		System.out.println(numDistinct(s, t));
	}

}
