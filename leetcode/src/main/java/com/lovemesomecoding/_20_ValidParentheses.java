package com.lovemesomecoding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}',<br>
 * '[' and ']', determine if the input string is valid.<br>
 * 
 * An input string is valid if:<br>
 * 
 * 1. Open brackets must be closed by the same type of brackets. <br>
 * 2. Open brackets must be closed in the correct order.<br>
 * * Note that an empty string is also considered valid.<br>
 * 
 * @author folaukaveinga
 *
 *         Resources
 *         https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 *         parent
 */
public class _20_ValidParentheses {

	public static void main(String[] args) {
		Arrays.asList("(sdfsd)", "(sdf)[dsf]{sdf}", "(]", "([)]", "{[sdf]ll}", "a*(b+c)-<d*e>", "(a*(b-c)*{d+e}")
				.forEach(str -> {
					boolean valid = isValidParentheses(str);
					System.out.println("str: " + str + ", valid: " + valid + "\n\n");
				});
	}

	/**
	 * 1. Use a Map as a dictionary for parentheses.<br>
	 * 2. Use a stack to store the input parentheses(opening)<br>
	 * 3. Loop through characters in str<br>
	 * 4. Whenever you encounter a opening ( or { or [, push it into the stack. <br>
	 * 5. Whenever you encounter a closing ) or } or ]<br>
	 * 5.a. pop the top element from stack<br>
	 * 5.b. Compare if top element is not in pair with current => return false<br>
	 * 6. At the end, if stack still contains elements, then it is invalid.<br>
	 * 
	 * Time Complexity: O(n)<br>
	 * Auxiliary Space: O(n) for stack.<br>
	 */
	public static boolean isValidParentheses(String str) {
		Map<Character, Character> parenthesesMappings = populateParentheses();

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < str.length(); i++) {
			char parentheses = str.charAt(i);

			// check if it's a closing parentheses
			if (parenthesesMappings.containsKey(parentheses)) {

				char topParentheses = stack.empty() ? '!' : stack.pop();

				// If mapping for bracket doesn't match stack's top element,
				// return false.
				if (topParentheses != parenthesesMappings.get(parentheses)) {
					return false;
				}

			} else {

				// If it was an opening, push to the stack.
				if (parenthesesMappings.values().contains(parentheses)) {
					stack.push(parentheses);
				}

			}

		}
		// If the stack still contains elements, then it is an invalid expression.
		return stack.isEmpty();
	}

	/**
	 * make closing parentheses as keys and opening parentheses as values.
	 */
	private static Map<Character, Character> populateParentheses() {
		Map<Character, Character> parentheses = new HashMap<>();
		parentheses.put(')', '(');
		parentheses.put('}', '{');
		parentheses.put(']', '[');
		parentheses.put('>', '<');

		return parentheses;
	}
}
