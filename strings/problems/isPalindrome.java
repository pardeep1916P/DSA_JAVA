class Solution {

    /*
      Palindrome Number — Reverse Half Digits Approach (Optimal Solution)

      Approach:
      - Negative numbers can never be palindromes.
      - Any number ending with 0 (except 0 itself) cannot be a palindrome.
      - Reverse only the second half of the number instead of the entire number.
      - Compare:
            • For even length → left half == reversed right half
            • For odd length  → left half == reversed right half / 10

      Time  : O(log10(n)) — number of digits processed
      Space : O(1)        — constant extra space

      Note:
      This avoids integer overflow and extra memory usage.
    */

    public boolean isPalindrome(int x) {

        // Negative numbers and numbers ending with 0 (except 0) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0))
            return false;

        int rev = 0;

        // Reverse only half of the digits
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        // Check for even and odd digit counts
        return x == rev || x == rev / 10;
    }
}
