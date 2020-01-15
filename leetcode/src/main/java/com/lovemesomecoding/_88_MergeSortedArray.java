package com.lovemesomecoding;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.<br>
 * 
 * Note:<br>
 * 
 * The number of elements initialized in nums1 and nums2 are m and n
 * respectively.<br>
 * You may assume that nums1 has enough space (size that is greater or equal to
 * m + n) to hold additional elements from nums2.
 *
 * Example:<br>
 * 
 * Input:<br>
 * 
 * nums1 = [1,2,3,0,0,0], m = 3<br>
 * nums2 = [2,5,6], n = 3<br>
 * 
 * Output: [1,2,2,3,5,6]<br>
 */
public class _88_MergeSortedArray {

	public static void main(String[] args) {
		int[] nums1 = new int[] { 1, 2, 3 };
		int[] nums2 = new int[] { 2, 5, 6 };
		System.out.println("nums1: " + Arrays.toString(nums1));
		System.out.println("nums2: " + Arrays.toString(nums2));
		int[] mergedNums = merge(nums1, nums2);
		System.out.println("mergedNums: " + Arrays.toString(mergedNums));
	}

	/**
	 * Use merge sort<br>
	 * Time Complexity : O(n1 + n2)<br>
	 * Auxiliary Space : O(n1 + n2)
	 * 
	 */
	public static int[] merge(int[] nums1, int[] nums2) {
		int nums1Size = nums1.length;
		int nums2Size = nums2.length;

		int[] merged = new int[nums1Size + nums2Size];

		int i = 0, j = 0, k = 0;

		// Traverse both array
		while (i < nums1Size && j < nums2Size) {
			// Check if current element of first
			// array is smaller than current element
			// of second array. If yes, store first
			// array element and increment first array
			// index. Otherwise do same with second array
			if (nums1[i] < nums2[j]) {
				merged[k++] = nums1[i++];
			} else {
				merged[k++] = nums2[j++];
			}

		}

		// Store remaining elements of first array
		while (i < nums1Size) {
			merged[k++] = nums1[i++];
		}

		// Store remaining elements of second array
		while (j < nums2Size) {
			merged[k++] = nums2[j++];
		}

		return merged;
	}
	
	public void merge(int A[], int m, int B[], int n) {
		 
        while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
 
        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }
}
