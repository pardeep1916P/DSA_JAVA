/*
  Optimal Solution — Sliding Window (Two Pointers)

  Why this works:
  We need the smallest subarray with sum ≥ target.
  A fixed-size window won't work, but a dynamically growing + shrinking one does.

  Key idea:
      Expand right pointer to increase the sum,
      Then shrink left pointer while the window is still valid.

  Even though there's a while-loop inside the for-loop, the window never moves backward:
      • right pointer moves forward n times
      • left pointer moves forward n times
  Total pointer movement = n + n → O(n) time.
  Space usage stays constant.

  Time  : O(n)  — each index visited at most twice
  Space : O(1)  — no extra data structures
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int l = 0;                     // left pointer of the window
        int total = 0;                 // running sum inside the window
        int res = Integer.MAX_VALUE;   // tracks minimum valid window size

        for (int r = 0; r < nums.length; r++) {
            total += nums[r];          // expand window by including nums[r]

            // When the sum is valid, shrink the window to find the smallest length.
            while (total >= target) {
                res = Math.min(res, r - l + 1);
                total -= nums[l];
                l++;                   // move left pointer forward
                //can also merge them like this => total -= nums[l++];(increments after using)
            }

        }

        // If no window ever satisfied the condition, return 0 (as per problem definition).
        return (res == Integer.MAX_VALUE)? 0 : res;
    }
}
