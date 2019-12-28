package com.lovemesomecoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: <br>
 * I, V, X, L, C, D and M.<br>
 * Symbol - Value<br>
 * I - 1<br>
 * V - 5<br>
 * X - 10<br>
 * L - 50<br>
 * C - 100<br>
 * D - 500<br>
 * M - 1000<br>
 * 
 * Note: A dash(-) on top means 3 zeros like x with dash on top is 10000.<br>
 * 
 * Example, two is written as II in Roman numeral, two one's added together.<br>
 * Twelve is written as, XII, which is simply X + II. <br>
 * The number twenty seven is written as XXVII, which is XX + V + II.<br>
 * 
 * Roman numerals are usually written largest to smallest <br>
 * from left to right. However, the numeral for four is not IIII. <br>
 * Instead, the number four is written as IV. Because the one is <br>
 * before the five we subtract it making four. The same principle applies <br>
 * to the number nine, which is written as IX. <br>
 * There are six instances where subtraction is used:<br>
 * 
 * I can be placed before V (5) and X (10) to make 4 and 9. <br>
 * X can be placed before L (50) and C (100) to make 40 and 90. <br>
 * C can be placed before D (500) and M (1000) to make 400 and 900.<br>
 * 
 * Given a roman numeral, convert it to an integer.<br>
 * Input is guaranteed to be within the range from 1 to 3999.<br>
 * 
 * @author folaukaveinga
 *
 */
public class _13_RomanToInteger {

	public static void main(String[] args) {

		Arrays.asList("III", "IV", "IX", "LVIII", "MCMXCIV").forEach(str -> {
			int number = romanToInt(str);
			System.out.println("str: " + str + ", number: " + number + "\n\n");
		});
	}

	/**
	 * 1. Get a dictionary for roman to english integers. <br>
	 * 2. Loop through each char in str get corresponding integer.<br>
	 * 
	 * @param str
	 * @return
	 */
	public static int romanToInt(String str) {
		System.out.println("roman to int: " + str);

		Map<String, Integer> romanDictionary = getRomanIntsDictionary();

		int result = 0;

		for (int i = 0; i < str.length(); i++) {

			String romanInt = String.valueOf(str.charAt(i));

			if (romanDictionary.containsKey(romanInt)) {

				int number = 0;

				// check again for special cases
				if ((i + 1) < str.length() && romanDictionary.containsKey(romanInt + str.charAt(i + 1))) {

					number = romanDictionary.get(romanInt + str.charAt(i + 1));

					// move cursor one more since you are consuming the next char already.
					i++;

				} else {

					number = romanDictionary.get(romanInt);

				}

				result += number;

				System.out.println("c: " + romanInt + ", number: " + number + ", result: " + result);
			}
		}
		return result;
	}

	/**
	 * Symbol - Value<br>
	 * I - 1<br>
	 * V - 5<br>
	 * X - 10<br>
	 * L - 50<br>
	 * C - 100<br>
	 * D - 500<br>
	 * M - 1000<br>
	 * 
	 * A dash(-) on top means add 3 zeros like x with dash on top is 10000.<br>
	 */
	private static Map<String, Integer> getRomanIntsDictionary() {
		Map<String, Integer> romanIntegers = new HashMap<>();
		romanIntegers.put("I", 1);
		romanIntegers.put("V", 5);
		romanIntegers.put("X", 10);
		romanIntegers.put("L", 50);
		romanIntegers.put("C", 100);
		romanIntegers.put("D", 500);
		romanIntegers.put("M", 1000);

		// special cases.
		romanIntegers.put("IV", 4);
		romanIntegers.put("IX", 9);
		romanIntegers.put("XL", 40);
		romanIntegers.put("XC", 90);
		romanIntegers.put("CD", 400);
		romanIntegers.put("CM", 900);

		return romanIntegers;
	}
}
