class Solution {

    /*
      Palindromic Substrings — Expand Around Center (Optimal Solution)

      Approach:
      - Every palindrome is centered around a character (odd length)
        or between two characters (even length).
      - For each index i:
            • Expand around (i, i)   → odd-length palindromes
            • Expand around (i, i+1) → even-length palindromes
      - Count all valid expansions.

      Time  : O(n^2) — each center may expand up to n times
      Space : O(1)   — constant extra space

      Note:
      This is the most practical optimal solution.
      DP exists but is more complex and uses extra space.
    */

    public int countSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // Count odd-length palindromes
            count += expand(s, i, i);

            // Count even-length palindromes
            count += expand(s, i, i + 1);
        }

        return count;
    }

    // Expands around the given center and counts palindromes
    private int expand(String s, int left, int right) {

        int count = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }

        return count;
    }
}
