class Solution {

    /*
      Minimum Add to Make Parentheses Valid — Counter Method (Optimal Solution)

      Approach:
      - Use two counters:
            • count → number of unmatched '('
            • add   → number of insertions needed for unmatched ')'
      - Traverse the string:
            • If '(' appears → increase count.
            • If ')' appears:
                  - If count > 0 → match with previous '(' (count--).
                  - Else → no '(' available, so we must add one (add++).
      - After traversal, any remaining unmatched '(' must be closed,
        so add them to the total operations.

      Time  : O(n) — single pass through the string
      Space : O(1) — constant extra space

      Note:
      - This avoids using a stack by simply counting unmatched parentheses.
    */

    public int minAddToMakeValid(String s) {

        int count = 0; // number of unmatched '('
        int add = 0;   // number of insertions needed

        for (char ch : s.toCharArray()) {

            if (ch == '(') count++; // track opening parenthesis
            else {
                if (count > 0) count--; // match with an existing '('
                else add++; // need to insert '(' before this ')'
            }
        }

        // remaining '(' need closing ')'
        return add + count;
    }
}