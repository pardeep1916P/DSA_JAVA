class Solution {

    /*
      Roman to Integer — Reverse Traversal with Value Comparison (Optimal Solution)

      Approach:
      - Use an array to map Roman characters to their integer values.
      - Traverse the string from right to left.
      - Keep track of the previous value:
            • If the current value is smaller than the previous value,
              subtract it from the total.
            • Otherwise, add it to the total.
      - This correctly handles subtractive cases like IV, IX, XL, etc.

      Time  : O(n) — single pass through the string
      Space : O(1) — fixed-size mapping array

      Note:
      Reverse traversal simplifies handling of Roman numeral subtraction rules.
    */

    public int romanToInt(String s) {

        // Map Roman numerals to their values
        int[] map = new int[26];
        map['I' - 'A'] = 1;
        map['V' - 'A'] = 5;
        map['X' - 'A'] = 10;
        map['L' - 'A'] = 50;
        map['C' - 'A'] = 100;
        map['D' - 'A'] = 500;
        map['M' - 'A'] = 1000;

        int sum = 0;
        int prev = 0;
        int n = s.length() - 1;

        // Traverse from right to left
        for (int i = n; i >= 0; i--) {

            int val = map[s.charAt(i) - 'A'];

            // Subtractive case
            if (prev > val) sum -= val;
            else sum += val;

            prev = val;
        }
        return sum;
    }
}
