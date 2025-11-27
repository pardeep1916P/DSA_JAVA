/*
  Sliding Window Approach — Count Subarrays with Product < k

  Why this works:
  All numbers are positive. So as the window expands, the product only increases.
  When product becomes ≥ k, we shrink the window from the left until it’s valid again.

  For each index r, every subarray ending at r and starting from any index in [l…r]
  is guaranteed to have product < k. So simply count them.

  Time  : O(n) — each element enters/exits window at most once
  Space : O(1) — constant extra space
*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // Edge case: if k <= 1, no positive product can be < k
        if (k <= 1) return 0;

        int l = 0;          // left pointer of sliding window
        int product = 1;    // product of current window
        int count = 0;      // total valid subarrays

        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];   // expand window to the right

            // Shrink window until product < k
            while (product >= k) product /= nums[l++];

            // All subarrays ending at r and starting in [l…r] are valid
            count += r - l + 1;
        }
        return count;
    }
}
