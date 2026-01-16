class Solution {

    /*
      Add Strings — Manual Addition Using Character Arrays (Second Optimal Solution)

      Approach:
      - Convert both input strings into character arrays.
      - Use two pointers starting from the last index of each array.
      - Add digits one by one along with carry, just like manual addition.
      - Append the result digit to a StringBuilder.
      - Reverse the StringBuilder at the end to get the correct order.

      Time  : O(max(n, m)) — each digit processed once
      Space : O(max(n, m)) — StringBuilder + char arrays

      Note:
      This solution is efficient but uses extra space
      due to conversion into character arrays.
    */

    public String addStrings(String num1, String num2) {

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();

        int i = n1.length - 1;
        int j = n2.length - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        // Process digits from right to left
        while (i >= 0 || j >= 0 || carry != 0) {

            int x = (i >= 0) ? n1[i--] - '0' : 0;
            int y = (j >= 0) ? n2[j--] - '0' : 0;

            int sum = x + y + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
