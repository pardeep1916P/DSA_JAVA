/*
      Array Pair Sum — Sorting Based Strategy (Second Optimal Solution)

      Approach:
      - Sort the array so that pairing adjacent elements produces the highest
        possible sum of the minimums in each pair.
      - Pair elements as (nums[0], nums[1]), (nums[2], nums[3]), ...
      - Always add the first element of each pair because it is the minimum
        after sorting.

      Time  : O(n log n) — due to sorting
      Space : O(n)       — merge sort creates temporary arrays

      Note:
      The absolute optimal solution uses counting sort / frequency array → O(n)
      This solution is clean but second best in performance.
    */

import java.util.Arrays; //optional for leetCode

class Solution {

    public int arrayPairSum(int[] nums) {

        // Sort using merge sort for controlled complexity
        nums = mergeSort(nums);

        int sum = 0;

        // Take every alternate number (the minimum of each sorted pair)
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }


    // ---------------- Merge Sort Implementation ---------------- //

    private int[] mergeSort(int[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }


    private int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int m = arr1.length, n = arr2.length;
        int[] arr = new int[m + n];

        // Merge two sorted lists into one sorted array
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) arr[k++] = arr1[i++];
            else arr[k++] = arr2[j++];
        }

        // Remaining elements
        while (i < m) arr[k++] = arr1[i++];
        while (j < n) arr[k++] = arr2[j++];

        return arr;
    }
}
