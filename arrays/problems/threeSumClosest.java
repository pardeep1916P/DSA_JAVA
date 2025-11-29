/*
  Two-Pointer Approach — Find the Closest 3-Sum to Target

  Why this works:
  - Sorting enables a structured two-pointer scan for each fixed element.
  - Since the array is sorted:
        * If current sum is < target → increase sum by moving left pointer right.
        * If current sum is > target → decrease sum by moving right pointer left.
  - Track the smallest absolute difference between any triplet sum and target.

  Key Notes:
  - If we find a triplet equal to target → best possible answer → return immediately.
  - Only O(n^2) combinations are checked efficiently with pointers.

  Time  : O(n^2) — sorting + nested two-pointer scanning
  Space : O(1) — no extra significant memory used
*/

import java.util.Arrays; //optional for LC

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        // Sort input for ordered two-pointer traversal
        Arrays.sort(nums);

        // Initialize result with the first valid triplet sum
        int resultSum = nums[0] + nums[1] + nums[2];

        // Track the closest difference found so far
        int minDif = Math.abs(resultSum - target);

        // Loop each number as the first element in the triplet
        for (int i = 0; i < nums.length - 2; i++) {

            int l = i + 1;              // Left pointer
            int r = nums.length - 1;    // Right pointer

            // Two-pointer scan for best pairing with nums[i]
            while (l < r) {

                int sum = nums[i] + nums[l] + nums[r]; //nums[i] is fixed for compelete loop iteration

                // If exact match found, no better result possible
                if (sum == target) return target;

                int diff = Math.abs(sum - target);

                // Update closest sum if a better difference is found
                if (diff < minDif) {
                    minDif = diff;
                    resultSum = sum;
                }

                // Adjust pointers to move sum closer to target
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        // Final closest sum identified
        return resultSum;
    }
}
