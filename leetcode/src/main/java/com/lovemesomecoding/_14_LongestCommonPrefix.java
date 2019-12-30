package com.lovemesomecoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Write a function to find the longest common prefix <br>
 * string amongst an array of strings.<br>
 * If there is no common prefix, return an empty string "".<br>
 * 
 * Example 1:<br>
 * Input: ["flower","flow","flight"]<br>
 * Output: "fl"<br>
 *
 */
public class _14_LongestCommonPrefix {

	public static void main(String[] args) {

		String[] words1 = { "flower", "flow", "flight" };
		String longestCommonPrefix = getLongestCommonPrefix(words1);
		System.out.println("longestCommonPrefix: " + longestCommonPrefix);

		System.out.println("\n");

		String[] words2 = { "dog", "racecar", "car" };
		longestCommonPrefix = getLongestCommonPrefix(words2);
		System.out.println("longestCommonPrefix: " + longestCommonPrefix);

		System.out.println("\n");

		String[] words3 = { "aa", "a" };
		longestCommonPrefix = getLongestCommonPrefix(words3);
		System.out.println("longestCommonPrefix: " + longestCommonPrefix);

	}

	/**
	 * Get longest common prefix among all elements in an array<br>
	 * The prefix must exist in all elements<br>
	 */
	public static String getLongestCommonPrefix(String[] strs) {
		System.out.println("getLongestCommonPrefix()");
		System.out.println("strs: " + Arrays.toString(strs));

		if (strs == null || strs.length == 0) {
			return "";
		}

		String commonPrefix = "";
		String longestCommonPrefix = "";

		int numOfStrs = strs.length;

		String firstStr = strs[0];

		// use the first string and compare it to others.
		for (int i = 0; i < firstStr.length(); i++) {

			commonPrefix = firstStr.substring(0, i+1);

			int commonPrefixCount = 0;

			for (int y = 1; y < numOfStrs; y++) {
				
				String str = strs[y];

				if ((i + 1) <= str.length() == false) {
					break;
				}

				String subStr = str.substring(0, i + 1);

				System.out.println("str: " + str + ", commonPrefix: " + commonPrefix + ", subStr: " + subStr);
				if (commonPrefix.equals(subStr)) {
					commonPrefixCount++;
				} else {
					break;
				}

			}
			System.out.println("commonPrefixCount: " + commonPrefixCount + ", numOfStrs: " + (numOfStrs-1));
			if (commonPrefixCount != (numOfStrs - 1)) {
				break;
			}
			longestCommonPrefix = commonPrefix;
		}

		return longestCommonPrefix;
	}
}
