/*
  Optimal Solution using Prefix Sum + HashMap

  Why this works:
  Instead of checking every subarray (O(n²)),
  we use the key idea:
      prefixSum[j] - prefixSum[i-1] = k

  So, for each running prefixSum, we just look up how many times
  (prefixSum - k) has appeared before. Those represent all valid
  subarrays ending at the current index.

  Time  : O(n)  — single pass, constant-time map operations
  Space : O(n)  — stores frequency of prefix sums
*/

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // Stores prefixSum → frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        //base case handles prefixSum equal to k (sum-k=0)
        // means a subarray starting at index 0 is valid
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;  // update running prefix sum
            // If (sum - k) appeared before, then every occurrence of that prefix marks a valid subarray ending here.
            if (map.containsKey(sum - k)) count += map.get(sum - k);
            // Record/update the frequency of the current prefix sum.
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
