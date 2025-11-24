/*
  Brute Force Approach

  Logic:
  For every starting index i, expand the subarray to the right (j)
  and keep a running sum. Each time the running sum equals k,
  we’ve found a valid subarray.

  Time  : O(n^2) — two nested loops checking all subarrays
  Space : O(1)   — uses only a few variables
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length,count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;  // reset sum for the new starting index
            for (int j = i; j < n; j++) {
                sum += nums[j];  // grow subarray and update sum
                // if running sum matches k, we've found a valid subarray
                if (sum == k) count++;
            }
        }
        return count;
    }
}
