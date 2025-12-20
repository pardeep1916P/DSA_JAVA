import java.util.Arrays;

class Solution {

    /*
      Maximum Gap — Sorting Based Approach (Brute Force)

      Approach:
      - Sort the array using merge sort.
      - Once sorted, the maximum gap must occur between
        two consecutive elements.
      - Scan the sorted array and compute the maximum
        difference between adjacent values.

      Time  : O(n log n) — dominated by merge sort
      Space : O(n)       — extra arrays created during merge

      Note:
      This is a brute force / baseline solution.
      The optimal solution uses bucket-based logic → O(n) time.
    */

    // Merge two sorted arrays into one sorted array
    private int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] arr = new int[m + n];

        while (i < m && j < n) arr[k++] = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];

        // Append remaining elements
        while (i < m) arr[k++] = arr1[i++];
        while (j < n) arr[k++] = arr2[j++];

        return arr;
    }

    // Recursive merge sort implementation
    private int[] mergeSort(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public int maximumGap(int[] nums) {

        // Less than two elements → no gap possible
        if (nums.length < 2) return 0;

        // Sort the array
        nums = mergeSort(nums);

        int maxDiff = 0;

        // Compute maximum difference between consecutive elements
        for (int i = 1; i < nums.length; i++) maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);

        return maxDiff;
    }
}
