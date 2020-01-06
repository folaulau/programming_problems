package com.lovemesomecoding;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space <br>
 * characters ' ', return the length of last word (last word means the<br>
 * last appearing word if we loop from left to right) in the string.<br>
 * 
 * If the last word does not exist, return 0.<br>
 * 
 * Note: A word is defined as a maximal substring consisting of non-space<br>
 * characters only.<br>
 * 
 * Example:<br>
 * 
 * Input: "Hello World" Output: 5<br>
 * 
 * @author folaukaveinga
 *
 */
public class _58_LengthOfLastWord {

	public static void main(String[] args) {

		String str = "Hello World";
		int lastWordLength = getLengthOfLastWord(str);

		System.out.println("str: " + str + ", lastWordLength: " + lastWordLength);

		str = "b   a    ";

		lastWordLength = getLengthOfLastWord(str);

		System.out.println("str: " + str + ", lastWordLength: " + lastWordLength);
	}

	/**
	 * My Solution
	 */
	public static int getLengthOfLastWordMySolution(String str) {
		if (str == null || str.trim().length() == 0) {
			return 0;
		}

		int count = 0;

		// important to trim whitespace both at the beginning at end.
		str = str.trim();
		int size = str.length();

		for (int i = 0; i < size; i++) {
			char c = str.charAt(i);

			if (c == ' ') {

				count = 0;

			} else {
				count++;
			}

		}

		return count;
	}

	/**
	 * 1. start from the end<br>
	 * 2. trim whitespace at the end<br>
	 * 3. count and stop at ' '<br>
	 */
	public static int getLengthOfLastWord(String str) {
		if (str == null || str.trim().length() == 0) {
			return 0;
		}

		int count = 0;

		// important to trim whitespace both at the beginning at end.
		str = str.trim();
		int size = str.length();
		boolean char_flag = false;

		for (int i = (size - 1); i > 0; i--) {
			char c = str.charAt(i);

			if (c == ' ') {
				break;

			} else {
				count++;
			}

			// here is another solution if trim is not used.
//			if (Character.isLetter(c)) {
//				// Once the first character from last
//				// is encountered, set char_flag to true.
//				char_flag = true;
//				count++;
//			} else {
//				// When the first space after the characters
//				// (from the last) is encountered, return the
//				// length of the last word
//				if (char_flag == true)
//					return count;
//			}

		}

		return count;
	}
}
