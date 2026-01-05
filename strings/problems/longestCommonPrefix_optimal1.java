class Solution {

    /*
      Longest Common Prefix — Horizontal Scanning (Optimal Solution 1)

      Approach:
      - If the input array is empty, return an empty string.
      - Treat the first string as the reference prefix.
      - Compare its characters one by one with the corresponding
        characters in all other strings.
      - On the first mismatch or when any string ends,
        return the prefix formed so far.
      - If all characters match, the entire first string
        is the longest common prefix.

      Time  : O(n * m)
              where n = number of strings
                    m = length of the shortest string
      Space : O(1) — no extra data structures used

      Note:
      This is one of the two optimal solutions.
      The other optimal approach uses vertical scanning
      or sorting-based comparison.
    */

    public String longestCommonPrefix(String[] strs) {

        // Edge case: empty input
        if (strs.length == 0) return "";

        // Compare characters column by column
        for (int i = 0; i < strs[0].length(); i++) {

            char c = strs[0].charAt(i);

            // Compare current character with all other strings
            for (int j = 1; j < strs.length; j++) {

                // Mismatch found or string length exceeded
                if (i >= strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0, i);

            }
        }

        // All characters matched
        return strs[0];
    }
}
