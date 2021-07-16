package Practice.algorithm;

public class ReverseString {

	public static String reverseString(String src) {

		String dst = "";
		if (src == null || src.trim().length() <= 0) {
			return src;
		}
		int length = src.length();
		dst = getLastestString(src, length - 1);

		dst += reverseString(src.substring(0, length - 1 >= 0 ? length - 1 : 0));

		return dst;

	}

	public static String getLastestString(String src, int index) {
		if (index <= 0) {
			return src;
		}
		return src.charAt(index) + "";
	}

	public static void main(String[] args) {
		System.out.println(reverseString("123"));

	}

}
