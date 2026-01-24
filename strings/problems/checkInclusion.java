class Solution {

    /*
      Permutation in String — Sliding Window with Frequency Count (Optimal Solution)

      Approach:
      - If s1 is longer than s2, permutation is impossible.
      - Build a frequency array for characters in s1.
      - Use a sliding window of size s1.length() over s2.
      - Decrease frequency when a character enters the window.
      - Increase frequency when a character leaves the window.
      - Maintain a counter `required` to track how many characters
        still need to be matched.
      - If `required` becomes 0, a permutation exists.

      Time  : O(m)
              m = length of s2 (single pass)
      Space : O(1) — fixed-size frequency array (26 letters)

      Note:
      This is the most optimal and interview-expected approach.
      It avoids sorting and avoids recomputing frequencies repeatedly.
    */

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];
        int n = s1.length(), m = s2.length();

        // Build frequency map for s1
        for (char ch : s1.toCharArray()) freq[ch - 'a']++;

        int l = 0, required = n;  // number of characters still needed to match

        for (int r = 0; r < m; r++) {

            // Include current character into window
            if (freq[s2.charAt(r) - 'a']-- > 0) required--;

            // Maintain window size equal to s1 length
            if (r - l + 1 > n) {

                // Remove left character from window
                if (++freq[s2.charAt(l) - 'a'] > 0) required++;

                l++;
            }

            // If all characters matched
            if (required == 0) return true;
        }

        return false;
    }
}
