package com.lovemesomecoding;

import java.util.Arrays;

/**
 * Determine whether an integer is a palindrome. <br>
 * An integer is a palindrome when it reads the same backward as forward.<br>
 * 
 * @author folaukaveinga
 *
 */
public class _9_Palindrome {

	public static void main(String[] args) {

		Arrays.asList(12, 121, 111, 2332, 45654).forEach(num -> {
			boolean result = isPalindromeNumber(num);
			System.out.println("num: " + num + ", isPalindrome: " + result + "\n\n");
		});

		Arrays.asList("Kinga", "KinggniK", "Fusi").forEach(str -> {
			boolean result = isPalindromeString(str);
			System.out.println("str: " + str + ", isPalindrome: " + result + "\n\n");
		});

	}

	/**
	 * The reverse of the last half of the palindrome should be the same as the
	 * first half of the number.<br>
	 * how do we know that we've reached the half of the number?<br>
	 * 1. Get last half of the number<br>
	 * 2. Decrease firstHalf number everytime lastHalf number increases.<br>
	 * 3. Go until lastHalfNumber is equal or greater than the firstHalfNumber<br>
	 * 4. 
	 */
	public static boolean isPalindromeNumber(int number) {
		System.out.println("is " + number + " a palindrome?");
		if (number < 0 || (number % 10 == 0 && number != 0)) {
			return false;
		}

		int lastHalfNumber = 0;
		int firstHalfNumber = number;

		// go until the lastHalfNumber is equal or greater than the firstHalfNumber;
		while (firstHalfNumber > lastHalfNumber) {
			lastHalfNumber = flipNumber(lastHalfNumber, (firstHalfNumber % 10));
			System.out.println("firstHalfNumber: " + firstHalfNumber + ", lastHalfNumber: " + lastHalfNumber);
			firstHalfNumber = removeNumberFromRight(firstHalfNumber);
		}

		return (firstHalfNumber == lastHalfNumber) || (firstHalfNumber == (lastHalfNumber / 10));
	}

	/**
	 * divide by 10 and remove decimal.
	 * 
	 */
	private static int removeNumberFromRight(int number) {
		return (int) (number / 10);
	}

	/**
	 * revert the new remainder and the existing number<br>
	 * - get remainder of (number % 10)<br>
	 * - add (lastHalfNumber * 10)<br>
	 */
	private static int flipNumber(int lastHalfNumber, int newRemainder) {
		return (lastHalfNumber * 10) + newRemainder;
	}

	public static boolean isPalindromeString(String str) {
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
}
