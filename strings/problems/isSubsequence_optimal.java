class Solution {

    /*
      Is Subsequence — Two Pointer Greedy Approach (Optimal Solution)

      Approach:
      - Use two pointers:
            • i for string s
            • j for string t
      - Traverse string t and try to match characters of s in order.
      - When characters match, move pointer i forward.
      - Always move pointer j forward.
      - If all characters of s are matched, it is a subsequence.

      Time  : O(n)
              n = length of t
      Space : O(1) — constant extra space

      Note:
      This is the most optimal and interview-expected solution.
    */

    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {

            // Match character of s with current character of t
            if (s.charAt(i) == t.charAt(j)) i++;

            // Always move forward in t
            j++;
        }

        return i == s.length();
    }
}
