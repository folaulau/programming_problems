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
 */
public class _20_ValidParentheses {

	public static void main(String[] args) {
		Arrays.asList("()", "()[]{}", "(]", "([)]", "{[]}").forEach(str -> {
			boolean valid = isValidParentheses(str);
			System.out.println("str: " + str + ", valid: " + valid + "\n\n");
		});
	}

	/**
	 * 1. Use a Map as a dictionary for parentheses.<br>
	 * 2. Use a stack to store the input parentheses(opening)<br>
	 * 3. Loop through characters in str<br>
	 * 4. Check if it's a closing parentheses<br>
	 * 4.a. pop the top element from stack 4.b. if top element is not equal to
	 * closing parentheses opening parentheses => return false<br>
	 * 5. At the end, if stack still contains elements, then it is invalid.
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
				// If it was an opening bracket, push to the stack.
				stack.push(parentheses);
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

		return parentheses;
	}
}
