package com.lovemesomecoding;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.<br>
 * 
 * Example 1:<br>
 * 
 * Input: "abcabcbb"<br>
 * Output: 3 <br>
 * Explanation: The answer is "abc", with the length of 3. <br>
 * Example 2:<br>
 * 
 * Input: "bbbbb"<br>
 * Output: 1<br>
 * Explanation: The answer is "b", with the length of 1.<br>
 * Example 3:<br>
 * 
 * Input: "pwwkew"<br>
 * Output: 3<br>
 * Explanation: The answer is "wke", with the length of 3. <br>
 * Note that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.<br>
 * 
 * @author folaukaveinga
 *
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		String str = "abcabcbb";
		int length = getLongestSubstringWithoutReapting(str);

		System.out.println("str: " + str + ", length: " + str.length() + ", longest unique substring length: " + length
				+ "\n================");

		str = "bbbbb";
		length = getLongestSubstringWithoutReapting(str);

		System.out.println("str: " + str + ", length: " + str.length() + ", longest unique substring length: " + length
				+ "\n================");

		str = "pwwkew";
		length = getLongestSubstringWithoutReapting(str);

		System.out.println("str: " + str + " length: " + str.length() + ", longest unique substring length: " + length
				+ "\n================");

		str = "abcabcde";
		length = getLongestSubstringWithoutReapting(str);

		System.out.println("str: " + str + ", length: " + str.length() + ", longest unique substring length: " + length
				+ "\n================");

		str = "abccbadee";
		length = getLongestSubstringWithoutReapting(str);

		System.out.println("str: " + str + ", length: " + str.length() + ", longest unique substring length: " + length
				+ "\n================");
	}

	/**
	 * Sliding Window Optimized<br>
	 * 
	 * The above solution requires at most 2n steps. In fact, it could be optimized
	 * to require only n steps. Instead of using a set to tell if a character exists
	 * or not, we could define a mapping of the characters to its index. Then we can
	 * skip the characters immediately when we found a repeated character.<br>
	 * 
	 * The reason is that if s[j] have a duplicate in the range [i, j) with index j'
	 * , we don't need to increase i little by little. We can skip all the elements
	 * in the range [i, j']and let ii to be j' + 1 directly.<br>
	 * 
	 * This is almost the same as finding the highest number is a list<br>
	 * 
	 */
	static int getLongestSubstringWithoutReapting(String str) {
		System.out.println("\ngetLongestSubstringWithoutReapting(" + str + ")\n");
		int length = str.length();

		Map<Character, Integer> map = new HashMap<>();
		int startingPosition = 0;
		int longestLength = 0;
		int window = 0;

		for (int i = 0; i < length; i++) {
			char character = str.charAt(i);

			if (map.containsKey(character)) {
				System.out.print("*** - " + character + " is in map, startingPosition: " + (startingPosition + 1)
						+ ", map.get(character): " + map.get(character));

				startingPosition = Math.max(map.get(character), startingPosition);

				System.out.println(", new startingPosition: " + (startingPosition + 1));
			}
			window = (i - startingPosition) + 1;
			longestLength = Math.max(longestLength, window);

			System.out.println(
					"str: " + str + ", character: " + character + ", startingPosition: " + (startingPosition + 1)
							+ ", i: " + i + ", window: " + window + ", longestLength: " + longestLength);

			map.put(character, i + 1);
			System.out.println(map);
			System.out.println("\n");
		}

		return longestLength;
	}
}
