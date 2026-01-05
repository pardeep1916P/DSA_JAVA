class Solution {

    /*
      Longest Common Prefix — Prefix Shrinking Method (Optimal Solution 2)

      Approach:
      - Initialize the prefix as the first string.
      - Iterate through the remaining strings:
            • While the current string does not start with the prefix,
              shorten the prefix by removing the last character.
            • Stop early if the prefix becomes empty.
      - After processing all strings, the remaining prefix
        is the longest common prefix.

      Time  : O(n * m)
              where n = number of strings
                    m = length of the shortest string
      Space : O(1) — no extra data structures used

      Note:
      This is the second optimal solution.
      It progressively reduces the prefix until it fits all strings.
    */

    public String longestCommonPrefix(String[] strs) {

        // Edge case: empty input
        if (strs.length == 0) return "";

        String prefix = strs[0];

        // Compare prefix against each string
        for (int i = 1; i < strs.length; i++) {

            // Shrink prefix until it matches the start of the current string
            while (!strs[i].startsWith(prefix)) {

                prefix = prefix.substring(0, prefix.length() - 1);

                // No common prefix exists
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
