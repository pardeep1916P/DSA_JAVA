class Solution {

    /*
      Add Binary — Two Pointer Binary Addition (Optimal Solution)

      Approach:
      - Traverse both binary strings from right to left.
      - At each step:
            • Convert current characters to binary digits (0 or 1).
            • Add both digits along with the carry.
            • Append the resulting bit (sum % 2).
            • Update carry (sum / 2).
      - Reverse the result at the end to obtain the correct binary sum.

      Time  : O(max(n, m)) — each bit processed once
      Space : O(max(n, m)) — StringBuilder used to store result

      Note:
      This approach avoids built-in binary conversion
      and performs manual binary addition.
    */

    public String addBinary(String a, String b) {

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();

        // Process bits from right to left
        while (i >= 0 || j >= 0 || carry != 0) {

            int x = (i >= 0) ? a.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? b.charAt(j--) - '0' : 0;

            int sum = x + y + carry;

            // Current binary digit
            sb.append(sum % 2);

            // Update carry
            carry = sum / 2;
        }

        return sb.reverse().toString();
    }
}
