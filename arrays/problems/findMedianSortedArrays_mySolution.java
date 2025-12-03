
/*
  Median of Two Sorted Arrays — Simple Merge Approach (my approach)

  Approach:
  - Merge both sorted arrays into one fully sorted array
    using the same strategy as merge sort.
  - Once merged, compute the median based on total length.
      • Odd length  → middle element
      • Even length → average of two middle elements

  Time  : O(m + n) — merging both arrays completely
  Space : O(m + n) — storing the merged array

  Note:
  This solution is easy to understand but not the most optimal.
  The best known solution uses binary search → O(log(min(m, n))).
*/

class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Array to store merged result
        int[] arr = new int[nums1.length + nums2.length];

        int x = 0, y = 0, i = 0;

        // Merge both arrays while maintaining sorted order
        while (x < nums1.length && y < nums2.length) {
            if (nums1[x] < nums2[y]) arr[i++] = nums1[x++];
            else arr[i++] = nums2[y++];
        }

        // Remaining elements from nums1
        while (x < nums1.length) arr[i++] = nums1[x++];

        // Remaining elements from nums2
        while (y < nums2.length) arr[i++] = nums2[y++];

        int midIndex = arr.length / 2;
        double median;

        // If even length → average of two middle values
        if (arr.length % 2 == 0) median = (arr[midIndex] + arr[midIndex - 1]) / 2.0;
        else median = arr[midIndex];

        return median;
    }
}
