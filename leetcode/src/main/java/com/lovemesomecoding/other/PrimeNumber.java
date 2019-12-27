package com.lovemesomecoding.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Generally, the definition of prime numbers is all those natural numbers <br>
 * greater than 1, having only two divisiors [sic], the number itself and 1.
 * <br>
 * ... This is very similar to the positive integers, for which we say that <br>
 * a positive integer is prime if it has only two divisors among the <br>
 * positive integers<br>
 * 
 * A prime number is a number that is only divisible by 1 or itself. <br>
 * For example, 11 is only divisible by 1 or itself. <br>
 * Other Prime numbers 2, 3, 5, 7, 11, 13, 17....<br>
 * Note: 0 and 1 are not prime numbers. 2 is the only even prime number.
 * 
 * @author folaukaveinga
 *
 */
public class PrimeNumber {

	public static void main(String[] args) {
		Arrays.asList(-1, 0, 1, 2, 3, 12, 121, 23, 111).forEach(num -> {
			boolean result = isPrimeNumber(num);
			System.out.println("num: " + num + ", primeNumber: " + result);
		});

		int number = 4;
		
		List<Integer> primeNumbers = getPrimeNumbers(number);
		
		System.out.println("primeNumbers from "+number+" are: "+primeNumbers.toString());
	}

	/**
	 * No number is divisible by more than half of itself. <br>
	 * So, we need to loop through just numberToCheck/2. If the input is 17, <br>
	 * half is 8.5, and the loop will iterate through values 2 to 8<br>
	 * 
	 * @param number
	 * @return
	 */
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

	public static List<Integer> getPrimeNumbers(int number) {
		List<Integer> primeNumbers = new ArrayList<>();

		for(int i=2;i<=number;i++) {
			if(isPrimeNumber(i)) {
				primeNumbers.add(i);
			}
		}
		
		return primeNumbers;
	}
}
