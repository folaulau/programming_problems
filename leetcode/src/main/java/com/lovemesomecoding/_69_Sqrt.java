package com.lovemesomecoding;

public class _69_Sqrt {

	public static void main(String[] args) {
		int num = 4;
		int result = sqrt(num);
		System.out.println("result: " + result);

		System.out.println();
//
//		num = 2147395600;
//		result = sqrt(num);
//		System.out.println("result: " + result);

		num = 2147483647;
		result = sqrt(num);
		System.out.println("result: " + result);
	}

	/**
	 * Using binary search
	 */
	public static int sqrt(int number) {
		if (number == 0 || number == 1) {
			return number;
		}

		long start = 1, end = number;

		int answer = 0;

		long numberSquare = 0;

		while (start <= end) {
			long middle = (start + end) / 2;
			numberSquare = middle * middle;

			System.out.println("start: " + start + ", middle: " + middle + ", end: " + end + ", numberSquare: "
					+ numberSquare + ", number: " + number);
			// If x is a perfect square
			if (numberSquare == number) {
				return (int) middle;
			}

			if (numberSquare < number) {
				start = (int) (middle + 1);
				answer = (int) middle;
			} else { // If mid*mid is greater than x
				end = (int) (middle - 1);
			}
		}

		return answer;
	}
}
