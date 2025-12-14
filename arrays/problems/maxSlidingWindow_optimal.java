import java.util.Deque;      //optional for leetcode
import java.util.ArrayDeque; //optional for leetcode

class Solution {

    /*
      Sliding Window Maximum — Monotonic Deque Approach (Optimal Solution)

      Approach:
      - Use a deque to store indices of elements in decreasing order of values.
      - The deque always maintains candidates for the maximum of the current window.
      - For each index i:
            1. Remove indices from the front that are outside the current window.
            2. Remove indices from the back whose values are smaller than nums[i],
               since they can never become the maximum again.
            3. Add the current index to the back of the deque.
            4. Once the first window is formed (i >= k - 1),
               the element at the front of the deque is the maximum.

      Time  : O(n) — each index is added and removed at most once
      Space : O(k) — deque stores at most k indices

      Note:
      This is the most optimal solution for the sliding window maximum problem.
    */

    public int[] maxSlidingWindow(int[] nums, int k) {

        // Handle edge cases
        if (nums.length == 0 || k == 0) return new int[] {};

        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {

            // Remove index that is out of the current window
            if (!dq.isEmpty() && dq.peekFirst() == i - k) dq.pollFirst();

            // Maintain decreasing order in deque
            // Remove all smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            // Add current index
            dq.offerLast(i);

            // Window formed → record maximum
            if (i >= k - 1) res[index++] = nums[dq.peekFirst()];
        }

        return res;
    }
}
