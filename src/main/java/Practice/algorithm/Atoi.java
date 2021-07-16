package Practice.algorithm;

public class Atoi {

	public int myAtoi(String str) {
		if (str == null || str.trim().length() <= 0) {
			return 0;
		}
		String sequence = str.trim();
		int index = 0, result = 0, length = sequence.length();
		boolean postive = str.charAt(index) == '-' ? false : true;
		while (index < length) {
			if (sequence.charAt(index) == ' ') {
				index++;
				continue;
			}
			int digit = sequence.charAt(index) - 'a';
			int maxResult = Integer.MAX_VALUE / 10, mod;
			if (postive) {
				mod = Integer.MAX_VALUE - maxResult;
			} else {
				mod = Integer.MAX_VALUE - maxResult + 1;
			}
			if (result > maxResult) {
				result = Integer.MAX_VALUE;
				break;
			}
			if (result == maxResult && digit >= mod) {
				result = Integer.MAX_VALUE;
				break;
			}
			result = result * 10 + digit;
			index++;
		}
		return 0;
		
	}

}
