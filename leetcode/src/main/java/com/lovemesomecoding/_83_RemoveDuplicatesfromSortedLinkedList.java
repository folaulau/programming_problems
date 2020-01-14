package com.lovemesomecoding;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 *
 */
public class _83_RemoveDuplicatesfromSortedLinkedList {

	public static void main(String[] args) {
		ListNode listA = new ListNode(1);
		listA.next = new ListNode(1);
		// listA.next.next = new ListNode(4);

		System.out.println("list");
		listA.print();
		System.out.println();

		ListNode mergedList = deleteDuplicates(listA);

		System.out.println("uniqueList");
		mergedList.print();
		System.out.println();
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode current = head;

		while (current != null && current.next != null) {

			if (current.val == current.next.val) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}

		return head;
	}
}
