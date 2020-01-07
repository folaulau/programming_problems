package com.lovemesomecoding;

import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, <br>
 * plus one to the integer.<br>
 * The digits are stored such that the most significant digit is at the head
 * <br>
 * of the list, and each element in the array contain a single digit. <br>
 * You may assume the integer does not contain any leading zero,<br>
 * except the number 0 itself.<br>
 * 
 * Example 1:<br>
 * 
 * Input: [1,2,3]<br>
 * Output: [1,2,4]<br>
 * Explanation: The array represents the integer 123.<br>
 * 
 * Example 2:<br>
 * 
 * Input: [4,3,2,1]<br>
 * Output: [4,3,2,2]<br>
 * Explanation: The array represents the integer 4321.<br>
 *
 */
public class _66_PlusOne {

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3 };

		int[] result = plusOne(numbers);
		System.out.println("result: " + Arrays.toString(result));

		numbers = new int[] { 4, 3, 2, 1 };

		result = plusOne(numbers);
		System.out.println("result: " + Arrays.toString(result));

		numbers = new int[] { 9 };

		result = plusOne(numbers);
		System.out.println("result: " + Arrays.toString(result));

		numbers = new int[] { 9, 9 };

		result = plusOne(numbers);
		System.out.println("result: " + Arrays.toString(result));

		numbers = new int[] { 2, 9, 9 };

		result = plusOne(numbers);
		System.out.println("result: " + Arrays.toString(result));
	}

	public static int[] plusOneMySolution(int[] numbers) {

		System.out.println("plusOne, numbers: " + Arrays.toString(numbers));

		if (numbers == null || numbers.length == 0) {
			return numbers;
		}

		int newValue = numbers[numbers.length - 1] + 1;

		if (newValue == 10) {
			int[] newNumbers = Arrays.copyOf(numbers, numbers.length + 1);

			System.out.println("plusOne, newNumbers: " + Arrays.toString(newNumbers));

			newNumbers[newNumbers.length - 2] = 1;
			newNumbers[newNumbers.length - 1] = 0;

			return newNumbers;

		} else {
			numbers[numbers.length - 1] = newValue;
		}

		return numbers;
	}

	/**
	 * Do addition from the back and carry over as in middle school<br>
	 * 
	 */
	public static int[] plusOne(int[] numbers) {

		System.out.println("plusOne, numbers: " + Arrays.toString(numbers));

		if (numbers == null || numbers.length == 0) {
			return numbers;
		}

		int carry = 1;
		for (int i = numbers.length - 1; i >= 0; i--) {
			int sum = numbers[i] + carry;
			if (sum >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
			numbers[i] = sum % 10;
		}

		if (carry == 1) {
			int[] result = new int[numbers.length + 1];
			System.arraycopy(numbers, 0, result, 1, numbers.length);
			result[0] = 1;
			return result;
		} else {
			// int[] result = new int[digits.length];
			return numbers;
		}
	}
}
