package com.lovemesomecoding;

import java.util.Arrays;

public class _125_ValidPalindrome {

	public static void main(String[] args) {

//		Arrays.asList("A man 2, a plan, a canal: Pa2nama", "Kinga", "KinggniK", "Fusi").forEach(str -> {
//			boolean result = isPalindromeString(str);
//			System.out.println("str: " + str + ", isPalindrome: " + result + "\n\n");
//		});
//		
		for(int i=0;i<10;i=i++) {
			i+=1;
			System.out.println("Hello World!");
		}

	}

	static void print() {
		throw new Error();
	}

	public static boolean isPalindromeString(String str) {
		System.out.println("is " + str + " a valid palindrome?");
		str = getOnlyAlphaNumbericInLowercase(str);
		System.out.println("trim str: " + str);
		if (str == null) {
			return false;
		}

		if (str.length() == 1) {
			return true;
		}

		int left = 0;
		int right = str.length() - 1;

		char[] word = str.toCharArray();

		// While there are characters to compare. Let's meet in the middle.
		while (left < right) {

			if (word[left] != word[right]) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	/**
	 * Only return alphaNumberic<br>
	 * turn all characters to lower case.<br>
	 */
	private static String getOnlyAlphaNumbericInLowercase(String str) {
		return str.trim().replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
	}
}
