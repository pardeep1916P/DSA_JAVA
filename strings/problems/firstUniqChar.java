class Solution {

    /*
      First Unique Character in a String — Frequency Count Approach (Optimal Solution)

      Approach:
      - Use a fixed-size frequency array of size 26 for lowercase letters.
      - First pass:
            • Count the frequency of each character.
      - Second pass:
            • Traverse the string in original order.
            • Return the index of the first character with frequency 1.
      - If no such character exists, return -1.

      Time  : O(n) — two linear passes over the string
      Space : O(1) — fixed-size frequency array

      Note:
      This solution preserves the original character order
      while efficiently identifying the first unique character.
    */

    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Find first unique character by string order
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
