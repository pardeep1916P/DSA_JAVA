class Solution {

    /*
      Find the Index of the First Occurrence in a String — Built-in Method Approach

      Approach:
      - Directly use Java's built-in indexOf() method.
      - The method returns:
            • the index of the first occurrence of the substring
            • or -1 if the substring is not found

      Time  : O(n * m) in the worst case
              where n = length of haystack
                    m = length of needle
      Space : O(1) — no extra data structures used

      Note:
      This is the cleanest and simplest solution.
      In some interviews, manual string matching
      (brute force or KMP) may be expected instead.
    */

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
