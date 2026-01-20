class Solution {

    /*
      Check If Two String Arrays Are Equivalent — StringBuilder Concatenation
      (Second Optimal Solution)

      Approach:
      - Concatenate all strings from word1 into a single string.
      - Concatenate all strings from word2 into another single string.
      - Compare the two resulting strings for equality.

      Time  : O(n + m)
              n = total characters in word1
              m = total characters in word2
      Space : O(n + m) — additional space for concatenated strings

      Note:
      This is the second optimal solution.
      It is clean and easy to understand, but not the most space-efficient.
      The most optimal solution compares characters on the fly
      without building full strings.
    */

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        // Concatenate all strings in word1
        for (String s1 : word1) sb1.append(s1);

        // Concatenate all strings in word2
        for (String s2 : word2) sb2.append(s2);

        return sb1.toString().equals(sb2.toString());
    }
}
