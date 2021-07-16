package Optimization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CountPalindromicSubsequences {

	public int countPalindromicSubsequences(String S) {
		return 0;
	}

	public static Set<String> subsequences(String s) {
		if (s.length() == 0) {
			return new HashSet<>();
		}
		Set<String> tempSet = new LinkedHashSet<>();
		for (int i = 0; i < s.length(); i++) {
			String chooseCharactor = String.valueOf(s.charAt(i));
			tempSet.add(chooseCharactor);
			String subString = s.substring(i + 1);
			Set<String> strSet = subsequences(subString);
			Iterator<String> ite = strSet.iterator();
			while (ite.hasNext()) {
				String currentStr = ite.next();
				String newStr = chooseCharactor + currentStr;
				tempSet.add(newStr);
			}
		}
		return tempSet;
	}

	public static void main(String[] args) {
		String S = "abcdabcdabcdabcdabcd";
		Set<String> set = subsequences(S);
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String currentStr = ite.next();
			System.out.println(currentStr);
		}

	}

}
