package com.lovemesomecoding;

import java.util.Arrays;

/**
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.<br>
 * 
 * Example 1:<br>
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3<br>
 * Output: [5,6,7,1,2,3,4]<br>
 * 
 * Explanation:<br>
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]<br>
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]<br>
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]<br>
 * 
 */
public class _189_RotateArray {

	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int k = 3;
		int[] rotatedNumbers = rotate(numbers, k);
		System.out.println("numbers: " + Arrays.toString(numbers) + ", k: " + k);
		System.out.println("rotatedNumbers: " + Arrays.toString(rotatedNumbers));
	}

	/**
	 * We use an extra array in which we place every element of the array at its
	 * correct position i.e. the number at index i in the original array is placed
	 * at the index (i+k)%(length of array).<br>
	 * 
	 * new position = (i + k) % size;<br>
	 */
	public static int[] rotate(int[] nums, int k) {
		int size = nums.length;
		int[] rotatedNumbers = new int[size];

		for (int i = 0; i < size; i++) {
			int newPosition = (i + k) % size;
			int value = nums[i];
			System.out.println("switch newPosition: " + newPosition + " to new value " + value + ", i: " + i);
			rotatedNumbers[newPosition] = value;
		}

		return rotatedNumbers;
	}
}
