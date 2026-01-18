class Solution {

    /*
      Is Subsequence — Sliding Match Attempt (Own Solution)

      Approach:
      - Attempt to match the subsequence starting at different positions in `t`.
      - Use pointer `j` to track how many characters of `s` have been matched.
      - For each index `i` in `t`, try to match consecutive characters
        of `s` with `t[i + j]`.
      - If all characters of `s` are matched (`j == s.length()`),
        return true.

      Time  : O(n * m) in the worst case
              n = length of t
              m = length of s
      Space : O(1) — constant extra space

      Note:
      This solution works logically but does unnecessary re-checking
      and is not optimal.
    */

    public boolean isSubsequence(String s, String t) {

        // Edge case: both strings empty
        if (s.isEmpty() && t.isEmpty()) return true;

        int freq = s.length();
        int j = 0;

        // Try matching s starting from different positions in t
        for (int i = 0; i < t.length(); i++) {

            while (j < freq && i + j < t.length()
                    && s.charAt(j) == t.charAt(i + j)) {
                j++;
            }

            // All characters of s matched
            if (j == freq) return true;
        }

        return false;
    }
}
