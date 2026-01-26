class Solution {

    /*
      Longest Repeating Character Replacement — Sliding Window (Optimal Solution)

      Approach:
      - Use a sliding window with two pointers (l and r).
      - Maintain a frequency array for uppercase letters.
      - Track the maximum frequency character inside the current window.
      - The window is valid if:
            (window size - maxFreq) <= k
        meaning we can replace at most k characters to make
        all characters in the window the same.
      - If the window becomes invalid, shrink it from the left.
      - Track the maximum valid window length.

      Time  : O(n) — single pass through the string
      Space : O(1) — fixed-size frequency array (26 letters)

      Note:
      maxFreq is not reduced when shrinking the window.
      This is intentional and still correct because it never
      causes the window size to exceed the valid limit.
    */

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int l = 0;
        int maxFreq = 0;     // highest frequency in current window
        int maxLength = 0;   // maximum valid window length found

        for (int r = 0; r < s.length(); r++) {

            // Add current character to window
            freq[s.charAt(r) - 'A']++;

            // Update maximum frequency in window
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

            // If more than k replacements needed, shrink window
            if (r - l + 1 - maxFreq > k) freq[s.charAt(l++) - 'A']--;

            // Update maximum length of valid window
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}
