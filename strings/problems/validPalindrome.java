class Solution {

    /*
      Valid Palindrome — Two Pointer Filtering Approach (Optimal Solution)

      Approach:
      - Use two pointers starting from both ends of the string.
      - Skip characters that are not letters or digits.
      - Compare remaining characters in a case-insensitive manner.
      - Move pointers inward until they meet.

      Time  : O(n) — each character is processed at most once
      Space : O(1) — constant extra space

      Note:
      This approach avoids creating a new filtered string
      and works directly on the original input.
    */

    public boolean isPalindrome(String s) {

        int l = 0, r = s.length() - 1;

        while (l < r) {

            char left = s.charAt(l);
            char right = s.charAt(r);

            // Skip non-alphanumeric characters on the left
            if (!Character.isLetterOrDigit(left)) {
                l++;

                // Skip non-alphanumeric characters on the right
            } else if (!Character.isLetterOrDigit(right)) {
                r--;

                // Compare valid characters ignoring case
            } else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right))
                    return false;

                l++;
                r--;
            }
        }

        return true;
    }
}
