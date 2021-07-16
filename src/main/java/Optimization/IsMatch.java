package Optimization;

public class IsMatch {

	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}

		int sIndex = 0, pIndex = 0, sLength = s.length(), pLength = p.length();
		boolean isMatch = false;
		while (sIndex < sLength) {
			char sChar = s.charAt(sIndex);
			char pChar = s.charAt(pIndex);
			if (sChar == pChar) {

			} else {
				// 是否匹配* 可以忽略
				

			}

		}

	}
}
