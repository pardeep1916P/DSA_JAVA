class Solution {

    /*
      Repeated Substring Pattern — String Doubling Trick (Optimal & Elegant Solution)

      Approach:
      - If a string can be formed by repeating one of its substrings,
        then the original string must appear inside:
              (s + s).substring(1, 2*n - 1)
      - Why this works:
            • Repeating patterns create internal overlaps when doubled.
            • Removing the first and last characters avoids trivial matches.
      - If the original string exists inside this modified string,
        it confirms a repeated substring pattern.

      Time  : O(n) average — substring search
      Space : O(n) — additional string created by concatenation

      Note:
      This is a concise and commonly accepted optimal solution
      for this problem in interviews.
    */

    public boolean repeatedSubstringPattern(String s) {

        String res = s + s;

        // Check if original string exists within the trimmed doubled string
        return res.substring(1, res.length() - 1).contains(s);
    }
}
