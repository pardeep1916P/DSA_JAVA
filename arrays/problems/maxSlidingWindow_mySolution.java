class Solution {
    /*
      Sliding Window Maximum — Brute Force Approach (Not Optimal)

      Approach:
      - For each window position i → i+k-1:
            * Scan all k elements inside the window
            * Track and store the maximum value
      - Repeat this for all valid window positions.

      Time  : O(n * k) — for each of the (n−k+1) windows, we scan k elements
      Space : O(1) extra — result array excluded

      Note:
      This solution is correct but inefficient.
      The optimal approach uses a deque for O(n) time performance.
    */
    public int[] maxSlidingWindow(int[] nums, int k) {

        // Handle edge cases
        if (nums.length == 0 || k == 0)
            return new int[0];

        // Number of windows = n - k + 1
        int[] res = new int[nums.length - k + 1];
        int idx = 0;

        // Slide the window from index 0 → n-k
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];

            // Check all elements inside the current window
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max)
                    max = nums[j];
            }

            // Store max of this window
            res[idx++] = max;
        }

        return res;
    }
}
