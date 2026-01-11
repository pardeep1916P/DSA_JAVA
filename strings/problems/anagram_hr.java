class Solution {

    /*
      Anagram — Minimum Changes to Make Two Halves Anagram (Optimal Solution)

      Problem Context:
      - Given a string s of even length, split it into two equal halves.
      - Determine the minimum number of character changes required
        in the second half to make it an anagram of the first half.
      - If the string length is odd, it is impossible.

      Approach:
      - If the length is odd or zero, return -1.
      - Split the string into two halves.
      - Use a frequency array of size 26 for lowercase letters.
      - Increment frequencies for characters in the first half.
      - Decrement frequencies for characters in the second half.
      - The total number of positive remaining frequencies represents
        the minimum number of changes required.

      Time  : O(n) — single pass over the string
      Space : O(1) — fixed-size frequency array

      Note:
      This solution assumes the string contains only lowercase English letters.
    */

    public static int anagram(String s) {

        int n = s.length();

        // Odd-length or empty string cannot be split evenly
        if (n % 2 == 1 || n == 0) return -1;

        int mid = n / 2;
        int[] freq = new int[26];

        // Count characters in the first half
        for (int i = 0; i < mid; i++) freq[s.charAt(i) - 'a']++;

        // Subtract characters in the second half
        for (int i = mid; i < n; i++) freq[s.charAt(i) - 'a']--;

        int changes = 0;

        // Sum positive differences to get minimum changes required
        for (int f : freq) if (f > 0) changes += f;

        return changes;
    }
}
