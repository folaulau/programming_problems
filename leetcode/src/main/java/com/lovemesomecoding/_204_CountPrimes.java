package com.lovemesomecoding;

/**
 * Count the number of prime numbers less than a non-negative number, n.<br>
 * 
 * Example:<br>
 * 
 * Input: 10<br>
 * Output: 4<br>
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.<br>
 * 
 * @author folaukaveinga
 *
 */
public class _204_CountPrimes {

	public static void main(String[] args) {
		int number = 13;
		int count = countPrimes(number);
		System.out.println("number: "+number+", count: "+count);
	}

	public static int countPrimes(int n) {
		int count = 0;
		for(int i=0;i<n;i++) {
			if(isPrimeNumber(i)) {
				count++;
			}
		}
		return count;
	}
	
	public static boolean isPrimeNumber(int number) {
		boolean isPrime = true;
		// No prime number is divisible by more than half of itself.
		
		if(number<=1) {
			return false;
		}
		
		int halfOfNumber = number / 2;

		for (int i = 2; i <= halfOfNumber; i++) {
			//System.out.println(number + "%" + i + "=" + (number % i));
			if (number % i == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}
}
