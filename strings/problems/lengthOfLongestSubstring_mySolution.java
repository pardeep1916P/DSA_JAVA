import java.util.HashSet;

class Solution {

    /*
      Longest Substring Without Repeating Characters
      Sliding Window using HashSet (Optimal Solution 2)

      Approach:
      - Use two pointers (l and r) to maintain a sliding window.
      - Use a HashSet to store characters currently in the window.
      - Expand the right pointer.
      - If a duplicate is found:
            • Shrink the window from the left
            • Remove characters until the duplicate is removed.
      - Update the maximum window length at each step.

      Time  : O(n) — each character added and removed at most once
      Space : O(k) — at most k unique characters in the window

      Note:
      This is a standard and fully interview-acceptable solution.
      It is clean but involves repeated removals when duplicates appear.
    */

    public int lengthOfLongestSubstring(String s) {

        int l = 0, max = 0;
        HashSet<Character> set = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {

            // Remove characters until duplicate is gone
            while (set.contains(s.charAt(r))) set.remove(s.charAt(l++));

            set.add(s.charAt(r));

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
