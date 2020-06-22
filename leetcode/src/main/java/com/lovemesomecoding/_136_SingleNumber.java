package com.lovemesomecoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers, every element appears twice except for
 * one. Find that single one.<br>
 * 
 * Note:<br>
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?<br>
 * 
 * Example 1:<br>
 * 
 * Input: [2,2,1]<br>
 * Output: 1<br>
 * 
 * Solutions<br>
 * 1. brute force - two for loops to check for uniqueness.<br>
 * 2. hashmap to keep track of uniqueness<br>
 *
 */
public class _136_SingleNumber {

	public static void main(String[] args) {
		int[] numbers = new int[] { 2, 2, 1 };
		int singleNum = singleNumber(numbers);

		System.out.println("numbers: " + Arrays.toString(numbers) + ", singleNum: " + singleNum);

		numbers = new int[] { 4, 1, 2, 1, 2 };
		singleNum = singleNumber(numbers);

		System.out.println("numbers: " + Arrays.toString(numbers) + ", singleNum: " + singleNum);
	}

	public static int singleNumber(int[] nums) {

		Map<Integer, Integer> numStorage = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int number = nums[i];
			Integer count = numStorage.get(number);

			if (count == null) {
				numStorage.put(number, 1);
			} else {
				numStorage.put(number, count + 1);
			}
		}
		//System.out.println("numStorage: "+numStorage);
		
		//System.out.println("numStorage values: "+numStorage.values());
		return numStorage.entrySet().stream().filter(entry -> (entry.getValue() == 1)).findFirst().get().getKey();
	}
}
