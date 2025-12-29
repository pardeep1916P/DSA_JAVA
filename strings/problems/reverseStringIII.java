class Solution {

    /*
      Reverse Words in a String III — In-Place Word Reversal (optimal)

      Approach:
      - Convert the string to a character array for in-place modification.
      - Traverse the array using two pointers to identify word boundaries.
      - Reverse characters of each word individually when a space or
        the end of the string is encountered.
      - Preserve the original word order while reversing each word.

      Time  : O(n) — each character is visited once
      Space : O(n) — character array created from the string

      Note:
      This solution reverses each word without changing the order of words.
    */

    // Reverse characters between indices start and end (inclusive)
    private void reverse(char[] arr, int start, int end) {

        while (start < end) {
            char temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }

        return;
    }

    public String reverseWords(String s) {

        char[] arr = s.toCharArray();
        int n = arr.length;
        int l = 0;

        // Traverse the array to find word boundaries
        for (int r = 0; r <= n; r++) {

            // When a space or end of string is found, reverse the word
            if (r == n || arr[r] == ' ') {
                reverse(arr, l, r - 1);
                l = r + 1;  // move to the start of the next word
            }
        }

        return new String(arr);
    }
}
