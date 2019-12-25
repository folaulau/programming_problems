package com.lovemesomecoding;

import java.util.Arrays;

/*
 * Write a function that reverses a string. 
 * The input string is given as an array of characters char[]. 
 * 
 * Do not allocate extra space for another array, you must do this 
 * by modifying the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 */
public class _344ReverseString {

	public static void main(String[] args) {
		Arrays.asList("folau", "lisa").forEach((word) -> {
			System.out.println("word: " + word);
			String reversedStr = reverseString(word);
			System.out.println("reversedStr: " + reversedStr);

			System.out.println("word: " + word);
			String reverseStr = reverse(word);

			System.out.println("reverseStr: " + reverseStr);

			String reverseBySwap = reverseBySwap(word);

			System.out.println("reverseBySwap: " + reverseBySwap);
		});
	}

	/**
	 * Use built-in reverse method
	 */
	public static String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	/**
	 * 
	 * Complexity Analysis <br>
	 * Time complexity : O(N) <br>
	 * Space complexity : O(N)
	 */
	public static String reverse(String str) {
		char[] word = new char[str.length()];
		for (int i = str.length() - 1, x = 0; i >= 0; i--, x++) {
			word[x] = str.charAt(i);
		}
		return new String(word);
	}

	/**
	 * Approach 2: Two Pointers,(swap position) Iteration, O(1) Space
	 * 
	 * Two Pointers Approach In this approach, two pointers are used to process two
	 * array elements at the same time. Usual implementation is to set one pointer
	 * in the beginning and one at the end and then to move them until they both
	 * meet.
	 * 
	 * Sometimes one needs to generalize this approach in order to use three
	 * pointers, like for classical Sort Colors problem.
	 * 
	 * Algorithm
	 * 
	 * Set pointer left at index 0, and pointer right at index n - 1, where n is a
	 * number of elements in the array.
	 * 
	 * While left < right: <br>
	 * Swap s[left] and s[right]. <br>
	 * Move left pointer one step right, and right pointer one step left.<br>
	 * https://leetcode.com/problems/reverse-string/Figures/344/two.png
	 * 
	 * Complexity Analysis <br>
	 * Time complexity : O(N) to swap N/2 element. <br>
	 * Space complexity : O(1), it's a constant space solution.
	 * 
	 */
	public static String reverseBySwap(String chars) {
		int left = 0;
		int right = chars.length() - 1;

		char[] word = chars.toCharArray();

		while (left < right) {

			char tmp = word[left];
			word[left] = word[right];
			word[right] = tmp;

			left++;
			right--;
		}
		return String.valueOf(word);
	}
}
