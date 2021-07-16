package Practice.algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.math3.analysis.function.Rint;

public class NumDistinct {

	public static int numDistinct(String s, String t) {
		if (s == null || "".equals(s.trim()) || t == null || "".equals(t.trim())) {
			return 0;
		}
		if (s.trim().length() < t.trim().length()) {
			return 0;
		}
		int sIndex = 0, tIndex = 0;

		Map<String, Integer> sMap = new LinkedHashMap<>(s.length());
		Map<String, Integer> tMap = new LinkedHashMap<>(t.length());
		String lastPersitenceChar = "";
		while (tIndex < t.length()) {
			String currentTChar = String.valueOf(t.charAt(tIndex));
			if (tMap.containsKey(currentTChar)) {
				tMap.put(currentTChar, tMap.get(currentTChar) + 1);
			} else {
				tMap.put(currentTChar, 1);
			}
			tIndex++;
		}
		step: for (Map.Entry<String, Integer> entry : tMap.entrySet()) {
			while (sIndex < s.length()) {
				String currentKey = entry.getKey();
				String currentS = String.valueOf(s.charAt(sIndex));
				if (currentS.equals(lastPersitenceChar)) {
					sMap.put(lastPersitenceChar, sMap.get(currentS) + 1);
					sIndex++;
				} else if (currentS.equals(currentKey)) {
					if (sMap.containsKey(currentS)) {
						sMap.put(currentS, sMap.get(currentS) + 1);
					} else {
						sMap.put(currentS, 1);
					}
					lastPersitenceChar = currentKey;
					sIndex++;
					continue step;
				} else {
					sIndex++;
				}
			}

		}
		if (sMap.size() != tMap.size()) {
			return 0;
		}
		int count = 1;
		for (Map.Entry<String, Integer> entry : tMap.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			Integer sValue = sMap.get(key);
			if (sValue == value) {
				count *= 1;
			} else if(sValue < value) {
				return 0;
			} else {
				count*= combination(sValue,value);
			}

		}
		return count;
	}
	
	/** 
	 * 计算阶乘数，即n! = n * (n-1) * ... * 2 * 1 
	 * @param n 
	 * @return 
	 */  
	private static long factorial(int n) {  
	    return (n > 1) ? n * factorial(n - 1) : 1;  
	}  
	  
	/** 
	 * 计算排列数，即A(n, m) = n!/(n-m)! 
	 * @param n 
	 * @param m 
	 * @return 
	 */  
	public static long arrangement(int n, int m) {  
	    return (n >= m) ? factorial(n) / factorial(n - m) : 0;  
	}  
	  
	/** 
	 * 计算组合数，即C(n, m) = n!/((n-m)! * m!) 
	 * @param n 
	 * @param m 
	 * @return 
	 */  
	public static long combination(int n, int m) {  
	    return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;  
	}  

	public static void main(String[] args) {
		int a = numDistinct("rabbbit", "rabbit");
		System.out.println(a);
//		System.out.println(combination(3,2));
	}

}
