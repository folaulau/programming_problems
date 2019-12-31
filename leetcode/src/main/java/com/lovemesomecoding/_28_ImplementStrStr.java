package com.lovemesomecoding;

/**
 * Implement strStr() or indexOf like Java.<br>
 * Return the index of the first occurrence of needle in haystack, <br>
 * or -1 if needle is not part of haystack.<br>
 * 
 * Example 1:<br>
 * Input: haystack = "hello", needle = "ll"<br>
 * Output: 2<br>
 * Input: haystack = "aaaaa", needle = "bba"<br>
 * Output: -1<br>
 * 
 * Clarification:<br>
 * What should we return when needle is an empty string? <br>
 * This is a great question to ask during an interview.<br>
 * For the purpose of this problem, we will return 0 <br>
 * when needle is an empty string.<br>
 */
public class _28_ImplementStrStr {

	public static void main(String[] args) {
		String hayStack = null;
		String needle = null;

		int position = 0;

		hayStack = "hello";
		needle = "ll";

		position = strStr(hayStack, needle);

		System.out.println("position: " + position);

		System.out.println("\n");

		hayStack = "hello";
		needle = "he";

		position = strStr(hayStack, needle);

		System.out.println("position: " + position);

		System.out.println("\n");

		hayStack = "aaaaa";
		needle = "bbasfdsf";

		position = strStr(hayStack, needle);

		System.out.println("position: " + position);

		System.out.println("\n");

		hayStack = "";
		needle = "a";

		position = strStr(hayStack, needle);

		System.out.println("position: " + position);

		System.out.println("\n");

		hayStack = "a";
		needle = "a";

		position = strStr(hayStack, needle);

		System.out.println("position: " + position);

		System.out.println("\n");

		hayStack = "a";
		needle = "b";

		position = strStr(hayStack, needle);

		System.out.println("position: " + position);

		System.out.println("\n");

		hayStack = "mississippi";
		needle = "pi";

		position = strStr(hayStack, needle);

		System.out.println("position: " + position);

		System.out.println("\n");

		hayStack = "mississippi";
		needle = "ippi";

		position = strStr(hayStack, needle);

		System.out.println("position: " + position);

	}

	/**
	 * return 0 if needle is null or zero length<br>
	 * return -1 if hayStackLen is less than needleLen<br>
	 * return 0 if hayStackLen == needleLen && haystack.equals(needle)<br>
	 * 
	 * loop through hastack in needle size iteration<br>
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
		System.out.println("strStr()");
		System.out.println("haystack: " + haystack);
		System.out.println("needle: " + needle);

		if (needle == null || needle.length() == 0) {
			return 0;
		}

		int hayStackLen = haystack.length();
		int needleLen = needle.length();

		if (hayStackLen < needleLen) {
			return -1;
		}

		if (hayStackLen == needleLen && haystack.equals(needle)) {
			return 0;
		}

		int firstPosition = -1;

		// substring end is exclusive so interation has to go all the way to 1+
		for (int i = 0; i <= hayStackLen; i++) {
			System.out.println("i: " + i + ", needle len: " + needleLen);

			// make sure needle is in stack length.
			if (i < needleLen) {
				continue;
			}

			// once needle can be searched for in haystack.
			int start = i - needleLen;
			int end = i;

			String word = haystack.substring(start, end);

			System.out.println("start: " + start + ", end: " + end + ", word: " + word + ", needle: " + needle);

			if (needle.equals(word)) {
				firstPosition = i;
				break;
			}
		}

		// return -1 or if needle is found -> return the beginning index of the needle.
		return (firstPosition == -1) ? firstPosition : (firstPosition - needleLen);
	}
}
