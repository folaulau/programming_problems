package com.lovemesomecoding;

/**
 * Difficulty Level - Medium You are given two non-empty linked lists
 * representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.<br>
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.<br>
 * 
 * Example 1:<br>
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) <br>
 * Output: 7 -> 0 -> 8 Explanation: 342 + 465 = 807.
 * 
 * Example 2:<br>
 * 
 * Input: [9] + [1,9,9,9,9,9,9,9,9,9] <br>
 *
 */
public class _2_AddTwoNumbers {

	public static void main(String[] args) {
		ListNode listA = new ListNode(2);
		listA.next = new ListNode(4);
		listA.next.next = new ListNode(3);

		System.out.println("listA");
		listA.print();
		System.out.println();

		ListNode listB = new ListNode(5);
		listB.next = new ListNode(6);
		listB.next.next = new ListNode(4);

		System.out.println("listB");
		listB.print();
		System.out.println();

		ListNode sum = addTwoNumbersMySolution(listA, listB);
		sum.print();
		System.out.println();

		listA = new ListNode(9);

		System.out.println("listA");
		listA.print();
		System.out.println();

		listB = new ListNode(1);
		listB.next = new ListNode(9);
		listB.next.next = new ListNode(9);
		listB.next.next.next = new ListNode(9);
		listB.next.next.next.next = new ListNode(9);
		listB.next.next.next.next.next = new ListNode(9);
		listB.next.next.next.next.next.next = new ListNode(9);
		listB.next.next.next.next.next.next.next = new ListNode(9);
		listB.next.next.next.next.next.next.next.next = new ListNode(9);
		listB.next.next.next.next.next.next.next.next.next = new ListNode(9);

		System.out.println("listB");
		listB.print();
		System.out.println();

		sum = addTwoNumbers(listA, listB);
		sum.print();
		System.out.println();
	}

	/**
	 * Works for small set as the sum can out grow data structure.
	 * 
	 * int will go out of space.
	 * 
	 * 1. take sum of two lists<br>
	 * 2. put each digit in a node<br>
	 */
	public static ListNode addTwoNumbersMySolution(ListNode listA, ListNode listB) {

		int listASum = 0;
		int listBSum = 0;
		int count = 0;
		int multiplier = 0;

		while (listA != null || listB != null) {

			if (count == 0) {
				multiplier = 1;
			} else {
				multiplier = (int) Math.pow(10, count);
			}

			if (listA != null) {
				listASum += listA.val * multiplier;
				listA = listA.next;
			}

			if (listB != null) {
				listBSum += listB.val * multiplier;
				listB = listB.next;
			}

			System.out.println("multiplier: " + multiplier + ", count: " + count + ", listASum: " + listASum
					+ ", listBSum: " + listBSum);

			count++;
		}

		System.out.println("listASum: " + listASum + ", listBSum: " + listBSum);

		int sum = listASum + listBSum;

		ListNode mergedList = new ListNode(0);
		ListNode tail = mergedList;

		while (true) {
			int leftOver = sum % 10;
			System.out.println("sum: " + sum + ", leftOver: " + leftOver);
			tail.next = new ListNode(leftOver);

			sum = (int) (sum / 10);

			if (sum == 0) {
				break;
			}

			tail = tail.next;
		}

		return mergedList.next;
	}

	/**
	 * Traverse both lists and One by one pick nodes of both lists and add the
	 * values. If the sum is more than 10 then make carry as 1 and reduce sum. If
	 * one list has more elements than the other then consider remaining values of
	 * this list as 0.
	 * 
	 * Time complexity : O(max(m, n)).
	 * 
	 * Assume that m and n represents the length of l1 and l2 respectively, the
	 * algorithm above iterates at most max(m, n) times.
	 * 
	 * Space complexity : O(max(m,n)). The length of the new list is at most
	 * max(m,n)+1.
	 * 
	 */
	public static ListNode addTwoNumbers(ListNode listA, ListNode listB) {

		ListNode mergedList = new ListNode(0);
		ListNode tail = mergedList;

		int leftOver = 0, sum = 0;

		while (listA != null || listB != null) {
			sum = leftOver + (listA != null ? listA.val : 0) + (listB != null ? listB.val : 0);

			leftOver = (sum >= 10) ? 1 : 0;

			int value = sum % 10;

			System.out.println("sum: " + sum + ", leftOver: " + leftOver + ", value: " + value);

			tail.next = new ListNode(value);

			// Move first and second pointers to next nodes
			if (listA != null) {
				listA = listA.next;
			}

			if (listB != null) {
				listB = listB.next;
			}

			tail = tail.next;
		}

		System.out.println("leftOver: " + leftOver);

		if (leftOver > 0) {
			tail.next = new ListNode(leftOver);
		}

		return mergedList.next;
	}

}
