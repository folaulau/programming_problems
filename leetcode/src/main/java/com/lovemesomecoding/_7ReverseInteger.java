package com.lovemesomecoding;

import java.util.Arrays;

/*
 * Difficulty - Easy
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class _7ReverseInteger {

	public static void main(String[] args) {

		Arrays.asList(1534236469).forEach((num) -> {
			System.out.println("num: " + num);
//			int reversedNum = reverseInt(num);
//			System.out.println("reversedNum: " + reversedNum);
//
//			reversedNum = reverse(num);
//			System.out.println("reversedNum: " + reversedNum);

			int reversedNum = reverseWithoutOverflow(num);
			System.out.println("reversedNum: " + reversedNum);

			System.out.println("\n");
		});

	}

	public static int reverseInt(int num) {

		boolean negativeNum = false;

		if (num < 0) {
			num *= -1;
			negativeNum = true;
		}
		
		StringBuilder str = new StringBuilder(num + "");
		
		int reversedNum = Integer.parseInt(str.reverse().toString());

		return negativeNum ? reversedNum *= -1 : reversedNum;
	}

	/*
	 * Basic using division by 10 and remainder.
	 * 
	 * We want to repeatedly "pop" the last digit off of x and "push" it to the back
	 * of the rev. In the end, rev will be the reverse of the x.
	 * 
	 * Complexity Analysis Time Complexity: O(log(x)). There are roughly log_10(x)
	 * digits in x. Space Complexity: O(1).
	 */
	public static int reverse(int num) {
		int reversedNum = 0;

		while (num != 0) {

			int pop = num % 10;

			num = num / 10;

			reversedNum = reversedNum * 10 + pop;
		}

		return reversedNum;
	}

	/*
	 * Basic using division by 10 and remainder.
	 * 
	 * We want to repeatedly "pop" the last digit off of x and "push" it to the back
	 * of the rev. In the end, rev will be the reverse of the x.
	 * 
	 * Complexity Analysis Time Complexity: O(log(x)). There are roughly log_10(x)
	 * digits in x. Space Complexity: O(1).
	 */
	public static int reverseWithoutOverflow(int num) {
		int reversedNum = 0;
		while (num != 0) {
			int pop = num % 10;
			//System.out.println("pop: " + pop);
			num /= 10;
			//System.out.println("num: " + num);
			if (reversedNum > Integer.MAX_VALUE / 10 || (reversedNum == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}
			if (reversedNum < Integer.MIN_VALUE / 10 || (reversedNum == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			reversedNum = reversedNum * 10 + pop;
			//System.out.println("reversedNum: " + reversedNum);
		}
		return reversedNum;
	}
}
