class Solution {

    /*
      Score of Parentheses — Depth Counting + Bit Manipulation (Optimal Solution)

      Approach:
      - Maintain:
            • depth → current nesting level of parentheses
            • score → total score
      - Traverse the string:
            • On '(' → increase depth
            • On ')' → decrease depth
            • If we encounter "()" (i.e., previous char was '('):
                  → add 2^depth to score (using bit shift: 1 << depth)

      Why it works:
      - Each "()" contributes a value depending on its depth.
      - Deeper pairs contribute higher values (multiplied by powers of 2).

      Example:
          s = "(()(()))"
          Contributions happen only at "()" pairs with correct depth.

      Time  : O(n) — single pass
      Space : O(1) — no extra data structures

      Note:
      - 1 << depth is equivalent to 2^depth.
      - This avoids stack usage and is the most optimized approach.
    */

    public int scoreOfParentheses(String s) {

        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(')depth++;
            
            else {
                depth--;

                // Found a "()" pattern
                if (s.charAt(i - 1) == '(') score += 1 << depth;
            }
        }

        return score;
    }
}