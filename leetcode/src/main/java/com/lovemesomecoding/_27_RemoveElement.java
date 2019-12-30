package com.lovemesomecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given an array nums and a value val, remove all instances of that <br>
 * value in-place and return the new length.<br>
 * Do not allocate extra space for another array, you must do this by <br>
 * modifying the input array in-place with O(1) extra memory.<br>
 * 
 * The order of elements can be changed. It doesn't matter what <br>
 * you leave beyond the new length.<br>
 * 
 * ref: https://leetcode.com/problems/remove-element/
 * 
 * 
 * 
 * 
 */
public class _27_RemoveElement {

	public static void main(String[] args) {

		int[] numbers = { 0, 1, 2, 2, 3, 0, 4, 2 };

		System.out.println("numbers: " + Arrays.toString(numbers));

		System.out.println("size: " + numbers.length);

		int newSize = removeElement(numbers, 2);

		System.out.println("newSize: " + newSize);

		for (int i = 0; i < newSize; i++) {
			System.out.println("number: " + numbers[i]);
		}

		int s = removeElement(new ArrayList<>(Arrays.asList(0, 1, 2, 2, 3, 0, 4, 2)), 2);

	}

	/**
	 * Loop through the array<br>
	 * find unique values and arrange them together.<br>
	 * Time Complexity : O(n)<br>
	 * Auxiliary Space : O(1)<br>
	 */
	public static int removeElement(int[] numbers, int value) {
		System.out.println("removeElement..." + value);

		int nonValue = 0;

		for (int x = 0; x < numbers.length; x++) {

			if (numbers[x] != value) {

				numbers[nonValue] = numbers[x];

				nonValue++;
			}
		}

		System.out.println("final numbers: " + Arrays.toString(numbers));
		return nonValue;
	}

	public static int removeElement(List<Integer> numbers, int value) {
		System.out.println("removeElement.."+value);
		System.out.println("numbers: " + numbers);
		Iterator<Integer> it = numbers.iterator();

		while (it.hasNext()) {
			Integer i = it.next();
			if (i.equals(value)) {
				it.remove();
			}
		}
		System.out.println("final numbers: " + numbers);
		return numbers.size();
	}

}
