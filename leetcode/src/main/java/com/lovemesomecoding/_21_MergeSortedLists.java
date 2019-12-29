package com.lovemesomecoding;

import java.util.LinkedList;
import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list. <br>
 * The new list should be made by splicing together the nodes <br>
 * of the first two lists.
 * 
 * Example Input: 1->2->4, 1->3->4 1->1->2->3->4->4
 * 
 * @author folaukaveinga
 *
 */
public class _21_MergeSortedLists {

	public static void main(String[] args) {

		ListNode listA = new ListNode(1);
		listA.next = new ListNode(2);
		listA.next.next = new ListNode(4);

		System.out.println("listA");
		listA.print();
		System.out.println();

		ListNode listB = new ListNode(1);
		listB.next = new ListNode(3);
		listB.next.next = new ListNode(4);

		System.out.println("listB");
		listB.print();
		System.out.println();

//		ListNode mergedList = mergeMySolution(listA, listB);
//
//		System.out.println("mergedList");
//		mergedList.print();
//		System.out.println();

		ListNode mergedList = merge(listA, listB);

		System.out.println("mergedList");
		mergedList.print();
		System.out.println();

//		mergedList = mergeRecursion(listA, listB);
//
//		System.out.println("mergedList");
//		mergedList.print();
//		System.out.println();

	}

	/**
	 * Time Complexity: O(n)<br>
	 * 
	 * 1. set up a while to traverse both lists<br>
	 * 2. set up a dummy node<br>
	 * 3. set a pointer node to do the merge<br>
	 * 4. if either list is null, set other list as mergedList<br>
	 * 5. start traversing both lists, compare values<br>
	 * 6. add and move list points down their nodes<br>
	 * 7. once you are done, return the list start from the next of the dummy.<br>
	 */
	public static ListNode merge(ListNode listA, ListNode listB) {
		System.out.println("merge(..)");
		ListNode mergedList = new ListNode(0);

		ListNode tail = mergedList;

		while (true) {

			if (listA == null) {
				tail.next = listB;
				break;
			}

			if (listB == null) {
				tail.next = listA;
				break;
			}

			System.out.println("listA.val: " + listA.val + ", listB.val: " + listB.val);

			if (listA.val <= listB.val) {
				tail.next = listA;
				listA = listA.next;

			} else {
				tail.next = listB;
				listB = listB.next;

			}
			tail = tail.next;
		}

		return mergedList.next;
	}

	public static ListNode mergeMySolution(ListNode listA, ListNode listB) {
		System.out.println("merge(..)");
		ListNode mergedList = null;

		if (listA == null) {
			return listB;
		}

		if (listB == null) {
			return listA;
		}

		while (listA != null) {
			int valueA = listA.val;
			System.out.println("valueA: " + valueA);

			while (listB != null) {
				int valueB = listB.val;
				System.out.println("valueB: " + valueB);

				if (valueB <= valueA) {
					if (mergedList == null) {
						mergedList = new ListNode(valueB);
					} else {
						append(mergedList, valueB);
					}
					listB = listB.next;
					System.out.println("adding ------- " + valueB + " now!");
					// System.out.println("go to next b!"+(listB==null)+", next value b:
					// "+listB.val);
				} else {

					System.out.println("adding ------- " + valueA + " now!");

					if (mergedList == null) {
						mergedList = new ListNode(valueA);
					} else {
						append(mergedList, valueA);
					}

					System.out.println("adding ------- " + valueB + " now!");

					append(mergedList, valueB);

					listA = listA.next;

					break;
				}

			}

			listA = listA.next;

			// System.out.println("go to next!"+(listA==null)+", next value: "+listA.val);

		}

		return mergedList;
	}

	public static ListNode mergeRecursion(ListNode listA, ListNode listB) {
		if (listA == null) {
			return listB;
		}

		if (listB == null) {
			return listA;
		}

		if (listA.val < listB.val) {
			listA.next = mergeRecursion(listA.next, listB);
			return listA;
		} else {
			listB.next = mergeRecursion(listA, listB.next);
			return listB;
		}
	}

	public static void append(ListNode last, int value) {

		while (last.next != null) {
			last = last.next;
		}

		last.next = new ListNode(value);
	}
}

class ListNode {
	int val;

	ListNode next;

	ListNode(int x) {
		val = x;
	}

	/**
	 * append to end of list
	 * 
	 * @param value
	 */

	public void print() {
		ListNode head = this;
		System.out.print(head.val);
		while (head.next != null) {
			head = head.next;
			System.out.print(" " + head.val);
		}
	}

}
