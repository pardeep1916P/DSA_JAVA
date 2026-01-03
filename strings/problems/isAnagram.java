class Solution {

    /*
      Valid Anagram — Frequency Count Approach (Optimal Solution)

      Approach:
      - If the lengths of the two strings differ, they cannot be anagrams.
      - Use a fixed-size frequency array of size 26 for lowercase letters.
      - For each index:
            • Increment frequency for character from string s.
            • Decrement frequency for character from string t.
      - If both strings are anagrams, all frequencies must end up as zero.

      Time  : O(n) — single pass through both strings
      Space : O(1) — fixed-size array (26 letters)

      Note:
      This solution assumes the input contains only lowercase English letters.
    */

    public boolean isAnagram(String s, String t) {

        // Anagrams must have the same length
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        // Update frequency counts for both strings
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        // If any frequency is non-zero, strings are not anagrams
        for (int count : freq) if (count != 0) return false;

        return true;
    }
}
