package Practice.algorithm;

import java.util.Arrays;

public class Multiply {

	public static String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.trim().length() <= 0 || num2.trim().length() <= 0) {
			return "";
		}
		int num1Length = num1.length(), num2Length = num2.length();
		char[] advanceFlag = new char[num1Length + num2Length];
		Arrays.fill(advanceFlag, '0');
		String operateStr1, operateStr2;
		int operateStr1Length = 0, operateStr2Length = 0;
		if (num1Length >= num2Length) {
			operateStr1 = num1;
			operateStr2 = num2;
			operateStr1Length = num1Length;
			operateStr2Length = num2Length;
		} else {
			operateStr1 = num2;
			operateStr2 = num1;
			operateStr1Length = num2Length;
			operateStr2Length = num1Length;
		}
		for (int i = operateStr2Length - 1; i >= 0; i--) {
			int currentOperator = operateStr2.charAt(i) - '0';
			for (int j = operateStr1Length - 1; j >=0; j--) {
				int operator = operateStr1.charAt(j) - '0';
				int result = (advanceFlag[i + j + 1] - '0' )+ currentOperator * operator;
				advanceFlag[i + j + 1] = (char) (result % 10 + '0');
				advanceFlag[i + j] = (char) ( (advanceFlag[i + j] - '0' ) + result / 10  + '0');
			}
		}
		int k=0;
		for(;k< advanceFlag.length;k++) {
			if(advanceFlag[k] != '0') {
				break;
			}
		}
		String resultStr =null;
		if(k == advanceFlag.length) {
			resultStr = "0";
		} else {
			resultStr = new String(advanceFlag).substring(k);
		}
		return resultStr;
	}
	
	public static void main(String[] args) {
		String num1 = "123",  num2 = "456";
		System.out.println(multiply(num1, num2));
	}
}
