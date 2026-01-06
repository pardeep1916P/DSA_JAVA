class Solution {

    /*
      Find the Index of the First Occurrence in a String — Brute Force Matching

      Approach:
      - Let m be the length of the haystack and n be the length of the needle.
      - If the needle is empty, return 0 by definition.
      - If the needle is longer than the haystack, it cannot be found.
      - For each possible starting index in the haystack:
            • Compare characters of haystack and needle one by one.
            • If all characters of needle match, return the starting index.
      - If no match is found, return -1.

      Time  : O((m - n + 1) * n) — worst-case character comparisons
      Space : O(1) — constant extra space

      Note:
      This is a straightforward and correct solution.
      More advanced solutions (like KMP) improve performance in worst cases.
    */

    public int strStr(String haystack, String needle) {

        int m = haystack.length();
        int n = needle.length();

        // Edge cases
        if (n == 0)
            return 0;
        if (n > m)
            return -1;

        // Try matching needle starting at each valid position in haystack
        for (int i = 0; i <= m - n; i++) {

            int j = 0;

            // Compare characters of needle with substring of haystack
            while (j < n && haystack.charAt(i + j) == needle.charAt(j))
                j++;

            // Full match found
            if (j == n)
                return i;
        }

        return -1; // No occurrence found
    }
}
