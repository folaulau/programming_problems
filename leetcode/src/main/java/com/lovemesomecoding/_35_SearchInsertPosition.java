package com.lovemesomecoding;

import java.util.Arrays;

/**
 * Given a sorted array and a target value, <br>
 * return the index if the target is found. <br>
 * If not, return the index where it would be if it were inserted in order.<br>
 * 
 * You may assume no duplicates in the array.<br>
 * 
 * Example 1:<br>
 * 
 * Input: [1,3,5,6], 5<br>
 * Output: 2<br>
 * 
 * Example 2:<br>
 * 
 * Input: [1,3,5,6], 2<br>
 * Output: 1<br>
 * 
 * Example 3:<br>
 * 
 * Input: [1,3,5,6], 7<br>
 * Output: 4<br>
 * 
 * Example 4:<br>
 * 
 * Input: [1,3,5,6], 0<br>
 * Output: 0<br>
 * 
 * @author folaukaveinga
 *
 */
public class _35_SearchInsertPosition {

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 5, 6 };
		int pos = 2;
		System.out.println("numbers: " + Arrays.toString(numbers));

		int index = searchInsertMySolution(numbers, pos);
		System.out.println("index: " + index + "\n");

		pos = 7;
		index = searchInsert(numbers, pos);
		System.out.println("index: " + index + "\n");

		pos = 0;
		index = searchInsert(numbers, pos);
		System.out.println("index: " + index + "\n");

		pos = 4;
		index = searchInsert(numbers, pos);
		System.out.println("index: " + index + "\n");

		pos = 2;
		index = searchInsert(numbers, pos);
		System.out.println("index: " + index + "\n");
	}

	/**
	 * My solution<br>
	 * Time complexity: O(n)<br>
	 */
	public static int searchInsertMySolution(int[] numbers, int target) {
		System.out.println("numbers: " + Arrays.toString(numbers));
		System.out.println("searcInsert(), target: " + target);
		int position = 0;
		int size = numbers.length;

		for (int i = 0; i < size; i++) {
			int number = numbers[i];

			System.out.println("number: " + number + ", i: " + i + ", target: " + target);

			if (number == target) {
				position = i;
				break;
			} else if (number < target) {// target is bigger
				position = i;

				// check for last iteration
				if ((i + 1) == size) {
					position++;
				}

			} else {// target is smaller
				if (i == 0) {
					return 0;
				}

				position++;
				break;
			}
		}

		return position;
	}

	/**
	 * Time complexity: O(log(n))<br>
	 * like binary search.<br>
	 */
	public static int searchInsert(int[] numbers, int target) {
		System.out.println("numbers: " + Arrays.toString(numbers));
		System.out.println("searcInsert(), target: " + target);
		int size = numbers.length;

		if (target > numbers[size - 1]) {
			return size;
		} else if (target < numbers[0]) {
			return 0;
		}

		int left = 0;
		int right = size - 1;

		while (left <= right) {
			int middle = (right + left) / 2;
			int number = numbers[middle];
			System.out.println("leftIndex: " + left + ", rightIndex: " + right + ", middleIndex: " + middle
					+ ", target: " + target + ", number: " + number);

			// check
			if (target == number) {
				return middle++;
			} else if (target > number) {
				left = middle + 1;
			} else {// (target < number)
				right = middle - 1;
			}

		}

		return left;
	}
}
