class Solution {

    /*
      Add Strings — Two Pointer Digit Addition (Most Optimal Solution)

      Approach:
      - Traverse both strings from right to left using indices.
      - Convert characters to digits on the fly using ASCII subtraction.
      - Add digits along with carry and append the result digit.
      - Reverse the StringBuilder to obtain the final sum.

      Time  : O(max(n, m)) — each digit processed once
      Space : O(max(n, m)) — only StringBuilder used

      Note:
      This is the most optimal solution because it avoids
      creating additional character arrays.
    */

    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        // Process digits from right to left
        while (i >= 0 || j >= 0 || carry != 0) {

            int x = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j--) - '0' : 0;

            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
