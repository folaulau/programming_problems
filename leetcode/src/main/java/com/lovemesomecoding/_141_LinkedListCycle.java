package com.lovemesomecoding;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it. <br>
 * 
 * To represent a cycle in the given linked list, we use an integer pos which
 * represents the position (0-indexed) in the linked list where tail connects
 * to. If pos is -1, then there is no cycle in the linked list.<br>
 * 
 * Example 1<br>
 * Input: head = [3,2,0,-4], pos = 1<br>
 * Output: true<br>
 * Explanation: There is a cycle in the linked list, where tail connects to the
 * second node.<br>
 */
public class _141_LinkedListCycle {

	public static void main(String[] args) {
		ListNode nodeA = new ListNode(1);
		ListNode nodeB = new ListNode(2);
		ListNode nodeC = new ListNode(3);
		ListNode nodeD = new ListNode(4);
		ListNode nodeE = new ListNode(5);

		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		nodeD.next = nodeE;
		// nodeE.next = nodeA;

		System.out.println("listA");
		nodeA.print();
		System.out.println();

		boolean cycled = hasCycle(nodeA);

		System.out.println("cycled: " + cycled);

	}

	public static boolean hasCycleWithHashMap(ListNode head) {

		Set<ListNode> nodes = new HashSet<>();
		while (head != null) {
			if (nodes.contains(head)) {
				return true;
			} else {
				nodes.add(head);
			}
			head = head.next;
		}

		return false;
	}

	/**
	 * Imagine two runners running on a track at different speed. What happens when
	 * the track is actually a circle?<br>
	 * 
	 * Algorithm<br>
	 * 
	 * The space complexity can be reduced to O(1) by considering two pointers at
	 * different speed - a slow pointer and a fast pointer. The slow pointer moves
	 * one step at a time while the fast pointer moves two steps at a time.<br>
	 * 
	 * If there is no cycle in the list, the fast pointer will eventually reach the
	 * end and we can return false in this case.<br>
	 * 
	 * Now consider a cyclic list and imagine the slow and fast pointers are two
	 * runners racing around a circle track. The fast runner will eventually meet
	 * the slow runner. Why? Consider this case (we name it case A) - The fast
	 * runner is just one step behind the slow runner. In the next iteration, they
	 * both increment one and two steps respectively and meet each other.<br>
	 * 
	 * How about other cases? For example, we have not considered cases where the
	 * fast runner is two or three steps behind the slow runner yet. This is simple,
	 * because in the next or next's next iteration, this case will be reduced to
	 * case A mentioned above.<br>
	 * 
	 */
	public static boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;

		// check for no match
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			System.out.println("slow: " + slow.val + ", fast: " + fast.val);
			
			slow = slow.next;
			fast = fast.next.next;

			
		}

		return true;
	}
}
