class Solution {

    /*
      Length of Last Word — Backward Traversal Approach (Optimal Solution)

      Approach:
      - Start scanning the string from the end.
      - Skip all trailing spaces to locate the last word.
      - Count characters until a space or the start of the string is reached.
      - The count represents the length of the last word.

      Time  : O(n) — single backward pass
      Space : O(1) — constant extra space

      Note:
      This approach avoids extra memory usage such as splitting the string
      and efficiently handles trailing spaces.
    */

    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ')
            i--;

        int len = 0;

        // Count characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }

        return len;
    }
}
