class Solution {

    /*
      Reverse String II — Block-Based Reversal (Own Solution)

      Approach:
      - Convert the string to a character array for in-place modification.
      - Process the string in blocks of size 2k:
            • For every 2k characters, reverse the first k characters.
            • Leave the next k characters unchanged.
      - If fewer than k characters remain, reverse all of them.
      - If between k and 2k characters remain, reverse only the first k.

      Time  : O(n) — each character is processed once
      Space : O(n) — character array created from the string

      Note:
      This follows the exact problem requirement and modifies characters in-place.
    */

    // Reverse characters in the array between indices start and end
    public void reverse(char[] arr, int start, int end) {

        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }

        return;
    }

    public String reverseStr(String s, int k) {

        char[] arr = s.toCharArray();
        int n = s.length();

        // Process the string in chunks of size 2k
        for (int i = 0; i < n; i += 2 * k) {

            // Determine the end index for reversal
            int end = Math.min(i + k - 1, n - 1);

            // Reverse the first k characters in the current block
            reverse(arr, i, end);
        }

        return new String(arr);
    }
}
