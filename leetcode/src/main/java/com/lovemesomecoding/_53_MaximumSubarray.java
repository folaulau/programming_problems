package com.lovemesomecoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Given an integer array nums, find the contiguous subarray <br>
 * (containing at least one number) which has the largest sum <br>
 * and return its sum.<br>
 * 
 * Example:<br>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],<br>
 * Output: 6<br>
 * Explanation: [4,-1,2,1] has the largest sum = 6.<br>
 * 
 * Reference: https://leetcode.com/problems/maximum-subarray/
 * 
 * @author folaukaveinga
 *
 */
public class _53_MaximumSubarray {

	public static void main(String[] args) {

		int[] numbers = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("numbers: " + Arrays.toString(numbers));
		int sum = getMaxSumSubArray(numbers);
		System.out.println("sum: " + sum);
		sum = getSumSubArray(numbers);
		System.out.println("sum: " + sum);

	}

	/**
	 * My solution
	 */
	public static int getMaxSumSubArray(int[] numbers) {
		int maxSum = Integer.MIN_VALUE;

		for (int x = 0; x < numbers.length; x++) {
			int sum = 0;

			for (int y = x; y < numbers.length; y++) {

				sum += numbers[y];

				if (sum > maxSum) {
					maxSum = sum;
				}

			}
		}

		return maxSum;
	}

	/**
	 * 1. Loop through numbers<br>
	 * 2. aggregate numbers<br>
	 * 3. if sum is negative set sum to 0<br>
	 * 4. reset max when there is a new max<br>
	 * 
	 * @param numbers
	 * @return
	 */
	public static int getSumSubArray(int[] numbers) {
		int size = numbers.length;
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < size; i++) {

			sum += numbers[i];

			// new max
			if (max < sum) {
				max = sum;
			}

			// if sum is negative, starts over
			if (sum < 0) {
				sum = 0;
			}

			System.out.println("i: " + i + ", number: " + numbers[i] + ", max: " + max + ", sum: " + sum);

		}
		return max;
	}
}
