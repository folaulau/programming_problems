package com.lovemesomecoding.other;

import java.util.Arrays;

/**
 * Given a integer, Remove numbers from it either from left or right
 * 
 * @author folaukaveinga
 *
 */
public class ChopOffNumber {

	public static void main(String[] args) {

		Arrays.asList(12, 121, 2348, 23498).forEach(num -> {
			int result = removeFromRight(num, 2);

			System.out.println("num: " + num + ", right result: " + result);
			result = removeFromLeft(num, 2);
			System.out.println("num: " + num + ", left result: " + result + "\n");
		});
	}

	/**
	 * 1. Divide the number by 10 and remove decimal.<br>
	 */
	public static int removeFromRight(int number, int lastNumbers) {
		System.out.println("removeFromRight");
		for (int i = 0; i < lastNumbers; i++) {
			number = number / 10;
		}

		return number;
	}

	/**
	 * 1. Get the highest level number. i.e 10,100,1000,etc<br>
	 * 2. Divide the number and keep the remainder. i.e 123%100 = 23<br>
	 */
	public static int removeFromLeft(int number, int firstNumbers) {
		System.out.println("removeFromLeft");
		for (int i = 0; i < firstNumbers; i++) {
			double log10 = Math.log10(number);
			int divisor = (int) Math.pow(10, (int) log10);
			System.out.println("number: " + number + ", log10(" + number+"): " + log10 +", (int)log10: " + (int)log10 + ", divisor: " + divisor+", remainder: "+(number % divisor));
			number = number % divisor;
		}

		return number;
	}
}
