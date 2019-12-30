package com.lovemesomecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted array nums, remove the duplicates in-place such <br>
 * that each element appear only once and return the new length.<br>
 * Do not allocate extra space for another array, you must do <br>
 * this by modifying the input array in-place with O(1) extra memory.<br>
 * 
 * ref: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * 
 */
public class _26_RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {

		int[] numbers = { 1, 2, 3, 3, 4, 4, 4, 5, 6 };

		System.out.println("numbers: " + Arrays.toString(numbers));

		System.out.println("size: " + numbers.length);

		int newSize = removeDuplicatesAndReturnNewSize(numbers);

		System.out.println("newSize: " + newSize);

		for (int i = 0; i < newSize; i++) {
			System.out.println("number: " + numbers[i]);
		}

		int s = removeDuplicates(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 6)));

	}

	/**
	 * Loop through the array<br>
	 * find unique values and arrange them together.<br>
	 * Time Complexity : O(n)<br>
	 * Auxiliary Space : O(1)<br>
	 */
	public static int removeDuplicatesAndReturnNewSize(int[] numbers) {
		System.out.println("removeDuplicatesAndReturnNewSize..");

		int nonDuplicate = 0;

		for (int i = 1; i < numbers.length; i++) {

			System.out.println("numbers: " + Arrays.toString(numbers) + ", numbers[nonDuplicate]: "
					+ numbers[nonDuplicate] + ", numbers[i]: " + numbers[i]);
			if (numbers[nonDuplicate] != numbers[i]) {
				System.out.println("flip numbers: " + numbers[nonDuplicate + 1] + " and " + numbers[i]);
				nonDuplicate++;
				numbers[nonDuplicate] = numbers[i];
			}
		}

		System.out.println("final numbers: " + Arrays.toString(numbers));
		return nonDuplicate + 1;
	}

	public static int removeDuplicates(List<Integer> numbers) {
		System.out.println("removeDuplicates..");

		int nonDuplicate = 0;
		boolean zero = false;

		if (numbers.contains(0)) {
			zero = true;
		}

		for (int i = 0; i < numbers.size(); i++) {
			if (((i + 1) < numbers.size()) && numbers.get(i).equals(numbers.get(i + 1))) {
				numbers.set(i, 0);
			}
		}
		System.out.println("numbers: " + numbers);
		numbers.removeIf(n -> (n == 0));
		
		if(zero){
			numbers.add(0, 0);
		}
		
		System.out.println("final numbers: " + numbers);
		return nonDuplicate + 1;
	}

}
