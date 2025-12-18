class Solution {

    /*
      Search in Rotated Sorted Array II — Two-End Linear Scan (Simple Approach)

      Approach:
      - Use two pointers starting from both ends of the array.
      - At each step:
            • Check if either end matches the target.
            • If not, move both pointers inward.
      - Continue until the pointers cross or the target is found.

      Time  : O(n) — worst case scans the entire array
      Space : O(1) — constant extra space

      Note:
      This is a simple and correct solution,
      but it does not use the sorted or rotated property of the array.
    */

    public boolean search(int[] nums, int target) {

        int l = 0, r = nums.length - 1;

        while (l <= r) {

            // Check both ends for the target
            if (nums[l] == target || nums[r] == target)
                return true;

            // Move pointers inward
            l++;
            r--;
        }

        return false; // Target not found
    }
}
