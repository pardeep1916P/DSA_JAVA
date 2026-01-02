class Solution {

    /*
      Valid Palindrome II — Two Pointer + One Deletion Check (Optimal Solution)

      Approach:
      - Use two pointers from both ends of the string.
      - Traverse inward while characters match.
      - On the first mismatch:
            • Try skipping the left character and check if the remaining substring is a palindrome.
            • Try skipping the right character and check if the remaining substring is a palindrome.
      - If either case forms a palindrome, the string is valid.

      Time  : O(n) — single traversal, palindrome check happens at most once
      Space : O(1) — constant extra space (no new strings created)

      Note:
      At most one character deletion is allowed.
      This solution directly works on the original string without extra memory.
    */

    // Helper method to check if substring s[l..r] is a palindrome
    private boolean isPalindrome(String s, int l, int r) {

        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {

        int l = 0, r = s.length() - 1;

        while (l < r) {

            // Characters match → move both pointers inward
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;

                // First mismatch → try skipping one character
            } else {
                return isPalindrome(s, l + 1, r)
                        || isPalindrome(s, l, r - 1);
            }
        }

        return true;
    }
}
