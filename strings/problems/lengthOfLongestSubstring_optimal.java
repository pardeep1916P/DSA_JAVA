import java.util.Arrays;

class Solution {

    /*
      Longest Substring Without Repeating Characters
      Sliding Window using Last Seen Index (Most Optimal Solution)

      Approach:
      - Maintain an array `last` storing the last index of each character.
      - Initialize all values to -1.
      - Use two pointers:
            • l = start of current window
            • r = current index
      - If the current character was seen inside the window,
        jump l directly to last[ch] + 1.
      - Update last seen index and track maximum length.

      Time  : O(n) — single pass
      Space : O(1) — fixed-size array (ASCII)

      Note:
      This avoids repeated removals and makes direct jumps,
      making it strictly more efficient than the HashSet version.
    */

    public int lengthOfLongestSubstring(String s) {

        int[] last = new int[128];
        Arrays.fill(last, -1);

        int l = 0, max = 0, n = s.length();

        for (int r = 0; r < n; r++) {

            char ch = s.charAt(r);

            // If character seen inside current window, move left pointer
            if (last[ch] >= l) l = last[ch] + 1;

            last[ch] = r;

            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}
