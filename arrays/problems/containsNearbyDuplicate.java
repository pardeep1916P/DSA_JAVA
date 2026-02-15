import java.util.HashSet;

class Solution {

    /*
      Contains Duplicate II — Sliding Window with HashSet (Optimal Solution)

      Approach:
      - Maintain a sliding window of size at most k.
      - Use a HashSet to store elements inside the current window.
      - For each index i:
            • If nums[i] already exists in the set → duplicate found within k distance.
            • Add nums[i] to the set.
            • If window size exceeds k, remove nums[i - k] to maintain size.

      Time  : O(n) — each element added and removed at most once
      Space : O(k) — at most k elements stored in the set

      Note:
      This ensures we only check duplicates within distance k,
      not across the entire array.
    */

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {

            // If current element already in window → duplicate within k
            if (set.contains(nums[i]))
                return true;

            set.add(nums[i]);

            // Maintain window size ≤ k
            if (set.size() > k)
                set.remove(nums[i - k]);
        }

        return false;
    }
}
