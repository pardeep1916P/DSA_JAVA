class Solution {

    /*
      Split a String in Balanced Strings — Greedy Counter Approach (Optimal Solution)

      Approach:
      - Traverse the string character by character.
      - Maintain a counter:
            • Increment for 'L'
            • Decrement for 'R'
      - Whenever the counter becomes zero, it means
        an equal number of 'L' and 'R' have been seen,
        forming a balanced substring.
      - Count how many times this balance is achieved.

      Time  : O(n) — single pass through the string
      Space : O(1) — constant extra space

      Note:
      This greedy approach works because the string
      can be split as soon as balance is achieved,
      maximizing the number of balanced substrings.
    */

    public int balancedStringSplit(String s) {

        int freq = 0;   // balance counter for L and R
        int count = 0;  // number of balanced substrings

        for (char ch : s.toCharArray()) {

            // Update balance based on character
            if (ch == 'L') freq++;
            else freq--;

            // Balanced point found
            if (freq == 0) count++;
        }

        return count;
    }
}
