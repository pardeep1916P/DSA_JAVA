class Solution {

    /*
      Reverse String — Two Pointer In-Place Approach

      Approach:
      - Use two pointers starting from both ends of the array.
      - Swap characters at the left and right pointers.
      - Move pointers inward until they meet.

      Time  : O(n) — single pass through the array
      Space : O(1) — in-place reversal, no extra space

      Note:
      This modifies the input array directly as required.
    */

    public void reverseString(char[] s) {

        // Edge case: empty array
        if (s.length == 0) return;

        int l = 0, r = s.length - 1;

        // Swap characters while moving pointers inward
        while (l < r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
        return;
    }
}
